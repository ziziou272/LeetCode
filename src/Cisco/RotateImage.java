import java.util.Scanner;

public class RotateImage {
//    public static void rotateImage(int[][] matrix) {
//        int newrows = matrix[0].length;
//        int oricols = newrows;
//        int newcols = matrix.length;
//        int orirows = newcols;
//        int[][] res = new int[newrows][newcols];
//
//        for (int r = 0; r < orirows; r++) {
//            for (int c = 0; c < oricols; c++) {
//                res[c][newcols - 1 - r] = matrix[r][c];
//            }
//        }
//
//        for(int r = 0; r < newrows; r++) {
//            for (int c = 0; c < newcols; c++) {
//                System.out.print(res[r][c] + " ");
//            }
//            System.out.println();
//        }
//    }

    public static void rotateImage(int[][] matrix) {
        int newrows = matrix[0].length;
        int oricols = newrows;
        int newcols = matrix.length;
        int orirows = newcols;
        int[][] res = new int[newrows][newcols];

        for (int r = 0; r < orirows; r++) {
            for (int c = 0; c < oricols; c++) {
                res[c][newcols - 1 - r] = matrix[r][c];
            }
        }

        for(int r = 0; r < newrows; r++) {
            for (int c = 0; c < newcols; c++) {
                System.out.print(res[r][c] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        rotateImage(matrix);
    }
}
