package eg.edu.alexu.csd.datastructure.iceHockey.cs49;

import java.awt.Point;
import java.util.Arrays;
import java.util.Comparator;

import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;
/**
 *
 * @author amrmh_000
 *
 */
public class IceHockey implements IPlayersFinder {

    /**
     * image string.
     */
    String[] image;
    /**
     * result answer.
     */
    Point[] result = new Point[] {};
    /**
     * resultt.
     */
    Point[] resultt = new Point[] {};
    /**
     * center.
     */
    Point[] center;
    /**
     * result answer.
     */
    boolean[][] visited;
    /**
     *newPhoto.
     */
    int[][] newPhoto;
    /**
     * x0.
     */
    final int x0 = 0, x1 = 1, x2 = 2, x4 = 4;
    /**
     * noOfteam.
     */
    int noOfTeam = x0;
    /**
     * noOfPlayersinTeam.
     */
    int noOfPlayersinTeam;
    /**
     * forAllTeams.
     */
    Point[][] forAllTeams;
    /**
     * x.
     */
    int x, y, z = x0, counter = x0;

    /**
     *
     * @author amrmh_000
     *
     */
    class PointsComparator implements Comparator<Point> {

        @Override
        public int compare(final Point o1, final Point o2) {
            if (o1.x == o2.x) {
                return o1.y - o2.y;
            }

            return o1.x - o2.x;
        }
    }

    /**
     * @param photo string
     * @param team no of team
     * @param threshold area
     * @return "Point"
     */
    public final Point[] findPlayers(final String[] photo,
            final int team, final int threshold) {

        if ((photo == null)) {
            return null;
        }
        if (photo.length == x0) {
            result = new Point[] {};
            return result;
        }
        image = new String[photo.length];
        System.arraycopy(photo, x0, image, x0, photo.length);
        if (!isTeamValid(image, team)) {
            result = new Point[] {};
            return result;
        } else {
            visited = new boolean[photo.length][photo[x0].length()];
            newPhoto = new int[photo.length][photo[x0].length()];
            center = new Point[(photo.length) * (photo[x0].length())];
            setPhotoinArrayOfintWithoutChar(image, team);
            markVisitedPlayers(newPhoto, team);
            forAllTeams = new Point[(photo.length)
             * (photo[x0].length())][(photo.length) * (photo[x0].length())];

            for (int row = x0; row < visited.length; row++) {
                for (int coulmn = x0; coulmn < visited[row].length; coulmn++) {
                    if (!visited[row][coulmn]) {
                        noOfTeam++;
                        noOfPlayersinTeam = x1;
                        z = x0;
                        Point temp = new Point(x2 * coulmn, x2 * row);
                        forAllTeams[noOfTeam - x1][z] = temp;
                        // .setLocation(2*coulmn, 2*row);
                        z++;
                        calculateNoOfTeams(row, coulmn);
                        if (noOfPlayersinTeam * x4 >= threshold) {
                            center[counter] = findCenter();
                            counter++;
                        }
                    }
                }
            }
            int temp = x0;
            resultt = new Point[counter];
            for (int index = x0; index < counter; index++) {
                if (center[index] != null) {
                    resultt[temp] = center[index];
                    temp++;
                }
            }
            result = new Point[temp];
            for (int index = x0; index < temp; index++) {
                result[index] = resultt[index];
            }
            if (result.length != x0) {
                Arrays.sort(result, new PointsComparator());
                // sortArray ();
            }
        }
        return result;
    }

    /**
     * @param teamPhoto string photo
     * @param teamNumber no of team
     * @return "boolean"
     */
    private boolean isTeamValid(final String[] teamPhoto,
            final int teamNumber) {
        int index;
        boolean found = false;
        char teamName = (char) ('0' + teamNumber);
        for (index = x0; index < teamPhoto.length; index++) {
            for (int indexOfCharinString = x0; indexOfCharinString
                < teamPhoto[index].length(); indexOfCharinString++) {
                if (teamPhoto[index].toCharArray()[indexOfCharinString]
                        == teamName) {
                    found = true;
                }
            }
        }
        if (!found) {
            return false;
        }
        return true;
    }

    /**
     * @param teamPhoto string
     * @param teamNumber no of team
     * @return "int"
     */
    private int[][] setPhotoinArrayOfintWithoutChar(
      final String[] teamPhoto, final int teamNumber) {
        char teamName = (char) ('0' + teamNumber);
        for (int index = x0; index < teamPhoto.length; index++) {
            for (int indexOfCharinString = x0; indexOfCharinString
                    < teamPhoto[index].length(); indexOfCharinString++) {
                if (teamPhoto[index].toCharArray()[indexOfCharinString]
                        == teamName) {
                    newPhoto[index][indexOfCharinString] = teamNumber;
                } else {
                    final int x11 = 11;
                    newPhoto[index][indexOfCharinString] = x11;
                }
            }
        }
        return newPhoto;
    }

    /**
     * @param intTeamPhoto int photo
     * @param teamNumber no of team
     * @return "boolean"
     */
    private boolean[][] markVisitedPlayers(
            final int[][] intTeamPhoto, final int teamNumber) {
        for (int row1 = x0; row1
               < intTeamPhoto.length; row1++) {
            for (int coulmn1 = x0; coulmn1
                    < intTeamPhoto[row1].length; coulmn1++) {
                if (intTeamPhoto[row1][coulmn1] == teamNumber) {
                    visited[row1][coulmn1] = false;
                } else {
                    visited[row1][coulmn1] = true;
                }
            }
        }
        return visited;
    }

    /**
     * @param row row
     * @param coulmn coulmn
     */
    private void calculateNoOfTeams(final int row, final int coulmn) {
        if ((coulmn < newPhoto[0].length - x1) && (coulmn >= x0)) {
            visited[row][coulmn] = true;
            if (!(visited[row][coulmn + x1])
               && (coulmn + x1 < newPhoto[x0].length)) {
                noOfPlayersinTeam++;
                Point temp = new Point(x2 * (coulmn + x1), x2 * row);
                forAllTeams[noOfTeam - x1][z] = temp;
                z++;
                calculateNoOfTeams(row, coulmn + x1);
            }
        }
        if ((row < newPhoto.length - x1) && (row >= x0)) {
            visited[row][coulmn] = true;
            if (!visited[row + x1][coulmn]) {
                noOfPlayersinTeam++;
                Point temp = new Point(x2 * coulmn, x2 * (row + x1));
                forAllTeams[noOfTeam - x1][z] = temp;
                z++;
                calculateNoOfTeams(row + 1, coulmn);
            }
        }
        if ((coulmn < newPhoto[x0].length) && (coulmn >= x1)) {
            visited[row][coulmn] = true;
            if (!visited[row][coulmn - x1]) {
                noOfPlayersinTeam++;
                Point temp = new Point(x2 * (coulmn - x1), x2 * row);
                forAllTeams[noOfTeam - x1][z] = temp;
                z++;
                calculateNoOfTeams(row, coulmn - 1);
            }
        }
        if ((row < newPhoto.length) && (row >= x1)) {
            visited[row][coulmn] = true;
            if (!visited[row - x1][coulmn]) {
                noOfPlayersinTeam++;
                Point temp = new Point(x2 * coulmn, x2 * (row - x1));
                forAllTeams[noOfTeam - x1][z] = temp;
                z++;
                calculateNoOfTeams(row - x1, coulmn);
            }
        }
        return;
    }

    /**
     * @return "Point"
     */
    private Point findCenter() {
        final int x12 = 100000, y12 = -1, y13 = 100000;
        int xMax = y12, yMax = y12, xMin = y13, yMin = y13;
        for (int i = 0; i < noOfPlayersinTeam; i++) {

            if (forAllTeams[noOfTeam - 1][i].x > xMax) {
                xMax = forAllTeams[noOfTeam - 1][i].x;
            }

            if (forAllTeams[noOfTeam - 1][i].x < xMin) {
                xMin = forAllTeams[noOfTeam - 1][i].x;
            }

            if (forAllTeams[noOfTeam - 1][i].y > yMax) {
                yMax = forAllTeams[noOfTeam - 1][i].y;
            }

            if (forAllTeams[noOfTeam - 1][i].y < yMin) {
                yMin = forAllTeams[noOfTeam - 1][i].y;
            }
        }

//        Point center = new Point((xMax + xMin + x2)
//                / x2, ((yMax + yMin + x2) / x2));
//        return center;
        return new Point((xMax + xMin + x2)
              / x2, ((yMax + yMin + x2) / x2));
    }

    // private void sortArray (){
    // if((result == null )||(result.length==0))
    // return ;
    //
    // for(int index=0 ; index < result.length ;index++){
    // int xMin = result[index].x ;
    // int minIndex = index ;
    // for(int i= index+1 ;i< result.length;i++){
    // if(xMin>result[i].x){
    // xMin = result[i].x ;
    // minIndex = i ;
    // }
    // }
    //
    // Point temp = new Point() ;
    // temp = result[minIndex] ;
    // result[minIndex] = result[index] ;
    // result[index]= temp ;
    // }
    //
    // for(int index=0;index< result.length ;index++){
    // for(int i= index+1 ;i< result.length;i++){
    // if(result[index].x == result[i].x){
    // if(result[index].y <= result[i].y)
    // continue ;
    //
    // else{
    //
    // Point temp = new Point() ;
    // temp = result[index] ;
    // result[index] = result[i] ;
    // result[i]= temp ;
    // }
    // }
    // }
    // }
    // }

}
