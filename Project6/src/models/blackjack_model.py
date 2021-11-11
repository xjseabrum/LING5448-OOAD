from src.models.abstract_model import AbstractModel

class BlackJackModel(AbstractModel) : 

    def __init__(self):
        super().__init__()

    def _connection(self, db_conn) : 
        # connect to the db, automatically
        pass

    def create_migration(self, db_conn) : 
        '''
        1. Connect to the DB with db_conn
        2. Create migration
        3. Return 
        '''
        pass

    def migrate(self) : 

        '''
        Exectute the migration
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


    