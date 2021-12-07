"""
Main Manu messages
"""
import random as random

def rand_msg():
    r = random.randint(0, 2)
    msg = joy[r]
    print(msg)

joy = ["Enjoy!", "Have fun!", "Break a leg!"]

main_selection = ("Please select from the following options: \n" + 
              "1: Play Blackjack. \n" +
              "2: Play Slots. \n" + 
              "3: Play Roulette. \n" + 
              "4: Change Settings. " + 
              "5: Logout. \n\n\t")

options = {
    '1': print("Starting Blackjack. " + rand_msg()),
    '2': print("Starting Slots. " + rand_msg()),
    '3': print("Starting Roulette. " + rand_msg()),
    '4': print("Bringing up your settings."),
    '5': print("Changing to the logout menu.")
}

