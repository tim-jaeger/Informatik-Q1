import java.awt.*;

public class Vector {

    double x, y;

    public Vector(double x, double y) {

        this.x = x;
        this.y = y;
    }

    public void resizeTo1() {

        double abs = Math.sqrt(x*x + y*y);

        x = x / abs;
        y = y / abs;
    }

    public Vector multiply(double s) {

        return new Vector(x * s, y * s);
    }

    public Point move(Point p) {

        return new Point((int) x + p.x, (int) y + p.y);
    }
}
