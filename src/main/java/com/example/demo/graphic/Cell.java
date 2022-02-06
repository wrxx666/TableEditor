package com.example.demo.graphic;

/**
 * Клетка, условная единица, размером 10х10см, т.е. к примеру 1 метр = 10 клеток
 */
public class Cell {
    int x;
    int y;
    HallObject cellOwner; // TODO Реализовать привязку к объектам, для простоты перемещения/удаления объекта с поля
}
class HallCell extends Cell{
    //boolean isEmpty;
    boolean isEmpty = true;

}
