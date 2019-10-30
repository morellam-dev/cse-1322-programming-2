package module_5.assignment_5;

import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * A custom implementation of a doubly-linked list, based on Java's
 * AbstractSequentialList.
 * 
 * @author M Morella
 * 
 * @implNote This class differs from Java's LinkedList in that it does not implement
 *           Deque, so its functionality as a Stack or Queue is relatively limited.
 *           Due to its hasty implementation, it is undoubtedly less efficient
 *           and less functional than the built-in LinkedList.
 */
public class MyLinkedList<E> extends AbstractSequentialList<E> implements Cloneable, java.io.Serializable {
    private static final long serialVersionUID = 8794565002792734402L;

    private int size = 0;
    private Node<E> start;
    private Node<E> end;

    class Node<T> {
        public T data;
        public Node<T> next;
        public Node<T> prev;

        public Node(Node<T> prev, T data, Node<T> next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        /** Create a new node, and attach it between this node and the one before it */
        public void linkBefore(T data) {
            Node<T> before = this.prev; // nullable
            Node<T> newNode = new Node<>(before, data, this);
            this.prev = newNode;
            if (before != null) {
                before.next = newNode;
            }
        }

        /** Create a new node, and attach it between this node and the one after it */
        public void linkAfter(T data) {
            Node<T> after = this.next; // nullable
            Node<T> newNode = new Node<>(this, data, after);
            this.next = newNode;
            if (after != null) {
                after.prev = newNode;
            }
        }

        /** Remove this node by linking together its neighbors */
        public T unlink() {
            Node<T> before = this.prev;
            Node<T> after = this.next;

            before.next = after;
            after.next = before;
            return this.data;
        }
    }

    /** Instantiate a new empty list */
    public MyLinkedList() {}

    /** Instantiate the list with the elements of another Collection */
    public MyLinkedList(Collection<? extends E> collection) {
        addAll(collection);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E data) {
        return addLast(data);
    }
    /** Add a new element to the end of the List */
    public boolean addLast(E data) {
        Node<E> endNode = end;
        Node<E> newNode = new Node<>(endNode, data, null);
        end = newNode;
        if (endNode == null) {
            start = newNode;
        } else {
            endNode.next = newNode;
        }
        size++;
        return true;
    }
    
    /** Add a new element to the end of the List */
    public void addFirst(E data) {
        Node<E> startNode = start;
        Node<E> newNode = new Node<>(null, data, startNode);
        if (startNode == null) {
            start = end = newNode;
        } else {
            startNode.prev = newNode;
        }
        start = newNode;
        size++;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return new LinkedListIterator(index);
    }

    private class LinkedListIterator implements ListIterator<E> {
        private Node<E> next = start;
        private Node<E> lastAccessed;
        private int nextIndex = 0;

        public LinkedListIterator(int index) {
            if (index < 0 || size < index) {
                throw new IndexOutOfBoundsException(index);
            }
            while (nextIndex < index) {
                next();
            }
        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }

        @Override
        public boolean hasNext() {
            return (nextIndex < size);
        }

        @Override
        public boolean hasPrevious() {
            return (0 <= previousIndex());
        }

        @Override
        public E next() {
            if (hasNext()) {
                lastAccessed = next;
                next = next.next; // nullable
                nextIndex++;
                return lastAccessed.data;
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override
        public E previous() {
            if (hasPrevious()) {
                Node<E> prev = next.prev;
                lastAccessed = prev;
                next = prev; // nullable
                nextIndex--;
                return lastAccessed.data;
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override
        public void add(E data) {
            lastAccessed = null;
            if (next == null) {
                addLast(data);
            } else {
                next.linkBefore(data);
                size++;
            }
            nextIndex++; // shift next further forward in the array
        }

        @Override
        public void remove() {
            if (lastAccessed != null) {
                lastAccessed.unlink();
                lastAccessed = null;
                size--;
            } else {
                throw new IllegalStateException();
            }
        }

        @Override
        public void set(E data) {
            if (lastAccessed != null) {
                lastAccessed.data = data;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    /** @return A shallow copy of this linked list */
    @Override
    public MyLinkedList<E> clone() {
        MyLinkedList<E> clone = new MyLinkedList<>(this);
        for (E data : this) {
            clone.add(data);
        }
        return clone;
    }
}