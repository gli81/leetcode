import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class SubstringConcatAllWordsJava{

    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> ans = new ArrayList<Integer>();
        if (words.length == 0) return ans;
        int wordLen = words[0].length();
        HashMap<String, Integer> allWords = new HashMap<String, Integer>();
        for (String word : words) {
            allWords.put(word, allWords.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLen; i++) {
            HashMap<String, Integer> hasWords = new HashMap<String, Integer>();
            int wordCt = 0;
            for (int j = i; j < s.length() - wordLen * words.length + 1; j += wordLen) {
                while (wordCt < words.length) {
                    String currentWord = s.substring(j + wordCt * wordLen, j + (wordCt + 1) * wordLen);
                    if (!allWords.containsKey(currentWord)) {
                        j = j + wordCt * wordLen;
                        hasWords.clear();
                        wordCt = 0;
                        break;
                    } else {
                        hasWords.put(currentWord, hasWords.getOrDefault(currentWord, 0) + 1);
                        if (hasWords.get(currentWord) > allWords.get(currentWord)) {
                            int removed = 0;
                            while (hasWords.get(currentWord) > allWords.get(currentWord)) {
                                String headWord = s.substring(j + removed * wordLen, j + (removed + 1) * wordLen);
                                hasWords.put(headWord, hasWords.get(headWord) - 1);
                                removed++;
                            }
                            j = j + (removed - 1) * wordLen;
                            wordCt = wordCt - removed + 1;
                            break;
                        }
                    }
                    wordCt++;
                }
                if (wordCt == words.length) {
                    ans.add(j);
                    // remove first word in substring
                    // add another at the end, check if the new substring works
                    // to maximize efficiency
                    wordCt--;
                    String firstWord = s.substring(j, j + wordLen);
                    hasWords.put(firstWord, hasWords.get(firstWord) - 1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new SubstringConcatAllWordsJava().findSubstring2("barfoothefoobarman",
                                                                            new String[] {"foo", "bar", "foo", "the"}));
        System.out.println(new SubstringConcatAllWordsJava().findSubstring2("barfoofoobarthefoobarman",
                                                                            new String[] {"foo", "bar", "the"}));
        System.out.println(new SubstringConcatAllWordsJava().findSubstring2("bcabbcaabbccacacbabccacaababcbb",
                                                                            new String[] {"c","b","a","c","a","a","a","b","c"}));
        System.out.println(new SubstringConcatAllWordsJava().findSubstring2("wordgoodgoodgoodbestword",
                                                                            new String[] {"word","good","best","good"}));
    }
}

