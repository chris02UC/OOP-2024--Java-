package SoalIanToTes;

public class Aquarium {
    protected double price;
    protected double length, width, height, diameter, volume;
    protected double surface_area;
    protected double amount_side;
    protected String type;

    public void calc_price(){
        this.price = surface_area * 20 + amount_side * 5;
    }
    public double getprice(){
        return this.price;
    }

    public void setlength(double a){
        this.length = a;
    }
    public void setwidth(double a){
        this.width = a;
    }
    public void setheight(double a){
        this.height = a;
    }
    public void setdiameter(double a){
        this.diameter = a;
    }

    public double getlength(){
        return this.length;
    }
    public double getwidth(){
        return this.width;
    }
    public double getheight(){
        return this.height;
    }
    public double getdiameter(){
        return this.diameter;
    }
    public double getsurface_area(){
        return this.surface_area;
    }
    public double getvolume(){
        return this.volume;
    }
}
