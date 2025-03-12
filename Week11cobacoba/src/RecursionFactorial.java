public class RecursionFactorial {//

public static int factorial(int n){
   if (n <= 1){
      return 1; // 0 and 1 return 1
   } else {
 	return (n * factorial(n-1)); // if 5; so 5 * factorial 4 / 4 * factorial 3 / 3 * factorial 2 / 2 * factorial 1 = 1
   }
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}//
