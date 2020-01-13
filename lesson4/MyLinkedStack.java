package lesson4;

public class MyLinkedStack<Item> {
    private MyLinkedList<Item> stack = new MyLinkedList<>();

    public int size(){
        return stack.size();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public void push(Item value){
        stack.insertLast(value);
    }

    public Item pop(){
        return stack.removeLast();
    }

    public Item peek(){
        return stack.getLast();
    }

    public Item print() {
        return (Item) stack.toString();
    }
}
