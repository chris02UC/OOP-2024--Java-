package Model2;

import Interface.Shape2D;

public class Rectangle extends Square{

    protected double height;

    public Rectangle(double height, double width) {
        super(width);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double calcArea() {
        return width * height;
    }

    @Override
    public double calcPerimeter() {
        return 2 * (width * height);
    }

}
