package lesson3;

public class Deque<T> {

    private final int DEFAULT_SIZE = 10;
    private int maxSize;
    private T[] list;
    private int sizeQueue;
    private int left;
    private int right;

    public Deque(int maxSize) {
        if (maxSize < 1 || maxSize > Integer.MAX_VALUE - 1000) {
            throw new RuntimeException("Некорректный размер очереди " + maxSize);
        }
        this.maxSize = maxSize;
        this.list = (T[]) (new Object[maxSize]);
        this.left = maxSize / 2;
        this.right = this.left - 1;
        this.sizeQueue = 0;
    }

    public Deque() {
        this.maxSize = DEFAULT_SIZE;
        this.list = (T[]) (new Object[maxSize]);
        this.left = maxSize / 2;
        this.right = this.left - 1;
        this.sizeQueue = 0;
    }

    public boolean isEmpty() {
        return sizeQueue == 0;
    }

    public boolean isFull() {
        return (left == 0 || right == maxSize - 1);
    }

    public int getSize() {
        return sizeQueue;
    }

    public void addRight(T value) {
        if (isFull()) {
            resize();
        }
        list[++right] = value;
        sizeQueue++;
    }

    public void addLeft(T value) {
        if (isFull()) {
            resize();
        }
        list[--left] = value;
        sizeQueue++;
    }

    public T removeLeft() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty");
        }
        T temp = list[left];
        list[left] = null;
        left++;
        sizeQueue--;
        return temp;
    }

    public T removeRight() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty");
        }
        T temp = list[right];
        list[right] = null;
        right--;
        sizeQueue--;
        return temp;
    }

    public T peekLeft() {
        return list[left];
    }

    public T peekRight() {
        return list[right];
    }

    private void resize() {
        maxSize *= 2;
        if (maxSize > Integer.MAX_VALUE - 1000) {
            throw new RuntimeException("Невозможно увеличить очередь, т.к. достигнут максимальный предел по типу.");
        }
        T[] newList = (T[]) (new Object[maxSize]);
        int newMiddle = maxSize / 2;
        System.arraycopy(list, 0, newList, newMiddle - list.length / 2, list.length);
        left = newMiddle - (list.length / 2 - left);
        right = left + sizeQueue - 1;
        list = newList;
    }

    //для красивой печати очереди
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[ ");
        for (int i = left; i <= right; i++) {
            str.append(list[i]);
            if(i != right) {
                str.append(", ");
            }
        }
        str.append(" ]");
        return str.toString();
    }
}
