package boolean_expressions_control_flow;
/* Created by limxuanhui on 9/6/22 */

public class Operators {

    public static void main(String[] args) {
        boolean x = false;
        boolean y = true;

        // AND / OR - short circuit operators, evaluates second operand only if necessary
        boolean a = x && y;
        boolean b = x || y;

        // XOR
        boolean c = x ^ y;

        // evaluates both operands
        boolean d = x & y;
        boolean e = x | y;
    }
}
