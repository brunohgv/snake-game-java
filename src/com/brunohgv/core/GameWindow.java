package com.brunohgv.core;

import com.brunohgv.utils.Constants;
import com.brunohgv.graphics.Renderer;
import com.brunohgv.scene.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameWindow extends JFrame implements KeyListener {
    private Renderer renderer;
    private KeyEvent pressedKey;
    private Snake snake;
    private Image imageBuffer;
    private Graphics gImage;
    private Rectangle drawingArea;

    public GameWindow(Snake snake) {
        this.snake = snake;
        this.renderer = new Renderer();

        setTitle(Constants.GAME_TITLE);
        setSize(Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        addKeyListener(this);
        setVisible(true);

        imageBuffer = this.createImage(Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
        gImage = this.imageBuffer.getGraphics();

        this.defineDrawingArea();
    }

    private void defineDrawingArea() {
        int paddingY = Constants.GAME_HEIGHT - (int) getContentPane().getSize().getHeight();
        drawingArea = new Rectangle(0, paddingY, Constants.GAME_WIDTH, Constants.GAME_HEIGHT - paddingY);
    }

    public void keyPressed(KeyEvent event) {
        switch (event.getKeyCode()) {
            case KeyEvent.VK_UP:
                this.snake.up();
                break;
            case KeyEvent.VK_DOWN:
                this.snake.down();
                break;
            case KeyEvent.VK_LEFT:
                this.snake.left();
                break;
            case KeyEvent.VK_RIGHT:
                this.snake.right();
                break;
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                break;
        }
    }

    @Override
    public void paint(Graphics gScreen) {
        renderer.render(gImage);
        gScreen.drawImage(imageBuffer, 0, 0, null);
    }

    public Renderer getRenderer() {
        return this.renderer;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public Rectangle getDrawingArea() {
        return drawingArea;
    }
}
