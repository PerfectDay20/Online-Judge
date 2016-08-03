import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class TrieNode {
    boolean isEnd;
    char c;
    TrieNode[] next;

    // Initialize your data structure here.
    public TrieNode() {
        next = new TrieNode[26];
    }

    public TrieNode(char c) {
        this.c = c;
        next = new TrieNode[26];
    }

    public boolean contains(char c) {
        return next[c - 'a'] != null;
    }

    public void put(char c) {
        next[c - 'a'] = new TrieNode(c);
    }

    public TrieNode get(char c) {
        return next[c - 'a'];
    }

    public void setEnd() {
        isEnd = true;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.contains(c)) {
                node.put(c);
            }
            node = node.get(c);
        }
        node.setEnd();
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.contains(word.charAt(i))) {
                node = node.get(word.charAt(i));
            } else {
                return false;
            }
        }
        return node.isEnd;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (node.contains(prefix.charAt(i))) {
                node = node.get(prefix.charAt(i));
            } else {
                return false;
            }
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");