package eg.edu.alexu.csd.datastructure.stack;
/**
 * IExpressionEvaluator.
 * created on April 20, 2016
 * @author Amr Hedny
 *
 */
public interface IExpressionEvaluator {

    /**
     * @param expression thatt we want to convert
     * @return "String" converted expression
     */
    public String infixToPostfix(String expression);

    /**
     * @param expression that we want to evaluate
     * @return "int" value of expression
     */
    public int evaluate(String expression);

}
