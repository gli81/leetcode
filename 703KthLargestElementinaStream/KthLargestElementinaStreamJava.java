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
<<<<<<< HEAD
        if (
            this.pq.size() > 0 && this.pq.peek() < val ||
            this.pq.size() < this.k
        ) {
            this.pq.add(val);
            if (this.pq.size() > this.k) {
                this.pq.poll();
            }
        }
        return this.pq.peek();
=======
        if (val < this.pq.peek()){
            return this.pq.peek();
        }
>>>>>>> eb9ecffa4549684fffeb41629ff8f16b7dde7ed9
    }


    public static void main(String[] args) {
        
    }
}
