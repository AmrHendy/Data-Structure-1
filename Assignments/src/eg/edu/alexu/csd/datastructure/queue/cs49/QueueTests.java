package eg.edu.alexu.csd.datastructure.queue.cs49;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
/**
 * QueueTests.
 * created on May 16, 2016
 * @author Amr Hedny
 *
 */

public class QueueTests {
    /**
     * QueueLinkedBased.
     * test many enqueues and dequeues.
     */
    @Test
    public void test1() {
        MyQueueLinkedBased testQueue = new MyQueueLinkedBased();
        testQueue.enqueue("amr");
        testQueue.enqueue("23");
        final int y = 9, x = 2;
        assertEquals(x, testQueue.size());
        assertEquals("amr", testQueue.dequeue());
        assertEquals("23", testQueue.dequeue());
        testQueue.enqueue(y);
        assertEquals(y, testQueue.dequeue());
        final int z = 0;
        assertEquals(z, testQueue.size());
        assertTrue(testQueue.isEmpty());
    }
    /**
     * QueueLinkedBased.
     * test empty queue and throw exception.
     */
    @Test(expected = RuntimeException.class)
    public void test2() {
        MyQueueLinkedBased testQueue = new MyQueueLinkedBased();
        testQueue.enqueue(null);
        assertEquals(null, testQueue.dequeue());
        assertEquals(0, testQueue.size());
        assertTrue(testQueue.isEmpty());
        testQueue.dequeue();
    }

    /**
     * QueueArrayBased.
     * test many enqueues and dequeues.
     */
    @Test(expected = RuntimeException.class)
    public void test3() {
        final int size = 4;
        MyQueueArrayBased testQueue = new MyQueueArrayBased(size);
        testQueue.enqueue("amr");
        testQueue.enqueue("23");
        final int y = 9, x = 2;
        assertEquals(x, testQueue.size());
        assertEquals("amr", testQueue.dequeue());
        assertEquals("23", testQueue.dequeue());
        testQueue.enqueue(y);
        assertEquals(y, testQueue.dequeue());
        final int z = 0;
        assertEquals(z, testQueue.size());
        assertTrue(testQueue.isEmpty());
        testQueue.enqueue("1");
        testQueue.enqueue("2");
        testQueue.enqueue("3");
        testQueue.enqueue("4");
        testQueue.enqueue("5");
        // throw QueueFullException
    }
    /**
     * QueueArrayBased.
     * test empty queue and throw exception.
     */
    @Test(expected = RuntimeException.class)
    public void test4() {
        final int size = 2;
        MyQueueArrayBased testQueue = new MyQueueArrayBased(size);
        testQueue.enqueue(null);
        assertEquals(null, testQueue.dequeue());
        assertEquals(0, testQueue.size());
        assertTrue(testQueue.isEmpty());
        testQueue.dequeue();
    }

    /**
     * QueueArrayBased.
     * test QueueArrayBased with size = 0.
     */
    @Test(expected = RuntimeException.class)
    public void test5() {
        MyQueueArrayBased testQueue = new MyQueueArrayBased(0);
        testQueue.enqueue(null);
        assertEquals(0, testQueue.size());
        assertTrue(testQueue.isEmpty());
        testQueue.dequeue();
    }

}
