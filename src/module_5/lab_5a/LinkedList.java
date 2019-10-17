package module_5.lab_5a;

import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * A custom implementation of a Linked List 
 * using AbstractSequentialList as a base
 * @author M Morella
 */
public class LinkedList<E> extends AbstractSequentialList<E> implements Cloneable {
    private int size = 0;
    private Node<E> start;
    private Node<E> end;

    public LinkedList() {}
    /**
     * 
     * @param collection
     */
    public LinkedList(Collection<? extends E> collection) {
        addAll(collection);
    }

    @Override
    public int size() {
        return size;
    }

    private void addLast(E data) {
        Node<E> endNode = end;
        Node<E> newNode = new Node<>(endNode, data, null);
        end = newNode;
        if (endNode == null) {
            start = newNode;
        } else {
            endNode.next = newNode;
        }
        size++;
    }

    public void addFirst(E data) {
        Node<E> startNode = start;
        Node<E> newNode = new Node<>(null, data, startNode);
        if (startNode == null) {
            end = newNode;
        } else {
            startNode.prev = newNode;
        }
        start = newNode;
        size++;
    }

    private void linkAfter(E data, Node<E> node) {
        Node<E> after = node.next; // nullable
        Node<E> newNode = new Node<>(node, data, after);
        node.next = newNode;
        if (after != null) {
            after.prev = newNode;
        }
    }

    private void linkBefore(E data, Node<E> node) {
        Node<E> before = node.prev; // nullable
        Node<E> newNode = new Node<>(before, data, node);
        node.prev = newNode;
        if (before != null) {
            before.next = newNode;
        }
    }

    private E removeNode(Node<E> node) {
        Node<E> before = node.prev;
        Node<E> after = node.next;

        before.next = after;
        after.next = before;
        size--;
        return node.data;
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
                linkBefore(data, next);
                size++;
            }
            nextIndex++; // shift next further forward in the array
        }
        @Override
        public void remove() {
            if (lastAccessed != null) {
                removeNode(lastAccessed);
                lastAccessed = null;
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
    public LinkedList<E> clone() {
        LinkedList<E> clone = new LinkedList<>(this);
        for (E data : this) {
            clone.add(data);
        }
        return clone;
    }
}

class Node<E> {
    public E data;
    public Node<E> next;
    public Node<E> prev;

    public Node(Node<E> prev, E data, Node<E> next) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}