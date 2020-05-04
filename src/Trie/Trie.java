package Trie;
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
}