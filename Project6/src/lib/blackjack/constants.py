NUMBERS = ['A'] + [str(i) for i in range(2, 11)] + ['J', 'Q', 'K']
SUITES = ['♥️', '♦️', '♠️', '♣️']
DECK = [N + S for N in NUMBERS for S in SUITES]

VALUES = {
    'A': 1,
    '2': 2,
    '3': 3,
    '4': 4,
    '5': 5,
    '6': 6,
    '7': 7,
    '8': 8,
    '9': 9,
    '10': 10,
    'J': 10,
    'Q': 10,
    'K': 10,
    '♥️': 'H',
    '♦️': 'D',
    '♠️': 'S',
    '♣️': 'C',
}

INV_VALUES = {rep: val for val, rep in VALUES.items()}

ACTIONS = {'1': 'hit', '2': 'stay'}
