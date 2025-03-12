package Soal4;

public class character {
    private String nama1, nama2;
    int health1, health2;
    String []weapon = new String[6];
    int weapon1, weapon2;

    public void initialize(){
    health1 = 100;
    health2 = 100;
    weapon[0] = "Clurit";
    weapon[1] = "Tangan kosong";
    weapon[2] = "Rencong";
    weapon[3] = "Keris";
    weapon[4] = "Parang";
    weapon[5] = "Golok";
    }

    public int getHealth1() {
    return health1;
    }

    public int getHealth2(){
    return health2;
    }

    public void sethealth1(int damagetaken){
    health1 -= damagetaken;
    }
    public void sethealth2(int damagetaken){
    health2 -= damagetaken;
    }

    public void setWeapon1(int input){
    weapon1 = input;
    }
    public String getWeapon1(){
    return weapon[weapon1-1];
    }

    public void setWeapon2(int input){
        weapon2 = input;
    }
    public String getWeapon2(){
    return weapon[weapon2-1];
    }
    
    public void nama1(String input){
    nama1 = input;
    }
    public void nama2(String input){
    nama2 = input;
    }

    public String getWeapon(int input){
        return weapon[input];
    }

    public String getNama1() {
        return nama1;
    }
    public void setNama1(String nama1) {
        this.nama1 = nama1;
    }

    public String getNama2() {
        return nama2;
    }
    public void setNama2(String nama2) {
        this.nama2 = nama2;
    }

    public String[] getWeapon() {
        return weapon;
    }

    public void setWeapon(String[] weapon) {
        this.weapon = weapon;
    }


}
