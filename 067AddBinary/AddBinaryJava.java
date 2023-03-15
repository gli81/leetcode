

public class AddBinaryJava {
    /*
     * cannot deal with large number :D
     */
    public String addBinary(String a, String b) {
        // return dec2Bin(bin2Dec2(a) + bin2Dec2(b));
        return Integer.toBinaryString(
            Integer.parseInt(a, 2) + 
            Integer.parseInt(b, 2)
        );
    }
    
    private int bin2Dec(String bin) {
        int ans = 0;
        for (int i = 0; i < bin.length(); i++) {
            ans = ans + (int)((bin.charAt(i) - '0') * Math.pow(2, bin.length() - 1 - i));
        }
        return ans;
    }

    private String dec2Bin(int dec) {
        return Integer.toBinaryString(dec);
    }

    private int bin2Dec2(String bin) {
        return Integer.parseInt(bin, 2);
    }

    public String addBinary2(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        int sum, num1, num2;
        while (i >= 0 || j >= 0) {
            num1 = i >= 0 ? a.charAt(i) - '0' : 0;
            num2 = j >= 0 ? b.charAt(j) - '0' : 0;
            sum = num1 + num2 + carry;
            carry = 0;
            if (sum >= 2) { // 2 or 3
                carry = 1;
                sum = sum % 2;
            }
            ans.insert(0, sum);
            i--; j--;
        }
        if (carry == 1) ans.insert(0, 1);
        return ans.toString();
    }

    public String addBinary3(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();
        char[] sum = new char[Math.max(i, j) + 2];
        int num1, num2, sum_, carry = 0, index = sum.length;
        while (i >= 0 || j >= 0) {
            num1 = i >= 0 ? charA[i] - '0' : 0;
            num2 = j >= 0 ? charB[j] - '0' : 0;
            sum_ = num1 + num2 + carry;
            carry = 0;
            if (sum_ >= 2) {
                carry = 1;
                sum_ = sum_ % 2;
            }
            sum[--index] = (char) (sum_ + '0');
            i--; j--;
        }
        if (carry == 1) sum[0] = (char)(1 + '0'); 
        // return new String(sum) won't work in lower JDK
        // Think the String consturctor doesn't
        // ignore leading 0s in the char array
        // some how jdk17's String() does
        return carry == 1 ? new String(sum) : 
            new String(sum, 1, sum.length - 1);
    }

    public static void main(String[] args) {
        AddBinaryJava test = new AddBinaryJava();
        System.out.println(test.addBinary3("11", "1"));
        System.out.println(test.addBinary3("1010", "1011"));
        // System.out.println(test.bin2Dec("1011"));
        System.out.println(test.addBinary3("0", "0"));
    }
}