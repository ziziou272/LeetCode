package Trie;
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
class WordDictionary {
    private class TrieNode{
        char ch;
        boolean isWord = false;
        TrieNode [] nexts = new TrieNode[26];

        TrieNode(){}

        TrieNode(char ch){
            this.ch = ch;
        }
    }
    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if (cur.nexts[index] == null){
                cur.nexts[index] = new TrieNode(word.charAt(i));
            }
            cur = cur.nexts[index];
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return  dfs(word,root,0);
    }

    private boolean dfs(String word, TrieNode root, int index){
        int len = word.length();
        if(root == null)
            return false;
        if(len == index)
            return root.isWord;
        char ch = word.charAt(index);
        if(ch != '.'){
           return dfs(word, root.nexts[ch - 'a'],index + 1);
        }
        else {
            for (int i = 0; i < 26; i++){
                if(dfs(word, root.nexts[i],index + 1))
                    return true;
            }
        }
        return false;
    }
}
