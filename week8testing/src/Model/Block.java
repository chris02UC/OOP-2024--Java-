package Model;
import Interface.Shape3D;

public class Block extends Rectangle implements Shape3D{

    public Block(double height, double width){
        super(height, width);
    }

    @Override
    public double calcVolume(double t) {
        return width * height * t;
    }

    // @Override
    // public double calcArea(){
    //     return super.calcArea();
    // }
    // @Override
    // public double calcPerimeter(double t){
    //     return 4 * (width+height);
    // }
}
