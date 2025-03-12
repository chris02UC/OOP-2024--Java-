package SoalIan;

public class Cube extends Aquarium{
    
    public Cube(){
    this.amount_side = 5;
    }
    public void calcsurfacearea(){
        surface_area = (this.length * this.length) * 5;
    }
    public void calcvolume(){
        volume = this.length*this.length*this.length;
    }
}
