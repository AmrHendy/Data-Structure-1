package eg.edu.alexu.csd.datastructure.stack;
/**
 * IStack.
 * created on April 20, 2016
 * @author Amr Hedny
 *
 */
public interface IStack {

    /**
     * @param index where we want to add
     * @param element which we want to add
     */
    public void add(int index, Object element);

    /**
     * @return "Object" that you want to remove
     */
    public Object pop();

    /**
     * @return "Object" at the top
     */
    public Object peek();

    /**
     * @param element that we want to push
     */
    public void push(Object element);

    /**
     * @return "boolean" tells you if this stack is empty or not
     */
    public boolean isEmpty();

    /**
     * @return "int" represents the size of stack
     */
    public int size();
}
