package L4;
/* Created by limxuanhui on 9/6/22 */

class Laptop {
    private String company;
    private double price;

    public Laptop(String company, double price) {
        this.company = company;
        this.price = price;
    }

    public void getConfiguration() {
        System.out.println("This is a " + this.company + " laptop which costs $" + this.price);
    }

    public void playMusic() {
        System.out.println(this.company + " music playing...");
    }
}

class Person {
    int age;
    String name;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void getIntro() {
        System.out.println("Hey this is " + this.name + " and I am " + this.age + " years old.");
        System.out.println("Since I am " + (canVote() ? "older than 18" : "younger than 18") + ", I " + (canVote() ? "can vote." : "cannot vote."));
    }

    public boolean canVote() {
        if (this.age >= 18) {
            return true;
        }
        return false;
    }
}

public class TestOOP1 {

    public static void main(String[] args) {
//        Laptop laptop = new Laptop("Dell", 1999);
//        laptop.getConfiguration();
//        System.out.println(laptop);
//        char[] c = {'a','b','c'};
//        String s = new String(c);
//        System.out.println(s);

        Person p = new Person("Joseph", 17);
        p.getIntro();
    }
}
