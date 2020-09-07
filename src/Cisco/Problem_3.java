package Cisco;/*
CS5004 - PS2 - Problem_3
Author: Zongwei Fan
Last Changed: Jan 24, 2020
 */
import java.util.Scanner;

public class Problem_3 {
    public static void main(String[] args) {
        // collect the input
        Scanner keyboard = new Scanner(System.in);
        String[] names = new String[3];
        int[] quantities = new int[3];
        double[] prices = new double[3];
        double[] total = new double[3];
        for (int i = 0; i < 3; i++) {
            System.out.println("Input name of item " + (i + 1) + ":");
            names[i] = keyboard.nextLine();
            System.out.println("Input quantity of item " + (i + 1) + ":");
            quantities[i] = keyboard.nextInt();
            System.out.println("Input price of item " + (i + 1) + ":");
            prices[i] = keyboard.nextDouble();
            total[i] = quantities[i] * prices[i];
            String junk = keyboard.nextLine();
        }

        // output
        System.out.println("Your bill:");
        System.out.printf("%-30s%-10s%-10s%-10s %n", "Item", "Quantity", "Price", "Total");
        for (int i = 0; i < 3; i++) {
            System.out.printf("%-30s%-10d%-10.2f%-10.2f %n", names[i], quantities[i], prices[i], total[i]);
        }
        double subtotal = total[0] + total[1] + total[2];
        System.out.printf("%-50s%-10.2f %n", "Subtotal", subtotal);
        System.out.printf("%-50s%-10.2f %n", "6.25 percent sales tax", subtotal * 0.0625);
        System.out.printf("%-50s%-10.2f %n", "Total", subtotal + subtotal * 0.0625);
    }
}
