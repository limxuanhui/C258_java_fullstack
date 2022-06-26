package exercises.MathOperators;
/* Created by limxuanhui on 26/6/22 */

import io.UserIO;
import io.UserIOConsoleImpl;

public class App {
    public static int calculate(MathOperator operator, int operand1, int operand2) {
        switch (operator) {
            case PLUS:
                return operand1 + operand2;
            case MINUS:
                return operand1 - operand2;
            case MULTIPLY:
                return operand1 * operand2;
            case DIVIDE:
                return operand1 / operand2;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImpl();
        int op1 = io.readInt("Enter operand 1");
        int op2 = io.readInt("Enter operand 2");
        System.out.println(op1 + " + " + op2 + " = "
                            + calculate(MathOperator.PLUS, op1, op2));
        System.out.println(op1 + " - " + op2 + " = "
                + calculate(MathOperator.MINUS, op1, op2));
        System.out.println(op1 + " * " + op2 + " = "
                + calculate(MathOperator.MULTIPLY, op1, op2));
        System.out.println(op1 + " / " + op2 + " = "
                + calculate(MathOperator.DIVIDE, op1, op2));
    }
}
