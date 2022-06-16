package L8;
/* Created by limxuanhui on 15/6/22 */

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TestException2 {

    // No need throws if we are using try catch here
    // throws keyword says throw this exception as of now and handle it later
    public static void readMyFile() throws IOException, ArithmeticException {
        FileReader reader = new FileReader("src/L8/myfile.txt");
        System.out.println("readMyFile: " + reader.read());
        int a = 10/0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Before exception");

        // Checked exception --> without throws FileNotFoundException, there will be error
        // need try catch since we are throwing in readMyFile
        try {
            readMyFile();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("After exception");
    }
}
