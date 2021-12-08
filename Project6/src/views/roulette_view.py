from src.views.abstract_view import AbstractView
from src.lib.core.format_number import num_print
import time


class welcomeView(AbstractView):
    def __init__(self):
        pass

    def render(self):
        print("Welcome to Roulette! Place the number of the token you want to put, followed by the bets, or type spin to spin the roulette table.")
        print("For example, type '100 5' will bet 100 dollars on number '5'")


class rouletteTableView(AbstractView):
    def __init__(self):
        pass

    def render(self):
        print("Avalible bet:")
        print("'1', '2', '3' ..... '36', which wins back 36 times the money you put")
        print("'1-12', '13-24', '25-36', which wins back 3 times the money you put")
        print("'1-18', '19-36', which wins back 2 times the money you put")
        print("'even', 'odd', which wins back 2 times the money you put")
        print("'red', 'black', which wins back 2 times the money you put")


class invalidInputView(AbstractView):
    def __init__(self):
        pass

    def render(self):
        print("Sorry, your input format is not valid. Please try again.")


class accountBalanceNotEnoughView(AbstractView):
    def __init__(self):
        pass

    def render(self):
        print("Sorry, your balance is insufficient")


class betInputView(AbstractView):
    def __init__(self):
        pass

    def render(self):
        print("Please place your bet or type 'spin' to spin the roulette table:")
        response = input()
        return response


class betPutView(AbstractView):
    def __init__(self, bets: list):
        self.bets = bets

    def render(self):
        for x in self.bets:
            bet_money, bet_string = x[0], x[1]
            print("You bet $" + num_print(bet_money) + " on " + bet_string)


class spinView(AbstractView):
    def __init__(self, result: str):
        self.result = result

    def render(self):
        print('The spin result is\n.')
        for _ in range(3):
            time.sleep(0.5)
            print('.')
        print(self.result)


class earningCaculateView(AbstractView):
    def __init__(self, result: int, user_balance: int):
        self.user_balance = user_balance
        self.result = result

    def render(self):
        print("---------")
        print(
            'Money you earned/loss in this game : $' +
            num_print(
                self.result) +
            ".")
        print('You now have $' + num_print(self.user_balance) + ".")


class againOrLeaveView(AbstractView):
    def __init__(self):
        pass

    def render(self):
        print("Type 'quit' to leave the game or press any key to start a new game.")
        return input()
