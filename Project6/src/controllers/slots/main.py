# Slots main file.
# All this does is start slots. 
from src.controllers.slots.controller import SlotsGame

def start():
    play_again = True
    while play_again == True:
        print("Hello, welcome to Slots!")
        game = SlotsGame()
        game.execute()
        play_again = game.get_repeat()
        if(play_again == False):
            game.transition()
            break

if __name__ == '__main__':
    start()