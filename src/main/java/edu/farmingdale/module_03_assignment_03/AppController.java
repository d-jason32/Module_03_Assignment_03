package edu.farmingdale.module_03_assignment_03;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

public class AppController {

    public final static int JUMP = 20;
    @FXML
    private Button autoRobot2;

    @FXML
    private Button autoRobotButton;

    @FXML
    private ImageView movingImage;

    @FXML
    private ImageView movingImage1;

    @FXML
    private Button restartButton1;

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

    @FXML
    void restart1(ActionEvent event) {
        movingImage.setY(0);
        movingImage.setX(0);
    }
    @FXML
    void restart2(ActionEvent event) {
        movingImage1.setY(0);
        movingImage1.setX(0);
    }

    /**
     * @author Jason Devaraj
     */
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

    /**
     * @author Obye Shaji
     */
    @FXML
    public void autoRobot1() {
        movingImage.setY(0);
        movingImage.setX(0);

        System.out.println("AutoSolve button pressed");
        final String path = "RRUUUUUUUURRRRRRRRRRRRRRRRUUUURRRRDDDDDDDDDDDDDDDDRRRRUU" +
                "UUUUUURRRRRRRRUUUUUUUURRRRRDDDDDDDDDDRRR";
        Timeline timeline = new Timeline();
        timeline.setCycleCount(1);
        for (int i = 0; i < path.length(); i++) {
            final int index = i;
            KeyFrame keyFrame = new KeyFrame(
                    Duration.millis(100 * (i + 1)),
                    new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e) {
                            char move = path.charAt(index);
                            System.out.println("Step " + (index + 1) + ": " + move);
                            switch (move) {
                                case 'R':
                                    movingImage.setX(movingImage.getX() + JUMP);
                                    break;
                                case 'L':
                                    movingImage.setX(movingImage.getX() - JUMP);
                                    break;
                                case 'U':
                                    movingImage.setY(movingImage.getY() - JUMP);
                                    break;
                                case 'D':
                                    movingImage.setY(movingImage.getY() + JUMP);
                                    break;
                                default:
                                    System.out.println("Unknown move: " + move);
                                    break;
                            }
                        }
                    }
            );
            timeline.getKeyFrames().add(keyFrame);
        }
        timeline.play();

    }
    /**
     * @author Obye Shaji
     */
    @FXML
    public void autoRobot2() {
        movingImage1.setY(0);
        movingImage1.setX(0);
        System.out.println("AutoSolve Maze 2 button pressed");
        final String path = "DDDDDDDDDDDDDDDDDDDDDRRRRRRRRRRRRRUUUUUUUUUUUUURRRRRRRR" +
                "RRRRUUUUUUUUUUURRRRRRRRRRDDDDDDDDDDDDDDDDDDDDDDDDD";
        Timeline timeline = new Timeline();
        timeline.setCycleCount(1);
        for (int i = 0; i < path.length(); i++) {
            final int index = i;
            KeyFrame keyFrame = new KeyFrame(
                    Duration.millis(100 * (i + 1)),
                    new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e) {
                            char move = path.charAt(index);
                            System.out.println("Maze 2 Step " + (index + 1) + ": " + move);
                            switch (move) {
                                case 'R':
                                    movingImage1.setX(movingImage1.getX() + JUMP);
                                    break;
                                case 'L':
                                    movingImage1.setX(movingImage1.getX() - JUMP);
                                    break;
                                case 'U':
                                    movingImage1.setY(movingImage1.getY() - JUMP);
                                    break;
                                case 'D':
                                    movingImage1.setY(movingImage1.getY() + JUMP);
                                    break;
                                default:
                                    System.out.println("Unknown move: " + move);
                                    break;
                            }
                        }
                    }
            );
            timeline.getKeyFrames().add(keyFrame);
        }
        timeline.play();
    }
}