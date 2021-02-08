package com.brunohgv.scene;

import com.brunohgv.core.Direction;
import com.brunohgv.graphics.Rect;
import com.brunohgv.graphics.Shape;
import com.brunohgv.utils.Constants;
import com.brunohgv.utils.GameUtils;

public class Snake extends Shape {

    private Direction direction;
    private Direction nextDirection;
    private Direction directionIntent;
    private int piecesToGrow;

    public Snake() {
        this.setColor(Constants.SNAKE_COLOR);
        this.direction = Direction.NONE;
        this.nextDirection = Direction.NONE;

        Rect rect = new Rect(Constants.GAME_WIDTH/2, Constants.GAME_WIDTH/2, Constants.GLOBAL_BLOCK_SIZE, Constants.GLOBAL_BLOCK_SIZE, this.getColor());
        this.addRect(rect);

        for (int i = 1; i < Constants.SNAKE_INITIAL_BLOCKS_NUMBER; i++) {
            rect = this.duplicate(rect, Direction.LEFT);
            this.addRect(rect);
        }
    }

    public synchronized void move() {
        if(nextDirection != Direction.NONE) {
            Rect head = this.getHead();
            Rect tail = this.getTail();
            GameUtils.moveRect(getRects());
            this.direction = nextDirection;
            Rect newHead = duplicate(head, direction);
            this.getRects().set(0, newHead);
            if(this.piecesToGrow > 0) {
                this.getRects().add(tail);
                this.piecesToGrow--;
            }
        }
    }

    public synchronized void up() {
        this.directionIntent = Direction.UP;
        if(this.direction.canChangeTo(directionIntent)) {
            this.nextDirection = directionIntent;
        }
    }

    public synchronized void down() {
        this.directionIntent = Direction.DOWN;
        if(this.direction.canChangeTo(directionIntent)) {
            this.nextDirection = directionIntent;
        }
    }

    public synchronized void left() {
        this.directionIntent = Direction.LEFT;
        if(this.direction.canChangeTo(directionIntent)) {
            this.nextDirection = directionIntent;
        }
    }

    public synchronized void right() {
        this.directionIntent = Direction.RIGHT;
        if(this.direction.canChangeTo(directionIntent)) {
            this.nextDirection = directionIntent;
        }
    }

    public boolean collidesWithItself() {
        Rect head = this.getHead();
        for(int i = 1 ; i < this.getRects().size() ; i++) {
            Rect currentRect = this.getRects().get(i);
            if(head.intersects(currentRect)) {
                return true;
            }
        }
        return false;
    }

    public void grow() {
        this.piecesToGrow += Constants.SNAKE_GROWING_SPEED;
    }

}
