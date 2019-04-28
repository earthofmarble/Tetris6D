package Tetris;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    /** ЕСЛИ ВСЁ ПОДЧЕРКНУТО КРАСНЫМ - ЭТО НЕ ПРАВДА, ПОСЛЕ ОТКАТА ЧЕРЕЗ ИСТОРИЮ ОНО ПРИТВОРЯЕТСЯ, НО ВСЕ РАБОТАЕТ(НУ... КАК ВСЁ)))) ЧТО ДОЛЖНО РАБОТАТЬ - РАБОТАЕТ
     *  Я РЕАЛИЗОВАЛ НЕ ВСЕ ФИГУРЫ, ИНОГДА ИХ МОЖНО УСПЕТЬ ПОДВИНУТЬ ПОСЛЕ ПРИЗЕМЛЕНИЯ, ЛИНИЯ НЕ ВСЕГДА ПРАВИЛЬНО ВАЙПАЕТСЯ
     *  НУ, И РАЗУМЕЕТСЯ, С ПОТОКАМИ У МЕНЯ ПОКА НЕ ОЧЕНЬ :) ОЧЕНЬ НЕ ОЧЕНЬ
     *  НО ЗАДАЧА БЫЛА РАЗОБРАТЬСЯ С ПОВОРОТОМ ФИГУРЫ, И ТУТ ВСЕ СУПЕР
     *  К ЭТОЙ ПРОГРАММЕ КОММЕНТАРИИ Я ДАЖЕ НЕ ПИСАЛ, ПОТОМУ ЧТО ТУТ ВСЕ ТАК ХРЕНОВО, АПАВПВАПВАПВАП, НЕ ХОЧУ ДАЖЕ СМОТРЕТЬ*/



    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Tetris Controller");
        primaryStage.setScene(new Scene(root, 412, 112));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
