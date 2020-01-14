package lesson4;

import java.util.*;

public class MyOneLinkedList<Item> {
    private Node first;
    private int size;

    private class Node<Item>{
        Item value;
        Node next;

        public Node(Item value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(Item value) {
            this.value = value;
        }
    }

    public void insertFirst(Item value){
        Node newNode = new Node(value, first);
        first = newNode;
        size++;
    }

    public Item removeFirst(){
        if (isEmpty()){
            throw new NoSuchElementException("List is empty");
        }
        Node oldFirst = first;
        first = first.next;
        size--;
        return (Item) oldFirst.value;
    }

    public Item getFirst () {
        if (isEmpty()){
            throw new NoSuchElementException("List is empty");
        }
        return (Item)first.value;
    }

    public void insert(Item value, int index){
        if (index <= 0){
            insertFirst(value);
            return;
        }
        Node current = first;
        int i = 0;
        while ( i < size-1 && i < index - 1){
            current = current.next;
            i++;
        }
        Node newNode = new Node(value);
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    public boolean remove (Item value){
        if(isEmpty()){
            return false;
        }
        if(first.value.equals(value)){
            removeFirst();
            return true;
        }
        Node current = first;
        while (current.next != null && !current.next.value.equals(value) ){
            current = current.next;
        }
        if(current.next == null){
            return false;
        }
        current.next = current.next.next;
        size--;
        return true;
    }

    public int indexOf(Item value) {
        return index(value);
    }

    public int index(Item value){
        Node current = first;
        int link = 0;
        while (current != null){
            if(current.value.equals(value)){
                return link;
            }
            current = current.next;
            link++;
        }
        return -1;
    }

    public boolean contains(Item value){
        return index(value) > -1;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return size;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[ ]";
        }
        Node current = first;
        StringBuilder sb = new StringBuilder("[ ");

        while (current != null) {
            sb.append(current.value.toString() + ", ");
            current = current.next;
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(" ]");
        return sb.toString();
    }

}
