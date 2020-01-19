package lesson6;

public class MyTreeMap<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int size;
        int height;
        boolean balance;

        Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            size = 1;
            height = 0;
            balance = true;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    int height() {
        return height(root);
    }

    private int height(Node node) {
       if (node == null) {
            return 0;
        }
        return node.height;
    }

    boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        return node.balance;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private void isKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key is null");
        }
    }

    public boolean contains(Key key) {
        return get(root, key) != null;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        isKeyNotNull(key);
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node.value;
        } else if (cmp < 0) {
            return get(node.left, key);
        } else {
            return get(node.right, key);
        }
    }

    void put(Key key, Value value) {
        isKeyNotNull(key);
        if (value == null) {
            return;
        }
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            node.value = value;
        } else if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else {
            node.right = put(node.right, key, value);
        }
        calcSize(node);
        calcHeightAndBalance(node);
        return node;
    }

    private void calcSize(Node node) {
        node.size = size(node.left) + size(node.right) + 1;
    }

    private void calcHeightAndBalance(Node node) {
        int leftH = height(node.left);
        int rightH = height(node.right);
        calcHeight(node, leftH, rightH);
        calcBalance(node, leftH, rightH);
    }

    private void calcHeight(Node node, int leftH, int rightH) {
        node.height = Math.max(leftH, rightH) + 1;
    }

    private void calcBalance(Node node, int leftH, int rightH) {
       node.balance = !(Math.abs(leftH - rightH) > 1);
    }

    public Key minKey() {
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    public Key maxKey() {
        return max(root).key;
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        calcSize(node);
        calcHeightAndBalance(node);
        return node;
    }

    void delete(Key key) {
        isKeyNotNull(key);
        delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            Node temp = node;
            node = min(node.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }
        calcSize(node);
        calcHeightAndBalance(node);
        return node;
    }

    @Override
    public String toString() {
        return toString(root);
    }

    private String toString(Node node) {
        if (node == null) {
            return "";
        }
        return toString(node.left) +
                node.key.toString() + "(" + node.value.toString() + ")" + ", " +
                toString(node.right);
    }

}