package Tetris;

public class MyThread2 implements Runnable {

    private Direction direction;
    public MyThread2(Direction direction) {
        this.direction=direction;
    }

    public void run() {

          Controller.shape[0].move(direction);


    }

}