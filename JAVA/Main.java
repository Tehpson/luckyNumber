package org.example;

public class Main {
    public static void main(String[] args) {
        var gameLogic = new GameLogic();
        var playing = true;

        System.out.println("You have " + gameLogic.Pix + " pix");
        while (playing){
            var bet = UserInput.GetBet(gameLogic);
            var luckyNumber = UserInput.GetLuckyNumber();
            gameLogic.RollDice();
            var corrects = gameLogic.CalculateCorrects(luckyNumber);
            gameLogic.UpdatePix(corrects,bet);
            playing = UserInput.PlayMore(gameLogic.Pix);
        }
    }
}
