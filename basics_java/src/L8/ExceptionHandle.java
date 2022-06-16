package L8;
/* Created by limxuanhui on 15/6/22 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionHandle {

    public static void main(String[] args) {
        try {
            int a, b;
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            a = Integer.parseInt(bufferedReader.readLine());
            b = Integer.parseInt(bufferedReader.readLine());
            inputStreamReader.close();
            bufferedReader.close();
        } catch (NumberFormatException | IOException ex) {
            System.out.println(ex.getStackTrace());
            System.out.println(ex.getMessage());
            System.out.println(ex.getMessage() + " is not a numeric value.");
            System.exit(0);
        } finally {
        }
    }
}
