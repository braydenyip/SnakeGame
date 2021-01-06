package main.java;

import java.util.ArrayDeque;
import java.util.Deque;

public class Snake {

    Deque<Tile> linkedSnake = new ArrayDeque<>();
    Character direction;

    public Snake(Tile head) {
        addSegment(head);
        direction = '-';
    }

    public int getScore() {
        return linkedSnake.size();
    }

    public Tile getHead() {
        return linkedSnake.peekFirst();
    }

    public void setDirection(Character newDirection) {
        direction = newDirection;
    }
    public void addSegment(Tile seg) {
        seg.setState(Tile.SNAKE_STATE);
        linkedSnake.addLast(seg);
    }
}
