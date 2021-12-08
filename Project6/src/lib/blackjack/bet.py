       

from abc import abstractmethod


class Bet(object) : 

    def __init__(self, wager:int, odds:float=1) -> None:
        """This object records and modifies the bet a user has wagered.
        It also hosts common operations related to betting, such as doubling down and paying out.  

        Args:
            wager (int): How much the user has bet. 
            odds (float, optional): The factor by which the odds are increased . Defaults to 1.
        """
        self._wager = wager
        self._bet = wager
        self._odds = odds

    def validate_wager(self, wager:int) -> bool:
        """Checks if wager is a number and is positive. It has to be real, non-zero positive integer, failing 
        which it returns False. 

        Args:
            wager (int): The wager to check. 

        Returns:
            bool: [description]
        """
        try: # checks if it is a number
            wager = int(wager)
            is_number = True
        except : 
            return False

        is_positive = wager>0 # checks if non-zero positive integer

        if is_number and is_positive : 
            return True

        return False


        

    def set_wager(self, wager:int) -> bool : 
        """Sets wager after the object has been initialized. 

        Args:
            wager (int): Amount to wager.
        """
 
        self._wager = wager


    def set_odds(self, odds: float) -> None : 
        """Selects odds after the object has been initialized. 

        Args:
            odds (float): The modifier for the payout
        """
        self._odds = odds

    def double_down(self) -> None: 
        """Double the wager.
        """

        self._bet+=self._wager

    def payout(self) -> float : 
        """How much money needs to be added/deducted from the player on account of their victory/defeat.

        Returns:
            float: Amount that they have received. 
        """

        return self._bet*self._odds


if __name__ == "__main__":

    bet = Bet(150, 2)
    print(bet._wager)
    print(bet._bet)
    print(bet.double_down())
    print(bet._bet)
    print(bet.payout())