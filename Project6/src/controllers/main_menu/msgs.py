"""
Main Manu messages
"""
import random as random

def rand_msg():
    r = random.randint(0, 2)
    msg = joy[r]
    return msg

joy = ["Enjoy!", "Have fun!", "Break a leg!"]

main_selection = ("Please select from the following options: \n" + 
              "1: Play Blackjack. \n" +
              "2: Play Slots. \n" + 
              "3: Play Roulette. \n" + 
              "4: Change Settings. \n" + 
              "5: Logout. \n\n\t")

options = {
    '1': "Starting Blackjack. " + rand_msg(),
    '2': "Starting Slots. " + rand_msg(),
    '3': "Starting Roulette. " + rand_msg(),
    '4': "Bringing up your settings.",
    '5': "Logging out..."
}

