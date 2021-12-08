# This is the main menu.
# Users will be able to select which game they want to play
# They can also access settings and a logout screen.

# It needs to have access to the different controllers
# These will be imported up h

from src.controllers.abstract_controller import AbstractController
from src.controllers.main_menu.view import Display
import src.controllers.main_menu.msgs as msgs
import src.controllers.main_menu.assign_choice
from src.models.user_model import UserModel


class MainMenu(AbstractController):
    def __init__(self, player: UserModel):
        # Define a veriable that keeps track of if the user has seen the
        # MainMenu
        self.user_seen = False
        self.state = None
        self.user_choice = None
        self.player = player

    def execute(self):
        if ~self.user_seen:
            print("Hello, welcome to the Terminal Casino! \n")
        else:
            print("Welcome back. \n")

        self.user_seen = True
        display = Display()
        display.render(msg=msgs.main_selection)
        self.user_choice = display.get_choice()
        return src.controllers.main_menu.assign_choice.change(
            self.user_choice, self.player, self)

    def update_state(self):
        self.state = None

    def transition(self):
        # Not used
        new_controller = self.state
        new_controller.execute()
        self.user_choice = None

    def _set_state(self, state):
        self.state = state
