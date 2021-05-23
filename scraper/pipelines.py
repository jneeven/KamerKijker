from itemadapter import ItemAdapter


class DatabasePipeline:
    def __init__(self, url):
        self.url = url

    @classmethod
    def from_crawler(cls, crawler):
        return cls(
            url=crawler.settings.get("DATABASE_URL"),
        )

    def open_spider(self, spider):
        # TODO: connect to db
        self.client = None
        self.db = None
        spider.db = self.db

    def close_spider(self, spider):
        self.client.close()

    def process_item(self, item, spider):
        item = ItemAdapter(item).asdict()
        # TODO: process and insert into DB
        return item
