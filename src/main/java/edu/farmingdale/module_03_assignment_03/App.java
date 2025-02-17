package edu.farmingdale.module_03_assignment_03;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.image.ImageView;

public class App extends Application
{


    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1100, 800);


        AppController controller = fxmlLoader.getController();

        primaryStage.setTitle("Robot");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode().isArrowKey()) {
                event.consume();
                controller.processKeyPress(event);
            }
        });

        scene.setOnKeyPressed(controller::processKeyPress);



    }
    public static void main(String[] args) {
        launch();
    }



}


