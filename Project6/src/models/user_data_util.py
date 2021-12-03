from src.models.user_model import *

def validate_account_or_password(account,password=None):
    if password==None:
        if len(UserModel().retrieve(account))>0:
            return True
        else:
            return False
    if len(UserModel().retrieve(account, password))>0:
        return True
    return False