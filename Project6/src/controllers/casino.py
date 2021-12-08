# This is the file that is to be called by the user to kickstart 
# it all off.

from src.controllers.state_controller import states_controller

def execute():
    start = states_controller()
    start.execute()

if __name__ == "__main__":
    execute()