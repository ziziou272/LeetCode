package stringAndArray;

import java.util.HashSet;
class CleanSolution36{
    //slow but very readable
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>(9*9*3);
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char num = board[i][j];
                if(num != '.'){
                    if(!set.add(num + "row" + i) ||
                            !set.add(num + "col" + j) ||
                            !set.add(num + "box" + i/3 + "-" + j/3))
                        return false;
                }
            }
        }
        return true;
    }
}
public class LC36 {
}
class Solution36 {
    public boolean isValidSudoku(char[][] board) {

        HashSet<Character> row = new HashSet<>();
        HashSet<Character> col = new HashSet<>();
        HashSet<Character> box1 = new HashSet<>();
        HashSet<Character> box2 = new HashSet<>();
        HashSet<Character> box3 = new HashSet<>();
        //check rows
        //check 3 by 3
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                //clear row and col hashSet
                if(j == 0){
                    row.clear();
                    col.clear();
                }
                //clear box hashset
                if(i % 3 == 0 && j == 0){
                    box1.clear();
                    box2.clear();
                    box3.clear();
                }
                if(board[i][j] != '.'){
                    if(j/3 < 1){
                        if(box1.contains(board[i][j]))
                            return false;
                        box1.add(board[i][j]);
                    }else if(j/3 < 2){
                        if(box2.contains(board[i][j]))
                            return false;
                        box2.add(board[i][j]);
                    }else{
                        if(box3.contains(board[i][j]))
                            return false;
                        box3.add(board[i][j]);
                    }
                    //check columns
                    if(row.contains(board[i][j]))
                        return false;
                    row.add(board[i][j]);
                }
                if(col.contains(board[j][i]))
                    return false;
                if(board[j][i] != '.'){
                    col.add(board[j][i]);
                }
            }
        }
        return true;
    }
}
/*
hashset:
box1,box2,box3
0 1 2  3 4 5  6 7 8

j/3 < 1
j/3 < 2
else

if(i%3==0) clear 3 hashsets

row -> if j == 0, clear

col if j == 0 clear

[[".","4",".",".",".",".",".",".","."],
[".",".","4",".",".",".",".",".","."],
[".",".",".","1",".",".","7",".","."],
[".",".",".",".",".",".",".",".","."],
[".",".",".","3",".",".",".","6","."],
[".",".",".",".",".","6",".","9","."],
[".",".",".",".","1",".",".",".","."],
[".",".",".",".",".",".","2",".","."],
[".",".",".","8",".",".",".",".","."]]






*/