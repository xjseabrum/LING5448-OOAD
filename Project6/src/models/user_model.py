from src.models.db_client import *
from src.models.abstract_model import AbstractModel

class UserModel(AbstractModel):
    collection = dbClient().get_db_client()["user"]

    def __init__(self, user_id=None, user_password=None, user_wallet=None):
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

    def create(self)->bool:
        document={"_id":self.user_id, "user_password":self.user_password, "user_wallet":self.user_wallet}
        self.collection.insert_one(document)
        for keyword, arg in document.items():
            print("Successfully create kwargs {} :-> {}".format(keyword, arg))
        return True


    @classmethod
    def update(self, filter_kwargs, update_values: dict) ->bool:
        '''

        Args:
            filter_kwargs:
            update_values:

        Returns:

        '''
        update_result = self.collection.update_many(filter_kwargs, {"$set": update_values})
        print(str(update_result.modified_count)+" documents updated\n")

    @classmethod
    def retrieve(self, user_id=None,user_password=None,wallet=None):
        doc={}
        if user_id: doc["_id"]=user_id
        if user_password: doc["password"]=user_password
        if wallet: doc["wallet"]=wallet
        result=UserModel.collection.find(doc)
        return [UserModel(x["_id"],x["password"],x["wallet"]) for x in result]

    def delete(self, kwargs):
        print("Deleting data from the DB with the following kwargs : \n", kwargs)
        self.collection.delete_one(kwargs)
        return True

    @classmethod
    def check_if_id_exist(self, user_id) -> bool:
        return self.collection.count_documents({"_id": user_id}) != 0


    