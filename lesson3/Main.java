package lesson3;

public class Main {

    private static String textReverse(String text) {
        Stack<Character> stack = new Stack<>(text.length());
        for (int i = 0; i < text.length(); i++) {
            stack.push(text.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(textReverse("Dudley and Harry shared a room with twin beds."));

        Deque<Integer> deq = new Deque<>(10);

        deq.addRight(1);
        System.out.println(deq.toString());
        deq.addRight(2);
        System.out.println(deq.toString());
        deq.addRight(3);
        System.out.println(deq.toString());
        deq.addLeft(4);
        System.out.println(deq.toString());
        deq.addLeft(5);
        System.out.println(deq.toString());

        System.out.println(deq.peekLeft());
        System.out.println(deq.peekRight());
        System.out.println(deq.toString());

        System.out.println(deq.removeLeft());
        System.out.println(deq.toString());
        System.out.println(deq.removeRight());
        System.out.println(deq.toString());

    }
}
