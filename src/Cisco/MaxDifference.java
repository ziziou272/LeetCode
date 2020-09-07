package Cisco;

import java.util.Scanner;

public class MaxDifference {
    public static void maxDifference() {
        // collect the input
        Scanner keyboard = new Scanner(System.in);
        int len = keyboard.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = keyboard.nextInt();
        }

        // corner
        if (nums == null || nums.length < 2) {
            System.out.println(0);
            return;
        }

        // init pointers
        int min = 0, max = 0;

        // traverse
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            // min
            if (nums[i] < nums[min]) min = i;
                // max
            else if (nums[i] - nums[min] > res) {
                max = i;
                res = nums[i] - nums[min];
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) {
        maxDifference();
    }
}
