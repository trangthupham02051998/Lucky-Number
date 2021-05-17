package com.company;

import java.util.Random;
import java.util.Scanner;

public class LuckyNumber {
    //    Khai bao cac bien
    static int totalGuess = 0;
    static int totalGame = 0;
    static double avgGame = 0;
    static int best = 0;
    static String playAgain;

    //    Thuc hien tro choi
    private static void play() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        do {
//            Tao random number
            int ranDomNum = random.nextInt(100);
            int aNumberGuess = 1;
            int numberGuess;
            System.out.println(ranDomNum);
            System.out.println("Toi Nghi So May Man tu 0 - 100");
//            Doan so may man

            do {
                System.out.print("So may man la so may ?");
                numberGuess = sc.nextInt();
                if (numberGuess > ranDomNum) {
                    System.out.println(" số may mắn nhỏ hơn số dự đoán của bạn.");
                    aNumberGuess++;
                } else if (numberGuess < ranDomNum) {
                    System.out.println(" số may mắn lớn hơn số dự đoán của bạn.");
                    aNumberGuess++;
                } else {
                    System.out.println("chúc mừng bạn đã đoán đúng con số may mắn" + aNumberGuess);
                }
            } while (numberGuess != ranDomNum);
            totalGuess += aNumberGuess;
            totalGame++;
            avgGame = (double) totalGuess / totalGame;
            if (aNumberGuess < best || best == 0) {
                best = aNumberGuess;
            }
            System.out.print("Bạn có muốn chơi lần nữa ?");
            playAgain = sc.next();

        } while (playAgain.equalsIgnoreCase("y") || playAgain.equalsIgnoreCase("yes"));
    }
    //    In thong bao ket thuc tro choi
    public static void baocao() {
        System.out.println(" Overall result: ");
        System.out.println(" Total game =" + totalGame);
        System.out.println(" Total guesses =" + totalGuess);
        System.out.println(" Guesses/game =" + avgGame);
        System.out.println(" Best game =" + best);
    }

    public static void main(String[] args) {
        play();
        baocao();
    }
}
