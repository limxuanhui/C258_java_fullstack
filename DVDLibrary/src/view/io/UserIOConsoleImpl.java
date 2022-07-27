package view.io;
/* Created by limxuanhui on 21/6/22 */

import java.util.Locale;
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
        boolean isValid = false;
        do {
            System.out.println(prompt);
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
    public int readInt(String prompt, int min) {
        boolean isValid = false;
        do {
            System.out.println(prompt + "minimum " + min);
            try {
                String numString = scanner.nextLine();
                int num = Integer.parseInt(numString);
                if (num < min) {
                    System.out.println("Invalid input, please try again");
                    continue;
                }
                return num;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (!isValid);
        return -1;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        boolean isValid = false;
        do {
            System.out.println(prompt + min + " to " + max);
            try {
                String numString = scanner.nextLine();
                int num = Integer.parseInt(numString);
                if (num < min || num > max) {
                    System.out.println("Invalid input, please try again");
                    continue;
                }
                return num;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (!isValid);
        return -1;
    }

    @Override
    public double readDouble(String prompt) {
        boolean isValid = false;
        do {
            System.out.println(prompt);
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
        boolean isValid = false;
        do {
            System.out.println(prompt + min + " to " + max);
            try {
                String numString = scanner.nextLine();
                double num = Double.parseDouble(numString);
                if (num < min || num > max) {
                    System.out.println("Invalid input, please try again");
                    continue;
                }
                return num;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (!isValid);
        return -1;
    }

    @Override
    public float readFloat(String prompt) {
        boolean isValid = false;
        do {
            System.out.println(prompt);
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
        boolean isValid = false;
        do {
            System.out.println(prompt + min + " to " + max);
            try {
                String numString = scanner.nextLine();
                float num = Float.parseFloat(numString);
                if (num < min || num > max) {
                    System.out.println("Invalid input, please try again");
                    continue;
                }
                return num;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (!isValid);
        return -1;
    }

    @Override
    public long readLong(String prompt) {
        boolean isValid = false;
        do {
            System.out.println(prompt);
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
        boolean isValid = false;
        do {
            System.out.println(prompt + min + " to " + max);
            try {
                String numString = scanner.nextLine();
                long num = Long.parseLong(numString);
                if (num < min || num > max) {
                    System.out.println("Invalid input, please try again");
                    continue;
                }
                return num;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (!isValid);
        return -1;
    }

    @Override
    public String readYesNo(String prompt) {
        boolean isValid = false;
        do {
            System.out.println(prompt + " (y or n)");
            try {
                String result = scanner.nextLine().toLowerCase(Locale.ROOT);
                if (!result.equals("y") && !result.equals("n")) {
                    System.out.println("Invalid input, please try again");
                    continue;
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (!isValid);
        return null;
    }
}
