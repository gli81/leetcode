

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
    public static void main(String[] args) {
        AddBinaryJava test = new AddBinaryJava();
        System.out.println(test.addBinary("11", "1"));
        System.out.println(test.addBinary("1010", "1011"));
        // System.out.println(test.bin2Dec("1011"));
    }
}