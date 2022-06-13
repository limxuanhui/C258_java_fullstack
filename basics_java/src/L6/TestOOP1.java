package L6;
/* Created by limxuanhui on 13/6/22 */

/**
 * OOP Abstraction
 */

abstract class MyAbstractClass {

    // abstract method cannot have body
    // 1) concrete method (knows definition and body)
    // 2) abstract method (knows definition only)
    abstract public void myGreeting(String name);

    public void printMe() {
        System.out.println("Hello everyone");
    }
}

class EnglishCommunity extends MyAbstractClass {

    @Override
    public void myGreeting(String name) {
        System.out.println("Good morning Mr/Mrs " + name);
    }
}

class GermanCommunity extends MyAbstractClass {

    @Override
    public void myGreeting(String name) {
        System.out.println("Gluten Morgun Mr/Mrs " + name);
    }
}

public class TestOOP1 {


   public static void main(String[] args) {
       EnglishCommunity ec = new EnglishCommunity();
       GermanCommunity gc = new GermanCommunity();

       ec.myGreeting("John");
       gc.myGreeting("Schwarzenegger");
       ec.printMe();
       gc.printMe();
   }
}
