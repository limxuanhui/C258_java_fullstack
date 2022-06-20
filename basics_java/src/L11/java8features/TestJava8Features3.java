package L11.java8features;
/* Created by limxuanhui on 20/6/22 */

interface MyInterface1 {
    // static methods in interface should have body
    static void myStaticPrintMe() {
        System.out.println("Hello from static method interface 1");
    }

    default void myDefaultPrintMe() {
        System.out.println("Hello from default method interface 1");
    }
}

interface MyInterface2 {
    // static methods in interface should have body
    static void myStaticPrintMe() {
        System.out.println("Hello from static method interface 2");
    }

    default void myDefaultPrintMe() {
        System.out.println("Hello from default method interface 2");
    }
}

public class TestJava8Features3 implements MyInterface1, MyInterface2 {

//    @Override
    public void myDefaultPrintMe() {
        System.out.println("Hello from new impl of default method interface");
//        MyInterface1.myDefaultPrintMe(); WHY NEED SUPER???????
        MyInterface1.super.myDefaultPrintMe();
    }

    public static void main(String[] args) {
        TestJava8Features3 obj = new TestJava8Features3();
//        MyInterface1.myStaticPrintMe();
        obj.myDefaultPrintMe();
    }
}
