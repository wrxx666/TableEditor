package com.example.demo.graphic;

import javafx.util.Pair;

import java.util.Scanner;

/**
 * Вероятно временный класс для работы с массивами графики,
 * на момент 03.02 добавляет зал, и способен размещать объекты на нем
 */
public class GraphicMain {
    public static void main(String[] args) throws InterruptedException {
        HallPlan firstFloor = new HallPlan(100, 100); //TODO Исправить "съезжание" объекта при указании поля не квадратным
        Table table = new Table(25, 100, true);
        Table table2 = new Table(15, 20, true);


        //objectMove(firstFloor, table); /** Словно маятник ползает по полю слева направо и обратно, на слабом пк лучше не проверять*/

    }

    public static void objectMove(HallPlan firstFloor, Table table) throws InterruptedException {
        Scanner se = new Scanner(System.in);
        String sss = "w";
        while (!sss.equals("e")) {
            for (int j = 1; j < firstFloor.width - table.width; j++) {
                firstFloor.addObject(table, j, 1);
                firstFloor.printHallPlan();
                //Thread.sleep(100);
                //firstFloor.removeObject(table, j, 1);
                //for (int i = 0; i < 40; i++) {
                //    System.out.println();
                //}
            }

            for (int j = firstFloor.width - table.width; j > 1; j--) {
                firstFloor.addObject(table, j, 1);
                firstFloor.printHallPlan();
                //Thread.sleep(100);
                firstFloor.removeObject(table, j, 1);
                //for (int i = 0; i < 40; i++) {
                //    System.out.println();
                //}
            }
        }
        sss = se.nextLine();
        se.close();
    }
}