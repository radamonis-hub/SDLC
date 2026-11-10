package by.bsuir.glycemicindex;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        MainController controller = new MainController(primaryStage);
        controller.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}