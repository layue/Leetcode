import java.util.Stack;

/**
 * Created by X on 06/03/2016.
 * Use Stack to store operands and internal result
 */
public class Solution150 {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> operand = new Stack<>();
        String operator = "+-*/";
        for (String token : tokens) {
            if (operator.contains(token)) {
                Integer o2 = operand.pop();
                Integer o1 = operand.pop();
                switch (token) {
                    case "+":
                        operand.push(o1 + o2);
                        break;
                    case "-":
                        operand.push(o1 - o2);
                        break;
                    case "*":
                        operand.push(o1 * o2);
                        break;
                    case "/":
                        operand.push(o1 / o2);
                        break;
                    default:
                        break;

                }
            } else {
                operand.push(Integer.valueOf(token));
            }
        }
        return operand.pop();
    }

    public static void main (String [] args) {
        String [] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens));

    }
}
