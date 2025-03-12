package SoalIanToTes;

public class UDpyramid extends Aquarium{

    public UDpyramid(){
    this.amount_side = 4;
    this.type = "UDpyramid";
    }

    public void calcsurfacearea(){
        surface_area = (this.length*Math.sqrt((this.width/2)*(this.width/2) + this.height*this.height)) + (this.width*Math.sqrt((this.length/2)*(this.length/2) + this.height*this.height));
    }
    public void calcvolume(){
        volume = (this.length*this.width*this.height)/3;
    }
}
