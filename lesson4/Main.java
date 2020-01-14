package lesson4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {

        /*MyLinkedList<String> mll = new MyLinkedList<>();
        mll.insertFirst("bob");
        mll.insertFirst("pit");
        mll.insertFirst("jack");
        System.out.println(mll);
        mll.insertLast("jerry");
        System.out.println(mll);
        mll.insertLast("molly");
        System.out.println(mll);
        System.out.println(mll.removeLast());
        System.out.println(mll);
        System.out.println(mll.removeFirst());
        System.out.println(mll);
        mll.insert("alex",2);
        System.out.println(mll);
        System.out.println(mll.remove("bob"));
        System.out.println(mll);
        System.out.println(mll.getFirst());

        System.out.println();

        Iterator<String> iterator = mll.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        for (String s: mll) {
            System.out.println(s);
        }

        System.out.println();*/

        MyLinkedList<String> list = new MyLinkedList<>();
        list.insertFirst("bob");
        list.insertFirst("pit");
        list.insertLast("jack");
        ListIterator<String> iter = list.listIterator();
        iter.next();
        iter.next();
        iter.set("jerry");
        System.out.println(iter.next());
        System.out.println(iter.previous());
        System.out.println(iter.nextIndex());
        System.out.println(iter.previousIndex());
        if (iter.hasNext()) iter.add("diana");
        if (iter.hasPrevious()) iter.add("valery");
        System.out.println(list);
        iter.next();
        iter.add("fiona");
        System.out.println(list);
        iter.previous();
        iter.previous();
        iter.remove();
        System.out.println(list);



        /*MyLinkedStack<String> stack = new MyLinkedStack<>();
        stack.push("mila");
        stack.push("kate");
        stack.push("nina");
        stack.push("molly");
        stack.push("lera");
        System.out.println(stack.print());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.print());
        System.out.println(stack.size());*/

    }
}
