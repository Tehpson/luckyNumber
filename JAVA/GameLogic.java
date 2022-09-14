package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameLogic {
     List<Integer> Dices = new ArrayList<Integer>();
     int Pix = 500;

     public void RollDice(){
         var rand = new Random();
         Dices.clear();
         Dices.add(rand.nextInt(1,7));
         Dices.add(rand.nextInt(1,7));
         Dices.add(rand.nextInt(1,7));
         for (var dice:Dices) {
             System.out.println(dice);
         }
     }

     public int CalculateCorrects(int luckyNumber){
         var corrects = 0;
         for (int dice: Dices) {
             if(dice==luckyNumber){
                 corrects++;
             }
         }
         return corrects;
     }

     public void UpdatePix(int corrects, int bet){
         Pix += corrects != 0 ? bet*(corrects+1):0;
     }
}
