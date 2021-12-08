# Slots main file.
# All this does is start slots.
from src.controllers.abstract_controller import AbstractController
from src.controllers.slots.controller import SlotsGame
from src.models.user_model import UserModel


class main_slots(AbstractController):
    def __init__(self, player: UserModel, prev_state: AbstractController):
        self.player = player
        self.previous_state = prev_state
        self.play_again = True

    def execute(self):
        while self.play_again == True:
            print("Hello, welcome to Slots!")
            game = SlotsGame(self.player, self.previous_state)
            game.execute()
            self.play_again = game.get_repeat()
            if(self.play_again == False):
                return self.previous_state

    def update_state(self):
        pass

    def transition(self):
        return self.previous_state
