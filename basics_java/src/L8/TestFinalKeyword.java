package L8;
/* Created by limxuanhui on 15/6/22 */

/*
  final keyword --> 1) with class
                    2) with methods
                    3) with variables (becomes a constant)
*/
// not valid --> final class cannot be inherited
// final class Student {
class Student {

    final int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public final void myIntro() {
        System.out.println("Hi this is " + this.name + " and my id is " + this.id);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class TestFinalKeyword extends Student {

    TestFinalKeyword(int id, String name) {
        super(id, name);
    }

    // not valid since Student myIntro is final
//    public void myIntro() {
//        System.out.println("Hi all im testfinalkeyword");
//    }

    public static void main(String[] args) {
        Student student = new Student(101, "Rajesh");
        student.myIntro();

        // not valid since id is final, ide does not create setter for id
        // student.setId(102);
        student.myIntro();
    }
}
