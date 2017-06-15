package eg.edu.alexu.csd.datastructure.linkedList;
/**
 *
 * @author amrmh_000
 *
 */
public interface ILinkedList {

    /**
     * @param index position
     * @param element value
     */
    void add(int index, Object element);

    /**
     * @param element value
     */
    void add(Object element);

    /**
     * @param index position
     *@return "Object"
     */
    Object get(int index);

    /**
     * @param index position
     * @param element value
     */
    void set(int index, Object element);

    /**
     */
    void clear();

    /**
     *@return "boolean"
     */
    boolean isEmpty();

    /**
     * @param index position
     */
    void remove(int index);

    /**
     * @return "int"
     */
    int size();

    /**
     * @param fromIndex first index
     * @param toIndex last index
     * @return "ILinkedList"
     */
    ILinkedList sublist(int fromIndex, int toIndex);

    /**
     * @param o value
     * @return "boolean"
     */
    boolean contains(Object o);

}
