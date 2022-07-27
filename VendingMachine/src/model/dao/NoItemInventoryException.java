package model.dao;
/* Created by limxuanhui on 27/6/22 */

public class NoItemInventoryException extends Exception {
    public NoItemInventoryException(String message) {
        super(message);
    }

    public NoItemInventoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
