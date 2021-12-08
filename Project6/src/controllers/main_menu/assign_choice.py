# This will assign the controller based on the choice that
# the user gave.

from src.controllers.abstract_controller import AbstractController
from src.controllers.slots import main as slots_main
# from src. import as roulette_main
# from src. import as blackjack_main
from src.controllers.settings import main as settings_screen
from src.controllers.roulette_controller import rouletteController
from src.controllers.blackjack_controller import BlackJackGame
import src.controllers.logout as logout_screen
from src.models.user_model import UserModel


def change(choice,player:UserModel,prev_state:AbstractController)->AbstractController:
    if choice == 1:
        controller = BlackJackGame()
        return controller
    elif choice == 2:
        controller = slots_main
        return controller
    elif choice == 3:
        controller = rouletteController(player,prev_state)
        return controller
    elif choice == 4:
        controller = settings_screen
        return controller
    elif choice == 5:
        controller = logout_screen()
        return controller
    else:
        raise NotImplementedError('Invalid choise')

