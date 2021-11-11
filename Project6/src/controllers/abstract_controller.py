from abc import ABC, abstractclassmethod

class AbstractController(ABC) : 

    def __init__(self) : 
        pass

    def set_state(self, state) : 
        self.state = state

    @abstractclassmethod
    def execute(self) :
        raise NotImplementedError('Controller has not defined method execute()')

    @abstractclassmethod
    def update_state(self) : 
        raise NotImplementedError('Controller has not defined method update_state()')
    
    
    @abstractclassmethod
    def transition(self) : 
        raise NotImplementedError('Controller has not defined method transition()')
