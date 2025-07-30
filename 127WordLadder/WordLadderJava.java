

import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;

public class WordLadderJava {
    public int ladderLength(
        String beginWord, String endWord, List<String> wordList
    ) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (endWord.equals(beginWord) || !wordSet.contains(endWord)) {
            return 0;
        }
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int ans = 0;
        while (!q.isEmpty()) {
            ans++;
            int len = q.size();
            for (int i = 0; i < len; ++i) {
                String word = q.poll();
                if (word.equals(endWord)) {
                    return ans;
                }
                for (int j = 0; j < word.length(); ++j) {
                    StringBuilder sb = new StringBuilder(word);
                    for (char c = 'a'; c <= 'z'; ++c) {
                        if (c != word.charAt(j)) {
                            sb.setCharAt(j, c);
                            String nextWord = sb.toString();
                            if (wordSet.contains(nextWord)) {
                                q.offer(nextWord);
                                // don't come back to this word
                                wordSet.remove(nextWord);
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}