import time

def display_msg(method, message, animation_delay=0.5, leading_elipsis=3, trailing_elipsis=False) : 

    for i in range(leading_elipsis) : 
        print("...")
        time.sleep(animation_delay)

    if method.upper() == "POST" : 
        print(message)
        time.sleep(animation_delay)
    else : 
        return input(message)

    for i in range(trailing_elipsis) : 
        print("...")
        time.sleep(animation_delay)

