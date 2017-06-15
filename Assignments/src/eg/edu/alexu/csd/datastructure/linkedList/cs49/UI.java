package eg.edu.alexu.csd.datastructure.linkedList.cs49;

import java.util.Scanner;
/** UI. */
public class UI {

    /**
     * choice char.
     */
    private static char choice;
    /**
     * exit if user want to exit from any step or choice.
     */
    private static boolean exit;
    /**
     * result of any opertion.
     */
    private static int[][] result;
    /**
     * solver object of class PolynomialSolver.
     */
    private static PolynomialSolver solver = new PolynomialSolver();
    /**
     * input to scan from user.
     */
    private static Scanner input = new Scanner(System.in);
    /**
     * flag to execute events.
     */
    private static boolean flag = true;
    /**
     * closeProgram if he want to close.
     */
    private static boolean closeProgram = false;
    /**
     * choice2 char.
     */
    private static char choice2;

    /**
     * @param args parameters for main
     */
    public static void main(final String[] args) {
        while (!closeProgram) {
            exit = false;
            print();

            try {
                char option = input.nextLine().toCharArray()[0];
                switch (option) {
                case '1': // Set a polynomial variable
                    executeCase1();
                    if (exit) {
                        break;
                    }
                    break;
                case '2': // Print the value of a polynomial variable
                    executeCase2();
                    break;
                case '3': // Add two polynomials
                    executeCase3();
                    break;
                case '4': // Subtract two polynomials
                    executeCase4();
                    break;
                case '5': // Multiply two polynomials
                    executeCase5();
                    break;
                case '6': // Evaluate a polynomial at some point
                    executeCase6();
                    break;
                case '7': // Clear a polynomial variable
                    flag = true;
                    while (flag) {
                        System.out.println("Insert The variable name:");
                        choice = input.nextLine().toCharArray()[0];
                        while (choice != 'A' && choice != 'B'
                                && choice != 'C') {
                            System.out.println("Invalid Input!");
                            System.out.println("Press E to return"
                                + " to the main menu or anykey to continue");
                            char close = input.nextLine().toCharArray()[0];
                            if (close == 'E') {
                                exit = true;
                                break;
                            }
                            System.out.println("Choose the variable "
                                    + "name: A, B or C ");
                            choice = input.nextLine().toCharArray()[0];
                        }
                        if (exit) {
                            break;
                        }

                        try {
                            flag = false;
                            solver.clearPolynomial(choice);
                            System.out.println(choice + " is cleared now.\n");
                        } catch (RuntimeException e) {
                            System.out.println("The polynomial "
                        + choice + " isn't set");
                            flag = true;
                            System.out.println("Press E to return"
                        + " to the main menu or anykey to continue");
                            char close = input.nextLine().toCharArray()[0];
                            if (close == 'E') {
                                exit = true;
                                flag = false;
                                break;
                            }
                        }
                    }
                    break;

                case '8':
                    closeProgram = true;
                    System.out.println("Program is closed .. "
                            + "please open program again to restart");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Input!\nTry again");
                    break;
                }

                System.out.println("************************");

            } catch (IndexOutOfBoundsException e) {
                continue;
            }
        }
    }

    /**
     * @param resultt which we want to print
     * @return "String"
     */
    private static String changeToCoeff(final int[][] resultt) {
        String printed = "";
        for (int i = 0; i < resultt.length; i++) {
            printed += "( " + resultt[i][0] + ", " + resultt[i][1] + ')';
            if (i != resultt.length - 1) {
                printed += " , ";
            }
        }
        return printed;
    }

    /**
     * print messesges for user.
     */
    private static void print() {
        System.out.println("Please choose an action:");
        System.out.println("************************");
        System.out.println("1) Set a polynomial variable");
        System.out.println("2) Print the value of a polynomial variable");
        System.out.println("3) Add two polynomials");
        System.out.println("4) Subtract two polynomials");
        System.out.println("5) Multiply two polynomials");
        System.out.println("6) Evaluate a polynomial at some point ");
        System.out.println("7) Clear a polynomial variable  ");
        System.out.println("8) Close all Program  ");
        System.out.println("************************");
    }

    /**
     * execute case1 of switch.
     */
    private static void executeCase1() {
        System.out.println("Choose the variable name: A, B or C ");
        choice = input.nextLine().toCharArray()[0];
        while (choice != 'A' && choice != 'B' && choice != 'C') {
            System.out.println("Invalid Input!");
            System.out.println("Press E to return to the main"
                    + " menu or anykey to continue");
            char close = input.nextLine().toCharArray()[0];
            if (close == 'E') {
                exit = true;
                break;
            }
            System.out.println("Choose the variable name:"
                    + " A, B or C ");
            choice = input.nextLine().toCharArray()[0];
        }
        if (exit) {
            exit = true;

        } else {
        System.out.println("Insert the polynomial"
                + " terms in the form : ");
        System.out.println("(coeff1 , exponent1),"
                + " (coeff2 , exponent2), .. ");
        String array;
        array = input.nextLine();
        array = array.replace(" ", "");
        array = array.replace(",", " ");
        array = array.replace("(", "");
        array = array.replace(")", "");
        String[] inputt = array.split(" ");
        int[] poly = new int[inputt.length];
        for (int i = 0; i < inputt.length; i++) {
            poly[i] = Integer.parseInt(inputt[i]);
        }
        result = new int[inputt.length / 2][2];
        for (int i = 0; i < inputt.length; i += 2) {
            result[i / 2][0] = poly[i];
            result[i / 2][1] = poly[i + 1];
        }
        try {
            solver.setPolynomial(choice, result);
            System.out.println("Polynomial " + choice + " is set.");
            System.out.println("************************");
        } catch (RuntimeException e) {
            System.out.println("Input your polynomial"
                    + " descendively with no similar exponents!");
        }
        }
    }

    /**
     * execute case2 of switch.
     */
    private static void executeCase2() {
        flag = true;
        while (flag) {
            System.out.println("Insert the variable name:");
            choice = input.nextLine().toCharArray()[0];
            try {
                flag = false;
                while (choice != 'A' && choice != 'B'
                        && choice != 'C' && choice != 'R') {
                    System.out.println("Invalid Input"
                            + "....Do it again");
                    System.out.println("Press E to return"
                    + " to the main menu or anykey to continue");
                    char close = input.nextLine().toCharArray()[0];
                    if (close == 'E') {
                        exit = true;
                        break;
                    }
                    System.out.println("Insert the variable name:");
                    choice = input.nextLine().toCharArray()[0];
                }
                if (exit) {
                    break;
                }
                solver.print(choice);
                if (solver.print(choice) == null) {
                    System.out.println("Polynomial "
                + choice + " isn't set");
                    flag = true;
                    System.out.println("Press E to return"
                     + " to the main menu or anykey to continue");
                    char close = input.nextLine().toCharArray()[0];
                    if (close == 'E') {
                        exit = true;
                        flag = false;
                        break;
                    }
                } else {
                    System.out.println("The polynomial "
                + choice + " is:");
                    System.out.println(solver.print(choice));
                }

            } catch (RuntimeException e) {
                continue;
            }
        }
    }

    /**
     * execute case3 of switch.
     */
    private static void executeCase3() {
        flag = true;
        while (flag) {
            System.out.println("Insert"
                    + " the first operand variable:");
            choice = input.nextLine().toCharArray()[0];
            while (choice != 'A'
                && choice != 'B' && choice != 'C') {
                System.out.println("Invalid Input!");
                System.out.println("Press E to"
                + " return to the main menu or anykey to continue");
                char close = input.nextLine().toCharArray()[0];
                if (close == 'E') {
                    exit = true;
                    break;
                }
                System.out.println("Insert the first"
                        + " operand variable: ");
                choice = input.nextLine().toCharArray()[0];
            }
            if (exit) {
                break;
            }

            System.out.println("Insert the second"
                    + " operand variable:");
            choice2 = input.nextLine().charAt(0);
            while (choice2 != 'A' && choice2 != 'B'
                   && choice2 != 'C') {
                System.out.println("Invalid Input!");
                System.out.println("Press E to return to"
                        + " the main menu or anykey to continue");
                char close = input.nextLine().toCharArray()[0];
                if (close == 'E') {
                    exit = true;
                    break;
                }
                System.out.println("Insert the second"
                        + " operand variable: ");
                choice2 = input.nextLine().toCharArray()[0];
            }
            if (exit) {
                break;
            }

            try {
                flag = false;
                solver.add(choice, choice2);
                System.out.println(
                        "The polynomial stored in R is:"
               + changeToCoeff(solver.add(choice, choice2)));
                System.out.println("************************");
            } catch (RuntimeException e) {
                System.out.println("Operands aren't"
                        + " successfully set");
                flag = true;
                System.out.println("Press E to return to"
                        + " the main menu or anykey to continue");
                char close = input.nextLine().toCharArray()[0];
                if (close == 'E') {
                    exit = true;
                    flag = false;
                    break;
                }
            }
        }

    }

    /**
     * execute case4 of switch.
     */
    private static void executeCase4() {
        flag = true;
        while (flag) {
            System.out.println("Insert the first"
                    + " operand variable:");
            choice = input.nextLine().charAt(0);
            while (choice != 'A' && choice != 'B'
                    && choice != 'C') {
                System.out.println("Invalid Input!");
                System.out.println("Press E to return"
                     + " to the main menu or anykey to continue");
                char close = input.nextLine().toCharArray()[0];
                if (close == 'E') {
                    exit = true;
                    break;
                }
                System.out.println("Insert the first"
                        + " operand variable: ");
                choice = input.nextLine().charAt(0);
            }
            if (exit) {
                break;
            }

            System.out.println("Insert the second"
                    + " operand variable:");
            choice2 = input.nextLine().toCharArray()[0];
            while (choice2 != 'A' && choice2 != 'B'
                    && choice2 != 'C') {
                System.out.println("Invalid Input!");
                System.out.println("Press E to return"
                   + " to the main menu or anykey to continue");
                char close = input.nextLine().toCharArray()[0];
                if (close == 'E') {
                    exit = true;
                    break;
                }
                System.out.println("Insert the second"
                        + " operand variable: ");
                choice2 = input.nextLine().toCharArray()[0];
            }
            if (exit) {
                break;
            }

            try {
                flag = false;
                solver.subtract(choice, choice2);
                System.out.println(
                        "The polynomial stored in R is:"
                + changeToCoeff(solver.subtract(choice, choice2)));
                if (solver.print('R') == "") {
                    System.out.println("0");
                }
                System.out.println("************************");
            } catch (RuntimeException e) {
                System.out.println("Operands aren't"
                        + " successfully set");
                flag = true;
                System.out.println("Press E to return to the"
                        + " main menu or anykey to continue");
                char close = input.nextLine().toCharArray()[0];
                if (close == 'E') {
                    exit = true;
                    flag = false;
                    break;
                }
            }
        }

    }

    /**
     * execute case5 of switch.
     */
    private static void executeCase5() {
        flag = true;
        while (flag) {
            flag = false;
            System.out.println("Insert the first"
                    + " operand variable:");
            choice = input.nextLine().toCharArray()[0];
            while (choice != 'A' && choice != 'B'
                    && choice != 'C') {
                System.out.println("Invalid Input!");
                System.out.println("Press E to return to"
                        + " the main menu or anykey to continue");
                char close = input.nextLine().toCharArray()[0];
                if (close == 'E') {
                    exit = true;
                    break;
                }
                System.out.println("Insert the"
                        + " first operand variable: ");
                choice = input.nextLine().toCharArray()[0];
            }
            if (exit) {
                break;
            }

            System.out.println("Insert the second"
                    + " operand variable:");
            choice2 = input.nextLine().toCharArray()[0];
            while (choice2 != 'A' && choice2 != 'B'
                    && choice2 != 'C') {
                System.out.println("Invalid Input!");
                System.out.println("Press E to return to "
                        + "the main menu or anykey to continue");
                char close = input.nextLine().toCharArray()[0];
                if (close == 'E') {
                    exit = true;
                    break;
                }
                System.out.println("Insert the second"
                        + " operand variable: ");
                choice2 = input.nextLine().toCharArray()[0];
            }
            if (exit) {
                break;
            }

            try {
                solver.multiply(choice, choice2);
                System.out.println(
                        "The polynomial stored in R is:"
                + changeToCoeff(solver.multiply(choice, choice2)));
                System.out.println("************************");
            } catch (RuntimeException e) {
                System.out.println("Operands aren't "
                        + "successfully set");
                flag = true;
                System.out.println("Press E to return "
                        + "to the main menu or anykey to continue");
                char close = input.nextLine().toCharArray()[0];
                if (close == 'E') {
                    exit = true;
                    flag = false;
                    break;
                }
            }
        }

    }

    /**
     * execute case6 of switch.
     */
    private static void executeCase6() {
        flag = true;
        while (flag) {

            System.out.println("Insert The variable name:");
            choice = input.nextLine().charAt(0);
            while (choice != 'A' && choice != 'B'
                    && choice != 'C' && choice != 'R') {
                System.out.println("Invalid Input!");
                System.out.println("Press E to return to "
                        + "the main menu or anykey to continue");
                char close = input.nextLine().toCharArray()[0];
                if (close == 'E') {
                    exit = true;
                    break;
                }
                System.out.println("Choose the variable name:"
                        + " A, B, C or R");
                choice = input.nextLine().toCharArray()[0];
            }
            if (exit) {
                break;
            }

            System.out.println("Enter your point");
            float point;
            point = Float.parseFloat(input.nextLine());
            try {
                flag = false;
                solver.evaluatePolynomial(choice, point);
                System.out.println("The value is: "
                + solver.evaluatePolynomial(choice, point));

            } catch (RuntimeException e) {
                System.out.println("The polynomial "
                + choice + " isn't set.");
                System.out.println("Press E to return "
                        + "to the main menu or anykey to continue");
                char close = input.nextLine().toCharArray()[0];
                if (close == 'E') {
                    exit = true;
                    flag = false;
                    break;
                }
                flag = true;
            }
        }

    }

}
