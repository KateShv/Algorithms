package lesson4;

import java.util.*;

public class MyLinkedList<Item> implements ListIterable<Item> {
    private Node first;
    private Node last;
    private int size;



    private class Node<Item> {
        Item value;
        Node next;
        Node prev;

        public Node(Item value) {
            this.value = value;
        }

        public Node(Item value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.prev = previous;
        }
    }



    @Override
    public Iterator<Item> iterator() {
        return new Iter();
    }

    @Override
    public ListIterator<Item> listIterator() {
        return new Iter();
    }



    private class Iter implements ListIterator<Item> {
        Node current = new Node(null, first, null);
        private int index;

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public Item next() {
            current = current.next;
            if (current == null) {
                throw new NoSuchElementException();
            }
            index++;
            return (Item) current.value;
        }

        @Override
        public boolean hasPrevious() {
            return current.prev != null;
        }

        @Override
        public Item previous() {
            current = current.prev;
            if (current == null) {
                throw new NoSuchElementException();
            }
            index--;
            return (Item) current.value;
        }

        @Override
        public int nextIndex() {
            return index + 1;
        }

        @Override
        public int previousIndex() {
            return index - 1;
        }

        @Override
        public void remove() {
            if (current == null){
                throw new NoSuchElementException();
            }
            if (current.prev == null) {
                current.next.prev = null;
                first = current.next;
                current = null;
                return;
            }
            if (current.next == null) {
                current.prev.next = null;
                last = current.prev;
                current = null;
                return;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
            current = null;
        }

        @Override
        public void set(Item item) {
            if (current == null){
                throw new NoSuchElementException();
            }
            current.value = item;
        }

        @Override
        public void add(Item item) {
            insert(item, index);
        }
    }



    public void insertFirst(Item item) {
        Node newNode = new Node(item);
        newNode.next = first;
        if (isEmpty()) {
            last = newNode;
        } else {
            first.prev = newNode;
        }
        first = newNode;
        size++;
    }

    public void insertLast(Item item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            first = newNode;
        } else {
            newNode.prev = last;
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        Node oldFirst = first;
        first = first.next;
        if (isEmpty()) {
            last = null;
        } else {
            first.prev = null;
        }
        size--;
        return (Item) oldFirst.value;
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        Node oldLast = last;
        if (last.prev != null) {
            last.prev.next = null;
        } else {
            first = null;
        }
        last = last.prev;
        size--;
        return (Item) oldLast.value;
    }

    public Item getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return (Item) first.value;
    }

    public Item getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return (Item) last.value;
    }

    public void insert(Item item, int link) {
        if (link <= 0) {
            insertFirst(item);
            return;
        }
        if (link >= size) {
            insertLast(item);
            return;
        }
        Node current = first;
        int i = 0;
        while (i < link - 1) {
            current = current.next;
            i++;
        }
        Node newNode = new Node(item);
        newNode.next = current.next;
        newNode.prev = current;
        current.next = newNode;
        newNode.next.prev = newNode;
        size++;
    }

    public boolean remove(Item item) {
        if (isEmpty()) {
            return false;
        }
        if (first.value.equals(item)) {
            removeFirst();
            return true;
        }
        Node current = first;
        while (current != null && !current.value.equals(item)) {
            current = current.next;
        }
        if (current == null) {
            return false;
        }
        if (current == last) {
            removeLast();
            return true;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
        return true;
    }

    public int linkOf(Item item) {
        Node current = first;
        int link = 0;
        while (current != null) {
            if (current.value.equals(item)) {
                return link;
            }
            current = current.next;
            link++;
        }
        return -1;
    }

    public boolean contains(Item item) {
        return linkOf(item) > -1;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        Node current = first;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.value.toString() + " ");
            current = current.next;
        }
        return sb.toString();
    }
}
