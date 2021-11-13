# This will take in the user input
# and select the appropriate difficulty

import chars

def select(user_input): 
    if (user_input == "2"):
        print("Difficulty set to medium.  Earnings will be 2x.")
        return (chars.wheel().med, 2)

    elif (user_input == "3"):
        print("Difficulty set to hard.  Earnings will be 10x.")
        return(chars.wheel().hard, 10)

    else:
        print("Difficulty set to easy.  Earnings will be 1x.")
        return(chars.wheel().easy, 1)