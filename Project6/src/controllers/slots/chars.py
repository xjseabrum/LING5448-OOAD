# This file contains the possible characters that can be
# spun in slots.  

# There are 3 difficulties

class wheel():

    # Traditionally, slots only had 10 characters per 
    # slot column.  The emojis in this set are:
    # keycap 7, A button, face w tongue, cowboy, skull, 
    # grinning face, strawberry, kiwi, peach, 
    # pineapple
        easy = ["\U0001f4b5", "\U0001F170", "\U0001f61b", "\U0001f920",
                "\U0001f480", 
                "\U0001f600", "\U0001f353", "\U0001f95d", "\U0001f351", 
                "\U0001f34d"]

    # In modern times, slots have between 15 and 25 characters
    # per slot column. Adding 6 more characters to bring the 
    # total to 16.
    # The added emojis are: 
    # poop, ghost, heart eyes, 
    # drool, hot, party popper
        med = easy + ["\U0001f4a9", "\U0001f47b", "\U0001f60d", 
                      "\U0001f924", "\U0001f975", "\U0001f389"]

    # For those who are insane, they can choose this difficulty.
    # Adding 16 more characters to bring the total to 32. 
    # The additions are:
    # pool 8, spade, fire, club, 
    # diamond, crown, heart, cold
    # sunglasses, pleading, scream, angry w horns,
    # eggplant, 100, broccoli, honey
        hard =  med + ["\U0001f3B1", "\U00002660", "\U0001f525", 
                       "\U00002663", 
                       "\U00002666", "\U0001f451", "\U00002665", 
                       "\U0001f976",
                       "\U0001f60e", "\U0001f97a", "\U0001f631", "\U0001f608", 
                       "\U0001f346", "\U0001f4af", "\U0001f966",
                       "\U0001f36f"]                         