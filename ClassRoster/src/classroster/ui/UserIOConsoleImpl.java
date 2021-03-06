package classroster.ui;
/* Created by limxuanhui on 21/6/22 */

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        boolean isValid = false;
        do {
            try {
                String numString = scanner.nextLine();
                return Integer.parseInt(numString);
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (!isValid);
        return -1;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        System.out.println(prompt + min + " to " + max);
        boolean isValid = false;
        do {
            try {
                String numString = scanner.nextLine();
                int num = Integer.parseInt(numString);
                if (num < min || num > max) continue;
                return num;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (!isValid);
        return -1;
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        boolean isValid = false;
        do {
            try {
                String numString = scanner.nextLine();
                return Double.parseDouble(numString);
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (!isValid);
        return -1;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        System.out.println(prompt + min + " to " + max);
        boolean isValid = false;
        do {
            try {
                String numString = scanner.nextLine();
                double num = Double.parseDouble(numString);
                if (num < min || num > max) continue;
                return num;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (!isValid);
        return -1;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        boolean isValid = false;
        do {
            try {
                String numString = scanner.nextLine();
                return Float.parseFloat(numString);
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (!isValid);
        return -1;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        System.out.println(prompt + min + " to " + max);
        boolean isValid = false;
        do {
            try {
                String numString = scanner.nextLine();
                float num = Float.parseFloat(numString);
                if (num < min || num > max) continue;
                return num;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (!isValid);
        return -1;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        boolean isValid = false;
        do {
            try {
                String numString = scanner.nextLine();
                return Long.parseLong(numString);
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (!isValid);
        return -1;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        System.out.println(prompt + min + " to " + max);
        boolean isValid = false;
        do {
            try {
                String numString = scanner.nextLine();
                long num = Long.parseLong(numString);
                if (num < min || num > max) continue;
                return num;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (!isValid);
        return -1;
    }
}
