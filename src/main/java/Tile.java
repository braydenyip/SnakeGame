package main.java;

import java.awt.Point;

public class Tile {
    public static final int EMPTY_STATE = 0;
    public static final int SNAKE_STATE = 1;
    public static final int APPLE_STATE = 2;

    private Point location;
    private int state;

    public Tile() {
        this(0, 0);
    }

    public Tile(int x, int y) {
        location = new Point(x, y);
        state = EMPTY_STATE;
    }

    public Tile(int x, int y, int initialState) {
        this(x, y);
        setState(initialState);
    }

    public int getState() {
        return state;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public void setState(int state) {
        this.state = state;
    }

    public boolean hasSnake() {
        return state == SNAKE_STATE;
    }

    public boolean hasApple() {
        return state == APPLE_STATE;
    }

    public boolean isEmpty() {
        return state == EMPTY_STATE;
    }

}
