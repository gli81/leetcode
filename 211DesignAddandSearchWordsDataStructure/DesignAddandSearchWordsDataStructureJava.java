

import node_structure.TrieNode;

public class DesignAddandSearchWordsDataStructureJava {
    private TrieNode root;


    public DesignAddandSearchWordsDataStructureJava() {
        this.root = new TrieNode();
    }


    public void addWord(String word) {
        TrieNode cur = this.root;
        for (char c : word.toCharArray()) {
            if (null == cur.children[c - 'a']) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.end = true;
    }

    public boolean search(String word) {
        return searchHelper(word, 0, this.root);
    }

    private boolean searchHelper(String word, int idx, TrieNode root) {
        TrieNode cur = root;
        for (int i = idx; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode child : cur.children) {
                    if (null != child && searchHelper(word, i + 1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                // actual letter
                if (null == cur.children[c - 'a']) {
                    return false;
                } else {
                    cur = cur.children[c - 'a'];
                }
            }
        }
        return cur.end;
    }
}


