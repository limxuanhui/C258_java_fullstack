package exercises.HowManyDaysUntilFriday;
/* Created by limxuanhui on 26/6/22 */

import io.UserIO;
import io.UserIOConsoleImpl;

import java.util.Locale;

public class App {
    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImpl();
        String dayInput = io.readString("Enter a day of the week: ");
        Day day = Day.valueOf(dayInput.toUpperCase(Locale.ROOT));
        switch (day) {
            case MONDAY:
                System.out.println("4 days to Friday");
                break;
            case TUESDAY:
                System.out.println("3 days to Friday");
                break;
            case WEDNESDAY:
                System.out.println("2 days to Friday");
                break;
            case THURSDAY:
                System.out.println("1 days to Friday");
                break;
            case FRIDAY:
                System.out.println("0 days to Friday");
                break;
            case SATURDAY:
                System.out.println("6 days to Friday");
                break;
            case SUNDAY:
                System.out.println("5 days to Friday");
                break;
            default:
                System.out.println("");
        }
    }
}
