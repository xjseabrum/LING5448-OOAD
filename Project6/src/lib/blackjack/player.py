from src.lib.core.user import User


class Player(object) : 



    def __init__(self, user: User) -> None:
        self._player = user

    def _validate_wager(self, amount:float)->bool:
        """TODO: A precursor before placing the wager, this private function
        makes checks to ensure the player is not making spurious bets. 

        For instance, it may ensure that the bet placed by the user is less than 
        what they have in their purse. 

        Args:
            amount (float): The amount that was placed in the bet. 

        Returns:
            bool: True if the bet is valid, False otherwise. 
        """

        return True

    def place_wager(self, amount:float)->int:
        """TODO: Function that places the wager at the start of the game.
        It will be validated before being allowed.

        Args:
            amount (float): The amount that was placed in the bet.

        Returns:
            int: Returns back the amount, if the wager is successful. 
        """

        pass



