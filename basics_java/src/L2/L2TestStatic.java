package L2;
/* Created by limxuanhui on 7/6/22 */

class MyClass {
    public int x = 10;
    public static int y;
    public static String z;
    public static float a;
    public static double b;
    public static boolean c;

    public static void method1() {
//        Cannot do this!!!
//        System.out.println(this.x);
    }
}

public class L2TestStatic {

    public static void main(String[] args) {
        MyClass obj = new MyClass();

        System.out.println(obj.x);
        System.out.println(obj.y);
        System.out.println(obj.z);
        System.out.println(obj.a);
        System.out.println(obj.b);
        System.out.println(obj.c);
    }
}
