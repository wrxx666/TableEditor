package com.example.demo.graphic;

import java.util.HashMap;

/**
 * Класс зала
 * описывает в себе двумерное пространство, задаваемых размеров
 * на 03.02 находится в плачевном состоянии
 * на 06.02 состояние получше, но я уже черт знает что тут происходит
 */
public class HallPlan {
    int width;
    int height;
    int square;

    HallCell[] cells;
    HashMap<Integer,HallObject> hallObjectHashMap;
    public HallPlan(int width, int height){
        this.width = width;
        this.height = height;
        square = width*height;
        cells = new HallCell[square];
        //System.out.println(cells.length);
        for (int j = 0,s = 0; j < height;j++){

                for (int i = 0; i < width; i++, s++) {
                    cells[s] = new HallCell();
                    cells[s].x = i+1;
                    //System.out.print(cells[s].x+".");
                    cells[s].y = j+1;
                    //System.out.print(cells[s].y+" ");
                    cells[s].isEmpty = true;
                }
            //System.out.println();
        }
        hallObjectHashMap = new HashMap<>();
    }

    /**
     * Метод для добавления объекта на поле
     */
    public boolean addObject(HallObject hallObject, int xStartPos, int yStartPos){
        int xStartPos0 = xStartPos;
        int yStartPos0 = yStartPos;
        int objH = hallObject.height;
        int objW = hallObject.width;
        int xEndPoint = xStartPos0+objW-1;
        int yEndPoint = yStartPos0+objH-1;
        boolean stop = false;
        int hallObjectCellNum = 0;

        //System.out.println(hallObject.height);
        //System.out.println(hallObject.width);

        for(int j = 0,s=0; j < this.height; j++){
            for (int i = 0; i < this.width; i++,s++){
                if(this.cells[s].x == xStartPos && this.cells[s].y == yStartPos){
                    this.cells[s].isEmpty=false;
                    this.cells[s].cellOwner = hallObject;
                    hallObject.objectCells[hallObjectCellNum].x=this.cells[s].x;
                    hallObject.objectCells[hallObjectCellNum].y=this.cells[s].y;
                    xStartPos++;
                    hallObjectCellNum++;
                }

                if(xStartPos > xEndPoint){
                    xStartPos = xStartPos0;

                }


                if(s==this.cells.length-1){
                    stop = true;
                    break;
                }
            }
            if(yStartPos <= j+1 && j+1< yEndPoint ){
                yStartPos++;
            }
            if(yStartPos > yEndPoint){
                yStartPos = yStartPos0;
                break;
            }

        }
        hallObjectHashMap.put(hallObject.ID,hallObject);

        return false;



    }


    /**
     * Метод для отображения зала и объёктов в нем таблицей
     */
    public void printHallPlan(){
        for(int j = 0, s = 0; j < width; j++){
            for( int i = 0; i < height; i++, s++){
                String str = " ";
                //System.out.print(cells[s].isEmpty);
               // System.out.print(this.cells[s].x + "." + this.cells[s].y + "(" + this.cells[s].isEmpty + ")" );
                //System.out.print("(" + this.cells[s].isEmpty + ")" );
                if(!this.cells[s].isEmpty){
                    str = "@";
                }
                System.out.print(str);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    /**НЕДОСТУПНО Метод для перемещения объекта влево путем сдвига по ячейке*/
    public void moveObjectLeft(int objectID){  //TODO Научить объекты ползать по залу, пригодится для того чтобы прикрутить "таскание объектов"
        HallObject obj = hallObjectHashMap.get(objectID);
        for(int j = 0,s = 0; j < height; j++){
            for(int i = 0; i < width;i++, s++){
                if(this.cells[s].cellOwner == obj){

                }
            }
        }
    }

    /**НЕДОСТУПНО Метод для перемещения объекта вправо путем сдвига по ячейке*/
    public void moveObjectRight(int objectID){
        HallObject obj = hallObjectHashMap.get(objectID);
        System.out.println(objectID);

        for (HallCell c : cells){
            if(c.cellOwner==hallObjectHashMap.get(objectID)){

            }
        }
    }

    /** Метод для удаления объекта с поля */
    public void removeObject(HallObject hallObject, int xStartPos, int yStartPos){
        int xStartPos0 = xStartPos;
        int yStartPos0 = yStartPos;
        int objH = hallObject.height;
        int objW = hallObject.width;
        int xEndPoint = xStartPos0+objW-1;
        int yEndPoint = yStartPos0+objH-1;
        int hallObjectCellNum = 0;

        for(int j = 0,s=0; j < this.height; j++){
            for (int i = 0; i < this.width; i++,s++){
                if(this.cells[s].x == xStartPos && this.cells[s].y == yStartPos){
                    this.cells[s].isEmpty=true;
                    this.cells[s].cellOwner = null;
                    hallObject.objectCells[hallObjectCellNum].x=this.cells[s].x;
                    hallObject.objectCells[hallObjectCellNum].y=this.cells[s].y;
                    xStartPos++;
                    hallObjectCellNum++;
                }

                if(xStartPos > xEndPoint){
                    xStartPos = xStartPos0;

                }


                if(s==this.cells.length-1){
                    break;
                }
            }
            if(yStartPos <= j+1 && j+1< yEndPoint ){
                yStartPos++;
            }
            if(yStartPos > yEndPoint){
                yStartPos = yStartPos0;
                break;
            }

        }
        //TODO Переписать метод удаления основываясь на принадлежности клетки к объекту
    }   //TODO Добавить удаление из HashMap
}
