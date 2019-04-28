package Tetris;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;

import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    public  Button leftButton;

    @FXML
    public  Button rightButton;

    @FXML
    public  Button flipButton;




    //TODO не дописаны остальные фигуры, но это не важно


    static boolean gameOver=false;
    public static final Shape[] shape = {null};
    static Thread move;
    static Thread move2;
    static Thread flip;
    static final AtomicBoolean running = new AtomicBoolean(false);
    static final AtomicBoolean running2 = new AtomicBoolean(false);
    static final AtomicBoolean running3 = new AtomicBoolean(false);

    @FXML

    void initialize() {

        Runnable first = new MyThread(Controller.shape[0]);
        move =  new Thread(first);
        Field.createField();
        start();

        leftButton.setOnAction(event -> {
            if (!gameOver) {
                start2(Direction.LEFT);
            } else System.out.println("Игра окончена");
        });
       rightButton.setOnAction(event -> {
           if (!gameOver) {
               start2(Direction.RIGHT);
           } else System.out.println("Игра окончена");
        });
        flipButton.setOnAction(event -> {
            if (!gameOver) {
                start3();
            } else System.out.println("Игра окончена");
        });


//        System.out.println("GAME OVER");


    }
    private void start3(){
        if (!gameOver) {
            Runnable r3 = new MyThread3();
            flip = new Thread(r3);
            running3.set(true);
            flip.start();
        } else System.out.println("конец");

    }


    private void start2(Direction direction){
        if (!gameOver) {
            Runnable r2 = new MyThread2(direction);
            move2 = new Thread(r2);
            running2.set(true);
            move2.start();
        } else System.out.println("конец");

    }

    private void start() {
        if (!gameOver) {
            Runnable r = new MyThread(Controller.shape[0]);
            move.stop();
            move = new Thread(r);
            running.set(true);
            move.start();
        } else System.out.println("конец");

    }


}
