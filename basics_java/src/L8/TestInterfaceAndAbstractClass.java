package L8;
/* Created by limxuanhui on 15/6/22 */

interface A {
    void methodA();
    default void methodB() {
        System.out.println("methodB in A called");
    }
}

abstract class B implements A {

}

class C extends B {
    @Override
    public void methodA() {
        System.out.println("methodA in C called");
    }
}

public class TestInterfaceAndAbstractClass {
    public static void main(String[] args) {
        C c = new C();
        c.methodA();
        c.methodB();
    }
}
