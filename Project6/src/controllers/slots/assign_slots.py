"""assign_slots.py assigns values to the 9 slots available.
"""

import secrets

def assign(char_list: list, list: list) -> list:
    """This is accessed via the slot contorller's __spin_slots method.

    Args:
        char_list (list): This is the character set of the difficulty level chosen earlier.
        list (list): This is the empty list which will be randomly filled in from char_list

    Returns:
        list: This is the filled list of randomly chosen characters.
    """
    n_elements = len(char_list)

    # Next get random values from the charset 
    for index in range(len(list)):
        list[index] = char_list[secrets.randbelow(n_elements)]
    
    print("The lever arm is pulled and the slots spin.")
    return list