package com.brunohgv.core;

import com.brunohgv.graphics.Rect;
import com.brunohgv.scene.*;
import com.brunohgv.graphics.Renderer;
import com.brunohgv.utils.Constants;
import com.brunohgv.utils.GameUtils;

import java.awt.*;

public class Game implements Runnable {

    private GameWindow gameWindow;
    private Snake snake;
    private Renderer renderer;
    private Food food;

    public void start() {
        this.snake = new Snake();
        this.gameWindow = new GameWindow(snake);
        this.food = new Food(gameWindow.getDrawingArea(), snake);
        this.renderer = gameWindow.getRenderer();
        renderer.add(new Background());
        renderer.add(snake);
        renderer.add(food);

        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while(!isGameOver()) {
            snake.move();
            gameWindow.repaint();
            food.checkIfWasEaten(snake, gameWindow.getDrawingArea());
            GameUtils.sleep(Constants.MOVEMENT_INTERVAL);
        }
        this.processGameOver();
    }

    private boolean isGameOver() {
        return this.snake.collidesWithItself() || this.isSnakeHitbound();
    }

    private boolean isSnakeHitbound() {
        Rect head = this.snake.getHead();
        Rectangle drawingArea = this.gameWindow.getDrawingArea();

        int headX = (int) head.getLocation().getX();
        int headY = (int) head.getLocation().getY();

        int topWall = (int) drawingArea.getY();
        int bottomWall = (int) drawingArea.getY() + (int) drawingArea.getHeight();
        int leftWall = (int) drawingArea.getX();
        int rightWall = (int) drawingArea.getX() + (int) drawingArea.getWidth();

        if (headY < topWall) {
            return true;
        }

        if (headY + Constants.GLOBAL_BLOCK_SIZE > bottomWall) {
            return true;
        }

        if (headX < leftWall) {
            return true;
        }

        if (headX + Constants.GLOBAL_BLOCK_SIZE > rightWall) {
            return true;
        }

        return false;
    }

    private void processGameOver() {
        this.renderer.remove(food);
        this.renderer.remove(snake);
        this.renderer.add(new GameOverText());
        this.renderer.add(new PointsText(food.getEatenTimes()));
        gameWindow.repaint();
    }
}
