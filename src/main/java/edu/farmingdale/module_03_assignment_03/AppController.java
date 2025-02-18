package edu.farmingdale.module_03_assignment_03;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

public class AppController {

    public final static int JUMP = 10;
    @FXML
    private ImageView movingImage;
    @FXML
    private ImageView movingImage1;


    public void processKeyPress(KeyEvent event)
    {
        System.out.println("Key pressed: " + event.getCode());
        switch (event.getCode())
        {
            case UP:
                movingImage.setY(movingImage.getY() - JUMP);
                movingImage1.setY(movingImage1.getY() - JUMP);
                // Face upwards (0 degrees rotation)
                movingImage.setRotate(0);
                movingImage1.setRotate(0);
                break;

            case DOWN:
                movingImage.setY(movingImage.getY() + JUMP);
                movingImage1.setY(movingImage1.getY() + JUMP);
                // Face downwards (180 degrees rotation)
                movingImage.setRotate(180);
                movingImage1.setRotate(180);
                break;

            case RIGHT:
                movingImage.setX(movingImage.getX() + JUMP);
                movingImage1.setX(movingImage1.getX() + JUMP);
                // Face right (90 degrees rotation)
                movingImage.setRotate(90);
                movingImage1.setRotate(90);
                break;

            case LEFT:
                movingImage.setX(movingImage.getX() - JUMP);
                movingImage1.setX(movingImage1.getX() - JUMP);
                // Face left (270 degrees rotation)
                movingImage.setRotate(270);
                movingImage1.setRotate(270);
                break;

            default:
                break; // do nothing if it's not an arrow key
        }
        event.consume();

    }
}