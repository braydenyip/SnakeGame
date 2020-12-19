package main.java;

import javax.swing.*;
import java.awt.*;

public class GameUI extends JFrame {
    public static final int HEIGHT = 600;
    public static final int WIDTH = 1000;
    private Container theContentPane;
    private SnakeGame theGame;

    public GameUI() {
        setDefaults();
    }

    public void setDefaults() {
        setTitle("Snake");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theContentPane = this.getContentPane();
        this.getContentPane().setLayout(new BorderLayout());
        setPanels();
    }

    public void setPanels() {
        JPanel gamePanel = new JPanel();
        gamePanel.setBackground(Color.black);
        JPanel scorePanel = new JPanel();
        JLabel scoreLabel = new JLabel("Score:    Best Score:   ");
        scoreLabel.setBackground(Color.white);
        scorePanel.add(scoreLabel);
        theContentPane.add(gamePanel, BorderLayout.CENTER);
        theContentPane.add(scorePanel, BorderLayout.PAGE_START);
    }

    public void setTheGame(SnakeGame gm) {
        theGame = gm;
    }

    public static void main(String[] args) {
        GameUI snakeGameUI = new GameUI();
        SnakeGame theGame = new SnakeGame();
        snakeGameUI.setTheGame(theGame);
        snakeGameUI.setVisible(true);
    }
}
