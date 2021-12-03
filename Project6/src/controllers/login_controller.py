from src.controllers.abstract_controller import AbstractController
from src.views.login_view import *
from src.models.user_model import *
class login(AbstractController) :
    def __init__(self) : 
        self.view=None
        self.cur_state=0
        self.account=None
        self.password=None
    def set_state(self, state) : 
        self.cur_state=state

    def execute(self) :
        self.update_state()
        while(True):
            response=self.view.render()
            # account state
            if self.account==None:
                if response == "register":
                    # goes to register controller
                    print("goes to register controller")
                    return
                elif self.validate_account_or_password(response):
                    self.go_to_next_step()
                    self.account=response
                    continue
                else:
                    print("account doesn't exist, please try again")
                    continue

            # password state
            if response == 'log in another account':
                self.account=None
                self.go_to_prev_step()
                continue
            elif self.validate_account_or_password(self.account,response):
                self.password=response
                #goes to menu controller
                print("goes to menu controller")
                return
            else:
                print("password is wrong, please try again")
                continue

    def go_to_next_step(self):
        self.cur_state+=1
        self.update_state()
        return
    def go_to_prev_step(self):
        self.cur_state-=1
        self.update_state()
        return
        
    def validate_account_or_password(self,account,password=None):
        if password==None:
            if len(UserModel().retrieve(account))>0:
                return True
            else:
                return False
        if len(UserModel().retrieve(account, password))>0:
            return True
        
        return False

    def update_state(self) : 
        view_list = [AskAccountView(),AskPasswordView()]
        self.view=view_list[self.cur_state]
    
    def transition(self) : 
        raise NotImplementedError('Controller has not defined method transition()')

class register(AbstractController):
    def __init__(self) : 
        pass

    def set_state(self, state) : 
        self.state = state

    def execute(self) :
        registration_view=registrationView()


    def update_state(self) : 
        raise NotImplementedError('Controller has not defined method update_state()')
    
    def transition(self) : 
        raise NotImplementedError('Controller has not defined method transition()')