

public class ValidNumJava {
    public boolean isNumber(String s) {

    }


    public static void main(String[] args) {
        ValidNumJava test = new ValidNumJava();
        System.out.println(test.isNumber("0"));
        System.out.println(test.isNumber("e"));
        System.out.println(test.isNumber("."));
    }
}