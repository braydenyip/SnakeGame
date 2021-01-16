package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameUI extends JFrame implements KeyListener {
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
        setFocusable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theContentPane = this.getContentPane();
        theContentPane.setFocusable(true);
        addKeyListener(this);
        this.getContentPane().setLayout(new BorderLayout());
        setPanels();
    }

    public void setPanels() {
        theGamePanel = new JPanel(new GridLayout(theGame.getRows(), theGame.getCols()));
        theGamePanel.setBackground(Color.black);
        theGamePanel.setFocusable(true);
        theGamePanel.requestFocus();
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

    public void displayGameOver() {
        theGamePanel = new JPanel(new FlowLayout());
        theGamePanel.setBackground(Color.black);
        JLabel gameOverLabel = new JLabel("Game Over");
        gameOverLabel.setFont(new Font("SansSerif", Font.PLAIN, 40));
        gameOverLabel.setForeground(new Color(148, 12, 12));
        theGamePanel.add(gameOverLabel);
        theContentPane.add(theGamePanel);
        updateGameUI();
    }

    public void updateGameUI() {
        theGamePanel.updateUI();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            theGame.changeDirection('L');
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            theGame.changeDirection('U');
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            theGame.changeDirection('R');
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            theGame.changeDirection('D');
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //nothing
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //nothing
    }

    public static void main(String[] args) throws InterruptedException {
        SnakeGame theGame = new SnakeGame();
        GameUI snakeGameUI = new GameUI(theGame);
        snakeGameUI.setTiles();
        snakeGameUI.setVisible(true);
        theGame.changeDirection('R');
        while (theGame.moveSnake()) {
            Thread.sleep(150);
            snakeGameUI.updateGameUI();
        }
        snakeGameUI.displayGameOver();
    }
}
