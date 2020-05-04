public class SolutionWay {
    public static int solution(String[] B) {
        // corner
        if (B.length == 0 || B[0].length() == 0) return 0;

        // locate the Jafar pawn
        int jrow = 0, jcol = 0;
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[i].length(); j++) {
                if (B[i].charAt(j) == 'O') {
                    jrow = i;
                    jcol = j;
                    break;
                }
            }
        }

        // find on left-up and right-up sides
        return backtracking(jrow, jcol, B);
    }

    private static int backtracking(int curRow, int curCol, String[] B) {

        int resL = 0;
        int resR = 0;

        // find for the left-up side
        if (isValid(curRow - 1, curCol - 1, B) && isValid(curRow - 2, curCol - 2, B)
                && hasX(curRow - 1, curCol - 1, B) && !hasX(curRow - 2, curCol - 2, B)) {
            resL++;
            resL += backtracking(curRow - 2, curCol - 2, B);
        }

        // find for the right-up side
        if (isValid(curRow - 1, curCol + 1, B) && isValid(curRow - 2, curCol + 2, B)
                && hasX(curRow - 1, curCol + 1, B) && !hasX(curRow - 2, curCol + 2, B)) {
            resR++;
            resR += backtracking(curRow - 2, curCol + 2, B);
        }
        return Math.max(resL, resR);
    }

    // return true if the given i and j is in the range of board
    private static boolean isValid(int i, int j, String[] B) {
        int rows = B.length;
        int cols = B[0].length();
        if (i < 0 || i >= rows || j < 0 || j >= cols) return false;
        return true;
    }

    // return true if the given location contains 'X'
    private static boolean hasX(int i, int j, String[] B) {
        return B[i].charAt(j) == 'X';
    }

    // test cases
    public static void main(String[] args) {
        String[] B = new String[6];
        B[0] = "..X...";
        B[1] = "......";
        B[2] = "....X.";
        B[3] = ".X....";
        B[4] = "..X.X.";
        B[5] = "...O..";
        System.out.println(solution(B));

//        String[] B = new String[5];
//        B[0] = "X....";
//        B[1] = ".X...";
//        B[2] = "..O..";
//        B[3] = "...X.";
//        B[4] = ".....";
//        System.out.println(solution(B));
    }
}
