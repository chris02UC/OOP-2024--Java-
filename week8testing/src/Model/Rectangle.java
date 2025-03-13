package Model;

import Interface.Shape2D;

public class Rectangle implements Shape2D{
    protected double width;
    protected double height;

    public Rectangle (double height, double width){
        this.width = width;
        this.height = height;
    }

    public double getWidth(){
        return width;
    }
    public void setWidth(double width){
        this.width = width;
    }

    public double getHeight(){
        return height;
    }
    public void setHeight(double height){
        this.height = height;
    }

    @Override
    public double calcArea() {
        return width * height;

    }

    @Override
    public double calcPerimeter() {
        return 2*(width + height);
    }   
}
