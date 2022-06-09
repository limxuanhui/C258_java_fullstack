package boolean_expressions_control_flow;
/* Created by limxuanhui on 9/6/22 */

public class WhyUseSwitchFallingThrough {

    public static void main(String[] args) {
        int day = 4;
        String dayType = "";

        // if cases before 5 handles the same way as 5
        switch (day) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                dayType = "Weekday";
                break;
            case 6:
            case 7:
                dayType = "Weekend";
                break;
            default:
                dayType = "Invalid Day";
        }

        System.out.println(dayType);
    }
}
