
def CheckFloat(input):
    try:
        float(input)
        return True
    except BaseException:
        return False
