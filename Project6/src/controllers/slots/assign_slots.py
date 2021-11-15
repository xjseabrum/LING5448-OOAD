"""assign_slots.py assigns values to the 9 slots available.
"""

import secrets

def assign(char_list, list):
    n_elements = len(char_list)

    # Next get random values from the charset 
    for index in range(len(list)):
        list[index] = char_list[secrets.randbelow(n_elements)]
    
    print("The lever arm is pulled and the slots spin.")
    return list