

import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
// import java.util.Arrays;

public class CourseScheduleJava {
    /**
     * topological
     */
    public boolean canFinish1(
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
        // for (Integer k : edges.keySet()) {
        //     System.out.println(
        //         k.toString() + " : " + edges.get(k).toString()
        //     );
        // }
        // edges.forEach(
        //     (k, v) -> System.out.println(k + " : " + v)
        // );
        // System.out.println(Arrays.toString(indeg));
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) q.offer(i);
        }
        int visited = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            // System.out.println("cur: " + cur);
            visited++;
            for (
                int lead_to : edges.getOrDefault(cur, new ArrayList<Integer>())
            ) {
                // System.out.println(lead_to);
                if (--indeg[lead_to] == 0) {
                    // System.out.println("hihihi");
                    q.offer(lead_to);
                }
            }
        }
        // System.out.println(visited);
        return visited == numCourses;
    }

    /**
     * DFS
     * @param numCourses
     * @param prerequisites
     */
    public boolean canFinish2(
        int numCourses,
        int[][] prerequisites
    ) {
        // course to prereq
        Map<Integer, List<Integer>> prereq = new HashMap<>();
        for (int i = 0; i < numCourses; ++i) {
            prereq.put(i, new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            prereq.get(p[0]).add(p[1]);
        }
        for (int i = 0; i < numCourses; ++i) {
            if (!dfs(i, prereq, new HashSet<Integer>())) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(
        int crs, Map<Integer, List<Integer>> map, Set<Integer> visiting
    ) {
        if (visiting.contains(crs)) {
            return false; // cycle
        }
        if (map.get(crs).isEmpty()) {
            return true;
        }
        visiting.add(crs);
        for (int i : map.get(crs)) {
            if (!dfs(i, map, visiting)) {
                return false;
            }
        }
        visiting.remove(crs);
        map.put(crs, new ArrayList<>());
        return true;
    }


    public static void main(String[] args) {
        CourseScheduleJava test =
            new CourseScheduleJava();
        System.out.println(test.canFinish1(
            2, new int[][]{{1, 0}}
        ));
        System.out.println("==================");
        System.out.println(test.canFinish1(
            2, new int[][]{{1, 0}, {0, 1}}
        ));
    }
}