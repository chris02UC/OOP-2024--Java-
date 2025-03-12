package SoalIanToTes;

public class Tube extends Aquarium{

    public Tube(){
    this.amount_side = 2;
    this.type = "tube";
    }

    public void calcsurfacearea(){
        surface_area = (Math.PI*diameter*height) + Math.PI*((diameter/2)*(diameter/2)) ;
    }
    public void calcvolume(){
        volume = Math.PI*((diameter/2)*(diameter/2))*height;
    }
}
