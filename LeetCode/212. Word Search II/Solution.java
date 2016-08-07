import java.util.ArrayList;
import java.util.List;

public class Solution {
    private char[][] board;

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        List<String> ans = new ArrayList<>();
        TrieNode root = buildTrie(words);//use Trie, so traverse once and get all the words start with board[i][j]
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i, j, root, ans);
            }
        }
        return ans;
    }

    private void dfs(int i, int j, TrieNode root, List<String> ans) {
        char c = board[i][j];
        if (c == '#' || root.next[c - 'a'] == null) {
            return;
        }
        root = root.next[c - 'a'];
        if (root.word != null) {//find a word
            ans.add(root.word);
            root.word = null;//delete word, prevent duplicate
        }
        board[i][j] = '#';//set to '#' to mark visited
        if (i > 0) {
            dfs(i - 1, j, root, ans);
        }
        if (j > 0) {
            dfs(i, j - 1, root, ans);
        }
        if (i < board.length - 1) {
            dfs(i + 1, j, root, ans);
        }
        if (j < board[0].length - 1) {
            dfs(i, j + 1, root, ans);
        }
        board[i][j] = c;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String s : words) {
            TrieNode p = root;
            for (char c : s.toCharArray()) {
                int index = c - 'a';
                if (p.next[index] == null) {
                    p.next[index] = new TrieNode();
                }
                p = p.next[index];
            }
            p.word = s;
        }
        return root;
    }

    class TrieNode {
        String word;//store the word in the last node, so no need to set boolean flag and no need to traverse back to get word
        TrieNode[] next = new TrieNode[26];
    }
}