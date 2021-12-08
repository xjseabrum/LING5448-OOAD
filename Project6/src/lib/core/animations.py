import time
import os

def display_msg(method, message, animation_delay=0.5, leading_elipsis=3, trailing_elipsis=False, acceptable_inputs=None) : 

    for i in range(leading_elipsis) : 
        print("...")
        time.sleep(animation_delay)

    if method.upper() == "POST" : 
        print(message)
        time.sleep(animation_delay)
    else : 
        if acceptable_inputs is not None :
            while True : 
                user_input = input(message)
                if user_input in acceptable_inputs : return user_input
                print("Sorry, but I could not understand that request.\n")



    for i in range(trailing_elipsis) : 
        print("...")
        time.sleep(animation_delay)


def clear_screen():
    os.system('cls' if os.name == 'nt' else 'clear')

def _player_or_computer(player_num) : 
    
    if player_num==0 : 
        return "HUMAN"
    else : 
        return "DEALER"


def _display_center(pit, gap=50) : 

    stencil="{}\n{}\n{}"
    row_format = "{}\t"
    message = ""
    
    
    for player, hand in pit.items() : 
        print("\n")
        cards = "\t".join(hand['cards'])
        score = "Score : {}".format(str(hand['score']))
        turn = "{}".format(_player_or_computer(player))

        cards = row_format.format(cards)
        score = row_format.format(score)
        turn = row_format.format(turn)
        message += stencil.format(cards, score, turn)
        message += "\n"*gap
        
    print(message.strip())


def display_pit(pit, num_players) : 

    if num_players==1 : 
        _display_center(pit, gap=3)
    
    elif num_players==2 : 
        display_preset = "inline"

    else : 
        display_preset = "default"


