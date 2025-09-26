package org.example.domain.model;

public class Car {
    private int position;

    public Car(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public boolean isCollidingWith(Chicken chicken) {
        return chicken.getPosition() == this.position;
    }
}
