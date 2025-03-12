import java.util.Scanner;
public class FIbonnaciown {

    public static int fibonacci(int n){
        if (n == 0){
           return 0;
        }else if (n == 1){
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2); 
        }
         }
     
         public static void main(String[] args) {
             Scanner s = new Scanner(System.in);

             System.out.print("Input: ");
             int input = s.nextInt();

             for (int a = 0; a < input; a ++){
                System.out.print(fibonacci(a)+ " ");
             }
         }
}
