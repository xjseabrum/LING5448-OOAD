from src.controllers.slots.check_bet import verify
import src.controllers.slots.difficulty as difficulty
import secrets
from src.controllers.slots.evaluate_board import matches
from src.controllers.slots.calculate_return import calculate
from src.controllers.slots.format_number import num_print
from src.controllers.slots.check_query import resolve
import src.controllers.slots.exit_sequence as exit_sequence
from src.views.slots_view import SlotsView

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

    # View
    def _set_difficulty(self):
        user_input = input("Select your difficulty:\n1: Easy.\n2: Medium (earnings are 2x if win)\n3: Hard (earnings are 10x if win)\n\t")
        selection = difficulty.select(user_input)
        self.charset = selection[0]
        self.earnings_multiplier = selection[1]
    
    # View
    def _ask_bet(self):
        user_bet = input("Please bet any amount between $5 and $60.\n\t")
        verified = verify(user_bet)
        original = round(verified * 1.25, 2)
        self.bet = verified
        self.user_wallet -= original
        print("You currently have $" + num_print(self.user_wallet) + ".")
    
    # Controller
    def _spin_slots(self):
        print("The lever arm is pulled and the slots spin.")
        # Get number of elements in the charset
        n_elements = len(self.charset)

        # Next get random values from the charset 
        for index in range(len(self.choices)):
            self.choices[index] = self.charset[secrets.randbelow(n_elements)]
    
    # View
    def _display_slots(self):
        SlotsView().render(choices = self.choices)
        # print(self.choices[0] + "\t" + self.choices[1] + "\t"+ self.choices[2] + "\n" +
        #       self.choices[3] + "\t" + self.choices[4] +  "\t" + self.choices[5] + "\n" +
        #       self.choices[6] + "\t" + self.choices[7] + "\t" + self.choices[8])
    
    # Controller
    def _check_matches(self):
        n_matches = matches(self.choices)
        self.tot_matches = n_matches
        print("The board has " + str(self.tot_matches) + " match(es) on it!")

    # Controller
    def _user_delta(self):
        delta = calculate(self.bet, self.tot_matches, self.earnings_multiplier)
        print("You won $" + num_print(delta) + "!")
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
        return(self.charset)
    
    def get_matches(self):
        return(self.tot_matches)

    def get_repeat(self):
        return(self.repeat)

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
