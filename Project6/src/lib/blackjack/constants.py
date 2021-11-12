NUMBERS = [str(i) for i in range(1, 14)] 
SUITES = ['H', 'D', 'S', 'C']
DECK = [N+S for N in NUMBERS for S in SUITES]

VALUES = {
    '1' : 'A',
    '2' : '2',
    '3' : '3',
    '4' : '4',
    '5' : '5',
    '6' : '6',
    '7' : '7', 
    '8' : '8', 
    '9' : '9',
    '10' : '10',
    '11' : 'J', 
    '12' : '👑', 
    '13' : '☩', 
    'H' : '♥️', 
    'D' : '♦️', 
    'S' : '♠️', 
    'C' : '♣️'
}

INV_VALUES = {rep:val for val, rep in VALUES.items()}

print(DECK)




