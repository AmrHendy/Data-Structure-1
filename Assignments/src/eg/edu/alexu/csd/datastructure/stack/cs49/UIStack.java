package eg.edu.alexu.csd.datastructure.stack.cs49;

import java.util.Scanner;

/**
 * UIStack.
 * created on April 20, 2016
 * @author Amr Hedny
 *
 */
public class UIStack {

    /**
     * @param args parameters which we can send to run main
     */
    public static void main(final String[] args) {

        MyStack uI = new MyStack();
        boolean exit = false;
        while (!exit) {
            System.out.println("Choose one of the next actions : ");
            System.out.println("1- Push");
            System.out.println("2- Pop");
            System.out.println("3- Peek");
            System.out.println("4- Get Size");
            System.out.println("5- Check if Empty");
            System.out.println("6- Exit");
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
                            System.out.print("Enter the value "
                                    + "you want to push : ");
                            String numberInString = "";
                            try {
                                numberInString = input.nextLine();
                                float number = Float.parseFloat(numberInString);
                                uI.push(number);
                                System.out.println("" + number + "  is pushed");
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("" + numberInString
                                        + " : is invalid input .. try again");
                            }
                        } else {
                            break;
                        }
                    }
                    break;
                case '2':
                    try {
                        float output = (Float) uI.pop();
                        System.out.println("stack is poped  " + output);
                    } catch (RuntimeException e) {
                        System.out.println("Stack is empty Can't pop");
                    }

                    break;
                case '3':
                    try {
                        float output = (Float) uI.peek();
                        System.out.println("peek is successfull  " + output);
                    } catch (RuntimeException e) {
                        System.out.println("Stack is empty "
                                + ", peek can't be done !");
                    }
                    break;
                case '4':
                    int size = uI.size();
                    if (size != 0) {
                        System.out.println("Size is  " + size);
                    } else {
                        System.out.println("Stack is empty , Size = 0 ");
                    }
                    break;
                case '5':
                    boolean empty = uI.isEmpty();
                    int size2 = uI.size();
                    if (empty) {
                        System.out.println("yes , stack is empty");
                    } else {
                        System.out.println("No , stack isn't empty "
                                + "but has " + size2 + " elements");
                    }
                    break;
                case '6':
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid Choose ,, "
                            + "please Choose from 1 --> 6 ");
                    break;
                }

            }
        }
        System.out.println("Program is closed .. "
                + "please open program again to restart");
        System.exit(0);

    }

}
