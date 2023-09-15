package org.example;

/**
 * Базовый класс Node (узел)
 */
class Node {
    /**
     * Поле Значение родительского узла
     */
    int value;
    /**
     * Поле Левый потомок
     */
    Node left;
    /**
     * Поле Правый потомок
     */
    Node right;

    /**
     * Конструкор создания нового узла
     */
    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }

    /**
     * Перегрузка для корректного вывода информации об узле
     */
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
