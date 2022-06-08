package L1;
/* Created by limxuanhui on 6/6/22 */

public class L1HelloMyWorld {

    public static void add(int x, int y) {
        System.out.println("add:");
        System.out.println("x:" + x);
        System.out.println("y:" + y);
        System.out.println(x+y);
    }

    public static void main(String[] args) {
        System.out.println("Hellow my world!");
        L1HelloWorld hw = new L1HelloWorld();

        int x = 100;
        char z = 'z';
        char y = '1';
        System.out.println(Character.getNumericValue(y));
        System.out.println(Character.toChars(x));

//        int y = 20;
//        x = 'A';
//        System.out.println(x+y);
//        char a = 'a';
//        System.out.println(a + 0);
//        System.out.println("===add");
//        add(a, y);
    }
}
