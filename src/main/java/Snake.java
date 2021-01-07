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
            if (snakeTiles.getFirst().getXCoord() <= 0) {
                return false;
            } else {
                changeTiles();
                return true;
            }
        } else if (direction == 'R') {
            if (snakeTiles.getFirst().getXCoord() >= (SnakeGame.DEFAULT_COLS - 1)) {
                return false;
            } else {
                changeTiles();
                return true;
            }
        } else if (direction == 'U') {
            if (snakeTiles.getFirst().getYCoord() <= 0) {
                return false;
            } else {
                changeTiles();
                return true;
            }
        } else if (direction == 'D') {
            if (snakeTiles.getFirst().getYCoord() >= (SnakeGame.DEFAULT_ROWS - 1)) {
                return false;
            } else {
                changeTiles();
                return true;
            }
        }
        return true;
    }

    public void changeTiles() {
        Tile removed = snakeTiles.removeLast();
        removed.setState(Tile.EMPTY_STATE);
        if (direction == 'L') {
            snakeTiles.addFirst(matrix.get(removed.getYCoord()).get(removed.getXCoord() - 1));
            snakeTiles.peekFirst().setState(Tile.SNAKE_STATE);
        } else if (direction == 'R') {
            snakeTiles.addFirst(matrix.get(removed.getYCoord()).get(removed.getXCoord() + 1));
            snakeTiles.peekFirst().setState(Tile.SNAKE_STATE);
        } else if (direction == 'U') {
            snakeTiles.addFirst(matrix.get(removed.getYCoord() - 1).get(removed.getXCoord()));
            snakeTiles.peekFirst().setState(Tile.SNAKE_STATE);
        } else {
            snakeTiles.addFirst(matrix.get(removed.getYCoord() + 1).get(removed.getXCoord()));
            snakeTiles.peekFirst().setState(Tile.SNAKE_STATE);
        }
    }

    public void addSegment(Tile seg) {
        seg.setState(Tile.SNAKE_STATE);
        snakeTiles.addFirst(seg);
    }
}
