package L8;
/* Created by limxuanhui on 15/6/22 */


public class FinallyDemo {
    public static void main(String[] args) {
        int i = 0;
        String greetings[] = {"Hello Twinkle !", "Hello Java !", "Hello World !"};

        while (i < 4) {
            try {
                System.out.println(greetings[i]);
            } catch (Exception e) {
                // ArrayIndexOutOfBoundsException
                System.out.println(e.toString());
                System.out.println("Resetting index value");
            } finally {
                System.out.println("Hi!");
                i++;
            }
        }
    }
}
