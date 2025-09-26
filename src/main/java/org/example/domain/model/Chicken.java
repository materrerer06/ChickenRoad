package org.example.domain.model;

import lombok.Getter;

@Getter

public class Chicken {

    private int position;
    private boolean isAlive;

    public Chicken() {
        this.position = 0;
        this.isAlive = true;
    }

    public void move() {
        if (isAlive) {
            position++;
            System.out.println("Kurczak ruszył do przodu, aktualna pozycja: " + position);
        }
    }

    public void die() {
        isAlive = false;
        System.out.println("Kurczak zginął!");
    }

    public boolean isAlive() {
        return isAlive;
    }
}
