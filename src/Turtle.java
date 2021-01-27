import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.*;

public class Turtle extends Canvas {

    GraphicsContext gc;

    Point position;
    Vector drawDirection = new Vector(1, 0);

    public Turtle(int width, int height) {

        super(width, height);
        gc = super.getGraphicsContext2D();
        position = new Point(0, 0);
    }

    public void setPosition(int x, int y) {

        position = new Point(x, y);
    }

    public void turn(double angle) {

        double r = angle * (Math.PI / 180.0);

        drawDirection = new Vector(Math.cos(r) * drawDirection.x - Math.sin(r) * drawDirection.y, Math.sin(r) * drawDirection.x + Math.cos(r) * drawDirection.y);
        drawDirection.resizeTo1();
    }

    public void draw(double length) {

        Point nextPosition = drawDirection.multiply(length).move(position);

        gc.setLineWidth(3);
        gc.strokeLine(position.x, position.y, nextPosition.x, nextPosition.y);

        position = nextPosition;
    }
    
    public void clear() {
        
        gc.clearRect(0, 0, super.getWidth(), super.getHeight());
    }
}
