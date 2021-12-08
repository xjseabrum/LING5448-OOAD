"""Views for the Main Menu!
"""

from src.views.abstract_view import AbstractView
import src.controllers.main_menu.msgs as msgs


class Display(AbstractView):
    def __init__(self):
        self.show = msgs.options
        self.min = 1
        self.max = 5
        self.keep_choice = None

    def render(self, **kwargs):
        inquire = input(kwargs["msg"])
        is_valid = self.__validate_input(inquire)

        if is_valid:
            self.__assign(inquire)
            self.keep_choice = inquire
        else:
            while is_valid == False:
                inquire = input(kwargs["msg"])
                is_valid = self.__validate_input(inquire)
                if is_valid == True:
                    self.__assign(inquire)
                    self.keep_choice = inquire

    def __assign(self, inquire):
        print(self.show[inquire])

    def get_choice(self):
        return int(self.keep_choice)

    def __validate_input(self, input):
        if((~input.isnumeric()) and (int(input) < self.min or int(input) > self.max)):
            print("Invalid input.  Please try again.\n")
            return False
        else:
            return True
