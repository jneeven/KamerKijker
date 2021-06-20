import scrapy
from scrapy.http import Request


class StemmingsUitslagenSpider(scrapy.Spider):
    """Scrape tweedekamer.nl for all its motions and their vote results."""

    name = "StemmingsUitslagen"
    allowed_domains = ["tweedekamer.nl"]
    start_urls = [
        "https://www.tweedekamer.nl/kamerstukken?qry=%2A&fld_tk_categorie=Kamerstukken&srt=date%3Adesc%3Adate&clusterName=Tweedekamer.nl&sta=1&fld_prl_kamerstuk=Stemmingsuitslagen"
    ]

    def parse(self, response):
        # This should only be executed once: when we crawl the start URL.
        # Any followed links will explicitly call the relevant callback.
        if response.url == self.start_urls[0]:
            yield from self.parse_homepage(response)
        else:
            self.logger.warning(f"Did not know how to handle {response.url} !")

    def parse_homepage(self, response):
        # Parses the homepage for the batch motion result cards (one for each day)
        cards = response.xpath(
            "//div[@class='card' and normalize-space(descendant::div[@class='card__title']/text()) = 'Stemmingsuitslagen']"
        )
        # All cards are Stemmingsuitslagen, so we expect at least one per page.
        assert len(cards) > 0

        # TODO: filter out the ones that have yet to take place

        for card in cards:
            url = card.xpath("div[@class='card__content']//div/h3/a/@href").get()
            yield Request(
                response.urljoin(url),
                callback=self.parse_motion_batch,
            )

        # TODO: move to next page

    def parse_motion_batch(self, response):
        # Retrieves the individual motions from a daily results page, e.g.
        # https://www.tweedekamer.nl/kamerstukken/stemmingsuitslagen/detail?id=2021P10885
        motion_urls = response.xpath("//a[@class='card']/@href").getall()
        assert len(motion_urls) > 0

        for url in motion_urls:
            yield Request(
                response.urljoin(url),
                callback=self.parse_motion,
            )

    def parse_motion(self, response):
        # Parses a specific motion and its results, e.g.
        # https://www.tweedekamer.nl/kamerstukken/detail?id=2021Z11008&did=2021D23928
        print(f"Parsing motion! {response.url}")

        # TODO: scrape the actual info and call database endpoint
