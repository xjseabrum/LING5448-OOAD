import pymongo


class dbClient():
    conn = "mongodb+srv://m001-student:Samjason4993785!@sandbox.dpual.mongodb.net/Casino?retryWrites=true&w=majority&ssl=true&ssl_cert_reqs=CERT_NONE"
    db = "Casino"

    @classmethod
    def get_db_client(cls):
        client = pymongo.MongoClient(dbClient.conn)[dbClient.db]
        return client
