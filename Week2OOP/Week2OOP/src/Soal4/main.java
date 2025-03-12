package Soal4;
import java.util.Scanner;
import java.util.Random;

public class main {
    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    Random r = new Random();
    character c = new character();
    menu m = new menu();
    c.initialize();
    int counter = 1;

    System.out.println("=== Giliran Ian ===");
    System.out.print("Nama karakter : ");
    String inputname = s.next()+s.nextLine();
    c.nama1(inputname);
    for (int a = 0; a < 6; a++){
    System.out.print("["+(a+1)+"] "+c.getWeapon(a)+"\n");
    }
    System.out.print("Pilih senjata : ");
    int inputsenjata = s.nextInt();
        while (inputsenjata < 1 || inputsenjata > 6){
        System.out.print("Input invalid! Pilih senjata : ");
        inputsenjata = s.nextInt();
        }
    c.setWeapon1(inputsenjata);
    System.out.println("Ian memilih "+c.getWeapon((inputsenjata-1)));
    
    System.out.println("=== Giliran Gavin ===");
    System.out.print("Nama karakter : ");
    inputname = s.next()+s.nextLine();
    c.nama2(inputname);
    for (int a = 0; a < 6; a++){
    System.out.print("["+(a+1)+"] "+c.getWeapon(a)+"\n");
    }
    System.out.print("Pilih senjata : ");
    inputsenjata = s.nextInt();
        while (inputsenjata < 1 || inputsenjata > 6){
        System.out.print("Input invalid! Pilih senjata : ");
        inputsenjata = s.nextInt();
        }
    c.setWeapon2((inputsenjata)); 
    System.out.println("Gavin memilih "+c.getWeapon((inputsenjata-1)));

    while (true){
    System.out.println("=== WELCOME TO THE GAME ===");
    if (counter == 1){
    System.out.println("Player : Ian");
    System.out.println("Nama karakter : "+c.getNama1());
    System.out.println("Senjata : "+c.getWeapon1());
    System.out.println("HP : "+c.getHealth1());
    m.Menu();
    System.out.print("Pilih : ");
    int menupilih = s.nextInt();
    while (menupilih < 1 || menupilih > 4){
    System.out.println("Input invalid! Pilih : ");
    menupilih = s.nextInt();
    }
        if (menupilih == 1){
        int attackvalue = r.nextInt(11)+10;
        c.sethealth2(attackvalue);
        System.out.println(c.getNama1()+" menyerang dengan kekuatan "+attackvalue+" power");
            if (c.getHealth2() < 0){
            System.out.println("\n=== CONGRATULATIONS ===");
            System.out.println("Player 1 "+(c.getNama1())+" menang!");
            System.exit(0);
            }
        counter = 2;
        }
        else if (menupilih == 2){  
        System.out.println("Senjata sebelumnya: "+c.getWeapon1());
        for (int a = 0; a < 6; a++){
        System.out.print("["+(a+1)+"] "+c.getWeapon(a)+"\n");
        }
        System.out.println("Pilih senjata baru : ");
        int pilihbaru = s.nextInt();
        c.setWeapon1((pilihbaru));
        counter = 2;       
        }
        else if (menupilih == 3){
        System.out.println("Nama karakter sebelumnya: "+c.getNama1());
        System.out.println("Nama karakter baru : ");
        String karakbaru = s.next()+s.nextLine();
        c.setNama1(karakbaru);
        counter = 2;       
        }
        else if (menupilih == 4){
        System.exit(0);
        }
    System.out.println("");
    }
    else if (counter == 2){
        System.out.println("Player : Gavin");
        System.out.println("Nama karakter : "+c.getNama2());
        System.out.println("Senjata : "+c.getWeapon2());
        System.out.println("HP : "+c.getHealth2());
        m.Menu();
        System.out.print("Pilih : ");
        int menupilih = s.nextInt();
        while (menupilih < 1 || menupilih > 4){
        System.out.println("Input invalid! Pilih : ");
        menupilih = s.nextInt();
        }
            if (menupilih == 1){
            int attackvalue = r.nextInt(11)+10;
            c.sethealth1(attackvalue);
            System.out.println(c.getNama2()+" menyerang dengan kekuatan "+attackvalue+" power");
                if (c.getHealth1() < 0){
                System.out.println("\n=== CONGRATULATIONS ===");
                System.out.println("Player 2 "+(c.getNama2())+" menang!");
                System.exit(0);
                }
            counter = 1;
            }
            else if (menupilih == 2){  
            System.out.println("Senjata sebelumnya: "+c.getWeapon2());
            for (int a = 0; a < 6; a++){
            System.out.print("["+(a+1)+"] "+c.getWeapon(a)+"\n");
            }
            System.out.println("Pilih senjata baru : ");
            int pilihbaru = s.nextInt();
            c.setWeapon2((pilihbaru));
            counter = 1;       
            }
            else if (menupilih == 3){
            System.out.println("Nama karakter sebelumnya: "+c.getNama2());
            System.out.println("Nama karakter baru : ");
            String karakbaru = s.next()+s.nextLine();
            c.setNama2(karakbaru);
            counter = 1;       
            }
            else if (menupilih == 4){
            System.exit(0);
            }
        System.out.println("");    
    }
    }

    }
}
