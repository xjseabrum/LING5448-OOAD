class Dealer(object):

    def dealer_actions(self, highest_score: int, dealer_hand: dict) -> str:

        if dealer_hand['score'] >= highest_score:
            return '2'

        else:
            return '1'
