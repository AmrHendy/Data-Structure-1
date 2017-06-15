package eg.edu.alexu.csd.datastructure.queue.cs49;

import eg.edu.alexu.csd.datastructure.queue.ILinkedBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

/**
 * @author Amr Hendy
 *
 */

public class MyQueueLinkedBased implements ILinkedBased, IQueue {
    /**
     * pointer to tail.
     */
    private Node tail;
    /**
     * pointer to head node.
     */
    private Node head;
    /**
     * size of list.
     */
    private int size = 0;
    /**
     * Constructor.
     */
    public MyQueueLinkedBased() {
        tail = null;
        head = null;
    }
    /**
     * Class Constructor.
     */
    public class Node {
        /**
         * data value of any node.
         */
        private Object data;
        /**
         * next pointer of any node to next of it.
         */
        private Node next;

        /**
         * Constructor of node.
         * @param value data of node
         */
        public Node(final Object value) {
            data = value;
        }
    }

    @Override
    public void enqueue(final Object item) {
        // TODO Auto-generated method stub
        Node newTemp = new Node(item);
        if (head == null) {
            head = newTemp;
            tail = newTemp;
            size++;
        } else {
            tail.next = newTemp;
            tail = newTemp;
            size++;
        }
    }

    @Override
    public Object dequeue() {
        // TODO Auto-generated method stub
        if (head == null) {
            throw new RuntimeException("Empty Queue");

        } else {
            Node temp = head.next;
            Object tempData = head.data;
            // to make sure garbadge collector will remove this node
            head.next = null;
            head = temp;
            size--;
            return tempData;
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
