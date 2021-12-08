from src.lib.blackjack.dealer import Dealer
from src.lib.blackjack.deck import Deck
from src.lib.blackjack.bet import Bet
from src.lib.blackjack.player import Player
from src.lib.blackjack.constants import VALUES, ACTIONS

import random

class BlackJack(object) : 


    def __init__(self, num_players:int=1) -> None:

        self.deck = Deck()
        self.bet = Bet(wager=0)
        self.num_human_players = num_players
        self.num_players = num_players+1

        self.pit = {}
        self.scores = {}

        self.proposed_odds = 0
        self.proposed_wager = 0
    
    def get_odds(self)-> float:
        """Generates a random odds between 1-5, upper-bound inclusive. The
        odds may be accepted or rejected by the user. 

        Returns:
            float: The odds of the bet. 
        """
        self.proposed_odds = 1 + 4*random.random()
        return  self.proposed_odds


    def set_odds(self):
        """Once the odds are agreeable to the player, it is set!
        """

        self.bet.set_odds(self.proposed_odds)
        
    def get_wager(self, wager: int)-> dict:
        """User inputs the wager. This function checks if the wager is 
        legitimate. 

        Args:
            wager (int): [description]

        Returns:
            bool: [description]
        """
        self.proposed_wager = wager
        return self.bet.validate_wager(wager) & self.player.check_funds(wager)

    def set_wager(self) : 
        """Once the checks on the wager are done, the wager can be set. 
        """
        self.bet.set_wager(self.proposed_wager)

    def opening_deal(self)->list:
        """The first deal is made by dealing 2 cards to the dealer and the 
        player each. 

        Returns:
            list: list of cards that were dealt. 
        """

        dealt_cards = self.deck.deal(self.num_players, 2)
        for player, cards in enumerate(dealt_cards) : 
            
            score = self._score(cards)
            valid = score<21
            blackjack = score==21

            self.pit[player] = {'cards':cards, 'score':score, 'valid':valid, 'blackjack':blackjack} 

        return self.pit

    def player_action(self, player: int, action: str)->None :
        """This function will take inputs from the user and respond according to the
        rules of the game. 
        """
        player_hand = self.pit[player]
        action = ACTIONS[action]
        
        if action.lower()=='hit' : 
            
            card = self.deck.deal(1, 1)[0]
            player_hand['cards'] += card
            player_hand['score'] = self._score(player_hand['cards'])
            player_hand['valid'] = player_hand['score'] <= 21
            player_hand['blackjack'] = player_hand['score']==21

        elif action.lower() == 'stay' : 
            player_hand['valid'] = False
        else:
            pass

        return player_hand


    def _score(self, hand:list)->int:
        """Gives a score to each hand. For example, a hand of [QD, 2C] 
        will return a score of 12 (10+2). 

        Args:
            hand (list): The hand as a list of cards. 

        Returns:
            int: The score of the resulting hands. 
        """

        score = 0
        aces = 0

        for card in hand : 
            
            if card[0] == "A" : 
                aces += 1
            elif card[:2]=="10" : 
                score += 10
            else : 
                score += VALUES[card[0]]

        if aces==0 : 
            return score
        else : 
            max_score = (aces-1)+11+score 
            min_score = aces+score

            return max_score if max_score <= 21 else min_score

    def get_victors(self) : 

        victors = []
        max_score = 0

        for player, hand in self.pit.items() : 

            player_name = "HUMAN" if player==0 else "DEALER"

            if (hand['score'] > max_score) and (hand['score']<=21) : 

                victors = [player_name]
                max_score = hand['score']

            elif hand['score'] == max_score : 
                victors.append(player_name)

            else : 
                pass
        
        
        return victors, max_score

            

if __name__ == "__main__" : 

    num_players = 1
    black_jack = BlackJack(num_players)
    print(black_jack._score(['3♠️', '8♣️']))
