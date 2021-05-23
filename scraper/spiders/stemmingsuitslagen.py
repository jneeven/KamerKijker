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
        # TODO: select each individual card
        table = []

        for row in table:
            url = ""
            yield Request(
                response.urljoin(url),
                callback=self.parse_sector_or_industry,
                cb_kwargs={},
                # TODO: this is probably only necessary if we need to load JS.
                # args={
                #     "wait": 1,
                # },
            )

        # TODO: move to next page

    def parse_result_batch(self):
        # TODO: select each individual motion card and parse it
        pass

    def parse_motion(self):
        # TODO: Parse motion item including its results and yield all the relevant
        # items to be inserted into the database.
        pass
