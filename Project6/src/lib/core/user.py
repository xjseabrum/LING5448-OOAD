from src.models.user_model import UserModel


class User(object):
    """A concrete entity retrieved from the UserModel table.

    Args:
        **kwargs (dict): Keyword arguments to find the exact user. For instance,
        you could provide the username to retreive the required User.
    """

    def __init__(self, **kwargs) -> None:
        self._user = UserModel().retrieve(**kwargs)
