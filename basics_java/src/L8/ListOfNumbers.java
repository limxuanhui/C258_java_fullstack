package L8;
/* Created by limxuanhui on 15/6/22 */

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ListOfNumbers {
    private static ArrayList<Character> arr = new ArrayList<>();

    public static void readList() throws IOException {
        FileReader fileReader = new FileReader("src/L8/listofnumbers.txt");

        int i;
        while ((i = fileReader.read()) != -1) {
            System.out.println((char)i);
            arr.add((char)i);
        }
    }

    public static void main(String[] args) {
        try {
            readList();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        for (char i : arr) {
            System.out.print(i);
        }

        // prints out ascii for value and newline in each iteration
        for (int i : arr) {
            System.out.print(i);
        }
    }
}
