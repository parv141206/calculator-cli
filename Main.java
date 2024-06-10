
/**
 * 
              ___            ___ ___         ___ 
              | |            | | | |         | |
              | |__     ___  | | | |   ___   | |
              | '_ \   / _ \ | | | |  / _ \  | |
              | | | | |  __/ | | | | | (_) | |_|
              |_| |_|  \___| |_| |_|  \___/  (_)

 * This is a simple calculator which uses Stack and polish notations for calculating!
 * 
 * All the major functions which you see are in the cli_lib.
 * It is custom module, made by myself! 
 * 
 * Requirements:
 *  - Java!
 * 
 * How to run:
 *  - If you want to run it manually, just run:
 *    - javac Main.java
 *    - java Main
 *  - Else you can just run the RUN batch file!
 * 
 * 
 * 
 * @author @parv141206
 *
 */

import cli_lib.*;

public class Main {
  public static void main(String[] args) {
    InputOutput.welcome();
    try {
      do {

        // Reading the expression from user...
        String expression = InputOutput.input();

        // If the input is exit, we simply exit,
        if (expression.equalsIgnoreCase("exit")) {
          break;
        }
        // Expression as an array
        String[] formatedExpression = Formating.convertExpressionToValidInput(expression.trim());

        /*
         * Following is in different , nested , try_catch because through this i can
         * identify if the problem was in my code, or in the input.
         */
        try {
          Solve obj = new Solve();
          InputOutput.output(obj.solve(formatedExpression));
        } catch (Exception e) {
          System.out.println("Invalid input");
        }
      } while (true);
    } catch (Exception e) {
      System.out.println(e.getMessage());

    }
    InputOutput.end();
  }
}
