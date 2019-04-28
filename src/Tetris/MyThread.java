package Tetris;

public class MyThread implements Runnable {

    private Shape shape;// параметр
    public MyThread(Shape shape) {      // через конструтор передадим параметр
        // передаём в конструктор все параметры, которые могут пигодится потоку
        this.shape=shape; // сохраняем параметры как поля
    }

    public void run() {
        while (Controller.running.get()) {
           Field.startGame();
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}