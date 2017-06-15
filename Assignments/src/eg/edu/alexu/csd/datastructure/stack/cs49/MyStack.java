package eg.edu.alexu.csd.datastructure.stack.cs49;

import eg.edu.alexu.csd.datastructure.stack.IStack;
/**
 * MyStack.
 * created on April 20, 2016
 * @author Amr Hedny
 *
 */

public class MyStack implements IStack {
    /** * pointer to top. */
    Node top = null;
    /** * size. */
    int size = 0;

    /** * node. */
    public class Node {
        /** * data. */
        Object data;
        /** * prev pointer. */
        Node prev;

        /**
         * @param data1 value of node
         */
        public Node(final Object data1) {
            data = data1;
        }
    }

    @Override
    public final void add(final int index, final Object element) {
        if ((index < 0) || (index > size) || (top == null && index != 0)) {
            throw new RuntimeException("invalid index");
        }
        if (top == null && index == 0) { // emmpty Stack
            Node newNode = new Node(element);
            newNode.prev = top;
            top = newNode;
            size++;
        } else if (index != size) {
            Node p = top;
            for (int i = size; i > index + 1; i--) {
                p = p.prev;
            }
            Node newNode = new Node(element);
            newNode.prev = p.prev;
            p.prev = newNode;
            size++;
        } else if (index == size) {
            Node newNode = new Node(element);
            newNode.prev = top;
            top = newNode;
            size++;
        }

    }

    @Override
    public final Object pop() {
        if (top == null) {
            throw new RuntimeException("Stack is empty can't pop");
        }
        Object valueOfTop = top.data;
        Node temp = top.prev;
        top.prev = null; // to make sure this node will be removed from memory
        top = temp;
        size--;
        return valueOfTop;
    }

    @Override
    public final Object peek() {
        if (top == null) {
            throw new RuntimeException("Stack is empty can't peek");
        } else {
            Object valueOftop = pop();
            push(valueOftop);
            return valueOftop;
        }

    }

    @Override
    public final void push(final Object element) {
        Node temp = new Node(element);
        temp.prev = top;
        top = temp;
        size++;
    }

    @Override
    public final boolean isEmpty() {
        return top == null;
    }

    @Override
    public final int size() {
        return size;
    }

}
