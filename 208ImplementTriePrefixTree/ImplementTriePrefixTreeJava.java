

public class ImplementTriePrefixTreeJava {
    private ImplementTriePrefixTreeJava[] next_ =
        new ImplementTriePrefixTreeJava[26];
    private boolean end = false;


    public ImplementTriePrefixTreeJava() {}


    public void insert(String word) {
        ImplementTriePrefixTreeJava cur = this;
        for (char c : word.toCharArray()) {
            if (null == cur.next_[c - 'a']) {
                cur.next_[c - 'a'] = new ImplementTriePrefixTreeJava();
            }
            cur = cur.next_[c - 'a'];
        }
        cur.end = true;
    }

    public boolean search(String word) {
        ImplementTriePrefixTreeJava cur = this;
        for (char c : word.toCharArray()) {
            if (null == cur.next_[c - 'a']) {
                return false;
            }
            cur = cur.next_[c - 'a'];
        }
        return cur.end;
    }

    public boolean startsWith(String word) {
        ImplementTriePrefixTreeJava cur = this;
        for (char c : word.toCharArray()) {
            if (null == cur.next_[c - 'a']) {
                return false;
            }
            cur = cur.next_[c - 'a'];
        }
        return true;
    }
}
