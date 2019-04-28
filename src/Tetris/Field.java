package Tetris;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class Field {        //поле
private final static int xSize = 15;
final static int xStart = 4;
final static int ySize = 15;


    //public static String[][] fieldArray;
static List<List<String>> fieldArray;
static void createField(){
   // fieldArray = new String[10][5];             /** 20*10  */
    fieldArray = new ArrayList<>();

    for (int i=0; i<xSize; i++){ //
        fieldArray.add(new ArrayList<>());
        for (int j=0; j<ySize; j++){  //
            fieldArray.get(i).add("*");
        }
    }
    try {
        printField();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}

//
//public static void tempMethod(){
//    HashMap <Position, Position> positionPositionHashMap23 = new HashMap<>();
//
//    positionPositionHashMap23.put(new Position(7,7), new Position(7,7));
//    positionPositionHashMap23.put(new Position(8,7), new Position(8,7));
//    positionPositionHashMap23.put(new Position(9,7), new Position(9,7));
//    positionPositionHashMap23.put(new Position(9,8), new Position(9,8));
//    StandShape standShape = new StandShape("stand", ShapeRotation.HORISONTAL, new Position(7,7), positionPositionHashMap23);
//
//    standShape.positionHashMap.forEach((position, position2) -> {
//        fieldArray.get(position.getX()).set(position.getY(), "Ф");
//    });
//    printField();
//
//    standShape.flipShape();
//    printField();
//}


static void startGame(){
    boolean isOn=true;
 int random;
    while (isOn) {
        random=Shape.randomShape();

        switch (random){
            case 1:    isOn=Field.canMove(Controller.shape[0]=StretchedShape.createShape());
                break;
            case 2:    isOn=Field.canMove(Controller.shape[0]=StandShape.createShape());
                break;
            case 3:    isOn=Field.canMove(Controller.shape[0]=SquareShape.createShape());
                break;
            case 4:    isOn=Field.canMove(Controller.shape[0]=LetterLShape.createShape());
                break;
        }
        //isOn=canMove(StandShape.createShape());
    }

    Controller.running.set(false);
    Controller.running2.set(false);
    Controller.running3.set(false);

    System.err.println("GAME OVER!@1");
}

private static boolean canMove(Shape shape){
    boolean canMove=true;
    final boolean[] isOn = {true};
    while (canMove) {
        canMove = shape.move(Direction.DOWN);
        try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
    shape.positionHashMap.forEach(((position, position2) -> {
        if (position.getX()<xStart){
            isOn[0] =false;
        }
    }));

    return isOn[0];
}



static void printField() throws IOException, InterruptedException {

        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

    System.out.println("\n");
    for (int i=xStart; i<xSize; i++){   //
        for (int j=0; j<ySize; j++){   //
            System.out.print(fieldArray.get(i).get(j));
        }
        System.out.println();
    }
    System.out.println("\n");


}


static void wipeLine(int x){                         ////////
             fieldArray.remove(x);
//    System.out.println("removed");
             fieldArray.add(0,new ArrayList<>());
             for (int j=0; j<ySize; j++){  //
                 fieldArray.get(0).add("*");
              }
}

}
