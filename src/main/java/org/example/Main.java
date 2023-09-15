package org.example;

/**
 * Класс запуска программы
 */
public class Main {

    /**
     * Метод запуска программы. Создание экземляров классов, вызова методов. Демонстрация работы программы.
     */
    public static void main(String[] args) {
        Data data = new Data();
        BinaryTree bt = data.generateTree();

        int valueToDelete = 13;
        int valueToSearch = 11;

        System.out.print("Значения узлов в дереве: ");
        bt.printTreeValues(bt.root);
        System.out.print("\nВсего узлов: ");
        System.out.println(bt.amount(bt.root));
        System.out.println("\nВсе узлы в дереве: ");
        bt.printTreeNodes(bt.root);
        System.out.println("\nПоиск по значению " + "(" + valueToSearch + "):");
        System.out.println(bt.search(valueToSearch));
        System.out.println("\nУдаление узла " + "(" + valueToDelete + ")...");
        bt.delete(valueToDelete);
        System.out.print("Значения узлов в дереве: ");
        bt.printTreeValues(bt.root);
        System.out.print("\nВсего узлов: ");
        System.out.println(bt.amount(bt.root));
    }
}