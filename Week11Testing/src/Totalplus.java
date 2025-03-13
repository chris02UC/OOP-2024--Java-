public class Totalplus {
    public static int sum(int[] arr, int i) {
        if(i==arr.length-1)
          return arr[i];
        else
          return arr[i] + sum(arr,i+1); // 0 + (1+(2+(3+(4+(5 == 5))))) // when it reaches the length, just returns 5
      }

    public static double mean(int[] arr, int i) {
        if(i==arr.length-1)
          return arr[i]/arr.length; 
        else
          return mean(arr, i+1) + arr[i]/arr.length;
      }
      

      public static void main(String[] args) {
        int[] myArray = {2, 5, 1, 8, 9}; // Example array
        int total = sum(myArray, 0); // Start summing from index 0
        double avg = mean(myArray, 0);
        System.out.println("Sum of the array: " + total); // Output the result
        System.out.println("Mean of Array: "+avg);
            for (int a = 0; a < myArray.length; a++){
                System.out.println(mean(myArray, a)+" ");
            }
    }
    
}
