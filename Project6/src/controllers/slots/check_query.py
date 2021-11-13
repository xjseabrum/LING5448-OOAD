# Checks the user query to see if they want to play again.

def resolve(input):
    lowered = input.lower()
    if (lowered == 'y'):
        return True
    else:
        return False