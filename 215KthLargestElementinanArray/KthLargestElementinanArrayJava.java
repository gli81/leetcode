import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementinanArrayJava {
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargest2(int[] nums, int k) {
        return 0;
    }

    public int findKthLargest3(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            if (pq.size() == k && pq.peek() < num || pq.size() < k) {
                pq.offer(num);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }


    public static void main(String[] args) {
        KthLargestElementinanArrayJava test =
            new KthLargestElementinanArrayJava();
        System.out.println(
            test.findKthLargest1(new int[]{2, 3, 1, 5, 4}, 2)
        );
    }
}