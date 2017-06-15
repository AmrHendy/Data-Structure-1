package eg.edu.alexu.csd.datastructure.maze.cs49;

import java.io.File;

public class main {

    public static void main(String[] args) {
        MyMazeSolution test = new MyMazeSolution();
        File file = new File("C:/Users/amrmh_000/Desktop/test.txt");
        int[][] result = test.solveBFS(file);
        for(int i=0; i < result.length; i++){
            for(int j =0 ;j<result[i].length ;j++){
                System.out.print(result[i][j]+ "  ");
            }
            System.out.println("");
        }
    }

}
