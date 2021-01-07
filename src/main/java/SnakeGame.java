package main.java;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SnakeGame {

    public static final int DEFAULT_ROWS = 20;
    public static final int DEFAULT_COLS = 25;

    private int rows;
    private int cols;
    private Snake snake;
    private List<List<Tile>> gameBoard;
    private Random random;

    public SnakeGame() {
        this(DEFAULT_ROWS, DEFAULT_COLS);
    }

    public SnakeGame(int gmRows, int gmCols) {
        rows = gmRows;
        cols = gmCols;
        random = new Random();
        gameBoard = new ArrayList<>();
        for (int y = 0; y < rows; y++) {
            List<Tile> row = new ArrayList<>();
            for (int x = 0; x < cols; x++) {
                row.add(new Tile(x, y));
            }
            gameBoard.add(row);
        }
        Point firstApple = generateApple();
        if (firstApple.equals(new Point(rows / 2, cols / 2))) {
            snake = new Snake(gameBoard.get((rows / 2) - 1).get((cols / 2) - 1), gameBoard);
        } else {
            snake = new Snake(gameBoard.get(rows / 2).get(cols / 2), gameBoard);
        }
    }

    public Point generateApple() {
        int x = random.nextInt(cols);
        int y = random.nextInt(rows);
        gameBoard.get(y).get(x).setState(Tile.APPLE_STATE);
        return(new Point(x, y));
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
