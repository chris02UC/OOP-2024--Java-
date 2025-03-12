package Soal1;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
        System.out.print("Masukan nama hotel Anda: ");
        String inputnama = s.next()+s.nextLine();
        hotel h = new hotel();
        h.namahotel(inputnama);

        System.out.print("Masukan jumlah kamar di hotel Anda: ");
        int inputjumlah = s.nextInt();
        h.jumlah(inputjumlah);

        System.out.print("Masukan biaya menambah jumlah kamar: ");
        int inputbiaya = s.nextInt();
        h.biaya(inputbiaya);
        
        System.out.print("Masukan harga permalam: ");
        int inputharga = s.nextInt();
        h.harga(inputharga);
        h.initalize();
        
        while (true){
        h.statushotel();
        h.menu();
        System.out.print("Pilih: ");
        String menu = s.next()+s.nextLine();
            while (!menu.equals("1") && !menu.equals("2") && !menu.equals("3") && !menu.equals("4") && !menu.equals("5") && !menu.equals("0")){
            System.out.print("Input invalid! Pilih: ");
            menu = s.next()+s.nextLine();
            }

        if (menu.equals("1")){
        System.out.print("Masukkan nama hotel baru: ");
        String tempnama = s.next()+s.nextLine();
        h.namahotel(tempnama);
        System.out.println("Berhasil mengganti nama menjadi "+h.getnamahotel()+ " Hotel");
        }
        else if (menu.equals("2")){
        System.out.print("Mau tambah berapa kamar? (Biaya: "+h.getbiaya()+" /kamar: )");
        int add = s.nextInt();
        h.tambahkamar(add);
        }
        else if (menu.equals("3")){
        System.out.print("Masukkan harga permalam baru: ");
        int tempharga = s.nextInt();
        h.harga(tempharga);
        System.out.println("Berhasil mengubah harga menjadi "+h.getharga());    
        }
        else if (menu.equals("4")){
        System.out.print("Masukkan harga menambah kamar baru: ");
        int tempbiaya = s.nextInt();
        h.biaya(tempbiaya);
        System.out.println("Berhasil mengubah harga menambah kamar baru menjadi "+h.getbiaya());
        }
        else if (menu.equals("5")){
        System.out.print("Jumlah customer hari ini: ");
        int inputcustomer = s.nextInt();
        h.nextday(inputcustomer);
        }
        else if (menu.equals("0")){
        System.out.println("Bye bye!");
        System.exit(0);
        }
        System.out.println("");
        }

    }
}
