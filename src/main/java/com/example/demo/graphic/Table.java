package com.example.demo.graphic;

public class Table extends HallObject{
    boolean freeForGuest;



    public Table(int width, int height, boolean freeForGuest){
        this.width = width;
        this.height = height;
        this.freeForGuest = freeForGuest;
        this.objectCells = new Cell[width*height];
        for(int i = 0; i < width*height;i++){
            objectCells[i] = new Cell();
        }
        //System.out.println(objectCells[0].x);
    }
}
