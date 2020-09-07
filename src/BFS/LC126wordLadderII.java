package BFS;

import java.util.*;

public class LC126wordLadderII {
    //time complexity: v + e:
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        //用hashMap建造graph
        //result list
        List<List<String>> res = new ArrayList<>();
        if(endWord == null || beginWord == null) return res;
        if(endWord.length() != beginWord.length()) return res;
        //把list换成hashSet
        HashSet<String> wordSet = new HashSet<>(wordList);
        Queue<String> myQ = new LinkedList<>();
        myQ.offer(beginWord);
        boolean findMinDistance = false;
        //hashMap to for future result
        //graph
        HashMap<String, List<String>> endToStartMap = new HashMap<>();
        while(!findMinDistance && !myQ.isEmpty()){
            int size = myQ.size();
            HashSet<String> levelSet = new HashSet<>();
            while(size-- > 0){
                String cur = myQ.poll();
                List<String> curList = canTrans(cur, wordSet);
                for(String word : curList){
                    if(word.equals(endWord)){
                        findMinDistance = true;
                    }
                    //查重: 本层加过的不再加进Q
                    if(levelSet.add(word))
                        myQ.offer(word);
                    //if empty add it
                    endToStartMap.putIfAbsent(word, new ArrayList<>());
                    //update
                    endToStartMap.get(word).add(cur);
                }
            }
            //本层结束时把word dict本层用过的删除
            // wordSet.removeAll(levelSet);
            for(String wordToDel : levelSet){
                wordSet.remove(wordToDel);
            }
        }
        if (! findMinDistance) return res;
        //post processing to get result
        List<String> path = new ArrayList<>();
        path.add(endWord);
        addResult(endToStartMap, beginWord, endWord, res, path);
        return res;
    }
    private void addResult(HashMap<String, List<String>> endToStartMap, String startWord, String curWord, List<List<String>> res, List<String> path){
        if(curWord.equals(startWord)){
            //path.add(curWord);
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            res.add(new ArrayList<>(temp));
            //path.remove(curWord);
            return;
        }
        List<String> nexts = endToStartMap.get(curWord);
        for(String next : nexts){
            path.add(next);
            addResult(endToStartMap, startWord, next, res, path);
            path.remove(next);
        }
    }
    private List<String> canTrans(String cur, HashSet<String> wordSet){//o(1)
        //这个就相到于把图上的边找出来
        //不要traverse dictionary因为assume dictionary很长
        char[] charCur = cur.toCharArray();
        List<String> res = new LinkedList<>();
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
        //把word dict删除的add back,给本层别的v用
        wordSet.addAll(res);
        return res;
    }
}
class BFSSolution126{
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        HashSet<String> wordSet = new HashSet<>(wordList);
        Queue<Vertex> queue = new LinkedList<>();
        Vertex start = new Vertex(beginWord, new ArrayList<>(Arrays.asList(beginWord)));
        queue.offer(start);
        boolean shortest = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            HashSet<String> toBeRemoved = new HashSet<>();
            while(size-- > 0){
                Vertex cur = queue.poll();
                //find end
                if(cur.word.equals(endWord)){
                    res.add(new ArrayList<>(cur.path));
                    shortest = true;
                }
                List<String> nexts = getNexts(cur.word, wordSet);
                for(String str:nexts){
                    ArrayList<String> path = new ArrayList<>(cur.path);
                    path.add(str);
                    toBeRemoved.add(str);
                    queue.offer(new Vertex(str, path));
                }
            }
            wordSet.removeAll(toBeRemoved);
            if(shortest) return res;
        }
        return res;
    }

    private List<String> getNexts(String start,HashSet<String> set){
        //assume the size of dictionary is huge, we try to generate all possible strings instead of traverse the whole dictionary
        List<String> list = new ArrayList<>();
        char[] word = start.toCharArray();
        for(int i = 0; i < word.length; i++){
            char temp = word[i];
            //from a to z
            for(char j = 'a'; j <= 'z'; j++){
                if(word[i] == j)
                    continue;
                word[i] = j;
                String str = new String(word);
                if(set.contains(str))
                    list.add(str);
                word[i] = temp;
            }
        }
        return list;
    }

    class Vertex{
        private String word;
        private ArrayList<String> path;
        public Vertex(String word, ArrayList<String> path){
            this.word = word;
            this.path = new ArrayList<>(path);
        }
    }
}
