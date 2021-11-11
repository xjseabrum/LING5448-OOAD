import os
print(os.getcwd())
print(os.listdir("."))

from src.controllers.abstract_controller import AbstractController
from src.views.blackjack_view import DefaultView
from src.models.blackjack_model import BlackJackModel
from src.models.user_model import UserModel

class BlackJackGame(AbstractController) : 

    def __init__(self):

        '''
        This will typically happen outside the controller : 
        '''

        self.default_view = DefaultView()
        self.game_model = BlackJackModel()
        self.user_model = UserModel()

    def execute(self):
        print("Executing!")

        import random

        k = random.randint(1,3)

        if k==1: 
            # PLACEHOLDER: we assume the user has "HIT"
            self.default_view.render(message="So you have hit. Your new cards are A-Spade, A-Spade")
        elif k==2:
            # PLACEHOLDER: we assume the user has "STAYED".
            self.default_view.render(message="OK then, let's see how the other's fare! "+ 
                "You'll have to wait till everyones turn is over to know the result!")

            win = random.randint(1,2)>1
            if win : 
                self.default_view.render(message="You've won! Let's celebrate!")
                self.game_model.update(user="jechante", outcome="win")
                self.user_model.update(user="jechante", game="blackjack", outcome="win", bet=1000)
            else : 
                self.default_view.render(message="You've lost! Give me the money!")
                self.game_model.update(user="jechante", outcome="lose")
                self.user_model.update(user="jechante", game="blackjack", outcome="lose", bet=1000)
        else : 
            # PLACEHOLDER: we assume the user has gone "BUST". 
            self.default_view.render(message="You have gone bust! Where is your money?")
            self.game_model.update(user="jechante", outcome="lose")
            self.user_model.update(user="jechante", game="blackjack", outcome="lose", bet=1000)

    def update_state(self):
        print("Update State")

    def transition(self):
        print("Transition")


        
if __name__ == '__main__' : 

    game = BlackJackGame()
    game.execute()


