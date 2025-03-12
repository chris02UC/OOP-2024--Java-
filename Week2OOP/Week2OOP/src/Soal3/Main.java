package Soal3;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    Menu m = new Menu();  
    Book b = new Book(); 
    b.initialize();
    while (true){
    try{
    m.menu();
    System.out.print("Pilih: ");
    String pilihmenu = s.next()+s.nextLine();
    
    switch (pilihmenu){
        case "1": 
            for (int a = 0; a < 3; a++){
                if (b.getBookTitle(a).equals("(*&^%)")){
                System.out.println("Buku "+(a+1)+" masih kosong!");
                }
                else {
                System.out.println("Buku "+(a+1)+" : "+b.getBookTitle(a));
                }
            }
            System.out.println("Buku mana yang mau diedit?");
            int editbuku = s.nextInt();
            while (editbuku > 3 || editbuku < 1){
            System.out.print("Input invalid! Buku mana yang mau diedit?");
            editbuku = s.nextInt();
            }
            editbuku--;
                if (b.getBookTitle(editbuku).equals("(*&^%)")){
                System.out.print("Judul baru : ");
                String judulbaru = s.next()+s.nextLine();
                System.out.print("Penulis baru : ");
                String penulisbaru = s.next()+s.nextLine();
                System.out.print("Tahun rilis baru : ");
                int tahunbaru = s.nextInt();
                b.setBookTitle(judulbaru, editbuku);
                b.setWriter(penulisbaru, editbuku);
                b.setPublishedYear(tahunbaru, editbuku);                
                break;                                
                }
            System.out.println("Judul lama : "+b.getBookTitle(editbuku));
            System.out.print("Judul baru : ");
            String judulbaru = s.next()+s.nextLine();
            System.out.println("Penulis lama : "+b.getWriter(editbuku));
            System.out.print("Penulis baru : ");
            String penulisbaru = s.next()+s.nextLine();
            System.out.println("Tahun rilis sebelumnya : "+b.getPublishedYear(editbuku)); 
            System.out.print("Tahun rilis baru : ");
            int tahunbaru = s.nextInt();
            b.setBookTitle(judulbaru, editbuku);
            b.setWriter(penulisbaru, editbuku);
            b.setPublishedYear(tahunbaru, editbuku);
        System.out.println("");
        break;
        case "2":
        for (int a = 0; a < 3; a++){
                if (b.getBookTitle(a).equals("(*&^%)")){
                System.out.println("Buku "+(a+1)+" masih kosong!");
                continue;
                }
            System.out.println("==== BUKU "+(a+1)+"  ====");
            System.out.println("Judul : "+b.getBookTitle(a));
            System.out.println("Karya : "+b.getWriter(a));
            System.out.println("Tahun rilis : "+b.getPublishedYear(a)+"\n");
        }
        break;
        case "3":
        for (int a = 0; a < 3; a++){
        System.out.println("Buku "+(a+1)+" : "+b.getBookTitle(a));
        }
        System.out.println("Buku mana yang mau dihapus?");
        int editbuku2 = s.nextInt();
        editbuku2--;
        b.setBookTitle("(*&^%)", editbuku2);
        b.setWriter("(*&^%)", editbuku2);
        b.setPublishedYear(0, editbuku2);        
        System.out.println("Buku terhapus!");

        break;
        case "4":
        System.out.println("Goodbye!");
        System.exit(0);

        break;
        default: 
        System.out.println("Input invalid!");
        break;
    }

    }catch (Exception e){
    System.out.println("Error, restarting....");
    }
    }
    
    }
}
