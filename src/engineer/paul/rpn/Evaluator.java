package engineer.paul.rpn;

import engineer.paul.util.Stack;

import java.util.HashSet;
import java.util.Set;

public class Evaluator {

    // TODO: Look into combining similar requirements such as operators into a utility class or similar
    private static Set<String> operators = new HashSet<>();

    public Evaluator() {
        operators.add("*");
        operators.add("/");
        operators.add("+");
        operators.add("-");
    }


    public static int evaluatePostFixExpression(String postfixExpression) {
        postfixExpression = postfixExpression.replaceAll("\\(", "( ")
                                             .replaceAll("\\)", " )");

        Stack operandStack = new Stack();
        String[] postfixInput = postfixExpression.split(" ");
        int solution = 0;

        for (String character : postfixInput) {
            if (!operators.contains(character)) {
                operandStack.push(character);
            } else {
                int secondOperand = Integer.parseInt(operandStack.pop());
                int firstOperand = Integer.parseInt(operandStack.pop());

                switch (character) {
                    case "*":
                        operandStack.push(Integer.toString(firstOperand * secondOperand));
                        break;
                    case "/":
                        operandStack.push(Integer.toString(firstOperand / secondOperand));
                        break;
                    case "+":
                        operandStack.push(Integer.toString(firstOperand + secondOperand));
                        break;
                    case "-":
                        operandStack.push(Integer.toString(firstOperand - secondOperand));
                        break;
                }
            }
        }

        return Integer.parseInt(operandStack.pop());
    }
}
