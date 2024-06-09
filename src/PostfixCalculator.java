import java.util.Stack;

public class PostfixCalculator {
    public int evaluatePostfix(String postfixExpression){
        Stack<Integer> stack = new Stack<>();
        for (char c : postfixExpression.toCharArray()) {
            if (Character.isDigit(c) && stack.size() <2) {
                stack.push(c - '0');
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid expression: Not enough operands");}
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = 0;
                result = switch (c) {
                    case '+' -> operand1 + operand2;
                    case '-' -> operand1 - operand2;
                    case '*' -> operand1 * operand2;
                    case '/' -> operand1 / operand2;
                    default -> throw new IllegalArgumentException("Invalid operator: " + c);};
                    stack.push(result);}
            else if (c == ' ') {
                throw new IllegalArgumentException("Spaces not permitted");}
            else{throw new IllegalArgumentException("Multi-digit numbers not allowed");}
            }
            if (stack.size() != 1) {
                throw new IllegalArgumentException("Invalid expression: Too many operands");}

        return stack.pop();}
    public static void main(String[] args){
        PostfixCalculator calculator = new PostfixCalculator();
        try {
            int result = calculator.evaluatePostfix("82/");
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error evaluating expression: " + e.getMessage());
        }

        try {
            int result2 = calculator.evaluatePostfix("26+2*");
            System.out.println("Result 2: " + result2);
        } catch (IllegalArgumentException e) {
            System.out.println("Error evaluating expression: " + e.getMessage());
        }

        try {
            int result3 = calculator.evaluatePostfix("12+9*22-");
            System.out.println("Result 3: " + result3);
        } catch (IllegalArgumentException e) {
            System.out.println("Error evaluating expression: " + e.getMessage());
        }

    }
}
