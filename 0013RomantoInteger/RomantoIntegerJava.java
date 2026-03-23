

public class RomantoIntegerJava {
    public int romanToInteger(String s) {
        int ans = 0;
        if (s.indexOf("IV") != -1) {ans -= 2;}
        if (s.indexOf("IX") != -1) {ans -= 2;}
        if (s.indexOf("XL") != -1) {ans -= 20;}
        if (s.indexOf("XC") != -1) {ans -= 20;}
        if (s.indexOf("CD") != -1) {ans -= 200;}
        if (s.indexOf("CM") != -1) {ans -= 200;}

        for(int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I':
                    ans += 1;
                    break;
                case 'V':
                    ans += 5;
                    break;
                case 'X':
                    ans += 10;
                    break;
                case 'L':
                    ans += 50;
                    break;
                case 'C':
                    ans += 100;
                    break;
                case 'D':
                    ans += 500;
                    break;
                case 'M':
                    ans += 1000;
                    break;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String[] testCase = new String[]{"I", "II", "III", "IV", "V", "VI", "IX", "CMDLVI"};
        for (String test : testCase){
            System.out.println(new RomantoIntegerJava().romanToInteger(test));
        }
    }
}
