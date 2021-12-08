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
        print("Please enter your username or type 'register' to create a new account")
        response=input()
        return response

class AskPasswordView(AbstractView):
    def __init__(self) : 
        pass
    def render(self) :
        print("Please enter your password or type 'log in another account' to login with another account")
        response=input()
        return response
class AccountOrPasswordErrorView(AbstractView):
    def __init__(self) : 
        pass
    def render(self) :
        print("Account or Password does not exist or is incorrect, please try again.")
        return 

class AskRegisterAccountView(AbstractView):
    def render(self) :
        print("Please set up your account.")
        response=input()
        return response

class AskRegisterPasswordView(AbstractView):
    def render(self) :
        print("Please set your password.")
        response=input()
        return response

class RegisterAccountExistedView(AbstractView):
    def render(self):
        print("Entered account already exists, please try again.")
        return 
class RegisterAccountSuccessView(AbstractView):
    def render(self):
        print("Account created successfully!")
        return 