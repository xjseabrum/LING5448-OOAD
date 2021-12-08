# Checks the user query to see if they want to play again.

def resolve(input: str) -> bool:
    """This checks to see is the user wants to play the game again.

    Args:
        input (str): This is the input that the user gives to the console.

    Returns:
        bool: A true/false given back to tell the controller to either exit or restart the game.
    """
    lowered = input.lower()
    if (lowered == 'y'):
        return True
    else:
        return False
