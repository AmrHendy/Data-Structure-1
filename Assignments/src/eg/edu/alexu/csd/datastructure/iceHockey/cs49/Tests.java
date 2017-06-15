package eg.edu.alexu.csd.datastructure.iceHockey.cs49;

import static org.junit.Assert.assertArrayEquals;

import java.awt.Point;
/**
 *
 * @author amrmh_000
 *
 */
public class Tests {
    /**
     * test.
     */
    private IceHockey test = new IceHockey();


    /**
     */
    @org.junit.Test
    //Test1
    public final void oneTeam() {
        String[] image = {"12345789", "ABCO8978",
                "OQOP44NB", "POTNSDPQ", "VNDSDUIO", "OINFDDI6" };
        final int x11 = 11, x15 = 15;
        Point[] answer = new Point[] {new Point(x15, x11) };
        final int x = 6;
        final Integer team = x;
        final Integer threashold = 3;
        Point[] result = test.findPlayers(image, team, threashold);
        assertArrayEquals(answer, result);
    }


    /**
     */
    @org.junit.Test
    public final void noPlayers() {
        String[] image = {"12345789", "ABCO8978", "OQOP44NB",
                "POTNSDPQ", "VNDSDUIO", "OINFDDI7" };
        Point[] answer = new Point[] {};
        final Integer team = 6;
        final Integer threashold = 3;
        Point[] result = test.findPlayers(image, team, threashold);
        assertArrayEquals(answer, result);
    }

    /**
     */
    @org.junit.Test
    public final void testSample3() {
        String[] image = {"12345789", "ABCO8978",
                "666644NB", "6OT6SDPQ", "VND6DUIO", "OINFDDI7" };
        Point[] answer = new Point[] {};
        final Integer team = 6;
        final Integer threashold = 30;
        Point[] result = test.findPlayers(image, team, threashold);
        assertArrayEquals(answer, result);
    }

    /**
     */
    @org.junit.Test
    public final void testSample4() {
        String[] image = {"12668689", "AB666678", "66644NB6",
                "6OT666P6", "V666DUI6", "OIN86666" };
        final int x4 = 4, x6 = 6, x7 = 7, x8 = 8, x12 = 12;
        Point[] answer = new Point[] {new Point(x6, x4), new Point(x7, x8),
                new Point(x12, x8) };
        final Integer team = 6;
        final Integer threashold = 4;
        Point[] result = test.findPlayers(image, team, threashold);
        assertArrayEquals(answer, result);
    }

}
