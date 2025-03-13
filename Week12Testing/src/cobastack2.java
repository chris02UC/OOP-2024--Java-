import java.util.Scanner;
import java.util.Stack;

public class cobastack2 {
    public static void main(String[] args) {
        Queue stack = new Queue();
        Scanner s = new Scanner(System.in);
        String lagi = "y";

        while(lagi.equals("y")){
            System.out.println("Masukkan angka");
            int angka = s.nextInt();
            stack.enqueue(angka);
            System.out.println("Input lagi(y/n)? ");
            lagi = s.next()+s.nextLine();
        }

        System.out.println("\nTampilkan isi Stack");
        while(stack.isEmpty() == false){
            System.out.println(stack.dequeue());
        }

        // System.out.println("\nPeek Stack");
        // int n = 0;
        // while (n < 10){
        //     System.out.println(stack.peek());
        //     n++;
        // }
        
        
    }
}
