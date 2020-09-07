package intuit.OA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/*
*For this question, basically, we are just searching for a word and we need to construct
* the word from different cells in our grid.
Since the word may start anywhere in the grid, I need to search starting from each cell
* in the grid
So if the letter in the cell matches the first letter of the word, then we could run a
* depth first search to check if we could get all the characters we need.
If we found, we just print this path and if we traversed the entire board and didn't
* find anything we just print none.

Time Complexity:  Let’s say there are n cells in the grid and the length of the word is k.
Since at most we run dfs n times and each dfs at most cost 2^k times
Therefore the running time is  O(2^k * n)
Space: The maximum length of the call stack would be the length of the word. O(k)
*
*
* */

public class oaWordSearch {
    // If you need extra classes, you can define them privately here within class Solution

    static void findWord(String word, String[][] grid) {
        //corner case
        if(word == null || word.length() == 0 || grid == null || grid.length == 0
                || grid[0] == null || grid[0].length == 0){
            System.out.println("None");
            return;
        }
        //used a list to store the coordinates
        List<List<Integer>> res = new ArrayList<>();
        Search:
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(dfs(grid, word, res, 0, i, j))
                    break Search;
            }
        }
        //if didn't find anything
        if(res.size() == 0) System.out.println("None");
        else{
            for(List<Integer> re : res){
                System.out.print(re.get(0));
                System.out.print(" ");
                System.out.print(re.get(1));
                System.out.println(" ");
            }
        }
    }

    static boolean dfs(String[][] grid, String word, List<List<Integer>> res, int index, int i, int j){
        //base case: to check if we already at the end of the word
        if(index == word.length()) return true;
        //fail
        if(i >= grid.length || j >= grid[0].length) return false;
        //if the character on the grid is equals the character in the word string
        //then we could continue searching and add current coordinate to the result list
        if(word.charAt(index) == grid[i][j].charAt(0)){
            List<Integer> level = new ArrayList<>();
            level.add(i);
            level.add(j);
            res.add(level);
            //we could go right or go down in the grid
            //i plus one means go down -> if this search found the word we could just return true
            //and skip the rest
            if(dfs(grid, word, res, index + 1, i + 1, j))
                return true;
            if(dfs(grid, word, res, index + 1, i, j + 1))
                return true;
            //if we didn't find anything we need to remove this coordinate from the result list
            res.remove(res.size() - 1);
        }
        return false;
    }

    // DO NOT MODIFY MAIN()
    public static void main(String[] args) {
        String arg0 = null;
        List<String[]> arg1 = new ArrayList<String[]>();

        String line;
        boolean first_arg = true;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while ((line = br.readLine()) != null) {
                if (line.equals("")) {
                    continue;
                }

                if(first_arg) {
                    arg0 = line;
                    first_arg = false;
                } else {
                    arg1.add(line.split(" "));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        String[][] grid = arg1.toArray(new String[arg1.size()][]);

        findWord(arg0, grid);
    }
}
