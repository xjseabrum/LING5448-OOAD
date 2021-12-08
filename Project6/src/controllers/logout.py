# This will log out the user
# It will return a new log in controller

from src.controllers.abstract_controller import AbstractController
import src.controllers.login_controller as login
from src.models.user_model import UserModel


class LogOut(AbstractController):
    def __init__(self, player: UserModel, prev_state: AbstractController):
        self.player = player
        self.previous_state = None

    def execute(self):
        print("You have been logged out. \n\n")
        self.transition()

    def update_state(self):
        pass

    def transition(self):
        return self.previous_state
