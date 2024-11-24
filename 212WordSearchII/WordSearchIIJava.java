

import node_structure.TrieNode;
import java.util.List;
import java.util.ArrayList;

public class WordSearchIIJava {
    private TrieNode root;


    public List<String> findWords1(char[][] board, String[] words) {
        return null;
    }

    public List<String> findWords2(char[][] board, String[] words) {
        // trie + backtrack
        // add every word
        this.root = new TrieNode();
        for (String word : words) {
            addWord(word);
        }

        int r, c;
        r = board.length;
        if (r == 0) {
            return new ArrayList<>();
        }
        c = board[0].length;
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                find2Helper(
                    board, ans, new StringBuilder(""), this.root, i, j
                );
            }
        }
        return ans;
    }

    private void addWord(String word) {
        TrieNode cur = this.root;
        for (char c : word.toCharArray()) {
            if (null == cur.children[c - 'a']) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.end = true;
    }

    private void find2Helper(
        char[][] board,
        List<String> ans,
        StringBuilder cur,
        TrieNode node,
        int r,
        int c
    ) {
        // out of bound
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
            return;
        }
        char letter = board[r][c];
        // repeat word or can't find letter
        if (letter == '#' || null == node.children[letter - 'a']) {
            return;
        }
        cur.append(letter);
        node = node.children[letter - 'a'];
        if (node.end) {
            ans.add(cur.toString());
            node.end = false; // no repeat
        }
        board[r][c] = '#';
        find2Helper(board, ans, cur, node, r + 1, c);
        find2Helper(board, ans, cur, node, r - 1, c);
        find2Helper(board, ans, cur, node, r, c + 1);
        find2Helper(board, ans, cur, node, r, c - 1);
        board[r][c] = letter;
        cur.deleteCharAt(cur.length() - 1);
    }
}