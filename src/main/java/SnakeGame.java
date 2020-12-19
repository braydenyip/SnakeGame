package main.java;

import java.util.ArrayList;
import java.util.List;

public class SnakeGame {

    public static final int DEFAULT_ROWS = 10;
    public static final int DEFAULT_COLS = 20;
    private Snake snake;
    private List<List<Tile>> gameBoard;

    public SnakeGame() {
        this(DEFAULT_ROWS, DEFAULT_COLS);
    }

    public SnakeGame(int rows, int cols) {
        gameBoard = new ArrayList<>();
        for (int y = 0; y < rows; y++) {
            List<Tile> row = new ArrayList<>();
            for (int x = 0; x < cols; x++) {
                row.add(new Tile(x, y));
            }
            gameBoard.add(row);
        }
        snake = new Snake(gameBoard.get(rows / 2).get(cols / 2));
    }

    public Tile getTile(int x, int y) {
        return (gameBoard.get(y).get(x));
    }

    public int getTileState(int x, int y) {
        return getTile(x, y).getState();
    }

}
