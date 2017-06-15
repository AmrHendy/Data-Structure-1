package eg.edu.alexu.csd.datastructure.linkedList;
/**
 *
 * @author amrmh_000
 *
 */
public interface IPolynomialSolver {

     /**
     * @param poly poly name
     * @param terms coeff and powers
     */
    void setPolynomial(char poly, int[][] terms);

    /**
     * @param poly poly name
     * @return "String"
     */
    String print(char poly);

    /**
     * @param poly poly name
     */
    void clearPolynomial(char poly);

    /**
     * @param poly poly name
     * @param value point where we evaluate
     * @return "float"
     */
    float evaluatePolynomial(char poly, float value);

    /**
     * @param poly1 first poly
     * @param poly2 second poly
     * @return "int"
     */
    int[][] add(char poly1, char poly2);

    /**
     * @param poly1 first poly
     * @param poly2 second poly
     * @return "int"
     */
    int[][] subtract(char poly1, char poly2);

    /**
     * @param poly1 first poly
     * @param poly2 second poly
     * @return "int"
     */
    int[][] multiply(char poly1, char poly2);

}
