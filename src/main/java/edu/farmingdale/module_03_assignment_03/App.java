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
    public final static int JUMP = 10;
    @FXML
    private ImageView robotImage;

    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1100, 800);

        App controller = fxmlLoader.getController();
        scene.setOnKeyPressed(controller::processKeyPress);



        primaryStage.setTitle("Robot");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch();
    }

    public void processKeyPress(KeyEvent event)
    {
        switch (event.getCode())
        {
            case UP:
                robotImage.setY(robotImage.getY() - JUMP);
                break;
            case DOWN:
                robotImage.setY(robotImage.getY() + JUMP);
                break;
            case RIGHT:
                robotImage.setX(robotImage.getX() + JUMP);
                break;
            case LEFT:
                robotImage.setX(robotImage.getX() - JUMP);
                break;
            default:
                break; // do nothing if it's not an arrow key
        }
    }

}


