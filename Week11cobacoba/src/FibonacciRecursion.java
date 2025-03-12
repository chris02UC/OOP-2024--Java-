public class FibonacciRecursion {

    // Recursive function to calculate Fibonacci number
    public static int fibonacci(int n) {
        // Base cases
        if (n == 0) {
            return 0; // if i is 0, return 0
        }
        if (n == 1) {
            return 1; // if i is 1, return 1
        }

        // Recursive case: Fibonacci(n) = Fibonacci(n-1) + Fibonacci(n-2)
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Print the first 'count' Fibonacci numbers
    public static void printFibonacciSequence(int count) {
        System.out.print("Fibonacci sequence: ");
        for (int i = 0; i < count; i++) { // 0, 1, 2, 3, etc 
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example: Print the first 10 Fibonacci numbers
        printFibonacciSequence(5);
    }
}
