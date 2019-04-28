package Tetris;

import java.util.HashMap;

public class LetterLShape extends Shape {

    /**

     *
     *
     * *

     */

    public LetterLShape(String name, ShapeRotation rotation, Position headPosition,  HashMap<Position,Position> positionHashMap){
        super(name, rotation,headPosition, positionHashMap);
    }

    public static StretchedShape createShape(){
        int randomNumber = randomRotation();
        HashMap<Position,Position> positionHashMap = new HashMap<>();
        Position headPosition = null;
        ShapeRotation rotation=null;
        switch (randomNumber){
            case 0:
                for (int i=center-1; i<center+2; i++) {
                    positionHashMap.put(new Position(Field.xStart-1, i), new Position(Field.xStart-1, i));
                }
                positionHashMap.put(new Position(Field.xStart - 2, center+1), new Position(Field.xStart - 2, center+1));

                headPosition=new Position(Field.xStart-1,center-1);
                rotation=ShapeRotation.HORISONTAL;
                break;

            case 1:
                for (int i=Field.xStart-3; i<Field.xStart; i++) {
                    positionHashMap.put(new Position(i, center), new Position(i, center));
                }
                positionHashMap.put(new Position(Field.xStart - 1, center+1), new Position(Field.xStart - 1, center+1));

                headPosition=new Position(Field.xStart-3,center);
                rotation=ShapeRotation.VERTICAL;

                break;
            case 2:
                for (int i=center-1; i<center+2; i++) {
                    positionHashMap.put(new Position(Field.xStart-2, i), new Position(Field.xStart-2, i));
                }
                positionHashMap.put(new Position(Field.xStart - 1, center-1), new Position(Field.xStart - 1, center-1));

                headPosition=new Position(Field.xStart-2,center+1);

                rotation=ShapeRotation.HORISONTALINVERTED;

                break;
            case 3:
                for (int i=Field.xStart-3; i<Field.xStart; i++) {
                    positionHashMap.put(new Position(i, center+1), new Position(i, center+1));
                }
                positionHashMap.put(new Position(Field.xStart - 3, center), new Position(Field.xStart - 3, center));

                headPosition=new Position(Field.xStart-1,center+1);
                rotation=ShapeRotation.VERTICALINVERTED;

                break;
        }
        System.out.println("HEAD: " + headPosition.x + " " + headPosition.y);

        return new StretchedShape("буква л", rotation, headPosition, positionHashMap);
    }




}
