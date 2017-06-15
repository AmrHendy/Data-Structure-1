package eg.edu.alexu.csd.datastructure.calculator.cs49;

import eg.edu.alexu.csd.datastructure.calculator.ICalculator;
/**
 *
 * @author amrmh_000
 *
 */
public class Calculator implements ICalculator {

    /**
     * @param x first no
     * @param y second no
     * @return "int"
     */
    public final int add(final int x, final int y) {
        return x + y;
    }

    /**
     * @param x first no
     * @param y second no
     * @return "float"
     */
    public final float divide(final int x, final int y) {
        return (float) x / y;
    }

}
