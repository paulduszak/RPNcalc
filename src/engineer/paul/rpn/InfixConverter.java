package engineer.paul.rpn;

import engineer.paul.util.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class InfixConverter {

    private static Map<String, Integer> operators = new HashMap<String, Integer>();

    public InfixConverter() {
        operators.put("*", 3);
        operators.put("/", 2);
        operators.put("+", 1);
        operators.put("-", 0);
    }

    /**
     * Returns a Postfix expression.
     *
     * Iterates over each character in the passed infix expression.
     *
     * 1. If the character is an operator, it is added to an operator stack. Any operators already on the stack with
     *    higher precedence are popped off the stack and are appended to the output string
     *
     * 2. If the character is a left paren, it is added to the operator stack.
     *
     * 3. If the character is a right paren, operators are popped off the operator stack and appended to the output
     *    string until a left paren is popped off the stack. The left and right parens are discarded.
     *
     * 4. Any other characters are immediately appended to the output string.
     *
     * @param infixExpression an expression where the operators come between operands
     * @return an expression where operators come after corresponding operands
     */
    public static String toPostFix(String infixExpression) {

        // TODO: Remove redundant expression parsing code, perhaps into a utility class
        infixExpression = infixExpression.replaceAll("\\(", "( ")
                                         .replaceAll("\\)", " )");

        Stack opStack = new Stack();
        String[] infixInput = infixExpression.split(" ");
        StringJoiner postFixOutput = new StringJoiner(" ");

        for (String character : infixInput) {
            if (operators.containsKey(character)) {
                while(!opStack.isEmpty()) {
                    if (operators.get(opStack.peek()) != null && operators.get(character) <= operators.get(opStack.peek())) {
                        postFixOutput.add(opStack.pop());
                    } else {
                        break;
                    }
                }
                opStack.push(character);
            } else if (character.equals("(")) {
                opStack.push("(");
            } else if (character.equals(")")) {
                while(!opStack.isEmpty()) {
                    String nextOp = opStack.pop();

                    if (!nextOp.equals("(")) {
                        postFixOutput.add(nextOp);
                    } else {
                        break;
                    }
                }
            } else {
               postFixOutput.add(character);
            }
        }

        while (!opStack.isEmpty()) {
            postFixOutput.add(opStack.pop());
        }

        return postFixOutput.toString();
    }

    /**
     * Returns a Prefix expression
     *
     * @param infixExpression an expression where the operator comes between operands
     * @return an expression where operators come after corresponding operands
     */
    public static String toPreFix(String infixExpression) {

        // TODO: Implement toPreFix function

        return null;
    }

}
