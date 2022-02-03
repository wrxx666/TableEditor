package com.example.demo.graphic;

import javafx.util.Pair;

/**
 * Вероятно временный класс для работы с массивами графики,
 * на момент 03.02 добавляет зал, и способен размещать объекты на нем
 */
public class GraphicMain {
    public static void main(String [] args){
        HallPlan firstFloor = new HallPlan(25,25); //TODO Исправить "съезжание" объекта при указании поля не квадратным
        Table table = new Table(10,10,true);
        Table table2 = new Table(15,4,true);

        firstFloor.addObject(table,1,1);
        firstFloor.printHallPlan();
        //firstFloor.moveObjectRight(table.ID);
       // System.out.println(table.objectCells[table.ID].y);
        //firstFloor.printHallPlan();
        //int[] ints = new int[10];
        //table.printCellCoordinates();



        /*
        1 2 3 4    1 2 3 4 5
        5 6 7 8    6 7 8 9 0
        9 0 0 0    0 0 0 0 0
         */

    }
}
