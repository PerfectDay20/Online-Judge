public class WordDictionary {
    public static void main(String[] args) {
        WordDictionary w = new WordDictionary();
        w.addWord("hahaha");

        System.out.println(w.search("hahah."));
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (cur.nodes[index] == null) {
                cur.nodes[index] = new TrieNode();
            }
            cur = cur.nodes[index];
        }
        cur.isEnd = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word.toCharArray(), 0, root);
    }

    private boolean search(char[] cs, int start, TrieNode node) {
        if (start == cs.length) {
            return node.isEnd;
        }

        if (cs[start] != '.') {
            int index = cs[start] - 'a';
            if (node.nodes[index] == null) {
                return false;
            }
            return search(cs, start + 1, node.nodes[index]);
        } else {
            for (int j = 0; j < 26; j++) {
                if (node.nodes[j] != null) {
                    if (search(cs, start + 1, node.nodes[j])) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}

class TrieNode {
    TrieNode[] nodes;
    boolean isEnd;

    public TrieNode() {
        nodes = new TrieNode[26];
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");