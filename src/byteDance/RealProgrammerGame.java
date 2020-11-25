package byteDance;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class RealProgrammerGame {

    public static double chance(int N, int M, int K){
        if(M <= 0 || M * K < N) return 0.0;
        if(N <= 0) return 1.0;
        double total = Math.pow(M + 1, K);
        double[][] memo = new double[N + 1][K + 1];
        for(int i = 0; i < memo.length; i++){
            for(int j = 0; j < memo[0].length; j++){
                memo[i][j] = -1.0;
            }
        }
        double count = dfs(N, M, K, memo);
        return count / total;
    }
    // N: health point, M:random
    private static double dfs(int N, int M, int K, double[][] memo){
        int count = 0;
        if(K == 0){
            if(N <= 0) {
                return 1.0;
            }
            return 0.0;
        }
        if(N <= 0){
            return Math.pow(M+1, K);
        }
        if(memo[N][K] != -1.0) return memo[N][K];
        for(int i = 0; i <= M; i++){
            count += dfs(N - i, M, K - 1, memo);
        }
        memo[N][K] = count;
        return count;
    }

    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat("0.00");
        //System.out.println(Double.parseDouble("0.00000"));
        System.out.println(0.0000000);

        //System.out.println(new BigDecimal("0.00000").setScale(5, RoundingMode.HALF_UP).doubleValue());
/*

        System.out.print(rpg(2,1,3));
        System.out.print(" VS ");
        System.out.println(chance(2,1,3));

        System.out.print(rpg(3,1,6));
        System.out.print(" VS ");
        System.out.println(chance(3,1,6));

        System.out.print(rpg(100,5,2));
        System.out.print(" VS ");
        System.out.println(chance(100,5,2));

        System.out.print(rpg(4,1,6));
        System.out.print(" VS ");
        System.out.println(chance(4,1,6));

        System.out.print(rpg(20,3,10));
        System.out.print(" VS ");
        System.out.println(chance(20,3,10));

        System.out.print(rpg(35,7,7));
        System.out.print(" VS ");
        System.out.println(chance(35,7,7));

        System.out.print(rpg(800,20,80));
        System.out.print(" VS ");
        System.out.println(chance(800,20,80));

        System.out.print(rpg(12,1,25));
        System.out.print(" VS ");
        System.out.println(chance(12,1,25));


        System.out.print(rpg(8, 1, 12));
        System.out.print(" VS ");
        System.out.println(chance(8, 1, 12));

        System.out.print(rpg(20,6,8));
        System.out.print(" VS ");
        System.out.println(chance(20,6,8));

        System.out.print(rpg(99, 66, 33));
        System.out.print(" VS ");
        System.out.println(chance(99, 66, 33));

        System.out.print(rpg(20, 10, 8));
        System.out.print(" VS ");
        System.out.println(chance(20, 10, 8));

        System.out.print(rpg(1000, 1000, 1000));
        System.out.print(" VS ");
        System.out.println(chance(1000, 1000, 1000));*/
    }
    /*
    *    cout << rpg(3,1,6) << endl;
    cout << rpg(10, 5, 2) << endl;
    cout << rpg(100, 5, 2) <<endl;
    cout << rpg(1000, 1000, 1000) <<endl;
    cout << rpg(4, 1, 6) <<endl;
    cout << rpg(20, 3, 10) <<endl;
    cout << rpg(20, 3, 10) <<endl;
    cout << rpg(99, 66, 33) <<endl;
    cout << rpg(20, 6, 8) <<endl;
    cout << rpg(35, 7, 7) <<endl;
    cout << rpg(8, 1, 12) <<endl;
    cout << rpg(800, 20, 80) <<endl;
    cout << rpg(12, 1, 25) <<endl;
    *
    * */



    public static double rpg(int n, int m, int k) {
        double allPos = Math.pow(m + 1, k);
        int[][] map = new int[n + 1][k + 1];
        for (int r = 0; r <= n; r++) {
            for (int c = 0; c <= k; c++) {
                map[r][c] = -1;
            }
        }
        int res = backtrack(0, k, n, m, map);
        double value = res / allPos;
        return value;
        //return (double)Math.round(value * 100000d) / 100000d;
    }

    private static int backtrack(int cur, int rem, int hp, int m, int[][] map) {
        int res = 0;
        if (rem < 0) return res;
        if (cur >= hp) {
            if (rem == 0) res += 1;
            else res += Math.pow(m + 1, rem);
            return res;
        }
        if (map[cur][rem] != -1) {
            res += map[cur][rem];
            return res;
        }

        for (int i = 0; i <= m; i++) {
            res += backtrack(cur + i, rem - 1, hp, m, map);
        }

        map[cur][rem] = res;
        return res;
    }

}

/*
3+2*4/4-3 need to follow the operator precedence


3
5 -


*/