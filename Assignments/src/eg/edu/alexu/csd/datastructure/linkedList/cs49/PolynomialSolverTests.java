package eg.edu.alexu.csd.datastructure.linkedList.cs49;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
/**
 *
 * @author amrmh_000
 *
 */
public class PolynomialSolverTests {

    /**
     @Test
     */
    public final void testOperationsAndPrint() {
        PolynomialSolver solver = new PolynomialSolver();
        final int  x8 = 8, x9 = 9, x12 = 12, x3 = 3, x7 = 7, x0 = -7,
        x19 = 19, x49 = 49, x21 = 21, x6 = 6, x4 = 4, x5 = 5, x11 = -4;
        int[][] a = new int[][] {{2, x4 }, {x3, x3 }, {x0, 2 }, {x3, 1 } };
        int[][] b = new int[][] {{2, x5 }, {x3, x4 }, {x0, x3 }, {x3, 2 } };
        int[][] c = new int[][] {{0, x4 }, {0, x3 }, {0, 2 }, {0, 1 } };
        solver.setPolynomial('A', a);
        solver.setPolynomial('B', b);
        solver.setPolynomial('C', c);
        int[][] answer1 = new int[][] {{2, x5 }, {x5, x4 }, {x11, x3 },
            {x11, 2 }, {x3, 1 } };
        assertArrayEquals(answer1, solver.add('A', 'B'));
        String printed1 = solver.print('R');
        assertEquals("2x^5+5x^4-4x^3-4x^2+3x", printed1);
        int[][] answer2 = new int[][] {{x4, x9 }, {x12, x8 },
            {-x19, x7 }, {x6 - x21 - x21 + x6, x6 }, {x9 + x49 + x9, x5 },
                {-x21 - x21, x4 }, {x9, x3 } };
        assertArrayEquals(answer2, solver.multiply('A', 'B'));
        String printed2 = solver.print('R');
        assertEquals("4x^9+12x^8-19x^7-30x^6+67x^5-42x^4+9x^3", printed2);
        final int x10 = 10, x2 = -2;
        int[][] answer3 = new int[][] {{x2, x5 }, {-1, x4 }, {x10, x3 },
            {-1 * x10, 2 }, {x3, 1 } };
        assertArrayEquals(answer3, solver.subtract('A', 'B'));
        String printed3 = solver.print('R');
        assertEquals("-2x^5-1x^4+10x^3-10x^2+3x", printed3);
        int[][] answer4 = new int[][] {{2, x5 }, {1, x4 }, {-1 * x10, x3 },
            {x10, 2 }, {x3 * -1, 1 }};
        assertArrayEquals(answer4, solver.subtract('B', 'A'));
        assertArrayEquals(a, solver.subtract('A', 'C'));
        assertArrayEquals(a, solver.add('A', 'C'));
        int[][] answer5 = new int[][] {{0, 0 } };
        assertArrayEquals(answer5, solver.multiply('A', 'C'));
        String printed = solver.print('R');
        assertEquals("0", printed);
    }

    /**
    @Test
    */
    @Test(expected = RuntimeException.class)
    public final void testUnOrdered() {
        PolynomialSolver solver = new PolynomialSolver();
        final int  x8 = 8, x9 = 9, x12 = 12, x3 = 3, x7 = 7, x0 = -7,
                x19 = 19, x49 = 49, x21 = 21, x6 = 6, x4 = 4, x5 = 5, x11 = -4;
        int[][] a = new int[][] {{2, x3 }, {x3, x5 }, {x0, 2 }, {x3, 1 }};
        int[][] c = new int[][] {{0, x4 }, {0, x3 }, {0, 2 }, {0, 1 }};
        solver.setPolynomial('C', c);
        solver.setPolynomial('A', a);
        solver.setPolynomial('D', a);
    }

    /**
    @Test
     */
    @Test(expected = RuntimeException.class)
    public final void testOtherCharsAndPrinted() {
        final int  x8 = 8, x9 = 9, x12 = 12, x3 = 3, x7 = 7, x0 = -7,
                x19 = 19, x49 = 49, x21 = 21, x6 = 6, x4 = 4, x5 = 5, x11 = -4;
        PolynomialSolver solver = new PolynomialSolver();
        int[][] c = new int[][] {{0, x4 }, {0, x3 }, {0, 2 }, {0, 1 } };
        int[][] b = new int[][] {{2, x5 }, {x3, x4 }, {x0, x3 }, {x3, 2 } };
        solver.setPolynomial('C', c);
        solver.setPolynomial('B', b);
        assertEquals("2x^5+3x^4-7x^3+3x^2", solver.print('B'));
        solver.setPolynomial('D', c);
    }

    /**
    @Test
    */
    @Test(expected = RuntimeException.class)
    public final void testEvaluateAndClear() {
        PolynomialSolver solver = new PolynomialSolver();
        final int  x8 = 8, x9 = 9, x12 = 12, x3 = 3, x7 = 7, x0 = -7,
                x19 = 19, x49 = 49, x21 = 21, x6 = 6, x4 = 4, x5 = 5, x11 = -4;
        int[][] a = new int[][] {{1, x4 }, {1, x3 }, {1, 2 }, {1, 1 } };
        int[][] c = new int[][] {{x3, x4 }, {2, x3 }, {1, 2 }, {0, 0 } };
        int[][] b = new int[][] {{2, x5 }, {x3, x4 }, {x0, x3 }, {x3, 2 } };
        solver.setPolynomial('A', a);
        solver.setPolynomial('C', c);
        solver.setPolynomial('B', b);
        final double x00 = 4.0, x01 = 68.0, x02 = 306.0;
        assertEquals(x00, solver.evaluatePolynomial('A', 1), 0);
        assertEquals("2x^5+3x^4-7x^3+3x^2", solver.print('B'));
        assertEquals(x01, solver.evaluatePolynomial('B', 2), 0);
        assertEquals(x02, solver.evaluatePolynomial('C', x3), 0);
        solver.clearPolynomial('A');
        solver.add('A', 'B');
    }

    /**
    @Test
    */
    @Test
    public final void testOperationOnR() {
        PolynomialSolver solver = new PolynomialSolver();
        final int  x8 = 8, x9 = 9, x12 = 12, x3 = 3, x7 = 7, x0 = -7, x2 = 2,
                x19 = 19, x49 = 49, x21 = 21, x6 = 6, x4 = 4, x5 = 5, x11 = -4,
                x100 = 100, x13 = 13, x25 = 25, x16 = 16, x10 = 10, x34 = 34;
        int[][] a = new int[][] {{x12, x100 }, {-1 * x13, x25 }, {x13, x16 },
            {x34, x10 } };
        int[][] c = new int[][] {{x3, x4 }, {2, x3 }, {1, 2 }, {0, 0 } };
        int[][] b = new int[][] {{2, x9 }, {2, x6 }, {-1 * x5, x5 }, {x4, 1 } };
        solver.setPolynomial('A', a);
        solver.setPolynomial('C', c);
        solver.setPolynomial('B', b);
        int[][] answer1 = {{x12, x100 }, {-1 * x13, x25 }, {x13, x16 },
                {x34, x10 }, {-1 * x2, x9 }, {-1 * x2, x6 },
                {x5, x5 }, {-1 * x4, 1 } };

        assertArrayEquals(answer1, solver.subtract('A', 'B'));
        int[][] answer2 = {{0, 0 } };
        assertArrayEquals(answer2, solver.subtract('R', 'R'));
    }

    /**
    @Test
    */
    @Test
    public final void testOperations2Similar() {
        PolynomialSolver solver = new PolynomialSolver();
        final int  x8 = 8, x9 = 9, x12 = 12, x3 = 3, x7 = 7, x0 = -7, x2 = 2,
                x19 = 19, x49 = 49, x21 = 21, x6 = 6, x4 = 4, x5 = 5, x11 = -4,
                x100 = 100, x13 = 13, x25 = 25, x16 = 16, x10 = 10, x34 = 34;
        int[][] b = new int[][] {{x3, x4 }, {x2, x3 }, {1, x2 }, {0, 0 } };
        int[][] c = new int[][] {{x3, x4 }, {x2, x3 }, {1, x2 }, {0, 0 } };
        int[][] a = new int[][] {{x2, x9 }, {x2, x6 },
        {-1 * x5, x5 }, {x4, 1 } };
        solver.setPolynomial('A', a);
        solver.setPolynomial('C', c);
        solver.setPolynomial('B', b);
        int[][] answer1 = {{0, 0 } };
        assertArrayEquals(answer1, solver.subtract('B', 'C'));
        assertEquals("0", solver.print('R'));
    }

}
