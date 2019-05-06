TODO: UNFINISHED P210

def salarycap(current_salaries, target):
    # exisiting salaray
    # total target pay
    # generte a single number: cap, so all pay will be under cap and meet the target

    current_salaries.sort()
    total = 0.0
    for i, salary in enumerate(current_salaries):
        adjusted_people = len(current_salaries) - i
