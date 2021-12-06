from src.controllers.abstract_controller import AbstractController
from src.controllers.roulette_controller import rouletteController
from src.views.login_view import *
from src.models.user_model import *
from src.models.user_data_util import *
class login(AbstractController) :
    def __init__(self): 
        self.view=None
        self.cur_state=0
        self.account=None
        self.password=None

    def execute(self) :
        self.update_state()
        while(True):
            # account state
            response=self.view.render()
            if self.account==None:
                if response == "register":
                    return register(self)
                elif validate_account_or_password(response):
                    self.go_to_next_step()
                    self.account=response
                    continue
                else:
                    AccountOrPasswordErrorView().render()
                    continue

            # password state
            if response == 'log in another account':
                self.account=None
                self.go_to_prev_step()
                continue
            elif validate_account_or_password(self.account,response):
                self.password=response
                #goes to menu controller
                print("goes to menu controller")
                return rouletteController(UserModel.retrieve(self.account)[0],self)
            else:
                AccountOrPasswordErrorView().render()
                continue

    def go_to_next_step(self):
        self.cur_state+=1
        self.update_state()
        return
    def go_to_prev_step(self):
        self.cur_state-=1
        self.update_state()
        return
        


    def update_state(self) : 
        view_list = [AskAccountView(),AskPasswordView()]
        self.view=view_list[self.cur_state]
    
    def transition(self) : 
        raise NotImplementedError('Controller has not defined method transition()')

class register(AbstractController):
    def __init__(self,previous_state) : 
        self.view=None
        self.cur_state=0
        self.previous_state=previous_state

    def execute(self) :
        self.update_state()

        while(True):
            account=self.view.render()
            if validate_account_or_password(account):
                RegisterAccountExistedView().render()
                continue
            else:
                self.go_to_next_step()
                password=self.view.render()
                self.go_to_next_step()
                user_model=UserModel(account,password)
                user_model.create()
                self.view.render() 
                return self.previous_state


    def update_state(self) : 
        view_list = [AskRegisterAccountView(),AskRegisterPasswordView(),RegisterAccountSuccessView()]
        self.view=view_list[self.cur_state]
    
    def go_to_next_step(self):
        self.cur_state+=1
        self.update_state()
    
    def transition(self) : 
        raise NotImplementedError('Controller has not defined method transition()')