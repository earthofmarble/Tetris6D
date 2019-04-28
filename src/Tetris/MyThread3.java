package Tetris;

public class MyThread3 implements Runnable {


    public void run() {

          boolean buf = Controller.shape[0].flipShape();

          if (buf) {
              System.out.println("!123!@");
          }

    }

}