package SoalIanToTes;

public class Cube extends Aquarium{
    
    public Cube(){
    this.amount_side = 5;
    this.type = "Cube";
    }
    public void calcsurfacearea(){
        surface_area = (this.length * this.length) * 5;
    }
    public void calcvolume(){
        volume = this.length*this.length*this.length;
    }
}
