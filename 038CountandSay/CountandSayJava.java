

public class CountandSayJava {
    public static void main(String[] args) {
        CountandSayJava test = new CountandSayJava();
        System.out.println(test.countAndSay2(9));
    }

    public String countAndSay2(int n) {
        String ans = "1";
        while(n != 1) {
            int index = 0;
            String temp = "";
            while (index < ans.length()) {
                temp = temp + getRepNum(ans.substring(index)) + ans.charAt(index);
                index += getRepNum(ans.substring(index));
            }
            ans = temp;
            // System.out.println(ans);
            n -= 1;
        }
        return ans;
    }

    private int getRepNum(String word){
        int count = 1;
        for (int i = 1; i < word.length(); i++){
            if (word.charAt(i) == word.charAt(0)) {
                count ++;
            } else {
                break;
            }
        }
        return count;
    }
}