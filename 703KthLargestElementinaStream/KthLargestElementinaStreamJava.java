import java.util.PriorityQueue;

public class KthLargestElementinaStreamJava {
    private PriorityQueue<Integer> pq;
    private int k;


    public KthLargestElementinaStreamJava(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>();
        for (int num : nums) {
            this.pq.add(num);
            if (this.pq.size() > this.k) {
                this.pq.poll();
            }
        }
    }

    public int add(int val) {
        if (val < this.pq.peek()){
            return this.pq.peek();
        }
    }


    public static void main(String[] args) {
        
    }
}
