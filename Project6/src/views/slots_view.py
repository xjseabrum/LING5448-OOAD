"""Views for Slots!
"""

from src.views.abstract_view import AbstractView
from src.lib.core.check_float import CheckFloat as cf
from src.lib.core.format_number import num_print

class SlotsView(AbstractView):
    def render(self, **kwargs):
        print(kwargs["choices"][0] + "\t" + kwargs["choices"][1] + "\t"+ kwargs["choices"][2] + "\n" +
              kwargs["choices"][3] + "\t" + kwargs["choices"][4] +  "\t" + kwargs["choices"][5] + "\n" +
              kwargs["choices"][6] + "\t" + kwargs["choices"][7] + "\t" + kwargs["choices"][8])


class AskView(AbstractView):
    def render(self, **kwargs):     
        user_bet = input(kwargs["msg"])
        is_valid = self.validate_input(user_bet)

        if is_valid:
            return self.check_constraint(is_valid, **kwargs)
        else:
            while is_valid == False:
                user_bet = input(kwargs["msg"])
                is_valid = self.validate_input(user_bet)
                if is_valid == True:
                    return self.check_constraint(is_valid, **kwargs)

    def validate_input(self, bet):
        # verification for if float
        if cf(bet):
            as_float = float(bet)
            return as_float
        else:
            print("Invalid input detected. Please try again.")
            return False

    def check_constraint(self, as_float, **kwargs):
        if ((kwargs["wallet"] < as_float) | (kwargs["wallet"] < 5)):
            # TODO, break out if user has less than $5
            print("You do not have that much money to bet. Setting to $0.")
            return 0
        
        if(as_float < kwargs["min"]):
            print("Detected bet less than $5.  Setting to $5.")
            return 5

        elif(as_float > kwargs["max"]):
            print("Detected bet greater than $60. Setting to $60.")
            return 60

        else:
            print("Bet set to $" + num_print(as_float) + ".")
            return round(as_float, 2) 