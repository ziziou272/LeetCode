package DFS;

public class LC351AndroidUnlockPatterns {
    public int numberOfPatterns(int m, int n) {
        int[][] jump = new int[10][10];
        jump[1][3] = jump[3][1] = 2;
        jump[1][7] = jump[7][1] = 4;
        jump[3][9] = jump[9][3] = 6;
        jump[9][7] = jump[7][9] = 8;
        jump[1][9] = jump[3][7] = jump[9][1] = jump[7][3] = jump[4][6] = jump[2][8] = jump[6][4] = jump[8][2] = 5;
        int count = 0;
        for(int i = 1; i <= 9; i++){
            count += dfs(m, n, 1, i, new boolean[10], jump);
        }
        return count;
    }

    private int dfs(int m, int n, int len, int cur, boolean[] visited, int[][] jump){
        visited[cur] = true;
        if(len == n) return 1;
        int count = 0;
        if(len >= m) count++;
        for(int i = 1; i <= 9; i++){
            if(!visited[i] && (jump[cur][i] == 0 || visited[jump[cur][i]])){
                count += dfs(m, n, len + 1, i, visited, jump);
                visited[i] = false;
            }
        }
        return count;
    }
}
/*

1 2 3
4 5 6
7 8 9

junm array 9*9
jump[1][3] = jum[3][1] = 2;
jump[1][7] = jum[7][1] = 4;
jump[3][9] = jum[9][3] = 6;
jump[9][7] = jum[7][9] = 8;
jump[1][9] = jum[3][7] = jump[9][1] = jum[7][3] = jump[4][6] = jum[2][8] = jump[6][4] = jum[8][2] = 5;

*/