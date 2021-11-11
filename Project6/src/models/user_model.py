from src.models.abstract_model import AbstractModel

class UserModel(AbstractModel) : 

    def __init__(self):
        pass

    def create_migration(self) : 
        '''
        Make the migration for setting up new DB here. 
        '''
        pass

    def migrate(self) : 

        '''
        Finalize the migration
        '''

        pass

    def validate(self, **kwargs) : 
        for keyword, arg in kwargs.items() : 
            print("Doing some validation on the kwarg {} :-> {}".format(keyword, arg))

        print("Everything looks good!")

    def create(self, **kwargs):
        self.validate(**kwargs)
        print(" Creating the DB with the following kwargs : \n", kwargs)

    def update(self, **kwargs):
        self.validate(**kwargs)
        print(" Updating the DB with the following kwargs : \n", kwargs)

    def retrieve(self, **kwargs):
        print("Fetching data from the DB with the following kwargs : \n", kwargs)

    def delete(self, **kwargs) : 
        print("Deleting data from the DB with the following kwargs : \n" , kwargs)


    