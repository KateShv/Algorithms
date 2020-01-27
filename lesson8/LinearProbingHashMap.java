package lesson8;

import java.util.*;

public class LinearProbingHashMap<Key, Value> {

    private int capacity;
    private int size;
    private final Key DELETED_KEY = (Key) new Integer(Integer.MIN_VALUE);
    private final Value DELETED_VALUE = (Value) "DELETED";
    private Key[] keys;
    private Value[] values;

    LinearProbingHashMap(int capacity) {
        this.capacity = capacity;
        size = 0;
        keys = (Key[]) new Object[capacity];
        values = (Value[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public final int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    public final int hash2(Key key) {
        return 7 - (key.hashCode() & 0x7fffffff) % 7;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    private void isKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key == null");
        }
    }

    public void put(Key key, Value value) {
        isKeyNotNull(key);
        if (size == capacity - 1) {
            throw new RuntimeException("места нет");
        }
        if(isEmpty()){
            keys[hash(key)] = key;
            values[hash(key)] = value;
            size++;
            return;
        }
        int index = -1;
        int count = 0;
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % capacity) {
            if(count >= keys.length){
                return;
            }
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
            if(keys[i].equals(DELETED_KEY) && index == -1){
                index = i;
            }
            count++;
        }
        if(index == -1){
            keys[i] = key;
            values[i] = value;
        } else{
            keys[index] = key;
            values[index] = value;
        }
        size++;
    }

    public Value get(Key key) {
        isKeyNotNull(key);
        int count = 0;
        for (int i = hash(key); keys[i] != null; i = (i + 1) % capacity) {
            if(count >= keys.length){
                break;
            }
            if (keys[i].equals(key)) {
                return values[i];
            }
            count++;
        }
        return null;
    }

    public Value delete(Key key){
        isKeyNotNull(key);
        if(isEmpty()){
            return null;
        }
        int count = 0;
        for (int i = hash(key); keys[i] != null; i = (i + 1) % capacity){
            if(count >= keys.length){
                break;
            }
            if(keys[i].equals(key)){
                Value tempValue = values[i];
                keys[i] = DELETED_KEY;
                values[i] = DELETED_VALUE;
                size--;
                return tempValue;
            }
            count++;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < capacity; i++) {
            sb.append(keys[i]).append("(").append(values[i]).append(")");
            if(i != keys.length - 1){
                sb.append(", ");
            }
        }
        sb.append("]\n");
        return sb.toString();
    }

}