package eg.edu.alexu.csd.datastructure.stack.cs49;
/**
 * Stack.
 * created on April 20, 2016
 * @author Amr Hedny
 *
 */
public class Main {

    /**
     * @param args parameters for main
     */
    /*    public static void main(final String[] args) {
        Evaluator stack = new Evaluator();
        String infix = "(1 + 2) * 7";
        String postfix = stack.infixToPostfix(infix);
        System.out.println(postfix);
        String expression = "2 0 /";
        int result = stack.evaluate(expression);
        System.out.println(result);
    }
*/

public static void main(String[] args) {
    Evaluator testMe = new Evaluator();
    StringBuilder string = new StringBuilder();

    for (int i = 0; i < 100000; i++) {
        string = string.append("1+");
    }
    string = string.append("1");
    long start = System.currentTimeMillis();
    String ev = testMe.infixToPostfix(string.toString());
    long first = System.currentTimeMillis();
    testMe.evaluate(ev);
    long second = System.currentTimeMillis();
    System.out.println(first-start);
    System.out.println(second-first);
    System.out.println(second-start);
    }

}
