package org.example;

/**
 * Класс создания бинарного дерева и наполнения его данными
 */
public class Data {

    /**
     * Метод создания бинарного дерева и наполнения его данными.
     * Возвращает объект типа BinaryTree
     */
    public BinaryTree generateTree(){
        BinaryTree bt = new BinaryTree();
        bt.add(11);
        bt.add(2);
        bt.add(7);
        bt.add(5);
        bt.add(84);
        bt.add(13);
        bt.add(6);
        bt.add(9);
        bt.add(40);
        bt.add(12);
        return bt;
    }
}
