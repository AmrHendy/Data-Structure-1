package eg.edu.alexu.csd.datastructure.queue.cs49;

import eg.edu.alexu.csd.datastructure.queue.IArrayBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

/**
 * @author Amr Hendy
 *
 */
public class MyQueueArrayBased implements IQueue, IArrayBased {

    /**
     * @param number fixed size of array.
     */
    public MyQueueArrayBased(final int number) {
        n = number;
        queue = new Object[n];
    }
    /**
     * n fixed size of array.
     */
    private int n;
    /**
     * queue array of nodes.
     */
    private Object[] queue;
    /**
     * n fixed size of array.
     */
    /**
     * f index of front element.
     * r index of last element.
     */
    private int f = -1, r = -1;
    /**
     * size real size of array.
     */
    private int size = 0;

    @Override
    public void enqueue(final Object item) {
        if (size == n) {
            throw new RuntimeException("Queue is full");

        } else {
            if (r + 1 == n) {
                r = 0;

            } else {
                r++;
            }
            queue[r] = item;
            size++;
        }
    }

    @Override
    public Object dequeue() {
        if (size == 0) {
            throw new RuntimeException("Empty Queue");
        } else {
            if (f + 1 == n) {
                f = 0;
            } else {
                f++;
            }
            Object temp = queue[f];
            queue[f] = null;
            size--;
            return temp;
        }
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return size == 0;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return size;
    }

}
