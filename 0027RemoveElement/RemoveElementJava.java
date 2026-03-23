

public class RemoveElementJava {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int i = 0;  // index
        for (int j = 0; j < nums.length; j ++) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            } 
        }
        return i;
    }

    
    public static void main(String[] args) {
        RemoveElementJava test = new RemoveElementJava();
        System.out.println(test.removeElement(new int[]{1, 1, 2}, 1));
    }
}