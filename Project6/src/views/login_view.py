from src.views.abstract_view import AbstractView

class registrationView(AbstractView):
    def __init__(self) : 
        '''
        TODO : Setup canvas here.
        '''
        pass
    
    def render(self) :

        raise NotImplementedError('Controller has not defined method render()')

class AskAccountView(AbstractView):
    def __init__(self) : 
        pass
    def render(self) :
        print("please enter account or type 'register' to create a new account")
        response=input()
        return response

class AskPasswordView(AbstractView):
    def __init__(self) : 
        pass
    def render(self) :
        print("please enter your password or type 'log in another account' to login with another account")
        response=input()
        return response