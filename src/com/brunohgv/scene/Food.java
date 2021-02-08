package com.brunohgv.scene;

import com.brunohgv.graphics.Rect;
import com.brunohgv.utils.Constants;
import com.brunohgv.utils.GameUtils;

import java.awt.*;

public class Food extends Rect {

    private int eatenTimes = 0;

    public Food(Rectangle drawingArea, Snake snake) {
        super();
        setRandomLocation(drawingArea, snake);
        setDimension(new Dimension(Constants.GLOBAL_BLOCK_SIZE, Constants.GLOBAL_BLOCK_SIZE));
        setColor(Color.GREEN);
    }

    public void setRandomLocation(Rectangle drawingArea, Snake snake) {
        do {
            int x = GameUtils.random((int) drawingArea.getMinX(), (int) drawingArea.getMaxX() - Constants.GLOBAL_BLOCK_SIZE);
            int y = GameUtils.random((int) drawingArea.getMinY(), (int) drawingArea.getMaxY() - Constants.GLOBAL_BLOCK_SIZE);
            this.setLocation(new Point(x, y));
        } while (snake.intersects(this));
    }

    public void checkIfWasEaten(Snake snake, Rectangle drawingArea) {
        if(snake.intersects(this)) {
            this.eatenTimes++;
            setRandomLocation(drawingArea, snake);
            snake.grow();
        }
    }

    public int getEatenTimes() {
        return eatenTimes;
    }
}
