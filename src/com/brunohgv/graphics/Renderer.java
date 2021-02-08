package com.brunohgv.graphics;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Renderer {

    private List<Drawable> drawables;

    public Renderer() {
        this.drawables = new ArrayList<>();
    }

    public synchronized void add(Drawable drawable) {
        this.drawables.add(drawable);
    }

    public synchronized void remove(Drawable drawable) {
        this.drawables.remove(drawable);
    }

    public synchronized void render(Graphics g) {
        for(Drawable drawable: this.drawables) {
            g.setColor(drawable.getColor());
            drawable.draw(g);
        }
    }
}
