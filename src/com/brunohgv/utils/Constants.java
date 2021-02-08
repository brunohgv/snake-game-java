package com.brunohgv.utils;

import java.awt.*;

public class Constants {

    public static final String GAME_TITLE = "Snake Game!";
    public static final int GAME_WIDTH = 500;
    public static final int GAME_HEIGHT = 500;
    public static final Color BACKGROUND_COLOR = Color.BLACK;

    public static final Color SNAKE_COLOR = Color.WHITE;
    public static final int SNAKE_INITIAL_BLOCKS_NUMBER = 10;
    public static final int SNAKE_GROWING_SPEED = 1;

    public static final int GLOBAL_BLOCK_SIZE = 10;

    public static final int MOVEMENT_INTERVAL = 50;

    public static final String GAME_OVER_TEXT = "GAME OVER!";
    public static final Point GAME_OVER_LOCATION = new Point(GAME_WIDTH/2 - 40, GAME_HEIGHT/2 - 30);
    public static final Color GAME_OVER_COLOR = Color.RED;

    public static final String POINTS_TEXT = "POINTS: %d";
    public static final Point POINTS_LOCATION = new Point(GAME_WIDTH/2 - 40, GAME_HEIGHT/2);
    public static final Color POINTS_COLOR = Color.WHITE;
}
