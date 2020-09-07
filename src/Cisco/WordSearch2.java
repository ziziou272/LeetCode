package Cisco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WordSearch2 {
    private class TrieNode {
        private Map<Character, TrieNode> children = new HashMap<>();
        private String word = null;
    }

    public List<String> findWords(char[][] board, String[] words) {
        // to find all words, intuitive thought is backtracking; but may be tle;
        // improve: trie + backtracking

        // build the trie
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char letter : word.toCharArray()) {
                if (!node.children.containsKey(letter)) {
                    TrieNode child = new TrieNode();
                    node.children.put(letter, child);
                    node = node.children.get(letter);
                }
                else {
                    node = node.children.get(letter);
                }
            }
            node.word = word;
        }

        // do backtracking
        List<String> res = new ArrayList<>();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (root.children.containsKey(board[r][c])) backtracking(board, r, c, root, res);
            }
        }

        return res;
    }

    // backtracking
    private void backtracking(char[][] board, int r, int c, TrieNode node, List<String> res) {
        // base case: if out of bound, or visited, or not equals the word char, just return false
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == '#' || !node.children.containsKey(board[r][c]))
            return;

        TrieNode currNode = node.children.get(board[r][c]);

        // if this is the last char of word, then we successfully find the word
        if (currNode.word != null) {
            res.add(currNode.word);
            currNode.word = null;
        }

        // mark as visited
        char origin = board[r][c];
        board[r][c] = '#';
        // visit the neighbors
        backtracking(board, r - 1, c, currNode, res);
        backtracking(board, r + 1, c, currNode, res);
        backtracking(board, r, c - 1, currNode, res);
        backtracking(board, r, c + 1, currNode, res);
        // mark back
        board[r][c] = origin;
    }
}