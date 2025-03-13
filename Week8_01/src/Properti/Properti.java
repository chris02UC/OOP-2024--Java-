package Properti;

public abstract class Properti {
    public abstract String getnamaCluster();
    public abstract String getfasilitas();
    public abstract double getluasBangunan();
    public abstract double getharga();
    public abstract void setnamaCluster(String name);
    public abstract void setfasilitas(String facilities);
    public abstract void setluasBangunan(double lb);
    public abstract void setharga(double price);
    // public abstract void initialize(String name, String facilities, double lb, double price);

    public void testdisplay(){
        System.out.println("This is a property");
    }
}
