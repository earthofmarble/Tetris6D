package Tetris;

import java.io.IOException;
import java.util.HashMap;

public abstract class Shape {           //фигура
        static int center=Field.ySize/2;
        String name;
        ShapeRotation rotation;
        Position headPosition;
        HashMap<Position,Position> positionHashMap;

        public Shape(String name, ShapeRotation rotation,  Position headPosition,  HashMap<Position,Position> positionHashMap){
                this.name=name;
                this.rotation=rotation;
                this.headPosition=headPosition;
                this.positionHashMap=positionHashMap;
        }





        public boolean flipShape(){
            HashMap<Position,Position> tempHashMap = new HashMap<>();
            final boolean[] b = {true};

              positionHashMap.forEach((position, position2) -> {
                  System.out.println("posX: " + position.getX() + " posY OLD: " + position.getY());

                 Position positionTemp = flipPart(headPosition, position);

                 if (positionTemp.getX()<0 || positionTemp.getX()>=Field.fieldArray.size() || positionTemp.getY()<0 || positionTemp.getY()>=Field.fieldArray.get(0).size()){
                     System.out.println("!RETURN!");
                        b[0] =false;
                 }

                 if (b[0]) {
                     this.rotation.flip();
                     System.out.println("NEW X: //  " + positionTemp.getX() + " NEW Y: " + positionTemp.getY());
                     Field.fieldArray.get(position.getX()).set(position.getY(), "*");
                     tempHashMap.put(positionTemp, positionTemp);
                 }
              });

              if (b[0]) {
                  tempHashMap.forEach((position, position2) -> {
                      System.out.println("x: " + position.x + " y: " + position.y);
                  });
                  positionHashMap.clear();
                  positionHashMap = tempHashMap;

                  positionHashMap.forEach((position, position2) -> {
                      System.out.println("posX: " + position.getX() + " posY NEW: " + position.getY());
                      System.out.println("NEW X: " + position.getX() + " NEW Y: " + position.getY() + "size " + positionHashMap.size());
                      Field.fieldArray.get(position.getX()).set(position.getY(), "Ф");
                  });
              }
            return b[0];
        }


        public Position flipPart(Position headPosition, Position pos){
         int tempX;
         int tempY;    //TODO сделать проверку при повороте, не врежется ли фигура после поворота   доделать криэйт остальных фигур



            Position tempPosition = new Position(pos.getX(), pos.getY());


//            System.out.println("headPos: " +headPosition.x + " " +headPosition.y);
//            System.out.println("POSITON: " +pos.x + " " +pos.y);

            tempPosition.x-=headPosition.x;
            tempPosition.y-=headPosition.y;
//            System.out.println("tempPOS: " +tempPosition.x + " " +tempPosition.y);
            tempX = tempPosition.x * 0 + tempPosition.y * 1;
            tempY = -1 * (tempPosition.x*1) + tempPosition.y*0;

//            System.out.println("1 tempX: " + tempX + " tempY: " + tempY);
            tempX+=headPosition.getX();
            tempY+=headPosition.getY();
//            System.out.println("2 tempX: " + tempX + " tempY: " + tempY);

//            if (position.getX()==headPosition.getX() && position.getY()==headPosition.getY()){
//                headPosition.x=tempX;
//                headPosition.y=tempY;
//            }
         return new Position(tempX, tempY);
        }

        boolean move(Direction direction) {
            final boolean[] canMove = new boolean[1];  //??? ! ? почему я не сделал ретурн и всё че это за хрень зачем так усложнять
            canMove[0]=true;
            HashMap<Position,Position> tempHashMap = new HashMap<>();
            positionHashMap.forEach((position, position2) -> {
                Field.fieldArray.get(position.getX()).set(position.getY(), "*");
            });

           move:  switch (direction){

                    case DOWN:
                        this.positionHashMap.forEach((positionA, positionB) -> {
                if (positionA.getX()+1<Field.fieldArray.size()) {
                  //  System.out.println("if1");
                    if (Field.fieldArray.get(positionA.getX() + 1).get(positionA.getY()).equals("Ф") || (positionA.getX() + 1)>=Field.fieldArray.size()) {
//                        System.out.println("checkWipe");
//                        if (checkWipe(positionA.getX())) {
//                            System.out.println("if checkWipe prowel");
//                            Field.wipeLine(positionA.getX());
//                            System.out.println("линия удалена");
//                        }
                        canMove[0] = false;

                    }
                } else{

//                    System.out.println("checkWipe2");
//                    if (checkWipe(positionA.getX())) {
//                        System.out.println("if checkWipe2 prowel");
//                        Field.wipeLine(positionA.getX());
//                        System.out.println("линия удалена!2");
//                    }
                    //System.out.println("if 2");
                    canMove[0] = false;
                }


            });
                        if (canMove[0]){

                            this.positionHashMap.forEach(((position, position2) -> {
                                position.x++;

                                Field.fieldArray.get(position.getX()).set(position.getY(), "Ф");

                             //   System.out.println("checkWipe2");
                                if (checkWipe(position.getX())) {
                               //     System.out.println("if checkWipe2 prowel");
                                    Field.wipeLine(position.getX());
                               //     System.out.println("линия удалена!2");
                                    canMove[0]=false;
                                }

                            }));
                            this.headPosition.x++;
                        } else {

                            this.positionHashMap.forEach(((position, position2) -> {
                                Field.fieldArray.get(position.getX()).set(position.getY(), "Ф");
                            }));
                        }

                        break;

                        /** case left case right*/
                case LEFT:
                    this.positionHashMap.forEach((positionA, positionB) -> {
                        if (positionA.getY()-1>=0) {
                            if (Field.fieldArray.get(positionA.getX()).get(positionA.getY()-1).equals("Ф")) {
                                canMove[0] = false;
                            }
                        } else{
                            canMove[0] = false;
                        }
                    });
                    if (canMove[0]){
                        this.positionHashMap.forEach(((position, position2) -> {
                            position.y--;

                            Field.fieldArray.get(position.getX()).set(position.getY(), "Ф");
                        }));
                        this.headPosition.y--;
                    } else {

                        this.positionHashMap.forEach(((position, position2) -> {
                            Field.fieldArray.get(position.getX()).set(position.getY(), "Ф");
                        }));
                    }

                    break;
                case RIGHT:
                    this.positionHashMap.forEach((positionA, positionB) -> {
                        if (positionA.getY()+1<Field.fieldArray.get(0).size()) {
                            if (Field.fieldArray.get(positionA.getX()).get(positionA.getY()+1).equals("Ф")) {
                                canMove[0] = false;
                            }
                        } else{
                            canMove[0] = false;
                        }
                    });
                    if (canMove[0]){
                        this.positionHashMap.forEach(((position, position2) -> {
                            position.y++;
                            Field.fieldArray.get(position.getX()).set(position.getY(), "Ф");
                        }));
                    this.headPosition.y++;
                    } else {

                        this.positionHashMap.forEach(((position, position2) -> {
                            Field.fieldArray.get(position.getX()).set(position.getY(), "Ф");
                        }));
                    }

                    break;

            }
            try {
                Field.printField();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return canMove[0];
        }

public boolean checkWipe(int x){            // просто сделать на криэйте чек всех линий и удаление тех, что заполнетны

  //  System.out.println("checkwipe voshlo");
            for (int j=0; j<Field.ySize; j++){
             //   System.out.println("Field.fieldArray.get(x).get(j)    " + Field.fieldArray.get(x).get(j));
                if (Field.fieldArray.get(x).get(j).equals("*")){
                  //  System.out.println("check if ");
                    return false;
                }
             //   System.out.println("checkWipe else");
            }
            return true;
}

public void printShape(){
   positionHashMap.forEach((position, position2) -> {
        Field.fieldArray.get(position.getX()).set(position.getY(), "Ф");
    });
}


public static int randomRotation(){
    int random=0;
            g: while (true) {
                random = (int) (Math.random() * 4);  //по-моему должны рандомится 0 1 2 3 и 4 , но когда стояла тройка, она никогда не рандомилась  //TODO дописать дефолт в кейсы полоежния
                if (random!=4){
                    break g;
                }
            }
    return random;
}

    public static int randomShape(){
        int random=0;
        g: while (true) {
            random = (int) (Math.random() * 5);  //по-моему должны рандомится 0 1 2 3 и 4 , но когда стояла тройка, она никогда не рандомилась  //TODO дописать дефолт в кейсы полоежния
            if (random!=5){
                break g;
            }
        }
        return random;
    }

public void move(){

}
}
