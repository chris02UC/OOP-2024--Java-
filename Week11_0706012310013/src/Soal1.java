import java.util.Scanner;
import java.util.ArrayList;

public class Soal1 {
    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
        while (true){
        try{
        System.out.println("\n=== RECURSIVE FUNCTIONS ===");
        System.out.println("1. Factorials\n2. Reverse\n3. Fibonacci\n4. Sum of numbers\n5. Quit");
        System.out.print("Choose: ");
        String inputmenu = s.next()+s.nextLine();
        switch (inputmenu){
        case "1":
            System.out.println("\n=== FACTORIAL ===");
            System.out.print("Input factorial: ");
            int inputfact = s.nextInt();
                while (inputfact < 0){
                    System.out.println("Factorial number cannot be negative!");
                    System.out.print("Input factorial: ");
                    inputfact = s.nextInt();
                }
                if (inputfact == 0){
                    System.out.println("0! -> 0 = 1");
                    break;
                }
            int hasilfact = factorial(inputfact);
            System.out.print(inputfact+"! -> ");
            for (int a = inputfact; a >= 1; a--){
                if (a == 1){
                    System.out.print(a+" = "+hasilfact);
                    break;
                }
                System.out.print(a + " x ");
            }
        break;
        
        case "2":
        String yesno2 = "";
        while (!yesno2.equalsIgnoreCase("n")){
            System.out.println("\n=== REVERSE LINE ===");
            System.out.print("Input string: ");
            String inputs = s.next()+s.nextLine();
            String hasilrev = reverse(inputs);
            System.out.println("Hasil Reverse: "+hasilrev);

            System.out.print("\nRepeat program? (Y/N): ");
            yesno2 = s.next()+s.nextLine();
                while (!yesno2.equalsIgnoreCase("y") && !yesno2.equalsIgnoreCase("n")){
                    System.out.println("Input can only be Y or N!");
                    System.out.print("\nRepeat program? (Y/N): ");
                    yesno2 = s.next()+s.nextLine();
                }
        }
        break;

        case "3": 
        String yesno3 = "";
        while (!yesno3.equalsIgnoreCase("n")){
            System.out.println("\n=== FIBONACCI ===");
            System.out.print("Fibonacci Sequence: ");
            int inputfib = s.nextInt();
                while (inputfib <= 0){
                    System.out.println("Fibonacci sequence only from 1!");
                    System.out.print("Fibonacci Sequence: ");
                    inputfib = s.nextInt();
                }
            for (int a = 1; a <= inputfib; a++){
                System.out.print(fibonacci(a)+ " ");
             }
            System.out.println("\nThe "+inputfib+"th term of the Fibonacci Sequence is: "+fibonacci(inputfib));

            System.out.print("\nRepeat program? (Y/N): ");
            yesno3 = s.next()+s.nextLine();
                while (!yesno3.equalsIgnoreCase("y") && !yesno3.equalsIgnoreCase("n")){
                    System.out.println("Input can only be Y or N!");
                    System.out.print("\nRepeat program? (Y/N): ");
                    yesno3 = s.next()+s.nextLine();
                }
        }
        break;

        case "4":
        String yesno4 = "";
        while (!yesno4.equalsIgnoreCase("n")){
            System.out.println("\n=== SUM OF NUMBERS ===");
            System.out.print("Sum of numbers until: ");
            int inputsum = s.nextInt();
                while (inputsum <= 0){
                    System.out.println("Input cannot be 0 or less than 0!");
                    System.out.print("Sum of numbers until: ");
                    inputsum = s.nextInt();
                }
            // int totalsum = sum(inputsum);
            ArrayList<Integer> SON = new ArrayList<Integer>();
            for (int a = 0; a < inputsum; a++){
                SON.add(a+1);
            }
            int totalsum = sum(SON, 0);
            System.out.println("The sum of the first "+inputsum+" numbers is: "+totalsum);

            System.out.print("\nRepeat program? (Y/N): ");
            yesno4 = s.next()+s.nextLine();
            while (!yesno4.equalsIgnoreCase("y") && !yesno4.equalsIgnoreCase("n")){
                System.out.println("Input can only be Y or N!");
                System.out.print("\nRepeat program? (Y/N): ");
                yesno4 = s.next()+s.nextLine();
            }
        }
        break;

        case "5":
        System.out.println("Bye bye!");
        System.exit(0);
        break;

        default:
        System.out.println("Input not available!");
        break;

        }// switch ends here
        System.out.println("");
        } catch (Exception e){
            System.out.println("Error, shutting down....");
            break;
        }
        }
    } // psvm ends here


    public static int factorial(int n){
        if (n <= 1){
           return 1; // 0 and 1 return 1
        } else {
          return (n * factorial(n-1)); // if 5; so 5 * factorial 4 / 4 * factorial 3 / 3 * factorial 2 / 2 * factorial 1 = 1
        }
    }

    public static String reverse (String input){
        if(input.length() <= 0){
            return input;
        }
        return reverse(input.substring(1)) + input.charAt(0);
    }


    public static int fibonacci(int n){
        if (n == 0){
           return 0;
        }else if (n == 1){
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2); 
        }
    }


    // public static int sum(int n){
    //     if (n == 1){
    //         return n;
    //     }
    //     return n + sum(n - 1);
    // }

    public static int sum(ArrayList<Integer> list, int n) {
        if(n == list.size() - 1)
          return list.get(n);
        else
          return list.get(n) + sum(list, n + 1); // 0 + (1+(2+(3+(4+(5 == 5))))) // when it reaches the length, just returns 5; use arraylist jadi bisa dipakai untuk full random  numbers;
    }

}
