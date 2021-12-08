from abc import ABC, abstractclassmethod


class AbstractModel(ABC):

    def __init__(self):
        pass

    @classmethod
    @abstractclassmethod
    def create(self):
        raise NotImplementedError('Controller has not defined method create()')

    @classmethod
    @abstractclassmethod
    def update(self):
        raise NotImplementedError('Controller has not defined method update()')

    @classmethod
    @abstractclassmethod
    def retrieve(self):
        raise NotImplementedError(
            'Controller has not defined method retrieve()')

    @classmethod
    @abstractclassmethod
    def delete(self):
        raise NotImplementedError('Controller has not defined method delete()')
