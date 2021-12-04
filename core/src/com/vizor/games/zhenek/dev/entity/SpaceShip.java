package com.vizor.games.zhenek.dev.entity;

import java.util.Objects;

public class SpaceShip {
    private float x,y;

    public SpaceShip(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SpaceShip)) return false;
        SpaceShip spaceShip = (SpaceShip) o;
        return Float.compare(spaceShip.getX(), getX()) == 0 && Float.compare(spaceShip.getY(), getY()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    @Override
    public String toString() {
        return "SpaceShip{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
