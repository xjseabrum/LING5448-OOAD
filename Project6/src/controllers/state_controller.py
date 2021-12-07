from src.controllers.login_controller import *

class states_controller():
    def __init__(self):
        self.initial_state=login()


    def execute(self) :
        
        state=self.initial_state

        while(True):
            next_state=state.execute()
            state=next_state
            if state==None:
                break
        print("finished")