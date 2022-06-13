package L5;
/* Created by limxuanhui on 10/6/22 */

class Calculator1 {
    private int x;
    private int y;

    public Calculator1(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }
}

class ScientificCalculator1 extends Calculator1 {
    private int z;

    public ScientificCalculator1(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public void area() {
        System.out.println("Calculating advanced area with scientific calculator");

    }
}

public class TestOOP2 {

    public static void main(String[] args) {
        ScientificCalculator1 sc = new ScientificCalculator1(1,2,3);
        System.out.println(sc.add(20, 30));
        sc.area();
    }
}
