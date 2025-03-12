package Main;
import java.util.Scanner;
import Model.Square;
import Model.Rectangle;
import Model.Block;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Calculate Shape");
        System.out.println("1. Square\n2. Rectangle\n3. Block");
        System.out.print("Choose: ");
        int choose = s.nextInt();

        if (choose == 1){
            int width = s.nextInt();
            Square square = new Square (width);
            System.out.println("Area: "+square.calcArea());
            System.out.println("Perimeter: "+square.calcPerimeter());
        } else if (choose == 2){
            int width = s.nextInt();
            int height = s.nextInt();
            Rectangle rectangle = new Rectangle (height, width);
            System.out.println("Area: "+rectangle.calcArea());
            System.out.println("Perimeter: "+rectangle.calcPerimeter());

        } else if (choose == 3){

        }
    }
}
