package com.example.demo.graphic;

/**
 * Стол, который наследник объекта в зале
 * класс описывает стол
 */
public class Table extends HallObject{
        int ID = 1;
    boolean freeForGuest;



    public Table(int width, int height, boolean freeForGuest){
        this.width = width;
        this.height = height;
        this.square = width*height;
        this.freeForGuest = freeForGuest;
        this.objectCells = new Cell[width*height]; //TODO Найти причину по которой массив не инициализируется
        for(int i = 0; i < width*height;i++){
            objectCells[i] = new Cell();
        }
        ID+=1;
        //System.out.println(objectCells[0].x);
    }
    public void printCellCoordinates(){
        for(Cell c : objectCells){
            System.out.println(c.x + " . " + c.y);
        }
    }
}
