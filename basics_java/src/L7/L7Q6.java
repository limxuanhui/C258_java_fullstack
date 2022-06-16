package L7;
/* Created by limxuanhui on 14/6/22 */

// CHECK
// classA t = new classB(); t.methodFour will use classA's methodfour
class ClassA {
    public void methodOne(int i) {
        System.out.println("ClassA methodOne");
    }
    public void methodTwo(int i) {
        System.out.println("ClassA methodTwo");
    }
    public static void methodThree(int i) {
        System.out.println("ClassA methodThree");
    }
    public static void methodFour(int i) {
        System.out.println("ClassA methodFour");
    }
}

class ClassB extends ClassA {
//    public static void methodOne(int i) {}
    public void methodTwo(int i) {
        System.out.println("ClassB methodTwo");
    }
//    public void methodThree(int i) {}
    public static void methodFour(int i) {
        System.out.println("ClassB methodFour");
    }
}

public class L7Q6 {
    public static void main(String[] args) {
        ClassB cb = new ClassB();
        cb.methodOne(1);
        cb.methodTwo(1);
        cb.methodThree(1);
        cb.methodFour(1);
    }
}
