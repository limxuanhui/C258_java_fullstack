package L7;
/* Created by limxuanhui on 14/6/22 */

import java.util.Date;

/*
  Suppose you have written a time server that periodically notifies its clients of the current date and time.
  Write an interface the server could use to enforce a particular protocol on its clients.
*/
public interface L7Q5TimeServerInterface {
    Date getDate();
    void scheduleNotification(Date from, Date to, int periods);
    void notifyDateTime(Date currentDate);
}
