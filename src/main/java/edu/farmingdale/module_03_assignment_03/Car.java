package edu.farmingdale.module_03_assignment_03;

import javafx.scene.image.Image;

public class Car {

    private Image image;

    public Car(){
        this.image = new Image(Car.class.getResourceAsStream("car.png"));
    }

    public Image getImage(){
        return image;
    }
}
