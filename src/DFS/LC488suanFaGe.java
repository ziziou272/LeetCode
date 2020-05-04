package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class LC488suanFaGe {
    public int findMinStep(String board, String hand) {
        //cc
        if(board == null || board.length() == 0) return 0;
        if(hand == null || hand.length() == 0) return -1;
        HashMap<Character, Integer> handMap = new HashMap<>();
        int [] min = new int[]{hand.length() + 1};
        for(int i = 0; i < hand.length(); i++){
            char curChar = hand.charAt(i);
            Integer count = handMap.get(curChar);
            if(count != null){
                handMap.remove(curChar);
                handMap.put(curChar, count + 1);
            }
            else
                handMap.put(curChar, 1);
        }
        dfs(board, handMap, 0, min);
        return min[0] == hand.length() + 1 ? -1 : min[0];
    }
    private void dfs(String board, HashMap<Character, Integer> handMap, int count, int[] min){
        //base case
        if(board.length() == 0){
            min[0] = Math.min(min[0], count);
            return;
        }
        if(handMap.isEmpty()) return;
        //for loop
        for(int i = 0; i < board.length(); i++){
            char curChar = board.charAt(i);
            Integer countFromHand = handMap.get(curChar);
            if(countFromHand == null) continue;
            //two together
            if(i + 1 < board.length() && curChar == board.charAt(i + 1)){
                //add one from hand
                handMap.remove(curChar);
                if(countFromHand > 1)
                    handMap.put(curChar, countFromHand - 1);
                dfs(getNewBoard(board, i - 1, i + 2), handMap, count + 1, min);
                //set back hashMap
                //handMap.remove(curChar);
                handMap.put(curChar, countFromHand);
            }
            //only one
            //and have enough ball
            else if(countFromHand >= 2){
                handMap.remove(curChar);
                if(countFromHand > 2)
                    handMap.put(curChar, countFromHand - 2);
                dfs(getNewBoard(board, i - 1, i + 1), handMap, count + 2, min);
                //set back
                //handMap.remove(curChar);
                handMap.put(curChar, countFromHand);
            }
        }
    }
    private String getNewBoard(String board, int left, int right){
        int count = 0;
        while(left >= 0 && right < board.length()){
            char curChar = board.charAt(left);
            int l = left;
            while(l >= 0 && board.charAt(l) == curChar){
                l--;
                count++;
            }
            int r = right;
            while(r < board.length() && board.charAt(r) == curChar){
                r++;
                count++;
            }
            if(count >= 3){
                left = l;
                right = r;
            }
            else
                break;
        }
        StringBuilder newBoard = new StringBuilder();
        for(int i = 0; i <= left; i++){
            newBoard.append(board.charAt(i));
        }
        for(int i = right; i < board.length(); i++){
            newBoard.append(board.charAt(i));
        }
        return newBoard.toString();
    }
}
class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String board = "YYGGRRYYGGYYGY";
            line = in.readLine();
            String hand = "RGG";

            int ret = new LC488suanFaGe().findMinStep(board, hand);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
