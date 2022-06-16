package L8;
/* Created by limxuanhui on 15/6/22 */

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Cat {

    public static void cat(File file) throws IOException {
        RandomAccessFile input = null;
        String line = null;

        try {
            input = new RandomAccessFile(file, "r");
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            return;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (input != null) {
                input.close();
            }
//            if (input != null) {
//                try {
//                    input.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
        }

    }

    public static void main(String[] args) {
        Cat c = new Cat();
        File file = new File("src/L8/listofnumbers.txt");
        try {
            cat(file);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
