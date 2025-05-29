import java.io.Serializable;

public class Number implements Serializable {

    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void calc() {
        y = x - Math.sin(x);
    }

}
