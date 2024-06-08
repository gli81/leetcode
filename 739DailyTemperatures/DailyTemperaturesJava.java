import java.util.Arrays;
import java.util.Stack;

public class DailyTemperaturesJava {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> stk = new Stack<>(); // index
        stk.push(0);
        for (int i = 1; i < n; ++i) {
            while (
                !stk.isEmpty() &&
                temperatures[i] > temperatures[stk.peek()]
            ) {
                int poped = stk.pop();
                ans[poped] = i - poped;
            }
            stk.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        DailyTemperaturesJava test = 
            new DailyTemperaturesJava();
        System.out.println(
            Arrays.toString(test.dailyTemperatures(
                new int[]{
                    73, 74, 75, 71, 69, 72, 76, 73
                }
            )
        ));
    }
}
