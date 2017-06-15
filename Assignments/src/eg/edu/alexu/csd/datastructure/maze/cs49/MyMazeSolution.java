package eg.edu.alexu.csd.datastructure.maze.cs49;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import eg.edu.alexu.csd.datastructure.maze.IMazeSolver;
import eg.edu.alexu.csd.datastructure.queue.cs49.MyQueueLinkedBased;
import eg.edu.alexu.csd.datastructure.stack.cs49.MyStack;

/**
 * @author Amr Hendy
 *
 */
public class MyMazeSolution implements IMazeSolver {
    /**
     * @author Amr Hedny
     *
     */
    public class Amr {
        /**
         * row1 first int.
         */
        private int row1 = -1;
        /**
         * coulmn1 second int.
         */
        private int coulmn1 = -1;
        /**
         * @param i first int.
         * @param j second int.
         */
        public Amr(final int i, final int j) {
            row1 = i;
            coulmn1 = j;
        }
        /**
         * constructor.
         */
        public Amr() {
        }
    }
    /**
     * Amr object to containg two int.
     */
    private Amr node = new Amr();
    /**
     * path solution of maze.
     */
    private MyQueueLinkedBased orderedPath = new MyQueueLinkedBased();
    /**
     * path solution of maze.
     */

    private MyStack correctPath = new MyStack();
    /**
     * path solution of maze.
     */

    private MyStack path = new MyStack();
    /**
     * found boolean point to fine end of maze.
     */
    private boolean found = false;
    /**
     * n no of rows.
     * m no of coulmns.
     */
    private int n = 0, m = 0;
    /**
     * input chars represent the maze.
     */
    private char[][]input = null;
    /**
     * visisted to mark visited cells.
     */
    private boolean[][] visited;
    /**
     * startRow index of row of start.
     * startCoulmn index of coulmn of start.
     */
    private int startRow = -1, startCoulmn = -1;
    @Override
    public int[][] solveBFS(final File maze) {
        findMaze1(maze);
        findBFSPath(startRow, startCoulmn);
        if (!found) {
            return null;
        }
        int size2 = correctPath.size();
        for (int i = size2; i > 0; i--) {
            correctPath.pop();
        }

        int size = path.size();

        for (int i = size; i > 0; i--) {
            if (i == size) {
                correctPath.push(path.pop());
            } else {
                int[] currentPoint = (int[]) path.pop();
                int x = currentPoint[0];
                int y = currentPoint[1];
                int[] nextPoint = (int[]) correctPath.peek();
                int z = nextPoint[0];
                int k = nextPoint[1];
                if (((x == z - 1 || x == z + 1) && k == y)
                        || ((y == k - 1 || y == k + 1) && z == x)) {
                    correctPath.push(currentPoint);
                }
            }
        }
        int[][] result = new int[correctPath.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = (int[]) correctPath.pop();
        }
        return result;
    }

    @Override
    public int[][] solveDFS(final File maze) {
        findMaze2(maze);
        findDFSPath(startRow, startCoulmn);
        if (!found) {
            return null;
        }
        // clear stack correcct path
        int size2 = correctPath.size();
        for (int i = size2; i > 0; i--) {
            correctPath.pop();
        }
        int size = path.size();
        for (int i = size; i > 0; i--) {
            correctPath.push(path.pop());
        }
        for (int i = size; i > 0; i--) {
            if (i == 1) {
                orderedPath.enqueue(correctPath.pop());
            } else {
                int[] currentPoint = (int[]) correctPath.pop();
                int x = currentPoint[0];
                int y = currentPoint[1];
                int[] nextPoint = (int[]) correctPath.peek();
                int z = nextPoint[0];
                int k = nextPoint[1];
                correctPath.push(currentPoint);
                if (((x == z - 1 || x == z + 1) && k == y)
                        || ((y == k - 1 || y == k + 1) && z == x)) {
                    orderedPath.enqueue(correctPath.pop());
                } else {
                    correctPath.pop();
                }

            }
        }
        int[][] result = new int[orderedPath.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = (int[]) orderedPath.dequeue();
        }
        return result;
    }

    /**
     * @param maze1 file of maze.
     */
    private void findMaze1(final File maze1) {
        try {
            FileReader fileReader = new FileReader(maze1);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            int numberOfLine = 0;
            int numberOfCharsAtLine = 0;
            int start = 0;
            int end = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if (numberOfLine == 0) {
                    line = line.replaceAll("\\s+", " ").trim();
                    if (line.split(" ").length != 2) {
                       throw new RuntimeException("invalid input");
                    } else {
                        try {
                            n = Integer.parseInt(line.split(" ")[0]);
                            m = Integer.parseInt(line.split(" ")[1]);
                            input = new char[n][m];
                            visited = new boolean[n][m];
                        } catch (Exception e) {
                            throw new RuntimeException("wrong n or m");
                        }
                    }
                } else {
                    line = line.replaceAll("\\s+", "").trim();
                    if (line.length() != m) {
                        throw new RuntimeException(
                                "numberOfCharsAtLine is invalid");
                    } else {
                        for (int i = 0; i < line.length(); i++) {
                            if (line.charAt(i) == 'S') {
                                input[numberOfLine - 1][i] = line.charAt(i);
                                startRow = numberOfLine - 1;
                                startCoulmn = i;
                                start++;

                            } else if (line.charAt(i) == 'E') {
                                input[numberOfLine - 1][i] = line.charAt(i);
                                end++;

                            } else if (line.charAt(i) == '#') {
                                input[numberOfLine - 1][i] = line.charAt(i);
                                visited[numberOfLine - 1][i] = true;
                            } else if (line.charAt(i) == '.') {
                                input[numberOfLine - 1][i] = line.charAt(i);
                            } else {
                                throw new RuntimeException(
                                   "invalid chars not . or # ");
                            }
                        }
                    }
                }
                numberOfLine++;
            }
            if (numberOfLine != n + 1 || start != 1 || end == 0) {
                throw new RuntimeException(
                        "numberOfLine is invalid or start or end");
            }
        } catch (IOException ex) {
            throw new RuntimeException("file not found");
        }
    }

    /**
     * @param maze2 file of maze.
     */
    private void findMaze2(final File maze2) {
        try {
            FileReader fileReader = new FileReader(maze2);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            int numberOfLine = 0;
            int numberOfCharsAtLine = 0;
            int start = 0;
            int end = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if (numberOfLine == 0) {
                    line = line.replaceAll("\\s+", " ").trim();
                    if (line.split(" ").length != 2) {
                       throw new RuntimeException("invalid input");
                    } else {
                        try {
                            n = Integer.parseInt(line.split(" ")[0]);
                            m = Integer.parseInt(line.split(" ")[1]);
                            input = new char[n][m];
                            visited = new boolean[n][m];
                        } catch (Exception e) {
                            throw new RuntimeException("wrong n or m");
                        }
                    }
                } else {
                    line = line.replaceAll("\\s+", "").trim();
                    if (line.length() != m) {
                        throw new RuntimeException(
                                "numberOfCharsAtLine is invalid");
                    } else {
                        for (int i = 0; i < line.length(); i++) {
                            if (line.charAt(i) == 'S') {
                                input[numberOfLine - 1][i] = line.charAt(i);
                                startRow = numberOfLine - 1;
                                startCoulmn = i;
                                start++;

                            } else if (line.charAt(i) == 'E') {
                                input[numberOfLine - 1][i] = line.charAt(i);
                                end++;

                            } else if (line.charAt(i) == '#') {
                                input[numberOfLine - 1][i] = line.charAt(i);
                                visited[numberOfLine - 1][i] = true;
                            } else if (line.charAt(i) == '.') {
                                input[numberOfLine - 1][i] = line.charAt(i);
                            } else {
                                throw new RuntimeException(
                                   "invalid chars not . or # ");
                            }
                        }
                    }
                }
                numberOfLine++;
            }
            if (numberOfLine != n + 1 || start != 1 || end == 0) {
                throw new RuntimeException(
                        "numberOfLine is invalid or start or end");
            }
        } catch (IOException ex) {
            throw new RuntimeException("file not found");
        }
    }
    /**
     * @param row index of row.
     * @param coulmn index of coulmn.
     */
    private void findDFSPath(final int row, final int coulmn) {
        if (row < 0 || row >= n || coulmn < 0 || coulmn >= m) {
            return;

        } else if (input[row][coulmn] == 'E' || found
                || visited[row][coulmn]) {
            if (input[row][coulmn] == 'E') {
                int[] a = new int[2];
                a[0] = row;
                a[1] = coulmn;
                path.push(a);
                found = true;
            }
            return;
        }
        visited[row][coulmn] = true;
        int[] a = new int[2];
        a[0] = row;
        a[1] = coulmn;
        path.push(a);
        findDFSPath(row - 1, coulmn);
        findDFSPath(row, coulmn + 1);
        findDFSPath(row + 1, coulmn);
        findDFSPath(row, coulmn - 1);
     }

    /**
     * @param row index of row.
     * @param coulmn index of coulmn.
     */
    private void findBFSPath(final int row, final int coulmn) {
        found = false;
        int[] a = {row, coulmn};
        visited[row][coulmn] = true;
        orderedPath.enqueue(a);
        while (!orderedPath.isEmpty()) {
            int[] currentCell = (int[]) orderedPath.dequeue();
            path.push(currentCell);
            int x = currentCell[0];
            int y = currentCell[1];
            if (input[x][y] == 'E') {
                found = true;
                return;
            } else {
                if (x - 1 >= 0 && y >= 0 && y < m && !visited[x - 1][y]) {
                    visited[x - 1][y] = true;
                    int[] b = {x - 1, y};
                    orderedPath.enqueue(b);
                }
                if (y + 1 < m && x >= 0 && x < n && !visited[x][y + 1]) {
                    visited[x][y + 1] = true;
                    int[] b = {x, y + 1};
                    orderedPath.enqueue(b);
                }
                if (x + 1 < n && y >= 0 && y < m && !visited[x + 1][y]) {
                    visited[x + 1][y] = true;
                    int[] b = {x + 1, y};
                    orderedPath.enqueue(b);
                }
                if (y - 1 >= 0 && x >= 0 && x < n && !visited[x][y - 1]) {
                    visited[x][y - 1] = true;
                    int[] b = {x, y - 1};
                    orderedPath.enqueue(b);
                }
            }
        }
        found = false;
    }
}
