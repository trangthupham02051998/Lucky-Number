package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static int totalGuess;
    static int totalGame = 0;
    static double avgGame = 0;
    static int best = 0;
    static String playAgain;
    boolean isInt = false;

    public static void main(String[] args) {
        Play();
        BaoCao();
    }



    public static void Play() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        boolean isInt = false;
        do {
            do {
//            Tao Random Number
            int ranDomNum = random.nextInt(100);
            int aNumberGuess = 1;
            int numberGuess;
            System.out.println(ranDomNum);
            System.out.println("Lucky Number from 0 - 100");
//            Doan so may  man

                try {

                    do {
                        System.out.println("Lucky Number is:");
                        numberGuess = sc.nextInt();
                        isInt = true;
                        if (numberGuess > ranDomNum) {
                            System.out.println("Lucky Guess Smaller");
                            aNumberGuess++;
                        } else if (numberGuess < ranDomNum) {
                            System.out.println("Lucky Guess Bigger");
                            aNumberGuess++;
                        } else {
                            System.out.println("You're Correct " + aNumberGuess);
                        }
                    } while (numberGuess != ranDomNum);

                    totalGuess += aNumberGuess;
                    totalGame++;
                    avgGame = (double) totalGuess / totalGame;
                    if (aNumberGuess < best || best == 0) {
                        best = aNumberGuess;
                    }
                    System.out.println("You want play again?");
                    playAgain = sc.next();
                }catch (Exception e) {
                        System.out.println("Not an integer. Try again: ");
                        sc.nextLine();
                        continue;
                    }
                    } while (playAgain.equalsIgnoreCase("y") || playAgain.equalsIgnoreCase("yes"));

        } while (!isInt);
    }
    public static void BaoCao() {
        System.out.println(" Overall result: ");
        System.out.println(" Total game =" + totalGame);
        System.out.println(" Total guesses =" + totalGuess);
        System.out.println(" Guesses/game =" + avgGame);
        System.out.println(" Best game =" + best);
    }
}
