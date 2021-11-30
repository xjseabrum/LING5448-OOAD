from itertools import groupby
import numpy as np

# This is here to evaluate the board for the number of matches on it
# the maximum number of matches is 8.

# Function all_equal is taken from 
# https://stackoverflow.com/questions/3844801/check-if-all-elements-in-a-list-are-identical
def all_equal(iterable):
    g = groupby(iterable)
    return next(g, True) and not next (g, False)

# Collect the slices of the board
def collect_slices(board: list) -> list:
    """This function will take in the list of random characters generated earlier and arrange them in such a way to check the number of matches on the board.

    Args:
        board (list): This is generated beforehand in the slot contorller's __spin_slots method.

    Returns:
        list: Returns a list of lists that contains all the possible triplets on the board.
    """
    # Arrange the board into a matrix to
    # do slice operations on it
    matrix = np.mat([board[0:3], 
                     board[3:6], 
                     board[6:9]])

    # Collect the rows, cols, and diags into
    # an iterable list to be checked for matches

    collection = []

    # Gather the rows and columns. This is a square matrix
    # so we can take advantage of that.
    for row_idx in range(3):
        collection.append(matrix[row_idx][:].tolist()[0])
        # The columns are the transpose while still using the row_idx
        collection.append(matrix.T[row_idx][:].tolist()[0])

    # Left diagonal is the main diagonal
    l_diag = matrix.diagonal().tolist()[0]
    
    # Right diagonal is the diagonal after a left-right flip
    r_diag = np.fliplr(matrix).diagonal().tolist()[0]

    # Append the left and right diagonals
    collection.append(l_diag)
    collection.append(r_diag)

    return collection

# Ennumerate the number of matches
def matches(board: list) -> int:
    """This function counts the number of matches on the board

    Args:
        board (list): This is generated beforehand in the slot contorller's __spin_slots method. 

    Returns:
        int: This is the number of matches on the board, from 0-8, inclusive.
    """
    examine = collect_slices(board)

    num_matches = 0

    # Iterate through the list
    for step in range(len(examine)):
        if(all_equal(examine[step])):
            num_matches += 1

    print("The board has " + str(num_matches) + " match(es) on it!") 
    return num_matches
