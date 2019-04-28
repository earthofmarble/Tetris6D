package Tetris;

import java.util.HashMap;

public class SquareShape extends Shape {

    /**

     **
     **

     */

    public SquareShape(String name, ShapeRotation rotation, Position headPosition,  HashMap<Position,Position> positionHashMap){
        super(name, rotation,headPosition, positionHashMap);
    }


    public static SquareShape createShape(){// ЭТО КВАДРАТ
        HashMap<Position,Position> positionHashMap = new HashMap<>();
        Position headPosition = null;
                positionHashMap.put(new Position(Field.xStart - 1, center), new Position(Field.xStart - 1, center));
                positionHashMap.put(new Position(Field.xStart - 1, center+1), new Position(Field.xStart - 1, center+1));
                positionHashMap.put(new Position(Field.xStart - 2, center), new Position(Field.xStart - 2, center));
                positionHashMap.put(new Position(Field.xStart - 2, center+1), new Position(Field.xStart - 2, center+1));

                headPosition=new Position(Field.xStart-1,center);
        System.out.println("HEAD: " + headPosition.x + " " + headPosition.y);

        return new SquareShape("квадрат", ShapeRotation.HORISONTAL, headPosition, positionHashMap);
    }

}
