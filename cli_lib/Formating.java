/**
 * 
 * This file contains methods for converting the input data which is in a string, unformatted, to a formatted array.
 * 
 * Example
 * Input: 12/    5  *2 -    1
 * Output: ['12' , '/' , '5' , '*' , '2' , '-' , '1']
 * 
 * Simply making it easier to process the input later.
 * 
 * @author @parv141206
 *
 */

package cli_lib;

import java.util.ArrayList;
import java.util.Arrays;

public class Formating {
  /**
   * The following function converts any express entered by the user to a formated
   * String,
   * which can be used to evaluate the expression.
   */
  public static String[] convertExpressionToValidInput(String expression) {
    // All the operators, just as an ArrayList
    ArrayList<Character> operators = new ArrayList<>(Arrays.asList('/', '*', '+', '-'));
    String[] formatedExpression;
    // Splitting expression for each character
    formatedExpression = expression.split("");
    for (int i = 0; i < formatedExpression.length; i++) {
      // Simply adding a whitespace after each operator
      if (operators.contains(formatedExpression[i].charAt(0))) {
        formatedExpression[i] = " " + formatedExpression[i] + " ";
      }
    }
    /*
     * Note: here i am splitting the expression with regex: \\s+ , which basically
     * removes variable length of whitespaces.
     */

    formatedExpression = String.join("", formatedExpression).split("\\s+");
    return formatedExpression;
  }
}
