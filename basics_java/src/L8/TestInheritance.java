package L8;
/* Created by limxuanhui on 15/6/22 */

class Parent {
    private String type = "parent";

    public void sayHello() {
        System.out.println("Hi everyone, I am a " + type);
    }
}

class Child extends Parent {
    private String type = "child";

    @Override
    public void sayHello() {
        System.out.println("Hi everyone, I am a " + type);
    }
}

public class TestInheritance {

    public static void main(String[] args) {
        Child c = new Child();
        c.sayHello();
    }
}
