package eg.edu.alexu.csd.datastructure.linkedList.cs49;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

/** * Double. */
public class DoublyLinkedList implements ILinkedList {
    /** * Len. */
    private int len = 0;
    /** * head. */
    private Node head = new Node(null, null, null);

    /** * Node .*/
    private class Node {

        /** * data .*/
        private Object data;
        /** * next .*/
        private Node next;
        /** * prev .*/
        private Node prev;

        /**
         * @param data1 value
         * @param next1 pointer to next
         * @param prev1 poniter to prev node
         */
        Node(final Object data1, final Node next1, final Node prev1) {
            data = data1;
            next = next1;
            prev = prev1;
        }
    }

    /**
     *@param index where we want to add
     *@param element value
     */
    public final void add(final int index, final Object element) {
        if (index > len + 1 || index < 0) {
            throw new RuntimeException("add function");
        } else {

            Node link = new Node(null, head, null);
            int counter = 0;
            if (index != 0 && head.next == null) {
                throw new RuntimeException("add function");
            }
            if (index == 0 && head.next == null) {
                head.next = link;
                link.data = element;
                link.next = null;
                link.prev = head;
                len++;
            } else {
                while (counter <= index) {
                    counter++;
                    link = link.next;
                }
                if (counter > index && head.next != null) {
                    Node temp = new Node(element, link.next, link);
                    link.next = temp;
                    len++;
                }

            }
        }

    }


    /**
     * @param element value
     */
    public final void add(final Object element) {
        int length = size(); // It's the length of the list
        int index = 0; // It's the counter to reach the tail
        Node link = new Node(null, head, null);
        while (index <= length) {
            link = link.next;
            index++;
        }
        Node temp = new Node(element, null, link);
        link.next = temp;
        len++;
    }

    /**
     * @param index where we want to add
     * @return "Object"
     */
    public final Object get(final int index) {
        if (len == 0 || index < 0 || index > len) {
            // empty
            throw new RuntimeException("get function"); // or the index is
        } else { // or the index is negative

            Object getter;
            int counter = -1;
            Node link = new Node(null, head, null);
            while (counter < index) { // There's no need to check if the next is
                                        // null
                (link.next).prev = link;
                link = link.next; // because it's checked at first that the
                                    // index is less
                counter++; // than the length
            }
            getter = (link.next).data;
            return getter;
        }
    }

    /**
     * @param index where we want to add
     * @param element value
     */
    public final void set(final int index, final Object element) {
        if (head.next == null || index < 0 || index >= len) {
            throw new RuntimeException("set function");
        } else {
            int counter = -1; // It's initializes with -1 because the index
            Node link = new Node(null, head, null); // is initialized with 0
            while (counter < index) { // With that loop all it does is reaching
                                        // the required
                counter++; // index
                (link.next).prev = link;
                link = link.next;
            }
            (link.next).data = element;
        }
    }
        /** * clear .*/
    public final void clear() {
        len = 0;
        head.next = null;
    }

    /** * @return . */
    public final boolean isEmpty() {

        return size() == 0;
    }

    /**
     * @param index where we want to add
     */
    public final void remove(final int index) {
        if (head.next == null || index < 0 || index >= len) {
            throw new RuntimeException("remove function");
        } else {
            Node link = new Node(null, head, null);
            int counter = 0;
            while (counter <= index) {
                (link.next).prev = link;
                link = link.next;
                counter++;
            }
            if ((link.next) != null) {
                link.next = (link.next).next;
            }

            if (link.next != null) {
                (link.next).prev = link;
            }
            len--;
        }
    }

    /**
     * @return "int"
     */
    public final int size() {

        return len;
    }

    /**
     * @param fromIndex first index
     * @param toIndex last index
     * @return "ILinkedList"
     */
    public final ILinkedList sublist(final int fromIndex, final int toIndex) {

        if (len == 0 || fromIndex < 0 || fromIndex > len
                || toIndex < 0 || toIndex > len || fromIndex > toIndex) {
            throw new RuntimeException("sublist error");
        } else {
            SinglyLinkedList sub = new SinglyLinkedList();
            int counter = fromIndex;
            while (counter <= toIndex) {
                sub.add(counter - fromIndex, get(counter));
                counter++;
            }
            return sub;
        }
    }

    /**
     * @param o value
     * @return "boolean"
     */
    public final boolean contains(final Object o) {

        if (len == 0) {
            return false;
        } else {
            Node link = new Node(null, head.next, null);
            while (link.next != null) { // Checking till the end of the list
                if ((link.next).data.equals(o)) {
                    // whichever comes first
                    return true;
                }

                (link.next).prev = link;
                link = link.next;
            }
            return false;
        }
    }
}
