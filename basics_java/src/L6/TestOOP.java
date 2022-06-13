package L6;
/* Created by limxuanhui on 13/6/22 */

/**
 * OOP Overriding Practice
 */

class Parent {
    protected void introduce() {
        System.out.println("Hello I'm parent");
    }
}

class Child extends Parent {
    public void introduce() {
        System.out.println("Hello I'm child");
    }
}

public class TestOOP {

    public static void main(String[] args) {
        Child child = new Child();
        child.introduce();
        Parent child2 = new Parent();
        child2.introduce();

        if (child2 instanceof Parent) {
            System.out.println("Is child");
        } else {
            System.out.println("Is parent");
        }
    }
}
