package top.bluesword.laboratory;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author 李林峰
 */
public class HelloFx extends Application {

    @Override
    public void start(Stage stage) {
        Scene scene = new Controller().webScene();
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}