package Cisco;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CheckPrime {
    public static void checkPrime() {
        // collect the input
        Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();

        while(keyboard.hasNextInt()){
            keyboard.nextInt();

        }
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = keyboard.nextInt();
        }

        // check prime and print

        // use a hashset to record the prime: save time
        Set<Integer> setPrime = new HashSet<>();

        for(int i = 0; i < n; i++) {
            if (setPrime.contains(list[i]) || isPrime(list[i])) {
                System.out.print("Prime");
                setPrime.add(list[i]);
            }
            else {
                System.out.print("Composite");
            }
            if (i != n - 1) System.out.print(" ");
        }
    }

    private static boolean isPrime(int n) {
        if (n == 1) return false;
        if (n == 2) return true;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        checkPrime();
    }
}
