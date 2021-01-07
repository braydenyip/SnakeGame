package main.java;

import javax.swing.*;
import java.awt.*;

public class Tile extends JComponent {
    public static final int EMPTY_STATE = 0;
    public static final int SNAKE_STATE = 1;
    public static final int APPLE_STATE = 2;

    private static int tileSideLength = 30;

    private Point location;
    private int state;

    public Tile() {
        this(0, 0);
    }

    public Tile(int x, int y) {
        location = new Point(x, y);
        state = EMPTY_STATE;
    }

    public int getState() {
        return state;
    }

    public Color getColour() {
        if (state == SNAKE_STATE) {
            return Color.yellow;
        } else if (state == APPLE_STATE) {
            return Color.red;
        } else {
            return Color.black;
        }
    }

    public int getXCoord() {
        return (int) location.getX();
    }

    public int getYCoord() {
        return (int) location.getY();
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

    public static void setTileSideLength(int newLength) {
        tileSideLength = newLength;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(getColour());
        Rectangle rect = new Rectangle(0, 0, tileSideLength, tileSideLength);
        g2.fill(rect);
        g2.draw(rect);
    }
}
