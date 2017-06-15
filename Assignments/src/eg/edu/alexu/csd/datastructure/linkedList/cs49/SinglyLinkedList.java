package eg.edu.alexu.csd.datastructure.linkedList.cs49;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
/** class single. */
public class SinglyLinkedList implements ILinkedList {
    /** len. */
    private int len = 0;
    /** head. */
    private Node head = new Node(null, null);
    /** node. */
    private class Node {
        /** data. */
        public Object data;

        /** next. */
        public Node next;

        /**
         * @param data1 which we want to add
         * @param next1 which is pointer to next
         */
        public Node(final Object data1, final Node next1) {
            data = data1;
            next = next1;
        }
    }

    /**
     * @param index which was index we want to add in
     * @param element that we want to add
     */
    public final void add(final int index, final Object element) {
        if (index > len + 1 || index < 0) {
            throw new RuntimeException("add function");
        } else {

            Node link = new Node(null, head);
            int counter = 0;
            if (index != 0 && head.next == null) {
                throw new RuntimeException("add function");
            }
            if (index == 0 && head.next == null) {
                head.next = link;
                link.data = element;
                link.next = null;
                len++;
            } else {
                while (counter <= index) {
                    counter++;
                    link = link.next;
                }
                if (counter > index && head.next != null) {
                    Node temp = new Node(element, link.next);
                    link.next = temp;
                    len++;
                }

            }
        }

    }


    /**
     * @param element which we want to add
     */
    public final void add(final Object element) {

        int length = size(); // It's the length of the list
        int index = 0; // It's the counter to reach the tail
        Node link = new Node(null, head);
        while (index <= length) {
            if (link.next != null) {
                link = link.next;
            }

            index++;
        }
        Node temp = new Node(element, null);
        link.next = temp;
        len++;
    }

    /**
     * @param index which we want to get data in
     * @return "Object"
     */
    public final Object get(final int index) {
        // It checks if the list is empty or the index is greater than the size
        // or the index is negative
        if (len == 0 || index < 0 || index > len) {
            throw new RuntimeException("get function");
        } else {

            Object getter;
            int counter = -1;
            Node link = new Node(null, head);
            while (counter < index) { // There's no need to check if the next is
                                        // null
                link = link.next; // because it's checked at first that the
                                    // index is less
                counter++; // than the length
            }
            getter = (link.next).data;
            return getter;
        }
    }

    /**
     * @param index which is the index we want to set value in
     * @param element the value we want to set
     */
    public final void set(final int index, final Object element) {
        if (head.next == null || index < 0 || index >= len) {
            throw new RuntimeException("set function");
        } else {
            int counter = -1; // It's initializes with -1 because the index
            Node link = new Node(null, head); // is initialized with 0
            while (counter < index) { // With that loop all it does is reaching
                                        // the required
                counter++; // index
                link = link.next;
            }
            (link.next).data = element;
        }

    }

    /**
     */
    public final void clear() {
        len = 0;
        head.next = null;

    }

    /**
     * @return "boolean"
     */
    public final boolean isEmpty() {
        return len == 0 || head.next == null;

    }

    /**
     * @param index which we want to remove node at
     */
    public final void remove(final int index) {

        if (head.next == null || index < 0 || index >= len) {
            throw new RuntimeException("remove function");
        } else {
            Node link = new Node(null, head);
            int counter = 0;
            while (counter <= index) {
                link = link.next;
                counter++;
            }
            link.next = (link.next).next;
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
     * @param o the value we want to search about
     * @return "boolean"
     */
    public final boolean contains(final Object o) {
        if (len == 0 || head.next == null) {
            return false;
        } else {
            Node link = new Node(null, head.next);
            while (link.next != null) { // Checking till the end of the list
                if ((link.next).data.equals(o)) {
                    // whichever comes first
                    return true;
                }
                link = link.next;
            }
            return false;
        }

    }

    /**
     * @param toIndex last index
     * @param fromIndex first index
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

}
