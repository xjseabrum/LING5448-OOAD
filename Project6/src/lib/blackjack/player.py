from src.lib.core.user import User


class Player(object) : 


    def __init__(self, user: User) -> None:
        """The Player object that is playing the game. It has a reference to the User object. 
        This may be refactored in future updates as it is probably not a good idea to pass a reference 
        of the model deep in the controller. 

        Args:
            user (User): The User that is playing the game.
        """
        self._player = user
        self.name = user.name
        self.wallet = user.wallet

    def check_funds(self, amount:float)->bool:
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
        valid_wager = self.check_funds(amount)
        if valid_wager:
            return amount 

        return 0

    



