package main.java;

import javax.swing.*;
import java.awt.*;

public class GameUI extends JFrame {
    public static final int HEIGHT = 480;
    public static final int WIDTH = 600;
    private Container theContentPane;
    private SnakeGame theGame;
    private JPanel theGamePanel;

    public GameUI() {
        this(new SnakeGame());
    }

    public GameUI(SnakeGame aGame) {
        setDefaults(aGame);
    }

    public void setDefaults(SnakeGame aGame) {
        setTheGame(aGame);
        setTitle("Snake");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theContentPane = this.getContentPane();
        this.getContentPane().setLayout(new BorderLayout());
        setPanels();
    }

    public void setPanels() {
        theGamePanel = new JPanel(new GridLayout(theGame.getRows(), theGame.getCols()));
        theGamePanel.setBackground(Color.black);
        JPanel scorePanel = new JPanel();
        JLabel scoreLabel = new JLabel("Score:    Best Score:   ");
        scoreLabel.setBackground(Color.white);
        scorePanel.add(scoreLabel);
        theContentPane.add(theGamePanel, BorderLayout.CENTER);
        theContentPane.add(scorePanel, BorderLayout.PAGE_START);
    }


    public void setTheGame(SnakeGame game) {
        theGame = game;
    }

    public void setTiles() {
        Tile.setTileSideLength(HEIGHT / theGame.getRows());
        for (int y = 0; y < theGame.getRows(); y++) {
            for (Tile tile : theGame.getGameBoard().get(y)) {
                theGamePanel.add(tile);
            }
        }
    }

    public static void main(String[] args) {
        SnakeGame theGame = new SnakeGame();
        GameUI snakeGameUI = new GameUI(theGame);
        snakeGameUI.setTiles();
        snakeGameUI.setVisible(true);
    }
}
