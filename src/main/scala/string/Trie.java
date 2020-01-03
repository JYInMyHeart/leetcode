package string;

/**
 * @Author: xck
 * @File: Trie
 * @Time: 11:25 2020/1/2
 */
public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String s) {
        TrieNode node = root;
        for (int i = 0; i < s.length(); i++) {
            if (!node.containsKey(s.charAt(i))) {
                node.put(s.charAt(i), new TrieNode());
            }
            node = node.get(s.charAt(i));
        }
        node.setEnd(true);
    }

    public TrieNode searchPrefix(String key) {
        TrieNode node = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (node.containsKey(c)) {
                node = node.get(c);
            } else {
                return null;
            }
        }
        return node;
    }

    public boolean searchKey(String key) {
        TrieNode node = searchPrefix(key);
        return (node != null && node.isEnd());
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return (node != null);
    }


    static class TrieNode {

        private TrieNode[] children;

        private boolean end;
        private int R = 26;

        public TrieNode() {
            this.children = new TrieNode[R];
        }

        public boolean isEnd() {
            return end;
        }

        public void setEnd(boolean end) {
            this.end = end;
        }

        public boolean containsKey(char key) {
            return children[key - 'a'] != null;
        }

        public void put(char key, TrieNode node) {
            children[key - 'a'] = node;
        }

        public TrieNode get(char key) {
            return children[key - 'a'];
        }

        public void del(char key) {
            children[key - 'a'] = null;
        }
    }

}
