package Tetris;

import java.util.HashMap;

public class StretchedShape extends Shape {
    /**

     ****

     */

    public StretchedShape(String name, ShapeRotation rotation,  Position headPosition, HashMap<Position,Position> positionHashMap){
        super(name, rotation, headPosition, positionHashMap);
    }



    public static StretchedShape createShape(){                //можно было спавнить дефолтную фигуру, а потом уже ее вращать, в зависимости от рандома, но тогда она не всегда будет по центру
        int randomNumber = randomRotation();
        HashMap<Position,Position> positionHashMap = new HashMap<>();
        Position headPosition = null;
        ShapeRotation rotation = null;
        switch (randomNumber){
            case 0:
                for (int i=center-2; i<center+2; i++) {
                    positionHashMap.put(new Position(Field.xStart - 1, i), new Position(Field.xStart - 1, i));
                }
                headPosition=new Position(Field.xStart-1,center-2);
                rotation=ShapeRotation.HORISONTAL;

                break;
            case 1:
                for (int i=0; i<Field.xStart; i++){
                    positionHashMap.put(new Position(i, center), new Position(i, center));
                }
                headPosition=new Position(0,center);
                rotation=ShapeRotation.VERTICAL;

                break;
            case 2:
                for (int i=center-2; i<center+2; i++) {
                    positionHashMap.put(new Position(Field.xStart - 1, i), new Position(Field.xStart - 1, i));
                }
                headPosition=new Position(Field.xStart-1,center+2);
                rotation=ShapeRotation.HORISONTALINVERTED;

                break;
            case 3:
                for (int i=0; i<Field.xStart; i++){
                    positionHashMap.put(new Position(i, center), new Position(i, center));
                }
                headPosition=new Position(Field.xStart-1,center);
                rotation=ShapeRotation.VERTICALINVERTED;

                break;
        }
      //  System.out.println("HEAD: " + headPosition.x + " " + headPosition.y);

        return new StretchedShape("длинная", rotation, headPosition, positionHashMap);
    }


}