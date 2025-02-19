package edu.farmingdale.module_03_assignment_03;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

public class AppController {

    public final static int JUMP = 20;
    @FXML
    private Button autoCar1;

    @FXML
    private Button autoCar2;

    @FXML
    private Button autoRobot1;

    @FXML
    private Button autoRobot2;

    @FXML
    public ImageView movingImage;

    @FXML
    private ImageView movingImage1;

    @FXML
    public Button restartButton1;

    @FXML
    private Button restartButton2;

    @FXML
    private Button switchCar1;

    @FXML
    private Button switchCar2;

    @FXML
    private Button switchRobot1;

    @FXML
    private Button switchRobot2;


    public void processKeyPress(KeyEvent event)
    {
        System.out.println("Key pressed: " + event.getCode());
        switch (event.getCode())
        {
            case UP:
                movingImage.setY(movingImage.getY() - JUMP);
                movingImage1.setY(movingImage1.getY() - JUMP);

                break;
            case DOWN:
                movingImage.setY(movingImage.getY() + JUMP);
                movingImage1.setY(movingImage1.getY() + JUMP);

                break;
            case RIGHT:
                movingImage.setX(movingImage.getX() + JUMP);
                movingImage1.setX(movingImage1.getX() + JUMP);

                break;
            case LEFT:
                movingImage.setX(movingImage.getX() - JUMP);
                movingImage1.setX(movingImage1.getX() - JUMP);

                break;
            default:
                break; // do nothing if it's not an arrow key
        }
        event.consume();

    }
}