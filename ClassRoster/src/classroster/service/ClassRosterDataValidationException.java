package classroster.service;
/* Created by limxuanhui on 4/7/22 */

public class ClassRosterDataValidationException extends Exception {

    public ClassRosterDataValidationException(String message) {
        super(message);
    }

    public ClassRosterDataValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
