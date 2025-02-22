package edu.farmingdale.module_03_assignment_03;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
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

    // Flags to track whether the current image is a car.
    private boolean isCar1 = false;
    private boolean isCar2 = false;

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

    // Switch methods for Maze 1
    @FXML
    void switchRobot1(ActionEvent event) {
        movingImage.setImage(new Image(getClass().getResourceAsStream("robot.png")));
        isCar1 = false; // robot mode
        // Ensure default orientation for robot.
        movingImage.setScaleX(1);
    }

    @FXML
    void switchCar1(ActionEvent event) {
        movingImage.setImage(new Image(getClass().getResourceAsStream("car.png")));
        isCar1 = true;  // car mode
        // Ensure default (right-facing) orientation for car.
        movingImage.setScaleX(1);
    }

    // Switch methods for Maze 2
    @FXML
    void switchRobot2(ActionEvent event) {
        movingImage1.setImage(new Image(getClass().getResourceAsStream("robot.png")));
        isCar2 = false; // robot mode
        movingImage1.setScaleX(1);
    }

    @FXML
    void switchCar2(ActionEvent event) {
        movingImage1.setImage(new Image(getClass().getResourceAsStream("car.png")));
        isCar2 = true;  // car mode
        movingImage1.setScaleX(1);
    }

    /**
     * Helper method to adjust the orientation for car key events.
     * Since the car image naturally faces right:
     * - RIGHT: no change (scaleX = 1, rotation = 0)
     * - LEFT: mirror horizontally (scaleX = -1, rotation = 0)
     * - UP: rotate upward (rotation = 270) with no mirror (scaleX = 1)
     * - DOWN: rotate downward (rotation = 90) with no mirror (scaleX = 1)
     */
    private void adjustCarOrientationForKey(ImageView car, KeyEvent event) {
        KeyCode code = event.getCode();
        switch(code) {
            case UP:
                car.setRotate(270);
                car.setScaleX(1);
                break;
            case RIGHT:
                car.setRotate(0);
                car.setScaleX(1);
                break;
            case DOWN:
                car.setRotate(90);
                car.setScaleX(1);
                break;
            case LEFT:
                car.setRotate(0);  // rotation remains 0 when mirrored
                car.setScaleX(-1); // mirror horizontally so it faces left
                break;
            default:
                break;
        }
    }

    /**
     * Helper method to adjust the orientation for car moves.
     * The logic is similar to the key event adjustment.
     */
    private void adjustCarOrientationForMove(ImageView car, char move) {
        switch(move) {
            case 'U':
                car.setRotate(270);
                car.setScaleX(1);
                break;
            case 'R':
                car.setRotate(0);
                car.setScaleX(1);
                break;
            case 'D':
                car.setRotate(90);
                car.setScaleX(1);
                break;
            case 'L':
                car.setRotate(0);
                car.setScaleX(-1);
                break;
            default:
                break;
        }
    }

    /**
     * Process key presses.
     */
    public void processKeyPress(KeyEvent event)
    {
        System.out.println("Key pressed: " + event.getCode());
        switch (event.getCode())
        {
            case UP:
                movingImage.setY(movingImage.getY() - JUMP);
                movingImage1.setY(movingImage1.getY() - JUMP);
                // For robot, face upwards (0 degrees rotation)
                movingImage.setRotate(0);
                movingImage1.setRotate(0);
                break;

            case DOWN:
                movingImage.setY(movingImage.getY() + JUMP);
                movingImage1.setY(movingImage1.getY() + JUMP);
                // For robot, face downwards (180 degrees rotation)
                movingImage.setRotate(180);
                movingImage1.setRotate(180);
                break;

            case RIGHT:
                movingImage.setX(movingImage.getX() + JUMP);
                movingImage1.setX(movingImage1.getX() + JUMP);
                // For robot, face right (90 degrees rotation)
                movingImage.setRotate(90);
                movingImage1.setRotate(90);
                break;

            case LEFT:
                movingImage.setX(movingImage.getX() - JUMP);
                movingImage1.setX(movingImage1.getX() - JUMP);
                // For robot, face left (270 degrees rotation)
                movingImage.setRotate(270);
                movingImage1.setRotate(270);
                break;
            default:
                break;
        }
        // Apply separate orientation for car versus robot.
        if (isCar1) {
            adjustCarOrientationForKey(movingImage, event);
        } else {
            // For robot, we use the default rotations already set.
            movingImage.setScaleX(1);
        }
        if (isCar2) {
            adjustCarOrientationForKey(movingImage1, event);
        } else {
            movingImage1.setScaleX(1);
        }
        event.consume();
    }

    /**
     * Auto-solve Maze 1.
     */
    @FXML
    public void autoRobot1() {
        movingImage.setY(0);
        movingImage.setX(0);

        System.out.println("AutoSolve button pressed");
        final String path = "RRUUUUUUUURRRRRRRRRRRRRRRRUUUURRRRDDDDDDDDDDDDDDDDRRRRUU" +
                "UUUUUURRRRRRRRUUUUUUUURRRRRDDDDDDDDDDRRRR";
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
                                    movingImage.setRotate(90);
                                    break;

                                case 'L':
                                    movingImage.setX(movingImage.getX() - JUMP);
                                    movingImage.setRotate(270);
                                    break;

                                case 'U':
                                    movingImage.setY(movingImage.getY() - JUMP);
                                    movingImage.setRotate(0);
                                    break;

                                case 'D':
                                    movingImage.setY(movingImage.getY() + JUMP);
                                    movingImage.setRotate(180);
                                    break;

                                default:
                                    System.out.println("Unknown move: " + move);
                                    break;
                            }
                            // If the image is a car, adjust its orientation based on the move.
                            if (isCar1) {
                                adjustCarOrientationForMove(movingImage, move);
                            } else {
                                movingImage.setScaleX(1);
                            }
                        }
                    }
            );
            timeline.getKeyFrames().add(keyFrame);
        }
        timeline.play();
    }

    /**
     * Auto-solve Maze 2.
     */
    @FXML
    public void autoRobot2() {
        movingImage1.setY(0);
        movingImage1.setX(0);
        System.out.println("AutoSolve Maze 2 button pressed");
        final String path = "DDDDDDDDDDDDDDDDDDDDDRRRRRRRRRRRRRUUUUUUUUUUUUURRRRRRRR" +
                "RRRRUUUUUUUUUUURRRRRRRRRRDDDDDDDDDDDDDDDDDDDDDDDDDDD";
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
                                    movingImage1.setRotate(90);
                                    break;

                                case 'L':
                                    movingImage1.setX(movingImage1.getX() - JUMP);
                                    movingImage1.setRotate(270);
                                    break;

                                case 'U':
                                    movingImage1.setY(movingImage1.getY() - JUMP);
                                    movingImage1.setRotate(0);
                                    break;

                                case 'D':
                                    movingImage1.setY(movingImage1.getY() + JUMP);
                                    movingImage1.setRotate(180);
                                    break;
                                default:
                                    System.out.println("Unknown move: " + move);
                                    break;
                            }
                            if (isCar2) {
                                adjustCarOrientationForMove(movingImage1, move);
                            } else {
                                movingImage1.setScaleX(1);
                            }
                        }
                    }
            );
            timeline.getKeyFrames().add(keyFrame);
        }
        timeline.play();
    }
}
