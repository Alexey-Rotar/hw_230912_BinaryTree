package org.example;

public class BinaryTree {

    public Node root;

    private Node addNode(Node node, int value) {
        if (node == null)
            return new Node(value);
        if (value == node.value)
            return node;
        else if (value < node.value)
            node.left = addNode(node.left, value);
        else
            node.right = addNode(node.right, value);
        return node;
    }

    private Node searchNode(Node node, int value) {
        if (node == null)
            return null;
        if (value == node.value)
            return node;
        if (value < node.value)
            return searchNode(node.left, value);
        else
            return searchNode(node.right, value);
    }

    private Node deleteNode(Node node, int value) {
        if (node == null)
            return null;
        if (value == node.value) {
            if (node.left == null && node.right == null)
                return null;
            if (node.right == null)
                return node.left;
            if (node.left == null)
                return node.right;
            int minValue = searchMin(node.right);
            node.value = minValue;
            node.right = deleteNode(node.right, minValue);
            return node;
        }
        if (value < node.value) {
            node.left = deleteNode(node.left, value);
            return node;
        }
        node.right = deleteNode(node.right, value);
        return node;
    }

    private int searchMin(Node root) {
        if (root.left == null)
            return root.value;
        else
            return searchMin(root.left);
    }

    public void add(int value) {
        root = addNode(root, value);
    }

    public Node search(int value) {
        return searchNode(root, value);
    }

    public void delete(int value) {
        root = deleteNode(root, value);
    }

    public int amount(Node node) {
        int count = 0;
        if (node != null) {
            count = 1;
            count += amount(node.left);
            count += amount(node.right);
        }
            return count;
    }

    public void printTreeValues(Node node) {
        if (node != null) {
            printTreeValues(node.left);
            System.out.print(node.value + " ");
            printTreeValues(node.right);
        }
    }

    public void printTreeNodes(Node node) {
        if (node != null) {
            printTreeNodes(node.left);
            System.out.print(node + "\n");
            printTreeNodes(node.right);
        }
    }

}