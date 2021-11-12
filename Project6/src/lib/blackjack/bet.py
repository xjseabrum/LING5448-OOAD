       

class Bet(object) : 

    def __init__(self, wager:int, odds:float=1) -> None:
        """[summary]

        Args:
            wager (int): [description]
            odds (float, optional): [description]. Defaults to 1.
        """
        self._wager = wager
        self._bet = wager
        self._odds = odds

    def double_down(self) -> None: 
        """[summary]
        """

        self._bet+=self._wager

    def payout(self) -> float : 
        """[summary]

        Returns:
            float: [description]
        """

        return self._bet*self._odds


if __name__ == "__main__":

    bet = Bet(150, 2)
    print(bet._wager)
    print(bet._bet)
    print(bet.double_down())
    print(bet._bet)
    print(bet.payout())