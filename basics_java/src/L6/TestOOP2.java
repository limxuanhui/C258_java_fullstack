package L6;
/* Created by limxuanhui on 13/6/22 */

/**
 * OOP Interface
 */

interface CentralBank {
    /*
        Interface only has abstract methods
     */
    void getEMI(int rate);
    void getIR();
}

interface WorldBank {
    void getEMI(int rate);
}

class HSBC implements CentralBank, WorldBank {

    @Override
    public void getEMI(int rate) {
        System.out.println("So the HSBC EMI will be " + rate);
    }

    @Override
    public void getIR() {
        System.out.println(Math.random());
    }


}

class DBS implements CentralBank {

    @Override
    public void getEMI(int rate) {
        System.out.println("DBS EMI is " + rate);
    }

    @Override
    public void getIR() {
        System.out.println(Math.random());
    }
}

public class TestOOP2 {

    public static void main(String[] args) {
        HSBC hsbc = new HSBC();
        DBS dbs = new DBS();
        hsbc.getEMI(4);
        dbs.getEMI(2);
        hsbc.getIR();
        dbs.getIR();
    }
}
