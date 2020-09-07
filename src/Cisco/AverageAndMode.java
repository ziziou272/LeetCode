package Cisco;

import java.util.Scanner;

public class AverageAndMode {
    public static void averageAndMode() {
        // collect the input
        Scanner keyboard = new Scanner(System.in);
        int len = keyboard.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = keyboard.nextInt();
        }

        // calculate the average and mode
        double average = 0;
        int mode = 0;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] > mode) mode = nums[i];
            sum += nums[i];
        }
        average = ((double) sum) / len;

        System.out.printf("%.4f", average);
        System.out.println();
        System.out.println(mode);
    }

    public static void main(String[] args) {
        averageAndMode();
    }
}
