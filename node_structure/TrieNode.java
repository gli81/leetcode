package node_structure;

public class TrieNode {
    public TrieNode[] children;
    public boolean end;


    public TrieNode() {
        this.children = new TrieNode[26];
        this.end = false;
    }
}