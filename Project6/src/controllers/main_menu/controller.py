# This is the main menu.
# Users will be able to select which game they want to play
# They can also access settings and a logout screen.

# It needs to have access to the different controllers
# These will be imported up h

from src.controllers.abstract_controller import AbstractController
from src.controllers.main_menu.view import Display
import src.controllers.main_menu.msgs as msgs


class MainMenu(AbstractController):
    def __init__(self):
        # Define a veriable that keeps track of if the user has seen the
        # MainMenu
        self.user_seen = False
        self.state = None
        self.user_choice = None
    
    def execute(self):
        if ~self.user_seen:
            print("Hello, welcome to the Terminal Casino! \n")
        else:
            print("Welcome back. \n")
            self.user_seen = True
        Display().render(msg = msgs.main_selection)
        self.user_choice = Display().get_choice
        self.update_state()
        self.transition()

    def update_state(self):
        self.state = None

    def transition(self):
        new_controller = self.state
        new_controller.execute()
        self.user_choice = None

    def _set_state(self, state):
        self.state = state


if __name__ == '__main__':
    controller = MainMenu()
    controller.execute()