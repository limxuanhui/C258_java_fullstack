package L11;
/* Created by limxuanhui on 20/6/22 */

interface Human {
    public void breath();
}

class Parent {
    public Parent() {
        System.out.println("Parent created");
    }

    public void sayHello() {
        System.out.println("Im a parent");
    }
}

class Child extends Parent {
    public Child() {
//        super();
        System.out.println("Child created");
    }

    @Override
    public void sayHello() {
        System.out.println("Im a child");
//        super.sayHello();
    }
}

public class Practice {
    public static void main(String[] args) {
        Parent p = new Parent();
        p.sayHello();
        System.out.println();

        Child c = new Child();
        c.sayHello();
        System.out.println();

        Parent cp = new Child();
        cp.sayHello();
    }
}
