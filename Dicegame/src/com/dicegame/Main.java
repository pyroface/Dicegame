package com.dicegame;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int playTimes = 0;
    static boolean loop = true;
    static int playerSum = 0;
    static int compSum = 0;

    static int[] highscore = new int[5];
    static int hsCounter = 0;

    public static void main(String[] args) {
      while(loop){
        menu();
      }
    }

    static void menu(){
      playerSum = 0;
      compSum = 0;

      System.out.println("\n1. Add your dice rolls");
      System.out.println("2. Play against the computer");
      System.out.println("3. See the scoreboard");
      System.out.println("0. Exit");
      System.out.println("--------------------");
      System.out.print("Make your choice: ");
      int choice = sc.nextInt();


      switch(choice){
        case 0: loop = false; break;
        case 1:
          System.out.print("add rolls: ");
          playTimes = sc.nextInt();
          break;
        case 2: castDice(); break;
        case 3:
          System.out.println("highscore");
          scoreBoard();
          break;
        default:System.out.println("No such option");
      }//Switch END
    }//menu END

    static void castDice(){
      if(playTimes == 0){
        System.out.println("Error!!! Choose how many dice rolls you want.");
      }else {
        int[] randomNumbers = new int[playTimes];
        int[] randomCompNumbers = new int[playTimes];
        Random rand = new Random();

        //Generate random rolls for the players
        for (int i = 0; i < randomNumbers.length; i++) {
          int n = rand.nextInt(6) + 1;
          int x = rand.nextInt(6) + 1;
          randomNumbers[i] = n;
          randomCompNumbers[i] = x;
        }
        //Prints the rolls
        for (int i = 0; i < randomNumbers.length; i++) {
          playerSum = playerSum + randomNumbers[i];
          compSum = compSum + randomCompNumbers[i];
          System.out.println("\nRoll " + i + "| " + "Player: " +
                  randomNumbers[i] + "    Computer: " + randomCompNumbers[i]);
        }
        System.out.println("---------------------------");
        System.out.println("player: " + playerSum + " Computer: " + compSum);

        decideWinner();
        hsCounter++;
      }
    }//Printrolls END

    static void scoreBoard(){
      int[] sortedScoreboard = new int[hsCounter];

      for (int i = 0; i < hsCounter; i++){
        sortedScoreboard[i] = highscore[i];
      }
      Arrays.sort(sortedScoreboard);

      for (int i = hsCounter - 1; i >= 0 ; i--){
        System.out.println(sortedScoreboard[i]);
      }
    }

    static void decideWinner(){
      if(hsCounter >= highscore.length){
        int[] temp = new int[highscore.length * 2];
        for (int i = 0; i < hsCounter; i++) {
          temp[i] = highscore[i];
        }
        highscore = temp;
      }

      if (playerSum > compSum) {
        System.out.println("You win");
        highscore[hsCounter] = playerSum;
      } else if (playerSum < compSum) {
        System.out.println("You lose");
        highscore[hsCounter] = compSum;
      } else {
        System.out.println("tie");
      }

    }





}
