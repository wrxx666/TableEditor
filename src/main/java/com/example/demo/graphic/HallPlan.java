package com.example.demo.graphic;

public class HallPlan {
    int width;
    int height;
    int square = width*height;

    HallCell[] cells;

    public HallPlan(int width, int height){
        this.width = width;
        this.height = height;
        int square = width*height;
        cells = new HallCell[square];
        //System.out.println(cells.length);
        for (int j = 0,s = 0; j < height;j++){
            if(s == cells.length - 1){
                break;
            } else {
                for (int i = 0; i < width; i++, s++) {
                    cells[s] = new HallCell();
                    cells[s].x = i;
                    cells[s].y = j;
                    cells[s].isEmpty = 0;//true;
                }
            }
        }
    }

    public boolean addObject(HallObject hallObject, int xStartPos, int yStartPos, boolean xPlus, boolean yPlus){
       for(int j = 0, s = (xStartPos*yStartPos)-1; j < height; j++){
           System.out.println(s);
           for(int i = 0; i < width; i++, s++){
               if(j >= height - yStartPos && i >= width - xStartPos){
                   cells[s].isEmpty = 1;//false;
               }
           }
       }




        /* for(int j = yStartPos-1, s = (xStartPos*yStartPos)-1; j < height;j++){
            for(int i = xStartPos-1 ; i < width;i++,s++){
                cells[s].isEmpty = 0;//false;
            }
        }

        for(int j = yStartPos-1, s = 0; j < height;j++){
            for(int i = xStartPos-1 ; i < width;i++,s++){

                if(s == height - 1){
                    break;
                } else {
                    hallObject.objectCells[s].x = i;
                    hallObject.objectCells[s].y = j;
                }
            }
        }

         */



        for(int j = 0, s = 0; j < width; j++){
            for( int i = 0; i < height; i++, s++){
                System.out.print(cells[s].isEmpty);
                System.out.print(" ");
            }
            System.out.println();
        }
        return false;
    }
}
