package eg.edu.alexu.csd.datastructure.linkedList.cs49;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
/** * class. */
public class DoublyLinkedListTests {

    /** * test1. */
    @Test(expected = RuntimeException.class)
    public final void caseSensitivity() {
        DoublyLinkedList test1 = new DoublyLinkedList();
        final int x61 = 61;
        test1.add(x61);
        test1.add(0, "Deif");
        test1.add(0, "Mohamed");
        // Mohamed,Deif,61
        assertFalse(test1.contains("MOhamed"));
        assertEquals(x61, test1.get(2));
        test1.remove(2);
        // Mohamed,Deif
        assertEquals("Deif", test1.get(1));
        test1.clear();
        // Empty
        assertTrue(test1.isEmpty());
        test1.add("Amr cs49");
        test1.add(0, "StudEnt");
        // StudEnt,Amr cs49
        assertFalse(test1.contains("Amrcs49"));
        assertFalse(test1.contains("stdent"));
        test1.set(0, "student");
        assertEquals("student", test1.get(0));
        final int x9 = 9;
        test1.remove(x9);
    }

    /** * test2. */
    @Test
    public final void nullSettingGetting() {
        DoublyLinkedList test2 = new DoublyLinkedList();
        final int x3 = 3, x5 = 5, x6 = 6;
        test2.add(x5);
        test2.add(x6);
        test2.add(null);
        // 5,6,null
        assertEquals(null, test2.get(2));
        test2.add("CSED");
        // 5,6,null,CSED
        assertEquals("CSED", test2.get(x3));
        test2.set(0, "student");
        assertEquals("student", test2.get(0));
    }

    /** * test3. */
    @Test
    public final void emptiness() {
        DoublyLinkedList test3 = new DoublyLinkedList();
        DoublyLinkedList subList = new DoublyLinkedList();
        final int x9 = 9, x10 = 10, x15 = 15, x6 = 6, x3 = 3;
        test3.add(x9);
        test3.add(x10);
        test3.add(x15);
        test3.clear();
        assertTrue(test3.isEmpty());
        assertFalse(test3.contains(x10));
        test3.add(1);
        test3.add(0, x6);
        test3.add(x6);
        test3.add(1, null);
        test3.add(2, x3);
        // 6,null,3,1,6
        subList.add(null);
        subList.add(x3);
        subList.add(1);
        // null,3,1
        assertEquals(null, subList.get(0));
        assertEquals(x3, subList.get(1));
        assertEquals(1, subList.get(2));
        assertEquals(subList.size(), (test3.sublist(1, x3)).size());
        assertEquals(subList.get(0), test3.get(1));
        assertEquals(subList.get(1), test3.get(2));
        assertEquals(subList.get(2), test3.get(x3));
    }

    /** * test4. */
    @Test(expected = RuntimeException.class)
    public final void wrongAccessing1() {
        DoublyLinkedList test4 = new DoublyLinkedList();
        test4.clear();
        test4.get(0);
    }

    /** * test5. */
    @Test
    public final void containChecking() {
        DoublyLinkedList test5 = new DoublyLinkedList();
        final int x15 = 15, x17 = 17, x12 = 12, x6 = 6, x10 = 10;
        test5.add(x15);
        test5.add(0, x17);
        test5.add(2, x12);
        assertFalse(test5.contains(x6));
        assertTrue(test5.contains(x15));
        test5.set(2, x10);
        assertEquals(x10, test5.get(2));
    }

    /** * test6. */
    @Test(expected = RuntimeException.class)
    public final void wrongAccessing2() {
        DoublyLinkedList test6 = new DoublyLinkedList();
        test6.clear();
        final int x3 = 3;
        test6.add(x3, "123");
    }

}
