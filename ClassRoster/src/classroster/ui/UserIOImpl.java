package classroster.ui;
/* Created by limxuanhui on 20/6/22 */

import java.util.Scanner;

public class UserIOImpl implements UserIO {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        String input = scanner.nextLine();
        return input;
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        boolean isValid = false;
        do {
            try {
                String numString = scanner.nextLine();
                int num = Integer.parseInt(numString);
                return num;
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
                double num = Double.parseDouble(numString);
                return num;
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
                float num = Float.parseFloat(numString);
                return num;
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
                long num = Long.parseLong(numString);
                return num;
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
