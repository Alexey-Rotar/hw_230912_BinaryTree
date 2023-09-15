package org.example;

class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }

    @Override
    public String toString() {
        String str = "[ Узел: " + value;
        if (left != null)
            str += "; Левый: " + left.value;
        else
            str += "; Левый: null";
        if (right != null)
            str += "; Правый: " + right.value;
        else
            str += "; Правый: null";
        str += " ]";
        return str;
    }
}
