package org.example;

import java.util.Locale;
import java.util.Scanner;

public class UserInput {
    public static int GetBet(GameLogic gameLogic){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("How Much do you want ot bet? you have " + gameLogic.Pix + " pix");
            var bet = Helper.TryParseInt(scanner.nextLine());
            if (bet == null || bet < 50 || bet > gameLogic.Pix){
                System.out.println("invalid amount");
            }
            else{
                gameLogic.Pix -= bet;
                return bet;
            }
        }
    }

    public static Integer GetLuckyNumber() {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Pick you number between 1-6");
            var number = Helper.TryParseInt(scanner.nextLine());
            if (number == null  || number < 1 || number > 6){
                System.out.println("invalid Input");
            }
            else{
                return number;
            }
        }
    }

    public static boolean PlayMore(int pix) {
        Scanner scanner = new Scanner(System.in);
        if(pix < 50){
            System.out.println("Game Over you only have " + pix + " pix left");
            return false;
        }else {
            System.out.println("You have " + pix + " left. Do you want to play more (Y/N) ");
            if ( scanner.nextLine().toUpperCase().equals("Y")){
                return true;
            }
            else return false;
        }
    }
}
