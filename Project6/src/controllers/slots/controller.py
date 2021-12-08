from src.controllers.abstract_controller import AbstractController
from src.controllers.slots.evaluate_board import matches
from src.controllers.slots.calculate_return import calculate
from src.controllers.slots.check_query import resolve
from src.controllers.slots.assign_slots import assign
import src.controllers.slots.exit_sequence as exit_sequence
from src.views.slots_view import DisplayAmount, DisplaySlots, AskBet, SetDifficulty
import src.controllers.slots.messages as msgs
from src.models.user_model import *

# user_wallet = 1000

class SlotsGame(AbstractController):   
    
    def __init__(self, player:UserModel, prev_state:AbstractController):
        self.charset = []
        self.earnings_multiplier = 1
        self.bet = 0
        self.choices = [None] * 9
        self.tot_matches = 0
        self.user_wallet = player.user_wallet
        self.repeat = True
        self.min_bet = 5
        self.max_bet = 60
        self.state = None
        self.player = player
        self.previous_state = prev_state

    # Concrete implementation of abstract class method
    # This and the getters are the only exposed points
    def execute(self):
        self.__set_difficulty()
        self.__ask_bet()
        self.__spin_slots()
        self.__display_slots()
        self.__check_matches()
        self.__user_delta()
        self.__reset_slots()
        self.__inquire()

    # Concrete implementation of public abstract class method
    def update_state():
        pass       

    # Concrete implementation of public abstract class method
    def transition(self):
        exit_sequence.exit()
        return self.previous_state

    # The only setter
    def _set_state(self, state):
        self.state = state
 
    def __set_difficulty(self):
        selection = SetDifficulty().render(msg = msgs.difficulty)
        self.charset, self.earnings_multiplier = selection
    
    def __house_transaction(self, val: float):
        self.user_wallet -= val
        self.bet = round((0.8 * val), 2)

    def __ask_bet(self):
        user_bet = AskBet().render(msg = msgs.bet, 
                                   min = self.min_bet,
                                   max = self.max_bet,
                                   wallet = self.user_wallet)
        self.__house_transaction(val = user_bet)
        DisplayAmount().render(wallet = self.user_wallet)
    
    def __spin_slots(self):
        self.choices = assign(char_list = self.charset, 
                              list = self.choices)
    
    def __display_slots(self):
        DisplaySlots().render(choices = self.choices)
    
    def __check_matches(self):
        self.tot_matches = matches(self.choices)

    def __user_delta(self):
        delta = calculate(bet = self.bet, 
                          matches = self.tot_matches, 
                          multiplier = self.earnings_multiplier)
        self.user_wallet += delta
        DisplayAmount().render(wallet = self.user_wallet, flag = 0)
        self.player.user_wallet = self.user_wallet
        self.player.update()

    def __inquire(self):
        query = input(msgs.inquire)
        self.repeat = resolve(query)

    def __reset_slots(self):
        self.choices = [None] * 9
    
    # Public getters
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
    
    def get_state(self):
        return self.state
