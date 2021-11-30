# This file contains the possible characters that can be
# spun in slots.  

# There are 3 difficulties

class wheel():
    """This class contains the lists of the varying difficulties for slots.
    """

    # The emojis in easy are:
    # 100, poop, party popper 
    # fire, eggplant, peach
    # Total in easy is 6.

    easy = ["\U0001f4af", "\U0001f4a9", "\U0001f389", 
            "\U0001f525", "\U0001f346", "\U0001f351"] 

    # The added emojis in medium are: 
    # heart eyes, cowboy
    # drool, hot, skull
    # Total in medium is 11.
    
    med = easy + ["\U0001f60d", "\U0001f920",
                  "\U0001f924", "\U0001f975", "\U0001f480"]

    # The added emojis in hard are:
    # cold, ghost
    # scream, angry w horns
    # Total in hard is 15.
    hard =  med + ["\U0001f976", "\U0001f47b",
                   "\U0001f631", "\U0001f608"]