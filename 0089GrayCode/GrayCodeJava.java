

import java.util.ArrayList;
import java.util.List;

public class GrayCodeJava {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0); // ans for n = 0
        for (int i = 1; i <= n; i++) {
            for (int j = ans.size() - 1; j > -1; j--) {
                ans.add(ans.get(j) + (1 << (i - 1)));
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        GrayCodeJava test = new GrayCodeJava();
        System.out.println(test.grayCode(2));
        System.out.println(test.grayCode(1));
        System.out.println(test.grayCode(0));
    }
}

// 