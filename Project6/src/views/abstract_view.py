from abc import ABC, abstractclassmethod


class AbstractView(ABC):

    def __init__(self):
        '''
        TODO : Setup canvas here.
        '''
        pass

    @abstractclassmethod
    def render(self):
        raise NotImplementedError('Controller has not defined method render()')
