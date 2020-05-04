package BFS;

import java.util.*;

public class LC127WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //边走边graph
        //v(dict 的size n) + e(v^2) -> v^2  graph的定义 e 是  v-v^2
        //o(n)
        //优化: 从end 到start 扫 和从start 到end扫，每次比较推分叉少的 2 directions
        if(endWord == null || beginWord == null) return 0;
        if(endWord.length() != beginWord.length()) return 0;
        HashSet<String> wordSet = new HashSet<>();
        for(String word : wordList) wordSet.add(word);
        Queue<String> myQ = new LinkedList<>();
        myQ.offer(beginWord);
        int count = 2;
        //boolean[] visited = new boolean[wordList.size()];
        while(!myQ.isEmpty()){
            int size = myQ.size();
            while(size-- > 0){
                String cur = myQ.poll();
                List<String> curList = canTrans(cur, wordSet);
                for(String word : curList){
                    if(word.equals(endWord))
                        return count;
                    myQ.offer(word);
                }
            }
            count++;
        }
        return 0;
    }
    private List<String> canTrans(String cur, HashSet<String> wordSet){//o(1)
        //这个就相到于把图上的边找出来
        //
        //不要traverse dictionary因为assume dictionary很长
        char[] charCur = cur.toCharArray();
        List<String> res = new ArrayList<>();
        for(int i = 0; i < charCur.length; i++){
            char temp = charCur[i];
            for(char j = 'a'; j <= 'z'; j++){
                charCur[i] = j;
                String check = String.valueOf(charCur);
                if(wordSet.contains(check)){
                    wordSet.remove(check);
                    res.add(check);
                }
            }
            charCur[i] = temp;
        }

        return res;
    }
}