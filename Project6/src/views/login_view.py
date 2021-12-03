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
class AccountOrPasswordErrorView(AbstractView):
    def __init__(self) : 
        pass
    def render(self) :
        print("Account or Password does not exisit or incorrect, please enter again")
        return 

class AskRegisterAccountView(AbstractView):
    def render(self) :
        print("please set your account")
        response=input()
        return response

class AskRegisterPasswordView(AbstractView):
    def render(self) :
        print("please set your password")
        response=input()
        return response

class RegisterAccountExistedView(AbstractView):
    def render(self):
        print("Entered account already exisit, please change it")
        return 
class RegisterAccountSuccessView(AbstractView):
    def render(self):
        print("Account create success")
        return 