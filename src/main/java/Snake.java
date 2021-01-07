package main.java;

import java.util.*;

public class Snake {

    Character direction;
    Deque<Tile> snakeTiles = new ArrayDeque<>();
    List<List<Tile>> matrix;

    public Snake(Tile head, List<List<Tile>> mat) {
        addSegment(head);
        matrix = mat;
        direction = '-';
    }

    public void setDirection(Character newDirection) {
        direction = newDirection;
    }

    public boolean move() {
        if (direction == 'L') {
            if (snakeTiles.getFirst().getXTile() <= 0) {
                return false;
            } else {

            }
        } else if (direction == 'R') {
            if (snakeTiles.getFirst().getXTile() >= (SnakeGame.DEFAULT_COLS - 1)) {
                return false;
            } else {

            }
        } else if (direction == 'U') {
            if (snakeTiles.getFirst().getYTile() <= 0) {
                return false;
            } else {

            }
        } else if (direction == 'D') {
            if (snakeTiles.getFirst().getYTile() >= (SnakeGame.DEFAULT_ROWS - 1)) {
                return false;
            } else {

            }
        }
        return true;
    }

    public void addSegment(Tile seg) {
        seg.setState(Tile.SNAKE_STATE);
        snakeTiles.addFirst(seg);
    }
}
