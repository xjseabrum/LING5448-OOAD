from src.views.abstract_view import AbstractView
from src.lib.core.animations import display_msg

class DefaultView(AbstractView) : 

    def render(self, **kwargs) : 
        print("Rendering kwargs : ", kwargs)

class MenuView(AbstractView) : 

    def render(self, **kwargs) : 
        print("Rendering kwargs : ", kwargs)
        
class GameView(AbstractView) : 

    import time

    def __init__(self) : 
        self.prefix = ""
        self.animation_delay = 0.5
        self.leading_elipsis = 0

    def _get_prefix(self, player_num): 
        return "PLAYER {} -> ".format(player_num)


    def render(self, **kwargs) : 
        
        prefix = "PLAYER {}-> ".format(kwargs['player_num']) if 'player_num' in kwargs else self.prefix
        prefix = "DEALER ->" if 'is_dealer' in kwargs and kwargs['is_dealer'] else prefix
        animation_delay = kwargs['animation_delay'] if 'animation_delay' in kwargs else self.animation_delay
        leading_elipsis = kwargs['leading_elipsis'] if 'leading_elipsis' in kwargs else self.leading_elipsis

        if 'method' in kwargs : 
            return display_msg(kwargs['method'], prefix + kwargs['message'], animation_delay, leading_elipsis)
            

class ResultView(AbstractView) : 

    def render(self, **kwargs) : 
        print("Rendering kwargs : ", kwargs)