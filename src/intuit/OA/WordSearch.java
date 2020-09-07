package intuit.OA;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {
    public static void main(String[] args){
        Solution s1 = new Solution();
/*        char[][] board = new char[][]{
                {'c','r','c','a','r','s'},
                {'a','b','i','t','n','b'},
                {'t','f','n','n','t','i'},
                {'x','s','c','a','t','n'},
                {'x','s','d','d','e','a'},
                {'s','q','w','x','s','p'}
        };
        String word = "c";
        s1.findWord(board, word.toCharArray());*/
    }
}
class Solution{
    public void findWord(String[][] grid, String word){
        if(word == null || word.length() == 0 || grid == null || grid.length == 0
                || grid[0] == null || grid[0].length == 0){
            System.out.println("None");
            return;
        }
        List<List<Integer>> res = new ArrayList<>();
        Search:
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j].charAt(0) == word.charAt(0)){
                    List<Integer> level = new ArrayList<>();
                    level.add(i);
                    level.add(j);
                    res.add(level);
                    if(dfs(grid, word, res, 1, i + 1, j))
                        break Search;
                    if(dfs(grid, word, res, 1, i, j + 1))
                        break Search;
                    res.remove(res.size() - 1);
                }
            }
        }
        if(res.size() == 0) System.out.println("None");
        else{
            for (List<Integer> re : res) {
                System.out.print(re.get(0));
                System.out.print(" ");
                System.out.print(re.get(1));
                System.out.println();
            }
        }
    }
    private boolean dfs(String[][] grid, String word, List<List<Integer>> res, int index, int i, int j){
        //base case: success
        if(index == word.length())
            return true;
        //fail
        if(i >= grid.length || j >= grid[0].length) return false;
        if(word.charAt(index) == grid[i][j].charAt(0)){
            List<Integer> level = new ArrayList<>();
            level.add(i);
            level.add(j);
            res.add(level);
            if(dfs(grid, word, res, index + 1, i + 1, j))
                return true;
            if(dfs(grid, word, res, index + 1, i, j + 1))
                return true;
            //backtracking
            res.remove(res.size() - 1);
        }
        return false;
    }
}
