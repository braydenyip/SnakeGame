package main.java;

import java.util.PriorityQueue;
import java.util.Queue;

public class Snake {

    Queue<Tile> linkedSnake = new PriorityQueue<>();

    public Snake(Tile head) {
        if (head.hasSnake()) {
            addSegment(head);
        }
    }

    public int getScore() {
        return linkedSnake.size();
    }

    public Tile getHead() {
        return linkedSnake.peek();
    }

    public void addSegment(Tile seg) {
        seg.setState(Tile.SNAKE_STATE);
        linkedSnake.add(seg);
    }
}
