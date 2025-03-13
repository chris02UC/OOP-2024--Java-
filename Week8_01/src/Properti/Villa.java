package Properti;

public class Villa extends Properti {
private double luasBangunan;
private String namaCluster;
private double harga;
private String fasilitas;

    public Villa(double luas, String nama, double harga, String fasilitas){
        this.luasBangunan = luas;
        this.namaCluster = nama;
        this.harga = harga;
        this.fasilitas = fasilitas;
    }

    @Override
    public double getluasBangunan() {
        return luasBangunan;
    }

    @Override
    public String getnamaCluster() {
        return namaCluster;
    }

    @Override
    public double getharga() {
        return harga;
    }

    @Override
    public String getfasilitas() {
        return fasilitas;
    }

    @Override
    public void setluasBangunan(double input) {
        this.luasBangunan = input;
    }

    @Override
    public void setnamaCluster(String input) {
        this.namaCluster = input;
    }

    @Override
    public void setharga(double input) {
        this.harga = input;
    }

    @Override
    public void setfasilitas(String input) {
        this.fasilitas = input;
    }
    
}
