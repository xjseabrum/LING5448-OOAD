from src.controllers.slots.format_number import num_print

# This will round and check the bet
# against the constraints of [$5, $60]
# and against the user's wallet.

def verify(user_bet):
    """This will round and check the bet against the 
    constraints of [$5, $60] and against user's wallet.

    Args:
        user_bet ([type]): [description]

    Returns:
        [type]: [description]
    """

    try: 
        float(user_bet)
        isfloat = True
    except:
        isfloat = False
    
    if isfloat:
        as_float = float(user_bet)
        rounded_user_bet = round(as_float, 2)

        if(rounded_user_bet < 5):
            print("Detected bet less than $5.  Setting to $5.")
            return set_bet(5)

        elif(rounded_user_bet > 60):
            print("Detected bet greater than $60. Setting to $60.")
            return set_bet(60)

        else:
            print("Bet set to $" + num_print(rounded_user_bet) + ".")
            return set_bet(rounded_user_bet)

    else:
        print("Invalid input detected. Setting bet to $5.")
        return set_bet(5)

def set_bet(value):
    new_value = round(0.8 * value, 2)
    return new_value
