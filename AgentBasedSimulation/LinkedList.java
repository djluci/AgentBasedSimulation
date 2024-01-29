/*
 * File:    Agent.java
 * Author:  Duilio Lucio
 * Project: Project 3
 * Course:  CS231
 * Section: B
 * Data:    03/01/2023
*/

package AgentBasedSimulation;
import java.util.ArrayList;
import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
    // the head variable keep track of the front of the list
    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    private static class Node<T> {
        // has a value and a pointer to the next node
        private T data;
        private Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(T data) {
            this(data, null);
        }

        /**
         * @return Node's data
         */
        public T getData() {
            return this.data;
        }

        public void setData(T newData) {
            data = newData;
        }

        public void setNext(Node newNext) {
            next = newNext;
        }

        public Node getNext() {
            return next;
        }
    }

    public void add(T data) {
        // create a new node to store my data point
        // Set its next to be null (because we want the new node to be the very last element in our list)
        Node newNode = new Node(data, null);

        if (head == null) {
            addFirst(data);
        } else {
            Node walker = head;
            for (int i = 0; i < size() - 1; i++) {
                walker = walker.getNext();
            }

            // Insert the newNode at last node
            walker.setNext(newNode);
            size++;
        }
    }

    public void addFirst(T data) {
        Node newNode = new Node(data, head);
        head = newNode;
        size++;

    }

    public void add(int index, T data) {
        if (index == size()) {
            add(data);
            return;
        } else if (index == 0 || size() == 0) {
            addFirst(data);
        } else {
            Node walker = head;
            // index - 1 steps so that we can insure that the previous Node's next pointer gets set to our new Node
            for (int i = 0; i < index - 1; i++) {
                walker = walker.getNext();
            }
            // walker is now situated directly before where I want to insert
            Node newNode = new Node(data, walker.getNext());
            walker.setNext(newNode);
            size++;
        }
    }

    // reset linkedlist to its initial state
    public void clear() {
        head = null;
        size = 0;
    }


    // check if a linkedlist contains an element
    public boolean contains(T value) {
        Node walker = head;
        if (walker.getData() == value) {
            return true;
        }
        for (int i = 0; i < size - 1; i++) {
            walker = walker.getNext();
            if (walker.getData() == value) {
                return true;
            }
        }
        return false;
    }

    // check if 2 linkedlists are equal
    public boolean equals(Object o) {
        if (!(o instanceof LinkedList)) {
            return false;
        }
        // If I have reached this line, o must be a LinkedList
        LinkedList parsedLinkedList = (LinkedList) o;
        // Now I have a reference to something Java knows is a LinkedList!
        if (parsedLinkedList.size() != this.size()) return false;

        if (parsedLinkedList.isEmpty() && isEmpty()) return true;

        Node walker1 = head;
        Node walker2 = (Node) parsedLinkedList.get(0);

        if (walker1.getData() != walker2.getData()) {
            return false;
        }

        for (int i = 0; i < size()-1; i++) {

            walker1 = walker1.getNext();
            walker2 = walker2.getNext();

            if (walker1.getData() != walker2.getData()) {
                return false;
            }
        }
        return true;
    }

    public T get(int index) {
        if (0 > index || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == 0) {
            return (T) head.getData();
        } else {
            Node walker = head;
            for (int i = 0; i < index; i++) {
                walker = walker.getNext();
            }
            return (T) walker.getData();
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T remove() {
        if (head == null) {
            return null;
        }
        Node elem = head;
        head = head.getNext();
        size--;
        return (T) elem.getData();
    }

    public T remove(int index) {
        if (head == null) {
            return null;
        } else if (index == 0) {
            return remove();
        } else {
            Node walker = head;
            for (int i = 0; i < index - 1; i++) {
                walker = walker.getNext();
            }
            Node nodeIndex = walker.getNext();
            Node newNodeIndex = nodeIndex.getNext();
            walker.setNext(newNodeIndex);
            size--;
            return (T) nodeIndex.getData();
        }
    }

    public int size() {
        return size;
    }

    public String toString() {
        Node walker = head;
        String result = "[";
        for (int i = 0; i < size(); i++) {
            if (i == 0) {
                result += " " + walker.getData() + " ";
            } else {
                result += ", " + walker.getData() + " ";
            }
            walker = walker.getNext();
        }
        result += "]";
        return result;
    }

    /**
     * converts the LinkedList to an ArrayList with the items in the same order.
     *
     * @return returns the converted linked list
     */
    public ArrayList<T> toArrayList() {
        ArrayList<T> arr = new ArrayList<T>();
        Node walker = head;
        arr.add((T) head.getData());
        for (int i = 0; i < size; i++) {
            walker.getNext();
            arr.add((T) walker.getData());
        }
        return arr;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new LLIterator(this.head);
    }

    private class LLIterator implements Iterator<T> {
        Node current;

        /**
         * the constructor for the LLIterator given the head of a list.
         *
         * @param head is the head of the list
         */
        public LLIterator(Node head) {
            current = head;
        }

        /**
         * @return true if there are still values to traverse (if the current node reference is not null).
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }

        /**
         * @return returns the next item in the list, which is the item contained in the current node.
         * The method also needs to move the traversal along to the next node in the list.
         */
        @Override
        public T next() {
            if (hasNext()) {
                T data = (T) current.getData();
                setCurrent(current.getNext());
                return data;
            }
            return null;
        }

        // not implemented
        public void remove() {
            throw new UnsupportedOperationException("Remove not implemented.");
        }

        /**
         * Sets the current node
         *
         * @param current = new current node
         */
        private void setCurrent(Node current) {
            this.current = current;
        }

    }

}