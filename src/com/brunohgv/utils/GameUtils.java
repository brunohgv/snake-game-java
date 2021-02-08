package com.brunohgv.utils;

import com.brunohgv.graphics.Rect;
import java.util.List;
import java.util.Random;

public class GameUtils {

    public static void moveRect(List<Rect> rects) {
        for(int i = rects.size() - 1 ; i > 0 ; i--) {
            rects.set(i, rects.get(i - 1));
        }
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch(InterruptedException ex) {
            // Do nothing
        }
    }

    public static int random(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

}
