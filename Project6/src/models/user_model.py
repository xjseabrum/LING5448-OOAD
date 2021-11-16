from src.models import user_data_model
from src.models import db_client
from src.models.abstract_model import AbstractModel

class UserModel(AbstractModel):

    def __init__(self):
        db=db_client.dbClient()
        self.collection = db.get_db_client()["user"]

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

    def validate(self, kwargs):
        return "_id" in kwargs.keys() and kwargs["_id"] is not None

    def create(self, kwargs):
        is_valid=self.validate(kwargs)
        '''Not sure should I use dataModel or validate function to validate input data, will discuss with you guys 
        with that '''
        # document={"user_id":user_data_model.user_id,"user_password":user_data_model.user_password,
        # "user_wallet":user_data_model.user_wallet}
        if is_valid:
            self.collection.insert_one(kwargs)
            for keyword, arg in kwargs.items():
                print("Successfully create kwargs {} :-> {}".format(keyword, arg))
        else:
            raise Exception("Data provided does not follow the data table constraint")
            return False

    def update(self, filter_kwargs, update_values):
        update_result = self.collection.update_many(filter_kwargs, {"$set": update_values})
        print(str(update_result.modified_count)+" documents updated\n")

    def retrieve(self, kwargs):
        print("Fetching data from the DB with the following kwargs : \n", kwargs)
        return list(self.collection.find(kwargs))

    def delete(self, kwargs):
        print("Deleting data from the DB with the following kwargs : \n", kwargs)
        self.collection.delete_one(kwargs)
        return True

    def check_if_id_exist(self, user_id) -> bool:
        return self.collection.count_documents({"_id": user_id}) != 0


    