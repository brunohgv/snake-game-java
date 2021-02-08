package com.brunohgv.graphics;

import java.awt.*;

public class Rect extends Drawable {

    private Rectangle rectangle;

    public Rect() {
        this.rectangle = new Rectangle();
    }

    public Rect(int x, int y, int width, int height, Color color) {
        this.rectangle = new Rectangle(x, y, width, height);
        this.setColor(color);
    }

    public Rect(Point location, Dimension dimension, Color color) {
        this.rectangle = new Rectangle(location, dimension);
        this.setColor(color);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.getColor());
        g.fillRect(
                (int) this.rectangle.getLocation().getX(),
                (int) this.rectangle.getLocation().getY(),
                (int) this.rectangle.getSize().getWidth(),
                (int) this.rectangle.getSize().getHeight()
        );
    }

    public boolean intersects(Rect rect) {
        return this.rectangle.intersects(rect.rectangle);
    }

    public Point getLocation() {
        return rectangle.getLocation();
    }

    public void setLocation(Point location) {
        this.rectangle.setLocation(location);
    }

    public Dimension getDimension() {
        return rectangle.getSize();
    }

    public void setDimension(Dimension dimension) {
        this.rectangle.setSize(dimension);
    }
}
