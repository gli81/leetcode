

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class CourseScheduleIIJava {
    /**
     * topological
     */
    public int[] findOrder1(
        int numCourses,
        int[][] prerequisites
    ) {
        int[] indeg = new int[numCourses];
        Map<Integer, ArrayList<Integer>> edges = new HashMap<>();
        for (int[] prereq : prerequisites) {
            indeg[prereq[0]]++;
            ArrayList<Integer> tmp = edges.getOrDefault(
                prereq[1], new ArrayList<Integer>()
            );
            tmp.add(prereq[0]);
            edges.put(prereq[1], tmp);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) q.offer(i);
        }
        int visited = 0;
        int[] ans = new int[numCourses];
        while (!q.isEmpty()) {
            int cur = q.poll();
            ans[visited++] = cur;
            for (
                int lead_to : edges.getOrDefault(cur, new ArrayList<Integer>())
            ) {
                if (--indeg[lead_to] == 0) {
                    q.offer(lead_to);
                }
            }
        }
        return visited == numCourses ? ans : new int[]{};
    }
}
