from src.controllers.abstract_controller import AbstractController
from src.views.roulette_view import *
from src.models.user_model import *
import random

class Bet():
    def __init__(self,bet_money,bet_string):
        self.bet_string=bet_string
        self.bet_money=int(bet_money)
    def fit(self,number:int,color:str)->bool:
        fit_range=self.convert_bet_string_to_bet(self.bet_string) 
        return number in fit_range or color in fit_range
    def convert_bet_string_to_bet(self,bet_string):
        if '-' in bet_string:
            lower_bound=int(bet_string.split("-")[0])
            upper_bound=int(bet_string.split("-")[1])
            return [x for x in range(lower_bound,upper_bound+1)]
        if bet_string.isnumeric():
            return [int(bet_string)]
        if bet_string=='even':
            return [x for x in range(1,37) if x%2==0]
        if bet_string=='odd':
            return [x for x in range(1,37) if x%2==1]
        if bet_string=='red':
            return ['red']
        if bet_string=='black':
            return ['black']

class rouletteController(AbstractController):
    def __init__(self,player:UserModel,prev_state:AbstractController) : 
        self.player=player
        self.roulette_table=rouletteTable()
        self.bets=[]
        self.previous_state=prev_state

    def set_state(self, state) : 
        self.state = state

    def execute(self) :
        welcomeView().render()
        rouletteTableView().render()
        while(True):
            bet_string=betInputView().render()
            if bet_string=="spin":
                spin_result=self.roulette_table.spin()
                spinView(spin_result).render()
                earn,loss=self.calculate_bet(spin_result)
                self.player.user_wallet+=earn
                earningCaculateView(earn-loss,self.player.user_wallet).render()
                self.player.update()
                self.bets=[]
                response=againOrLeaveView().render()
                if response=='quit':
                    return self.previous_state
                else:
                    continue
            if not self.validate_input_format(bet_string):
                invalidInputView().render()
                continue
            dollar,bet=bet_string.split(" ")[0],bet_string.split(" ")[1]
            if not self.checkBalanceIsEnough(dollar):
                accountBalanceNotEnoughView().render()
                continue
            
            self.bets.append(Bet(dollar,bet))
            self.player.user_wallet-=int(dollar)
            betPutView([(x.bet_money,x.bet_string) for x in self.bets]).render()
            

    def calculate_bet(self,spin_result):
        earn=0
        loss=0
        result_number=spin_result[0]
        result_color=spin_result[1]
        for bet in self.bets:
            if bet.fit(result_number,result_color):
                earn+=bet.bet_money*self.roulette_table.rate_table[bet.bet_string]
            else:
                loss+=bet.bet_money
        return earn,loss
    def checkBalanceIsEnough(self, bet_dollar): 
        return int(bet_dollar)<=self.player.user_wallet
    def validate_input_format(self,s):
        return " " in s and s.split(" ")[1] in self.roulette_table.rate_table.keys() and s.split(" ")[0].isnumeric()
    def update_state(self) : 
        raise NotImplementedError('Controller has not defined method update_state()')
    def transition(self) : 
        raise NotImplementedError('Controller has not defined method transition()')

class rouletteTable:
    def __init__(self):
        self.rate_table=dict.fromkeys([str(i) for i in range(1,37)],36)
        self.rate_table.update(dict.fromkeys(['1-12','13-24','25-36'],3))
        self.rate_table.update(dict.fromkeys(['1-18','19-36','even','odd','red','black'],2))
        self.spin_table=[(x,'red') if x in [1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36] else (x,'black')for x in range(1,37) ]
    def spin(self):
        return random.choice(self.spin_table)


