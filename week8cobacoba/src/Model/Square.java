package Model;
import Interface.Shape2D;

public class Square implements Shape2D{
    protected double width;

    public Square(double width){
        this.width = width;
    }
    public double getWidth(){
        return width;
    }
    public void setWidth(double width){
        this.width = width;
    }



    @Override
    public double calcArea() {
    return width * width;
    }

    @Override
    public double calcPerimeter() {
        return 2* (width+width);
    }
    
}
