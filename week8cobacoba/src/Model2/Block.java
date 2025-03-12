package Model2;

import Interface.Shape3D;

public class Block extends Rectangle implements Shape3D{

    public Block(double height, double width) {
        super(height, width);
    }
    
    @Override
    public double calcVolume(double t) {
        return width * height * t;
    }
}
