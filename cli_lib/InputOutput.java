/**
 * 
 * This file contains methods for reading and writing, that is, a way to show a good CLI.
 * @author @parv141206
 *
 */

package cli_lib;

import java.util.Scanner;

public class InputOutput {
    /**
     * The following function simply reads an expression from the user. It returns
     * it as a String.
     */
    public static String input() {
        try {
            // Just creating a scanner class instance
            Scanner scanner = new Scanner(System.in);
            /*
             * All the empty prinln() and special characters like " \u001B[34m\u001B[1m "
             * are only meant to make the CLI look good.
             * It has nothing to do with functioning.
             * 
             * For further reference, just search on google for them.
             */
            System.out.println();
            System.out.println("\u001B[34m\u001B[1mPlease enter an expression\u001B[0m" + "\t"
                    + "\u001B[32mType exit to exit...\u001B[0m "); // bold blue text
            System.out.println();
            System.out.println("  " + "\u001B[37m(Example 1 + 2 * 3)\u001B[0m"); // light gray text
            System.out.println();
            System.out.print("\u001B[32m>\u001B[0m "); // Shows the green arrow
            // Reading the expression
            String expression = scanner.nextLine();
            System.out.println();
            return expression;
        } catch (Exception e) {
            System.out.println("Error occured: " + e.getMessage());
            return "Error";
        }
    }

    public static void output(Double answere) {
        System.out.print("\u001B[34m\u001B[1mAnswere -> \u001B[0m" + answere);
        System.out.println();
    }

    // Just the welcome text
    public static void welcome() {
        // Obviously i havent typed the Calculator thing (doodle), i have generated it
        // from https://kammerl.de/ascii/AsciiSignature.php
        System.out.println("\r\n" + //
                "\r\n" + //
                "   ___      _            _       _              _ \r\n" + //
                "  / __\\__ _| | ___ _   _| | __ _| |_ ___  _ __ / \\\r\n" + //
                " / /  / _` | |/ __| | | | |/ _` | __/ _ \\| '__/  /\r\n" + //
                "/ /__| (_| | | (__| |_| | | (_| | || (_) | | /\\_/ \r\n" + //
                "\\____/\\__,_|_|\\___|\\__,_|_|\\__,_|\\__\\___/|_| \\/   \r\n" + //
                "                                                  \r\n" + //
                "\r\n" + //
                "");
        System.out.println("\u001B[34m\u001B[1mMade by Parv Shah @parv141206\u001B[0m");
        System.out.println("_______________________________________________________________");
    }

    public static void end() {
        System.out.println("\r\n" + //
                "\r\n" + //
                " _                  _ \r\n" + //
                "| |__  _   _  ___  / \\\r\n" + //
                "| '_ \\| | | |/ _ \\/  /\r\n" + //
                "| |_) | |_| |  __/\\_/ \r\n" + //
                "|_.__/ \\__, |\\___\\/   \r\n" + //
                "       |___/          \r\n" + //
                "\r\n" + //
                "");
    }
}
