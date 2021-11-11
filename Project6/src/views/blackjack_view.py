from src.views.abstract_view import AbstractView

class DefaultView(AbstractView) : 

    def render(self, **kwargs) : 
        print("Rendering kwargs : ", kwargs)
