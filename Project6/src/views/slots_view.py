    """Views for Slots!
    """

from src.views.abstract_view import AbstractView


class SlotsView(AbstractView):
    def render(self, **kwargs):
        print(kwargs)