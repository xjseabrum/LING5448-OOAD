# This will assign the controller based on the choice that
# the user gave.

from src.controllers.slots import main as slots_main
# from src. import as roulette_main
# from src. import as blackjack_main
from src.controllers.settings import main as settings_screen
import src.controllers.logout as logout_screen


def change(choice):
    if choice == 1:
        # controller = blackjack_main
        # return controller
        pass
    elif choice == 2:
        controller = slots_main
        return controller
    elif choice == 3:
        # controller = roulette_main
        # return controller
        pass
    elif choice == 4:
        controller = settings_screen
        return controller
    elif choice == 5:
        controller = logout_screen
        return controller

