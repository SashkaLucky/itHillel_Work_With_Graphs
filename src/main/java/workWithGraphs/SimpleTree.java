package workWithGraphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SimpleTree<T extends Comparable<T>> implements Iterable<T> {

    private Node<T> root;

    public SimpleTree() {
        root = null;
    }

    public void add(T value) {
        if (root == null) {
            root = new Node<>(value);
        } else {
            add(value, root);
        }
    }

    private void add(T value, Node<T> node) {
        if (value.compareTo(node.getValue()) < 0) {
            if (node.getLeft() == null) {
                node.setLeft(new Node<>(value));
            } else {
                add(value, node.getLeft());
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new Node<>(value));
            } else {
                add(value, node.getRight());
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        List<T> list = new ArrayList<>();
        traverseInOrder(root, list);
        return list.iterator();
    }

    private void traverseInOrder(Node<T> node, List<T> list) {
        if (node != null) {
            traverseInOrder(node.getLeft(), list);
            list.add(node.getValue());
            traverseInOrder(node.getRight(), list);
        }
    }

    private static class Node<T extends Comparable<T>> {
        private final T value;
        private Node<T> left;
        private Node<T> right;

        public Node(T value) {
            this.value = value;
            left = null;
            right = null;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }
    }
}