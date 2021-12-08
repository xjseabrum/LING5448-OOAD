from src.controllers.abstract_controller import AbstractController
from src.models.user_model import UserModel
from src.lib.core.check_float import CheckFloat as cf
from src.lib.core.format_number import num_print as num_print


class Settings(AbstractController):
    def __init__(self, player: UserModel, prev_state: AbstractController):
        self.player = player
        self.previous_state = prev_state

    def execute(self):
        print("Settings Menu: \n")
        inquire = input(
            "1: Return to Main Menu. \n" +
            "2: Check funds. \n" +
            "3: Add funds. \n\n\t")
        inquire = int(inquire)
        return self.__process(inquire)

    def __process(self, choice):
        if choice == 1:
            print("Returning to the main menu.")
            return self.previous_state
        elif choice == 2:
            print("You have $" + num_print(self.player.user_wallet) + "\n")
            return self.execute()
        elif choice == 3:
            print("How much money would you like to add (between $0 and $5000)?")
            number = input("\n\t")
            if cf(number):
                as_float = float(number)
                if ((as_float < 5000) & (as_float > 0)):
                    self.player.user_wallet += as_float
                    self.player.update()

                    print("You now have $" + num_print(self.player.user_wallet) + "\n")
                    return self.execute()
                else:
                    print("Invalid input detected. Please provide a number between 0 and 5000.\n")
                    return self.execute()
                
            else:
                print("Invalid input detected. Please give a number. \n")
                return self.execute()
        else:
            print("Returning to the main menu.\n")
            return self.previous_state

    def update_state(self):
        pass

    def get_user_input(self):
        return self.user_input

    def transition(self):
        return self.previous_state
