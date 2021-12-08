# This will assign the controller based on the choice that
# the user gave.

from src.controllers.abstract_controller import AbstractController
from src.controllers.slots.main import main_slots
# from src. import as blackjack_main
from src.controllers.settings.main import Settings
from src.controllers.roulette_controller import rouletteController
from src.controllers.blackjack_controller import BlackJackGame
from src.controllers.logout import LogOut
from src.models.user_model import UserModel


def change(choice, player: UserModel,
           prev_state: AbstractController) -> AbstractController:
    if choice == 1:
        # print(msgs.options[choice])
        controller = BlackJackGame(player, prev_state)
        return controller
    elif choice == 2:
        # print(msgs.options[choice])
        controller = main_slots(player, prev_state)
        return controller
    elif choice == 3:
        # print(msgs.options[choice])
        controller = rouletteController(player, prev_state)
        return controller
    elif choice == 4:
        controller = Settings(player, prev_state)
        return controller
    elif choice == 5:
        controller = LogOut(player, prev_state)
        return controller
    else:
        raise NotImplementedError('Invalid choice')
