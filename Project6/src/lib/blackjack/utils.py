def score_is_legal(score: int) -> bool:
    if score <= 21:
        return True
    return False


def score_is_21(score: int) -> bool:
    return score == 21


def calculate_result(score: int, highscore: int) -> str:

    is_legal = score_is_legal(score)
    is_blackjack = score_is_21(score)

    if not is_legal:
        return 'bust'
    elif is_blackjack:
        return 'blackjack'
    elif score == highscore:
        return 'highscore'
    elif (score > highscore) and is_legal:
        return 'new-highscore'
    else:
        return 'valid'
