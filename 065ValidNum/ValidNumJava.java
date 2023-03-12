

public class ValidNumJava {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberAfterE = true;

        for (int i = 0; i < s.length(); i++) {
            if ('0' <= s.charAt(i) && s.charAt(i) <= 9) {
                numberSeen = true;
                numberAfterE = true;
            } else if (s.charAt(i)== '.') {
                if (eSeen || pointSeen) return false;
                pointSeen = true;
            } else if (s.charAt(i) == 'e') {
                // no ee
                // no e3
                if (eSeen || !numberSeen) return false;
                numberAfterE = false;
                eSeen = true;
            } else if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                // stuff like 3e-3 or -3
                if (i != 0 && s.charAt(i - 1) != 'e') return false;
            } else return false;
        }
        return numberSeen && numberAfterE;
    }


    public static void main(String[] args) {
        ValidNumJava test = new ValidNumJava();
        System.out.println(test.isNumber("0"));
        System.out.println(test.isNumber("e"));
        System.out.println(test.isNumber("."));
    }
}