

import java.util.Map;
import java.util.PriorityQueue;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class TaskSchedulerJava {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> ct = new HashMap<>();
        for (char t : tasks) {
            ct.put(t, ct.getOrDefault(t, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int v : ct.values()) {
            pq.offer(v);
        }
        // System.out.println(pq);
        int time = 0;
        Deque<int[]> q = new ArrayDeque<>();
        while (!pq.isEmpty() || !q.isEmpty()) {
            if (!q.isEmpty() && time >= q.peek()[1]) {
                pq.offer(q.poll()[0]);
            }
            if (!pq.isEmpty()) {
                int cur = pq.poll() - 1;
                if (cur > 0) {
                    q.add(new int[]{cur, time + n + 1});
                }
            }
            time++;
        }
        return time;
    }


    public static void main(String[] args) {
        TaskSchedulerJava test = new TaskSchedulerJava();
        System.out.println(
            test.leastInterval(
                new char[]{'A', 'B', 'A', 'A', 'B', 'B'},
                2
            )
        );
    }
}
