package eg.edu.alexu.csd.datastructure.stack.cs49;

import java.util.Scanner;

/**
 * UIEvaluator.
 * created on April 20, 2016
 * @author Amr Hedny
 *
 */
public class UIEvaluator {

    /**
     * @param args string which we can sent to run main.
     */
    public static void main(final String[] args) {
        boolean exit = false;
        Evaluator evaluate = new Evaluator();
        while (!exit) {
            System.out.println("Choose one of the next actions : ");
            System.out.println("1- Convert infix to postfix");
            System.out.println("2- Evaluate infix expression");
            System.out.println("3- Exit");
            char choose;
            Scanner input = new Scanner(System.in);
            String inputt = input.nextLine();
            if (inputt.length() >= 2) {
                System.out.println("Invalid Choose .. try again");
            } else {
                choose = inputt.toCharArray()[0];
                switch (choose) {
                case '1':
                    while (true) {
                        System.out.print("Enter any key to go "
                                + "back to main list or C to continue : ");
                        char goBack = input.nextLine().toCharArray()[0];
                        if (goBack == 'C' || goBack == 'c') {
                            System.out.print("Enter the expression "
                                    + "you want to convert : ");
                            String expression = "";
                            try {
                                expression = input.nextLine();
                                String answer = evaluate.infixToPostfix(
                                        expression);
                                System.out.println("answer is : " + answer);
                                break;
                            } catch (RuntimeException e) {
                                System.out.println("your input : " + expression
                                        + " : is invalid input .. try again");
                            }
                        } else {
                            break;
                        }
                    }
                    break;

                case '2':
                    while (true) {
                        System.out.print("Enter any key to go "
                                + "back to main list or C to continue : ");
                        char goBack = input.nextLine().toCharArray()[0];
                        if (goBack == 'C' || goBack == 'c') {
                            System.out.print("Enter infix the expression "
                                    + "you want to evaluate : ");
                            String expression = "";
                            try {
                                expression = input.nextLine();
                                String postfix = evaluate.infixToPostfix(
                                        expression);
                                System.out.println("postfix expression is : "
                                        + postfix);
                                int answer = evaluate.evaluate(postfix);
                                System.out.println("answer is : " + answer);
                                break;
                            } catch (RuntimeException e) {
                                System.out.println("your input : " + expression
                                        + " : is invalid input .. try again");
                            }
                        } else {
                            break;
                        }
                    }
                    break;
                case '3':
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid Choose ,, "
                            + "please Choose from 1 --> 3 ");
                    break;
                }

            }
        }
        System.out.println("Program is closed .. "
                + "please open program again to restart");
        System.exit(0);

    }

}

