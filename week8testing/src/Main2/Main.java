package Main2;

import Model.Rectangle;
import Model.Square;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Calculate Shape");
        System.out.println("1. Square");
        System.out.println("2. Rectanle");
        System.out.println("3. Block");
        System.out.print("Choose: ");
        int choose = scan.nextInt();
        
        if (choose == 1) {
            int width = scan.nextInt();
            Square square = new Square(width);
            System.out.println("Area: "+ square.calcArea());
            System.out.println("Perimeter: "+ square.calcPerimeter());
        }else if (choose == 2) {
            int width = scan.nextInt();
            int height = scan.nextInt();
            Rectangle rectangle = new Rectangle(height, width);
            System.out.println("Area: "+ rectangle.calcArea());
            System.out.println("Perimeter: "+ rectangle.calcPerimeter());
        }else if (choose == 3) {
            
        }
    }
}
