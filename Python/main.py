from random import randint

pix = 500


def Playing():
    global pix
    continueLoop = True
    bet = 0
    luckyNumber = 0
    Dices = []

    while continueLoop:
        betInput = try_parse_int(input("How much do you want to bet?"))
        if betInput is None or betInput < 50 or betInput > pix:
            print("Bad Input")
        else:
            continueLoop = False
            pix = pix - betInput
            bet = betInput

    continueLoop = True
    while continueLoop:
        diceInput = try_parse_int(input("what is your lucky number"))
        if diceInput is None or diceInput < 1 or diceInput > 6:
            print("Bad input")
        else:
            continueLoop = False
            luckyNumber = diceInput

    print("Rolling Dices")
    Dices.append(randint(1, 7))
    Dices.append(randint(1, 7))
    Dices.append(randint(1, 7))

    correct = 0
    for dice in Dices:
        print(dice)
        if dice == luckyNumber:
            correct += 1

    print("you got " + str(correct) + " dice correct")
    if correct > 0:
        pix += bet * (correct + 1)


def try_parse_int(text):
    try:
        return int(text)
    except:
        return None


if __name__ == '__main__':
    playing = True

    print("You have " + str(pix) + "pix")
    while playing:
        Playing()
        print("You have " + str(pix) + "pix")
        if pix >= 50:
            yn = input("Do you want to Continue (Y/N)").lower()
            if yn == "n":
                playing = False
        else:
            print("Game Over")
            playing = False
