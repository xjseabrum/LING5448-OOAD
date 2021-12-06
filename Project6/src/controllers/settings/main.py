from src.controllers.abstract_controller import AbstractController
import src.controllers.main_menu.controller as main_menu

user_wallet = 1000

class Settings(AbstractController):
    def __init__(self):
        self.state = None
        self.user_input = 2
        self.user_wallet = user_wallet

    def execute(self):
        print("Settings Menu: \n")
        inquire = input(
        "1: Return to Main Menu. \n" + 
        "2: Add funds. \n\n\t")

        while inquire == 2:
            money = ("How much money would you like to add (between $0 and $5000)?")
            self.__add_funds(money)
            inquire = input(
                     "1: Return to Main Menu. \n" + 
                     "2: Add funds. \n\n\t")
            
    
    def update_state(self):
        check = self.get_user_input()
        if check != 2:
            pass
        
    def get_user_input(self):
        return self.user_input
    
    def transition(self):
        pass

    def __add_funds(self, input):
        self.user_wallet += input
        print("Added $" + input + "to your wallet.")

