from src.controllers.slots.check_bet import verify
import src.controllers.slots.difficulty as difficulty
from src.controllers.slots.evaluate_board import matches
from src.controllers.slots.calculate_return import calculate
from src.controllers.slots.format_number import num_print
from src.controllers.slots.check_query import resolve
from src.controllers.slots.assign_slots import assign
import src.controllers.slots.exit_sequence as exit_sequence
from src.views.slots_view import SlotsView, AskView

user_wallet = 1000

class SlotsGame():   
    
    def __init__(self):
        self.charset = []
        self.earnings_multiplier = 1
        self.bet = 0
        self.choices = [None] * 9
        self.tot_matches = 0
        self.user_wallet = user_wallet
        self.repeat = True
        self.min_bet = 5
        self.max_bet = 60

    # View
    def _set_difficulty(self):
        user_input = input("Select your difficulty:\n1: Easy.\n2: Medium (earnings are 2x if win)\n3: Hard (earnings are 10x if win)\n\t")
        selection = difficulty.select(user_input)
        self.charset, self.earnings_multiplier = selection
    
    # View
    def _ask_bet(self):
        AskView().render(msg = "Please bet any amount between $5 and $60.\n\t", 
                         min = self.min_bet,
                         max = self.max_bet,
                         wallet = self.user_wallet)
        # verified = verify(user_bet)
        # original = round(verified * 1.25, 2)
        # self.bet = verified
        # self.user_wallet -= original
        # print("You currently have $" + num_print(self.user_wallet) + ".")
    
    # Controller
    def _spin_slots(self):
        self.choices = assign(char_list = self.charset, 
                              list = self.choices)
    
    # View
    def _display_slots(self):
        SlotsView().render(choices = self.choices)
    
    # Controller
    def _check_matches(self):
        self.tot_matches = matches(self.choices)

    # Controller
    def _user_delta(self):
        delta = calculate(bet = self.bet, 
                          matches = self.tot_matches, 
                          multiplier = self.earnings_multiplier)
        self.user_wallet += delta
        print("You now have $" + num_print(self.user_wallet) + ".")

    # View
    def _inquire(self):
        query = input("Do you want to play again? [Y/N] \n\t")
        self.repeat = resolve(query)

    # Controller
    def _reset_slots(self):
        self.choices = [None] * 9
    
    def get_bet(self):
        return self.bet
    
    def get_earnings_multiplier(self):
        return self.earnings_multiplier
    
    def get_charset(self):
        return self.charset
    
    def get_matches(self):
        return self.tot_matches

    def get_repeat(self):
        return self.repeat

def initialize():
    play_again = True
    while play_again == True:
        print("Hello, welcome to Slots!")
        game = SlotsGame()
        game._set_difficulty()
        game._ask_bet()
        game._spin_slots()
        game._display_slots()
        game._check_matches()
        game._user_delta()
        game._reset_slots()
        game._inquire()
        play_again = game.get_repeat()
        if(play_again == False):
            exit_sequence.exit()
            break

if __name__ == '__main__':
    initialize()
