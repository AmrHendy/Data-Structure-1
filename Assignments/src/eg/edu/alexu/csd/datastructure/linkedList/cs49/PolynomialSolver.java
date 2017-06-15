package eg.edu.alexu.csd.datastructure.linkedList.cs49;

import java.util.Arrays;
import java.util.Comparator;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;
/** solver.*/
public class PolynomialSolver implements IPolynomialSolver {

    /** solver.*/
    int[][] array;
    /** A.*/
    SinglyLinkedList a;
    /** B.*/
    SinglyLinkedList b;
    /** C.*/
    SinglyLinkedList c;
    /** Result.*/
    SinglyLinkedList r;
    /** adder.*/
    boolean adder = false;
    /** subtract.*/
    boolean subtractor = false;
    /** multiply.*/
    boolean multiplier = false;
    /** sort.*/
    private class Sort2DArray implements Comparator<int[]> {

        /**
         * @param o1 first object
         * @param o2 second object
         * @return "int"
         */
        public int compare(final int[] o1, final int[] o2) {
            return o2[1] - o1[1];
        }
    }

    /**
     * @param poly first char
     * @param terms array
     */
    public final void setPolynomial(final char poly, final int[][] terms) {

        array = new int[terms.length][2];
        array = terms.clone();
        if (checkValid()) {
            switch (poly) {
            case 'A':
                a = new SinglyLinkedList();
                for (int i = 0; i < terms.length; i++) {
                    a.add(terms[i]);
                }
                break;
            case 'B':
                b = new SinglyLinkedList();
                for (int i = 0; i < terms.length; i++) {
                    b.add(terms[i]);
                }
                break;

            case 'C':
                c = new SinglyLinkedList();
                for (int i = 0; i < terms.length; i++) {
                    c.add(terms[i]);
                }
                break;

            case 'R':
                r = new SinglyLinkedList();
                for (int i = 0; i < terms.length; i++) {
                    r.add(terms[i]);
                }
                break;

            default:
                throw new RuntimeException("Wrong Poly");
            }

        } else {
            throw new RuntimeException("Wrong Array from set");
        }

    }

    /**
     * @param d linked list
     * @return "String"
     */
    private String printPolynomial(final SinglyLinkedList d) {
        String result = "", printedForm = "";
        for (int i = 0; (d != null) && !(d.isEmpty()) && (i < d.size()); i++) {
            if (((int[]) d.get(i))[0] > 0) {
                result += '+';
            }
            if (((int[]) d.get(i))[1] == 0 && ((int[]) d.get(i))[0] != 0) {
                // power
                result += ((int[]) d.get(i))[0];
            } else if (((int[]) d.get(i))[0] == 0) {
                continue;
            } else if ((((int[]) d.get(i))[1] == 1)
                    && (((int[]) d.get(i))[0] == 1)) {
                result += "x";
            } else if ((((int[]) d.get(i))[1] == 1)
                    && (((int[]) d.get(i))[0] != 1)) {
                result += ((int[]) d.get(i))[0] + "x";
            } else {
                result += ((int[]) d.get(i))[0] + "x^" + ((int[]) d.get(i))[1];
            }
        }
        if (d == null) {
            return null;
        }
        for (int i = 0; i < result.length(); i++) {
            if ((result.toCharArray()[i] == '+') && (i == 0)) {
                continue;
            }
            printedForm += result.toCharArray()[i];
        }
        if (printedForm == "") {
            printedForm = "0";
        }
        return printedForm;
    }

    /**
     * @param poly char
     * @return "String"
     */
    public final String print(final char poly) {
        switch (poly) {
        case 'A':
            return printPolynomial(a);
        case 'B':
            return printPolynomial(b);
        case 'C':
            return printPolynomial(c);
        case 'R':
            return printPolynomial(r);
        default:
            throw new RuntimeException("Wrong Poly");
        }

    }

    /**
     * @param poly char
     */
    public final void clearPolynomial(final char poly) {
        switch (poly) {
        case 'A':
            if (a != null) {
                a.clear();
                a = null;
            } else {
                throw new RuntimeException("A is empty can't be cleared");
            }
            break;

        case 'B':
            if (b != null) {
                b.clear();
            } else {
                throw new RuntimeException("B is empty can't be cleared");
            }
            break;

        case 'C':
            if (c != null) {
                c.clear();
            } else {
                throw new RuntimeException("C is empty can't be cleared");
            }
            break;

        case 'R':
            if (r != null) {
                r.clear();
            } else {
                throw new RuntimeException("R is empty can't be cleared");
            }
            break;

        default:
            throw new RuntimeException("Wrong Poly");
        }
    }

    /**
     * @return "boolean"
     */
    private boolean checkValid() {
        int i;
        for (i = 0; i < array.length - 1; i++) {

            if ((array[i][1] <= array[i + 1][1])
                    || (array[i][1] < 0) || (array[i + 1][1] < 0)) {
                return false;
            }
        }
        if (array[0][1] < 0) {
            return false;
        }

        return true;
    }

    /**
     * @param poly first char
     * @param value point
     * @return "float"
     */
    public final float evaluatePolynomial(final char poly, final float value) {
        float result = 0;
        switch (poly) {
        case 'A':
            for (int i = 0; (a != null) && (!a.isEmpty())
                    && (i < a.size()); i++) {
                result += (((int[]) a.get(i))[0])
            * Math.pow((double) value, (double) (((int[]) a.get(i))[1]));
            }
            if (a == null || a.isEmpty()) {
                throw new RuntimeException("A is empty or null can't access");
            }
            return result;

        case 'B':
            for (int i = 0; (b != null) && (!b.isEmpty())
                    && (i < b.size()); i++) {
                result += (((int[]) b.get(i))[0])
            * Math.pow((double) value, (double) (((int[]) b.get(i))[1]));
            }
            if (b == null || b.isEmpty()) {
                throw new RuntimeException("B is empty or null can't access");
            }
            return result;

        case 'C':
            for (int i = 0; (c != null) && (!c.isEmpty())
                    && (i < c.size()); i++) {
                result += (((int[]) c.get(i))[0])
               * Math.pow((double) value, (double) (((int[]) c.get(i))[1]));
            }
            if (c == null || c.isEmpty()) {
                throw new RuntimeException("C is empty or null can't access");
            }
            return result;

        case 'R':
            for (int i = 0; (r != null) && (!r.isEmpty())
                    && (i < r.size()); i++) {
                result += (((int[]) r.get(i))[0])
             * Math.pow((double) value, (double) (((int[]) r.get(i))[1]));
            }
            if (r == null || r.isEmpty()) {
                throw new RuntimeException("R is empty or null can't access");
            }
            return result;

        default:
            throw new RuntimeException("Wrong Poly");
        }
    }

    /**
     * @param poly1 first char
     * @param poly2 second char
     * @return "int"
     */
    public final int[][] add(final char poly1, final char poly2) {
        SinglyLinkedList result = null;
        int[][] resultt;
        adder = true;
        result = testOperation(poly1, poly2);
        adder = false;
        resultt = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            resultt[i] = (int[]) result.get(i);
        }
        Arrays.sort(resultt, new Sort2DArray());
        if (r != null) {
            clearPolynomial('R');
        }
        setPolynomial('R', resultt);

        return resultt;
    }

    /**
     * @param poly1 first char
     * @param poly2 second char
     * @return "int"
     */
    public final int[][] subtract(final char poly1, final char poly2) {
        int[][] resultt;
        if (poly1 == poly2) {
            resultt = new int[1][2];
            resultt[0][0] = 0;
            resultt[0][1] = 0;
            return resultt;
        }
        SinglyLinkedList result = null;
        SinglyLinkedList y = new SinglyLinkedList();

        switch (poly2) {
        case 'A':
            y = makeMinus(a);
            if (poly1 == 'B') {
                result = addTwoPolynomials(b, y);
            } else if (poly1 == 'C') {
                result = addTwoPolynomials(c, y);
            } else if (poly1 == 'R') {
                result = addTwoPolynomials(r, y);
            } else {
                throw new RuntimeException("Subtract Error");
            }
            break;
        case 'B':
            y = makeMinus(b);
            if (poly1 == 'A') {
                result = addTwoPolynomials(a, y);
            } else if (poly1 == 'C') {
                result = addTwoPolynomials(c, y);
            } else if (poly1 == 'R') {
                result = addTwoPolynomials(r, y);
            } else {
                throw new RuntimeException("Subtract Error");
            }
            break;
        case 'C':
            y = makeMinus(c);
            if (poly1 == 'B') {
                result = addTwoPolynomials(b, y);
            } else if (poly1 == 'A') {
                result = addTwoPolynomials(a, y);
            } else if (poly1 == 'R') {
                result = addTwoPolynomials(r, y);
            } else {
                throw new RuntimeException("Subtract Error");
            }
            break;
        case 'R':
            y = makeMinus(r);
            if (poly1 == 'B') {
                result = addTwoPolynomials(b, y);
            } else if (poly1 == 'C') {
                result = addTwoPolynomials(c, y);
            } else if (poly1 == 'A') {
                result = addTwoPolynomials(a, y);
            } else {
                throw new RuntimeException("Subtract Error");
            }
            break;
        default:
            throw new RuntimeException("Error Input");
        }
        resultt = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            resultt[i] = (int[]) result.get(i);
        }
        Arrays.sort(resultt, new Sort2DArray());
        if (r != null) {
            clearPolynomial('R');
        }
        setPolynomial('R', resultt);
        return resultt;
    }

    /**
     * @param poly1 first char
     * @param poly2 second char
     * @return "int"
     */
    public final int[][] multiply(final char poly1, final char poly2) {
        SinglyLinkedList result = null;
        int[][] resultt;
        multiplier = true;
        result = testOperation(poly1, poly2);
        multiplier = false;
        resultt = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            resultt[i] = (int[]) result.get(i);
        }
        Arrays.sort(resultt, new Sort2DArray());
        if (r != null) {
            clearPolynomial('R');
        }
        setPolynomial('R', resultt);
        return resultt;
    }
    /**
     *
     * @param d first linkedList
     * @param e second linkedList
     * @return "SinglyLinkedList"
     */
    private SinglyLinkedList addTwoPolynomials(
            final SinglyLinkedList d, final SinglyLinkedList e) {

        if (d == null || e == null || d.isEmpty() || e.isEmpty()) {
            throw new RuntimeException("error add two polynomials");
        }
        SinglyLinkedList resultList = new SinglyLinkedList();
        for (int i = 0; i < d.size(); i++) {
            resultList.add(d.get(i));
        }
        for (int i = 0; i < e.size(); i++) {
            resultList.add(e.get(i));
        }
        for (int i = 0; i < resultList.size(); i++) {
            for (int j = i + 1; j < resultList.size(); j++) {
                if (((int[]) resultList.get(i))[1]
                        == ((int[]) resultList.get(j))[1]) {
                    int coeff = ((int[]) resultList.get(i))[0]
                            + ((int[]) resultList.get(j))[0];
                    int[] temp = new int[2];
                    temp[0] = coeff;
                    temp[1] = ((int[]) resultList.get(i))[1];
                    resultList.set(i, temp);
                    resultList.remove(j);
                    break;
                }
            }
        }

        for (int i = 0; i < resultList.size();) {
            if (((int[]) resultList.get(i))[0] == 0) {
                resultList.remove(i);
            } else {
                i++;
            }
        }

        if (resultList.size() == 0) {
            int[] temp = new int[2];
            temp[0] = 0;
            temp[1] = 0;
            resultList.add(temp);
        }

        return resultList;
    }
    /**
     * @param poly1 first char
     * @param poly2 second char
     * @return "SinglyLinkedList"
     */
    private SinglyLinkedList testOperation(final char poly1, final char poly2) {

        if (poly1 == 'A' && poly2 == 'A') {
            if (adder) {
                return addTwoPolynomials(a, a);
            } else if (multiplier) {
                return multiplyTwoPolynomials(a, a);
            } else {
                throw new RuntimeException("Fail Test operation");
            }


        } else if ((poly1 == 'A' && poly2 == 'B')
                || (poly1 == 'B' && poly2 == 'A')) {
            if (adder) {
                return addTwoPolynomials(a, b);
            } else if (multiplier) {
                return multiplyTwoPolynomials(a, b);
            } else {
                throw new RuntimeException("Fail Test operation");
            }
        } else if ((poly1 == 'A' && poly2 == 'C')
                || (poly1 == 'C' && poly2 == 'A')) {
            if (adder) {
                return addTwoPolynomials(a, c);
            } else if (multiplier) {
                return multiplyTwoPolynomials(a, c);
            } else {
                throw new RuntimeException("Fail Test operation");
            }
        } else if ((poly1 == 'A' && poly2 == 'R')
                || (poly1 == 'R' && poly2 == 'A')) {
            if (adder) {
                return addTwoPolynomials(a, r);
            } else if (multiplier) {
                return multiplyTwoPolynomials(a, r);
            } else {
                throw new RuntimeException("Fail Test operation");
            }
        } else if (poly1 == 'B' && poly2 == 'B') {
            if (adder) {
                return addTwoPolynomials(b, b);
            } else if (multiplier) {
                return multiplyTwoPolynomials(b, b);
            } else {
                throw new RuntimeException("Fail Test operation");
            }
        } else if ((poly1 == 'B' && poly2 == 'C')
                || (poly1 == 'C' && poly2 == 'B')) {
            if (adder) {
                return addTwoPolynomials(b, c);
            } else if (multiplier) {
                return multiplyTwoPolynomials(b, c);
            } else {
                throw new RuntimeException("Fail Test operation");
            }
        } else if ((poly1 == 'B' && poly2 == 'R')
                || (poly1 == 'R' && poly2 == 'B')) {
            if (adder) {
                return addTwoPolynomials(b, r);
            } else if (multiplier) {
                return multiplyTwoPolynomials(b, r);
            } else {
                throw new RuntimeException("Fail Test operation");
            }
        } else if (poly1 == 'C' && poly2 == 'C') {
            if (adder) {
                return addTwoPolynomials(c, c);
            } else if (multiplier) {
                return multiplyTwoPolynomials(c, c);
            } else {
                throw new RuntimeException("Fail Test operation");
            }
        } else if ((poly1 == 'C' && poly2 == 'R')
                || (poly1 == 'R' && poly2 == 'C')) {
            if (adder) {
                return addTwoPolynomials(c, r);
            } else if (multiplier) {
                return multiplyTwoPolynomials(c, r);
            } else {
                throw new RuntimeException("Fail Test operation");
            }
        } else if (poly1 == 'R' && poly2 == 'R') {
            if (adder) {
                return addTwoPolynomials(r, r);
            } else if (multiplier) {
                return multiplyTwoPolynomials(r, r);
            } else {
                throw new RuntimeException("Fail Test operation");
            }
        } else {
            throw new RuntimeException("error in add ");
        }

    }

    /**
     * @param d first linked list
     * @param e second linked list
     * @return "SinglyLinkedList"
     */
    private SinglyLinkedList multiplyTwoPolynomials(
            final SinglyLinkedList d, final SinglyLinkedList e) {
        if (d == null || e == null || d.isEmpty() || e.isEmpty()) {
            throw new RuntimeException("error add two polynomials");
        }
        SinglyLinkedList resultList = new SinglyLinkedList();
        int[][] temp = new int[d.size() * e.size()][2];
        int counter = 0;
        for (int i = 0; i < d.size(); i++) {
            for (int j = 0; j < e.size(); j++) {
                temp[counter][0] = ((int[]) d.get(i))[0]
                        * ((int[]) e.get(j))[0];
                temp[counter][1] = ((int[]) d.get(i))[1]
                        + ((int[]) e.get(j))[1];
                resultList.add(temp[counter]);
                counter++;
            }
        }

        for (int i = 0; i < resultList.size(); i++) {
            for (int j = i + 1; j < resultList.size(); j++) {
                if (((int[]) resultList.get(i))[1]
                        == ((int[]) resultList.get(j))[1]) {
                    int coeff = ((int[]) resultList.get(i))[0]
                            + ((int[]) resultList.get(j))[0];
                    int[] tempp = new int[2];
                    tempp[0] = coeff;
                    tempp[1] = ((int[]) resultList.get(i))[1];
                    resultList.set(i, tempp);
                    resultList.remove(j);
                }
            }
        }
        for (int i = 0; i < resultList.size();) {
            if (((int[]) resultList.get(i))[0] == 0) {
                resultList.remove(i);
            } else {
                i++;
            }
        }
        if (resultList.size() == 0) {
            int[] tempp = new int[2];
            tempp[0] = 0;
            tempp[1] = 0;
            resultList.add(tempp);
        }
        return resultList;
    }

    /**
     * @param d first linked list
     * @return "SinglyLinkedList"
     */
    private SinglyLinkedList makeMinus(final SinglyLinkedList d) {
        if (d == null || d.isEmpty()) {
            throw new RuntimeException("Error in minus");
        }
        SinglyLinkedList e = new SinglyLinkedList();
        int[][] y = new int[d.size()][2];
        for (int i = 0; i < d.size(); i++) {
            y[i][0] = -1 * ((int[]) d.get(i))[0];
            y[i][1] = ((int[]) d.get(i))[1];
            e.add(i, y[i]);
        }
        return e;

    }
}
