package Trie;

import java.util.ArrayList;
import java.util.List;

class TrieNode{
    public char ch;
    public TrieNode [] children = new TrieNode[26];
    public boolean isWord = false;
    public TrieNode(char ch){
        this.ch = ch;
    }
    TrieNode(){

    }
}
class Trie {
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(cur.children[index] == null)
                cur.children[index] = new TrieNode(word.charAt(i));
            cur = cur.children[index];
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(cur.children[index] == null)
                return false;
            cur = cur.children[index];
        }
        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';
            if(cur.children[index] == null)
                return false;
            cur = cur.children[index];
        }
        return true;
    }

    public List<String> getClosetWordList(int n, String searchWord){
        List<String> res = new ArrayList<>();
        int[] count = new int[1];
        dfs(searchWord, 0, root, res, count, n, new StringBuilder());
        return res;
    }

    private boolean dfs(String searchWord, int index, TrieNode parent, List<String> res, int[] count, int n, StringBuilder sb){
        if(index == searchWord.length() - 1){
            findN(parent, res, count, n, sb);
        }
        char cur = searchWord.charAt(index);
        sb.append(cur);
        if(parent.children[cur] == null)
            return true;
        else
            dfs(searchWord, index+1, parent.children[cur], res, count, n, sb);
        return false;
    }

    private boolean findN(TrieNode parent, List<String> res, int[] count, int n, StringBuilder sb){
        if(count[0] == n)
            return true;
        for(int i = 0; i < 26; i++){
            char cur = (char)('a' + i);
            if(parent.children[cur] != null) {
                if(parent.children[cur].isWord){
                    sb.append(cur);
                    res.add(sb.toString());
                    count[0]++;
                    if(findN(parent.children[cur], res, count, n, sb))
                        return true;
                    sb.setLength(sb.length() - 1);
                }
            }
        }
        return false;
    }
}