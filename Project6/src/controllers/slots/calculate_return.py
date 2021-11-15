# This will calculate the return given back to the player
# based on the number of matches they got and 
# the diffuculty multiplier

from src.controllers.slots.format_number import num_print
import math as m

def calculate(bet: float, matches: int, multiplier: int) -> float:
    """This is accessed via _user_wallet in slots_controller.
    This is not access publically.

    Args:
        bet (float): Automatically filled in by the slot_controller's self.bet
        matches (int): Automatically filled in by the slot_controller's self.matches
        multiplier (int): Automatically filled in by the slot_controller's self.multiplier

    Returns:
        float: This is called dispense.  This is the amount given to the user's wallet.
    """
    # Internal check to ensure that matches is strictly between 0 and 8
    constrained_matches = constraint(matches)

    # Boolean of if the user even got any matches
    match_check = bool(constrained_matches > 0)
    
    # Perc increase function if there is any matches
    perc_increase = match_check * (1.5 + (constrained_matches - 1)*0.1)

    # Math behind dispense:
    dispense = round((match_check * multiplier * perc_increase * bet), 2)
    print("You won $" + num_print(dispense) + "!")
    return dispense

def constraint(value):
    if value > 8:
        constraint = 8
    elif value < 0:
        constraint = 0
    else:
        constraint = m.floor(value)
    return constraint
