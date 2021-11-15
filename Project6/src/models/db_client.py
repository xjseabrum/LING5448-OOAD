import pymongo
'''Singleton here'''
class dbClient():
    def __init__(self):
        self.conn="mongodb+srv://m001-student:Samjason4993785!@sandbox.dpual.mongodb.net/Casino?retryWrites=true&w=majority&ssl=true&ssl_cert_reqs=CERT_NONE"
        self.client=None
        self.db="Casino"
    def get_db_client(self):
        if self.client==None:
            client=pymongo.MongoClient(self.conn)
            self.client=client[self.db]
        return self.client

