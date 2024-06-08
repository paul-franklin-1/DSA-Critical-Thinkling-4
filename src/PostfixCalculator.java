import java.util.EmptyStackException;
import java.util.Stack;

public class PostfixCalculator {
    public int evaluatePostfix(String postfixExpression){
        Stack<Integer> stack = new Stack<>();
        for (char c : postfixExpression.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = switch (c) {
                    case '+' -> operand1 + operand2;
                    case '-' -> operand1 - operand2;
                    case '*' -> operand1 * operand2;
                    case '/' -> operand1 / operand2;
                    default -> throw new IllegalArgumentException("Invalid operator");
                };
                stack.push(result);
            }
        }
        return stack.pop();}
    public static void main(String[] args){
        PostfixCalculator calculator = new PostfixCalculator();
        /*int result = calculator.evaluatePostfix("82/");
        System.out.println("Result: " + result);
        int result2 = calculator.evaluatePostfix("26+2*");
        System.out.println("Result 2: " + result2);
        int result3 = calculator.evaluatePostfix("9-");
        System.out.println("Result 3: " + result3);*/
        try {
            int result = calculator.evaluatePostfix("82/");
            System.out.println("Result: " + result);
        } catch (EmptyStackException e) {
            System.out.println("Error evaluating expression: " + e.getMessage());
        }

        try {
            int result2 = calculator.evaluatePostfix("26+2*");
            System.out.println("Result 2: " + result2);
        } catch (EmptyStackException e) {
            System.out.println("Error evaluating expression: " + e.getMessage());
        }

        try {
            int result3 = calculator.evaluatePostfix("9-");
            System.out.println("Result 3: " + result3);
        } catch (EmptyStackException e) {
            System.out.println("Error evaluating expression: " + e.getMessage());
        }

    }
}
