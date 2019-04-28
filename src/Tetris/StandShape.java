package Tetris;

import java.util.HashMap;

public class StandShape extends Shape {
    /**

     *
    ***

 */

    public StandShape(String name, ShapeRotation rotation, Position headPosition,  HashMap<Position,Position> positionHashMap){
        super(name, rotation,headPosition, positionHashMap);
    }


    public static StandShape createShape(){
        int randomNumber = randomRotation();
        HashMap<Position,Position> positionHashMap = new HashMap<>();
        Position headPosition = null;
        ShapeRotation rotation=null;
       // System.out.println("rand: " + randomNumber);
        switch (randomNumber){
            case 0:
                for (int i=center-1; i<center+2; i++) {
                    positionHashMap.put(new Position(Field.xStart - 1, i), new Position(Field.xStart - 1, i));
                }
                positionHashMap.put(new Position(Field.xStart - 2, center), new Position(Field.xStart - 2, center));

                headPosition=new Position(Field.xStart-1,center-1);
                rotation=ShapeRotation.HORISONTAL;

                break;
            case 1:
                for (int i=1; i<Field.xStart; i++){
                    positionHashMap.put(new Position(i, center), new Position(i, center));
                }
                positionHashMap.put(new Position(Field.xStart - 2, center+1), new Position(Field.xStart - 2, center+1));

                headPosition=new Position(1,center);
                rotation=ShapeRotation.VERTICAL;

                break;
            case 2:
                for (int i=center-1; i<center+2; i++) {
                    positionHashMap.put(new Position(Field.xStart - 2, i), new Position(Field.xStart - 2, i));
                }
                positionHashMap.put(new Position(Field.xStart - 1, center), new Position(Field.xStart - 1, center));

                headPosition=new Position(Field.xStart-2,center-1);
                rotation=ShapeRotation.HORISONTALINVERTED;

                break;
            case 3:
                for (int i=1; i<Field.xStart; i++){
                    positionHashMap.put(new Position(i, center+1), new Position(i, center+1));
                }
                positionHashMap.put(new Position(Field.xStart - 2, center), new Position(Field.xStart - 2, center));

                headPosition=new Position(1,center);
                rotation=ShapeRotation.VERTICALINVERTED;

                break;
        } //System.out.println("rand: " + randomNumber);  //TODO ТРОЙКА НЕ РАНДОМИТСЯ ПОЧЕМУ-ТО

      //  System.out.println("HEAD: " + headPosition.x + " " + headPosition.y);
        return new StandShape("такая, типа пьедестал", rotation, headPosition, positionHashMap);
    }
}