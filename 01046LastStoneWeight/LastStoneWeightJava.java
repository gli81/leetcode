

import java.util.PriorityQueue;
// import java.util.Comparator;

public class LastStoneWeightJava {
    public int lastStoneWeight(int[] stones) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>(
        //     new Comparator<Integer>() {
        //         @Override
        //         public int compare(Integer a, Integer b) {
        //             return b - a;
        //         }
        //     }
        // );
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> b - a
        );
        // wrong order
        // PriorityQueue<Integer> pq = new PriorityQueue<>(
        //     Integer::compare
        // );
        for (int st : stones) pq.add(st);
        // System.out.println(pq);
        while (pq.size() > 1) {
            int one = pq.poll();
            int two = pq.poll();
            if (one != two) {
                pq.offer(Math.abs(one - two));
            }
        }
        return pq.size() == 0 ? 0 : pq.poll();
    }


    public static void main(String[] args) {
        LastStoneWeightJava test = new LastStoneWeightJava();
        System.out.println(
            test.lastStoneWeight(new int[]{2, 3, 6, 2, 4})
        );
    }
}