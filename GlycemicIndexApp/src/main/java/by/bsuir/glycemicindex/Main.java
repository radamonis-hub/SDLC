package by.bsuir.glycemicindex;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Гликемический индекс продуктов");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}