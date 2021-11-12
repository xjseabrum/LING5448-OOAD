from src.lib.blackjack.constants import *
import random


class Deck(object): 

    def __init__(self) -> None:
        self._current_deck = self._prepare_deck()

    def _prepare_deck(self)->list :  
        """This is a private function that prepares a deck from a prototype. 

        Patterns User:
            Prototype

        Returns:
            list: Deck of cards, returned as a list in plain representation (no symbols.)
        """
        new_deck = DECK.copy()
        return new_deck

    def _shuffle_deck(self)->None : 
        """Shuffles the deck randomly. 
        """

        random.shuffle(self._current_deck)

    def _draw_cards(self, num_cards:int=1)->list: 
        """Private function that draws cards from the deck. 

        Args:
            num_cards (int, optional): Number of cards to draw 
            from the deck. Defaults to 1.

        Returns:
            list: list of cards drawn from the deck. 
        """

        cards = [self._current_deck.pop() for __ in range(num_cards)]
        return cards

    def deal(self, num_players:int, num_cards:int) -> list: 
        """The primary function of the class, is used to deal "hands" with a 
        particular number of cards to players at the table. 

        Args:
            num_players (int): Number of hands/players at the table receiving a card. 
            num_cards (int): Number of cards required per hand.

        Returns:
            list: num_playersxnum_cards multi-dim list, containing the cards 
            that each player receives. 
        """
        hands = []
        for _ in range(num_players) : 
            hands.append(self._draw_cards(num_cards))
        return hands


if __name__ == "__main__" : 

    deck = Deck()
    print(deck._current_deck)
    print(deck._shuffle_deck())
    print(deck._current_deck)
    print(len(deck._current_deck))
    print(deck._deal_cards())
    print(deck._deal_cards())
    print(deck._deal_cards())
    print(len(deck._current_deck))


