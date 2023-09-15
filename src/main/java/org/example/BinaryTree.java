package org.example;

/**
 * Класс методов для работы с бинарным деревом
 */
public class BinaryTree {

    /**
     * Создание поля root типа Node
     */
    public Node root;

    /**
     * Рекурсивный private метод добавления узла.
     * Выполняет последовательный проход по дереву и определение места добавления нового узла.
     * Принимает на вход объект типа Node и его значение типа int.
     * Возвращает объект типа Node.
     */
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

    /**
     * Рекурсивный private метод поиска узла по значению.
     * Выполняет последовательный проход по дереву и поиск узла.
     * Принимает на вход объект типа Node и его значение типа int.
     * Возвращает объект типа Node.
     */
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

    /**
     * Рекурсивный private метод удаления узла.
     * Выполняет последовательный проход по дереву и поиск узла по значению.
     * Принимает на вход объект типа Node и его значение типа int.
     * Возвращает объект типа Node.
     */
    private Node deleteNode(Node node, int value) {
        if (node == null)
            return null;
        if (value == node.value) {
            // если у узла нет потомков (узел является листом), то ему присвается значение null
            if (node.left == null && node.right == null)
                return null;
            // если у узла один потомок (левый), он заменяется им
            if (node.right == null)
                return node.left;
            // если у узла один потомок (правый), он заменяется им
            if (node.left == null)
                return node.right;
            // если у узла есть оба потомка, определяется наименьший узел из правого поддерева
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

    /**
     * Вспомогательный рекурсивный private метод для определения узла, который заменит удаляемый узел.
     * Возвращает значение узла.
     */
    private int searchMin(Node root) {
        if (root.left == null)
            return root.value;
        else
            return searchMin(root.left);
    }

    /**
     * Публичный метод для добавления нового узла в дерево.
     * Принимает значение узла.
     * Вызывает основной private метод добаавления.
     */
    public void add(int value) {
        root = addNode(root, value);
    }

    /**
     * Публичный метод для поиска узла в дереве по значению.
     * Принимает значение узла.
     * Вызывает основной private метод поиска.
     */
    public Node search(int value) {
        return searchNode(root, value);
    }

    /**
     * Публичный метод для удаления узла из дерева.
     * Принимает значение узла.
     * Вызывает основной private метод удаления.
     */
    public void delete(int value) {
        root = deleteNode(root, value);
    }

    /**
     * Публичный рекурсивный метод для определения количества узлов в дереве.
     * Принимает на вход объект типа Node. Выполняет проход по дереву начиная с переданного узла.
     * Возвращает значение типа int.
     */
    public int amount(Node node) {
        int count = 0;
        if (node != null) {
            count = 1;
            count += amount(node.left);
            count += amount(node.right);
        }
            return count;
    }

    /**
     * Публичный рекурсивный метод для вывода в консоль значений узлов из дерева.
     * Принимает на вход объект типа Node. Выполняет проход по дереву начиная с переданного узла.
     */
    public void printTreeValues(Node node) {
        if (node != null) {
            printTreeValues(node.left);
            System.out.print(node.value + " ");
            printTreeValues(node.right);
        }
    }

    /**
     * Публичный рекурсивный метод для вывода в консоль узлов из дерева.
     * Принимает на вход объект типа Node. Выполняет проход по дереву начиная с переданного узла.
     */
    public void printTreeNodes(Node node) {
        if (node != null) {
            printTreeNodes(node.left);
            System.out.print(node + "\n");
            printTreeNodes(node.right);
        }
    }

}