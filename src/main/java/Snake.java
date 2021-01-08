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
        Tile nextTile;
        if (direction == 'L') {
            nextTile = matrix.get(removed.getYCoord()).get(removed.getXCoord() - 1);
            if (nextTile.hasApple()) {
                addTailSegment(removed);
            }
            snakeTiles.addFirst(nextTile);
            snakeTiles.peekFirst().setState(Tile.SNAKE_STATE);
        } else if (direction == 'R') {
            nextTile = matrix.get(removed.getYCoord()).get(removed.getXCoord() + 1);
            if (nextTile.hasApple()) {
                addTailSegment(removed);
            }
            snakeTiles.addFirst(nextTile);
            snakeTiles.peekFirst().setState(Tile.SNAKE_STATE);
        } else if (direction == 'U') {
            nextTile = matrix.get(removed.getYCoord() - 1).get(removed.getXCoord());
            if (nextTile.hasApple()) {
                addTailSegment(removed);
            }
            snakeTiles.addFirst(nextTile);
            snakeTiles.peekFirst().setState(Tile.SNAKE_STATE);
        } else {
            nextTile = matrix.get(removed.getYCoord() + 1).get(removed.getXCoord());
            if (nextTile.hasApple()) {
                addTailSegment(removed);
            }
            snakeTiles.addFirst(nextTile);
            snakeTiles.peekFirst().setState(Tile.SNAKE_STATE);
        }
    }

    public void addTailSegment(Tile seg) {
        seg.setState(Tile.SNAKE_STATE);
        snakeTiles.addLast(seg);
    }

    public void addSegment(Tile seg) {
        seg.setState(Tile.SNAKE_STATE);
        snakeTiles.addFirst(seg);
    }
}
