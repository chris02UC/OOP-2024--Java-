package Soal2;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    KRS k = new KRS();
    k.initialize();
    int sppbulan = 0;
    int inputsks = 0;
    System.out.print("Masukan nama anda: ");
    String inputnama = s.next()+s.nextLine();
    k.nama(inputnama);

    System.out.print("Masukkan nim anda(1xxx atau 2xxx): ");
    int inputnim = s.nextInt();
    while (inputnim < 1000 || inputnim >= 3000){
    System.out.print("NIM format invalid! Masukkan nim anda(1xxx atau 2xxx): ");
    inputnim = s.nextInt();
    }
    k.nim(inputnim);

    System.out.print("Masukkan uang anda: ");
    int inputuang = s.nextInt();
    while (inputuang <= 0){
    System.out.print("Input invalid! Masukkan uang anda: ");
    inputuang = s.nextInt();
    }
    k.uang(inputuang);

    System.out.println("Masukkan tipe beasiswa: \n1. Diamond(100% SPP + 50% SKS off)\n2. Platinum(80% SPP + 20% SKS off)\n3. Gold(50% SPP off)\n4. Silver(30% SPP off)\n5. Normal");
    System.out.print("Pilih: ");
    String pilihbea = s.next()+s.nextLine();
    while (!pilihbea.equals("1") && !pilihbea.equals("2") && !pilihbea.equals("3") && !pilihbea.equals("4") && !pilihbea.equals("5")){
    System.out.print("Input invalid! Pilih: ");
    pilihbea = s.next()+s.nextLine();
    }

    while (true){
        if (k.getsemester() == 9){
        System.out.println("Selamat Anda Lulus!!");
        System.out.print("Semester: "+k.getsemester()+"\n");
        System.out.print("Total SKS: "+k.getsks()+"\n");
        System.exit(0);
        }
    System.out.println("=======================================\nHalo "+k.getnama());
    System.out.println("NIM: "+k.getnim());
    System.out.println("Semester: "+k.getsemester());
    System.out.println("Total SKS: "+k.getsks());
    System.out.print("SKS taken this semester: ");
      for (int a = 0; a < 3; a++){
      System.out.print(k.getnamakelas(a));
        if (a != 2){
        System.out.print(", ");
        }
      }
    System.out.println("");
    System.out.print("Beasiswa = ");
    k.displaybea(pilihbea);
    System.out.println("Uang: "+k.getuang());
    k.menu();
    System.out.print("Pilih: ");
    String pilihmenu = s.next()+s.nextLine();
    while (!pilihmenu.equals("1")&&!pilihmenu.equals("2")&&!pilihmenu.equals("3")&&!pilihmenu.equals("4")){
    System.out.print("Input invalid! Pilih: ");
    pilihmenu = s.next()+s.nextLine();
    }
    switch (pilihmenu) {
      case "1":
        if (sppbulan == 1){
        System.out.println("Anda sudah bayar SPP\n");
        break;
        }
      k.menu1();
      k.hitungbea(pilihbea);
      //System.out.println(k.getbiaya()); -print harga spp
        if(k.getbiaya() > k.getuang()){
        System.out.println("Uang tidak mencukupi\n");
        }
        else if (k.getbiaya() <= k.getuang()){
        System.out.println("Berhasil\n");
        k.bayarspp();
        sppbulan = 1;
        }
      break;

      case "2": 
      if (inputsks > 2){
      System.out.println("SKS full\n");
      break;
      }
      System.out.println("Biaya -> 200/sks");
      System.out.println("Diamond 50 % off");
      System.out.println("Platinum 20% off");
        if (k.getuang() < 200){
        System.out.println("Uang tidak mencukupi\n");
        }
        else if (k.getuang() >= 200){
        System.out.print("Input mata kuliah: ");
        String inputnamakelas = s.next()+s.nextLine();
        k.setnamakelas(inputnamakelas, inputsks);
        k.bayarsks(pilihbea);
        k.addsks();
        inputsks++;
        System.out.println("");
        }
      break;

      case "3":
      if (sppbulan == 0 || inputsks < 2){
      System.out.println("Anda perlu membayar spp dan setidaknya bayar 2 sks\n");
      break;
      }
      else{
      k.gantisemester();
        for (int a = 0; a < 3; a++){
        k.setnamakelas(" ", a);
        }
      inputsks = 0;
      sppbulan = 0;
      System.out.println("Anda berhasil naik semester!\n");
      }
      break;

      case "4":
      System.out.println("Mau tambah berapa uang?");
      int tambahuang = s.nextInt();
      while (tambahuang <= 0){
      System.out.println("Input invalid! Mau tambah berapa uang?");
      tambahuang = s.nextInt();
      }
      k.adduang(tambahuang);
      System.out.println("Uang berhasil ditambah sebanyak "+tambahuang+"\n");
      break;

      default:
      System.out.println("Invalid input!");
      break;
    }
    }

    }
}
