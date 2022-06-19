package L9.BankingBackendApp;
/* Created by limxuanhui on 17/6/22 */

public interface Bank {

    int promptInt();
    String promptString(String field);
    public void serve(int choice);
    boolean connectToDatabase(String url);
    void saveToDatabase(String url);
    void greet();
    void bye();

}
