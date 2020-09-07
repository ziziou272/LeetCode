package Cisco;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
class Problem2
{
    public static void main(String args[] )
    {
        // Write your code here

        // get the input
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int[][] matrix = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = s.nextInt();
            }
        }

        // first swap diagnally
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < r; c++) {
                swap(matrix, r, c, c, r);
            }
        }

        // then swap cols
        int start = 0, end = matrix[0].length - 1;
        while (start < end) {
            for (int r = 0; r < matrix.length; r++) {
                swap(matrix, r, start, r, end);
            }
            start++;
            end--;
        }


        // print the output
        for(int r = 0; r < m; r++) {
            for (int c = 0; c < m; c++) {
                System.out.print(matrix[r][c]);
                if (c != m - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static void swap(int[][] matrix, int oldr, int oldc, int newr, int newc) {
        int temp = matrix[oldr][oldc];
        matrix[oldr][oldc] = matrix[newr][newc];
        matrix[newr][newc] = temp;
    }
}
