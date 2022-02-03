package com.example.demo.graphic;

/**
 * Клетка, условная единица, размером 10х10см, т.е. к примеру 1 метр = 10 клеток
 */
public class Cell {
    int x;
    int y;
    HallObject cellOwner; // По идее должно быть показателем принадлежности клетки к определённому объекту
}
class HallCell extends Cell{
    //boolean isEmpty;
    int isEmpty = 0;

}
