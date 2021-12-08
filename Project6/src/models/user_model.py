from src.models.db_client import *
from src.models.abstract_model import AbstractModel


class UserModel(AbstractModel):
    collection = dbClient().get_db_client()["user"]

    def __init__(self, user_id=None, user_password=None, user_wallet=1000):
        self.user_id = user_id
        self.user_password = user_password
        self.user_wallet = user_wallet

    def create_migration(self):
        '''
        Make the migration for setting up new DB here.
        '''
        pass

    def migrate(self):
        '''
        Finalize the migration
        '''

        pass

    def create(self) -> bool:
        document = self.get_document_from_self()
        self.collection.insert_one(document)
        for keyword, arg in document.items():
            print("Successfully create kwargs {} :-> {}".format(keyword, arg))
        return True

    def update(self) -> bool:
        document = self.get_document_from_self()
        update_result = self.collection.update_one(
            {"_id": document["_id"]}, {"$set": document})
        print(str(update_result.modified_count) + " document(s) updated\n")

    @classmethod
    def retrieve(self, user_id=None, user_password=None, wallet=None):
        doc = {}
        if user_id:
            doc["_id"] = user_id
        if user_password:
            doc["password"] = user_password
        if wallet:
            doc["wallet"] = wallet
        result = UserModel.collection.find(doc)
        return [UserModel(x["_id"], x["password"], x["wallet"])
                for x in result]

    def delete(self, kwargs):
        print("Deleting data from the DB with the following kwargs : \n", kwargs)
        self.collection.delete_one(kwargs)
        return True

    @classmethod
    def check_if_id_exist(self, user_id) -> bool:
        return self.collection.count_documents({"_id": user_id}) != 0

    def get_document_from_self(self):
        return {"_id": self.user_id, "password": self.user_password,
                "wallet": self.user_wallet}
