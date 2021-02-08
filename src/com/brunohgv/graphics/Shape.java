package com.brunohgv.graphics;

import com.brunohgv.core.Direction;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Shape extends Drawable {

    private List<Rect> rects;

    public Shape() {
        this.rects = new ArrayList<>();
    }

    public void addRect(Rect rect) {
        this.rects.add(rect);
    }

    @Override
    public void draw(Graphics g) {
        for(Rect rect: this.rects) {
            g.setColor(rect.getColor());
            rect.draw(g);
        }
    }

    public Rect duplicate(Rect baseRect, Direction direction) {
        int baseX = (int) baseRect.getLocation().getX();
        int baseY = (int) baseRect.getLocation().getY();

        int translocationX =  (int) baseRect.getDimension().getWidth() * direction.getX();
        int translocationY =  (int) baseRect.getDimension().getHeight() * direction.getY();

        Point point = new Point(baseX + translocationX, baseY + translocationY);
        Rect rect = new Rect(point, baseRect.getDimension(), this.getColor());
        return rect;
    }

    public boolean intersects(Rect rect) {
        for(Rect r: this.rects) {
            if(r.intersects(rect)) {
                return true;
            }
        }
        return false;
    }


    public List<Rect> getRects() {
        return rects;
    }

    public void setRects(List<Rect> rects) {
        this.rects = rects;
    }

    public Rect getHead() {
        return this.rects.get(0);
    }

    public Rect getTail() {
        return this.rects.get(this.rects.size() - 1);
    }
}
