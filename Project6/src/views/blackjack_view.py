from src.views.abstract_view import AbstractView

class DefaultView(AbstractView) : 

    def render(self, **kwargs) : 
        print("Rendering kwargs : ", kwargs)

class MenuView(AbstractView) : 

    def render(self, **kwargs) : 
        print("Rendering kwargs : ", kwargs)
        
class GameView(AbstractView) : 

    def render(self, **kwargs) : 
        print("Rendering kwargs : ", kwargs)

class ResultView(AbstractView) : 

    def render(self, **kwargs) : 
        print("Rendering kwargs : ", kwargs)