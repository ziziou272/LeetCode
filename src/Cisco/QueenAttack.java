package Cisco;

import java.util.Scanner;

public class QueenAttack {
    public static void queenAttack() {
        // collect the input
        Scanner keyboard = new Scanner(System.in);
        int qr = keyboard.nextInt();
        int qc = keyboard.nextInt();
        int or = keyboard.nextInt();
        int oc = keyboard.nextInt();

        // see if could attack
        if (qr == or || qc == oc || Math.abs(qr - or) == Math.abs(qc - oc))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    public static void main(String[] args) {
        // call method
        queenAttack();
    }
}
