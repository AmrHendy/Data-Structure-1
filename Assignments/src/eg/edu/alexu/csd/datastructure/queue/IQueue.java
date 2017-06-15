package eg.edu.alexu.csd.datastructure.queue;

/**
 * @author Amr Hendy
 *
 */
public interface IQueue {
    /**
    * Inserts an item at the queue front.
    * @param item data required to insert
    */
    public void enqueue(Object item);

    /**
     * Removes the object at the queue rear and returns it..
     * @return "Object"
    */
    public Object dequeue();

    /**
     * Tests if this queue is empty.
     * @return "boolean"
    */
    public boolean isEmpty();

    /**
     * Returns the number of elements in the queue.
     * @return "int"
    */
    public int size();

}
