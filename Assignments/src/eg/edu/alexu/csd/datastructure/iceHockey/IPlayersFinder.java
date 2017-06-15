package eg.edu.alexu.csd.datastructure.iceHockey;
/**
 *
 * @author amrmh_000
 *
 */
public interface IPlayersFinder {

    /**
     * @param photo string
     * @param team no of team
     * @param threshold area
     * @return "Point"
     */
    java.awt.Point[] findPlayers(String[] photo, int team, int threshold);

}
