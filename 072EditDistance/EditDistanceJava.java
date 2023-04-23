

import java.util.HashMap;
import java.util.Map;

public class EditDistanceJava {
    public int minDistance1(String word1, String word2) {
        // over time limit
        if (word1.length() == 0 && word2.length() == 0) {
            return 0;
        }
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();
        int x, y, z;
        x = minDistance1(word1,
                        word2.substring(0,
                                        word2.length() - 1)) + 1;
        y = minDistance1(word1.substring(0,
                                        word1.length() - 1),
                        word2) + 1;
        z = minDistance1(word1.substring(0,
                                        word1.length() - 1),
                        word2.substring(0,
                                        word2.length() - 1));
        if (word1.charAt(word1.length() - 1) !=
            word2.charAt(word2.length() - 1)) z++;
        return Math.min(Math.min(x, y), z);
    }

    public int minDistance2(String word1, String word2) {
        Map<String, Integer> d = new HashMap<>(){};
        return helper(word1, word2, d);
    }

    private int helper(String word1, String word2,
                        Map<String, Integer> d) {
        if (word1.length() == 0 && word2.length() == 0) {
            return 0;
        }
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();
        String key = word1 + "_" + word2;
        if (d.containsKey(key)) return d.get(key);
        else {
            int x, y, z;
            x = helper(word1,
                        word2.substring(0,
                                        word2.length() - 1),
                        d) + 1;
            y = helper(word1.substring(0,
                                        word1.length() - 1),
                        word2, d) + 1;
            z = helper(word1.substring(0,
                                        word1.length() - 1),
                        word2.substring(0,
                                        word2.length() - 1),
                        d);
            if (word1.charAt(word1.length() - 1) !=
                word2.charAt(word2.length() - 1)) z++;
            d.put(key, Math.min(Math.min(x, y), z));
            return Math.min(Math.min(x, y), z);
        }
    }

    public static void main(String[] args) {
        EditDistanceJava test = new EditDistanceJava();
        System.out.println(
            test.minDistance2("horse", "ros")
        );
        System.out.println(
            test.minDistance2("execution",
                            "intention")
        );
    }
}