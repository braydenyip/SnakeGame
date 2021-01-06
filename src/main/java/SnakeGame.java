package main.java;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SnakeGame {

    public static final int DEFAULT_ROWS = 20;
    public static final int DEFAULT_COLS = 25;

    private int rows;
    private int cols;
    private Snake snake;
    private List<List<Tile>> gameBoard;

    public SnakeGame() {
        this(DEFAULT_ROWS, DEFAULT_COLS);
    }

    public SnakeGame(int gmRows, int gmCols) {
        rows = gmRows;
        cols = gmCols;
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

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public List<List<Tile>> getGameBoard() {
        return gameBoard;
    }

    public Tile getTile(int x, int y) {
        return (gameBoard.get(y).get(x));
    }

}
