/**
 * 
 * This file contains methods for actually solving the expression.
 * 
 * As an input it simply takes the expression as a String array.
 * 
 * The entrypoint of the whole 'solve' functionality is the 'solve' method.
 * From that, all other functions are called as necessary.
 * 
 * 
 * @author @parv141206
 *
 */

package cli_lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Solve {
    /**
     * The existingOperators ArrayList contains the operators which we would want to
     * check during the evaluation.
     */
    ArrayList<Character> existingOperators = new ArrayList<>(Arrays.asList('/', '*', '+', '-'));

    /**
     * Operators stack stores the operators which come while evaluating each
     * character.
     */
    Stack<Character> Operators = new Stack<>();
    /**
     * Values stack stores the evaluation during each step.
     * Theoretically, at the end of the evaluation, the Values stack will contain
     * the final answere meanwhile Operators stack will be empty.
     */
    Stack<Double> Values = new Stack<>();

    /**
     * The following method , solve , is responsible for actually solving the
     * expression and returning a result.
     * It uses 2 Stacks which keep track of Operators and Values.
     * 
     */

    public Double solve(String[] expression) throws Exception {

        for (int i = 0; i < expression.length; i++) {
            String currentCharacter = expression[i];

            // If the current character is an operator...

            if (this.existingOperators.contains(currentCharacter.charAt(0))) {
                // ...we will push it in correct manner,
                PUSH_AS_OPERATOR(currentCharacter.charAt(0));
            } else {
                // Since its a value , we just push it to the Values stack
                PUSH(currentCharacter);
            }
        }

        /*
         * As stated before, after all the evaluation is completed, theoretically , if
         * the input was valid, the final answere must be stored at the TOP of the
         * Values stack.
         * And thus, we return it...
         * Though, if stack is not empty, we have to perform POP for each operator which
         * is left in the stack
         */
        if (!this.Operators.isEmpty()) {
            while (!this.Operators.isEmpty()) {
                // Performing pop with each operator
                POP(this.Operators.pop());
            }
            if (this.Values.peek() == null || this.Values.isEmpty()) {
                System.out.println("Invalid");
                throw new Exception("Invalid input");
            } else {
                return this.Values.pop();
            }
        } else {
            if (this.Values.peek() == null || this.Values.isEmpty()) {
                System.out.println("Invalid");
                throw new Exception("Invalid input");
            } else {
                return this.Values.pop();
            }
        }
    }

    /**
     * The following method pushes an operator (operator) after few checks...
     */
    private void PUSH_AS_OPERATOR(char operator) {
        // If the stack is empty, we simply push,
        if (this.Operators.empty()) {
            this.Operators.push(operator);
        } else {
            // Only reading the TOP of the stack (no mutation)
            Character operatorOnTop = Operators.peek();
            /*
             * If the precedence of the operator to be pushed is grater than the TOP, that
             * means we simply push the operator.
             * 
             * NOTE: Kindly dont get confused based on "less than" or "grater than", since
             * we are comparing based on index, we dont actually refer to the actual
             * precedence at all. Its all based on index. Just look at the existingOperators
             * to learn more.
             * 
             * - Example,
             * TOP -> |+|
             * the precedence of * is greater than +, though its index is less, and thus we
             * push it.
             */
            if (existingOperators.indexOf(operator) < existingOperators.indexOf(operatorOnTop)) {
                this.Operators.push(operator);
            } else {
                /*
                 * Else according to rules, we pop the TOP of stack and perform the
                 * calculation...
                 * All of the calculation is performed while POP, thus calling its corresponding
                 * method...
                 */
                char poppedOperator = this.Operators.pop();
                // Pushing the current operator
                this.Operators.push(operator);
                POP(poppedOperator);
            }
        }
    }

    private void POP(char operation) {
        // Getting last 2, TOP 2 values on which the operation will be performed.
        Double a = Values.pop();
        Double b = Values.pop();
        // Performing the calculation, note that the order of cases is totally arbitory
        // and doesnt actually effect the calculations.
        Double c;
        switch (operation) {
            case '+':
                c = b + a;
                break;

            case '-':
                c = b - a;
                break;

            case '*':
                c = b * a;
                break;

            case '/':
                c = b / a;
                break;
            default:
                // As such the default case will never be executed
                c = 0.0;
                break;
        }
        // Pushing the Value to the stack
        this.Values.push(c);
    }

    /*
     * Following function is only used during initially pushing the elements, when
     * they are in Character i.e.
     * For the Values Stack
     */
    private void PUSH(String value) {
        Double valueAsDouble = Double.parseDouble(value);
        this.Values.push(valueAsDouble);
    }
}
