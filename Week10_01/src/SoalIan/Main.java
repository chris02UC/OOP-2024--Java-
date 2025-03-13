package SoalIan;
import java.util.Scanner;
import java.util.Stack;
import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    Random r = new Random();
    int numToobs = 5;
    Toob[] toobs = new Toob[numToobs];
    Stack <Integer> stack1 = new Stack<>();
    int totalsealed = 0;
    int check0 = 0;
    int check1 = 0;
    int check2 = 0;


    //initialize toob
    for (int a = 0; a < numToobs; a++){
        toobs[a] = new Toob();
    }

    for (int t = 0; t < 3; t++){
        Toob currentToob = toobs[t];

        for (int a = 0; a < 4; a++) { // Populate each Toob with 4 elements
            int randomNum = r.nextInt(0, 3);
                while ((randomNum == 0 && check0 == 4) || (randomNum == 1 && check1 == 4) || (randomNum == 2 && check2 == 4)){
                randomNum = r.nextInt(0, 3);
                }
            currentToob.pushStack(randomNum);
            if (randomNum == 0){
                check0++;
            } else if (randomNum == 1){
                check1++;
            } else if (randomNum == 2){
                check2++;
            }
        }
        // System.out.println("Toob " + t + " contents:");
        // for (int a = 0; a < 4; a++) {
        //     System.out.println(currentToob.getStackIndex(a));
        // }
    }
    System.out.println("Let's Play!");
    //bruh
    while (true){
    try{
        if (totalsealed == 3){
            for (int p = 3; p >= 0; p--) { // Rows
                for (int t = 0; t < 5; t++) { // Toobs
                    if (toobs[t].checkEmpty() == false && p < toobs[t].getSize()) {
                        System.out.print("|" + toobs[t].getStackIndex(p) + "| ");
                    } else {
                        System.out.print("| | "); // Empty slot
                    }
                }
                System.out.println();
            }
        System.out.println(" 1   2   3   4   5");
        System.out.println("YOU WIN!!!");
        System.exit(0);
        }
    System.out.println("\nSealed: "+totalsealed);
    for (int p = 3; p >= 0; p--) { // Rows
        for (int t = 0; t < 5; t++) { // Toobs
            if (toobs[t].checkEmpty() == false && p < toobs[t].getSize()) {
                System.out.print("|" + toobs[t].getStackIndex(p) + "| ");
            } else {
                System.out.print("| | "); // Empty slot
            }
        }
        System.out.println();
    }

    System.out.println(" 1   2   3   4   5");

    //game here
    System.out.print("Move from: ");
    int movefrom = s.nextInt();
        if (movefrom < 1 || movefrom > 5){
            System.out.print("Input only 1 - 5! Move from: ");
            movefrom = s.nextInt();
        }
    System.out.print("To: ");
    int moveto = s.nextInt();
        if(moveto < 1 || moveto > 5){
            System.out.print("Input only 1 - 5! Move to: ");
            moveto = s.nextInt();
        }


    if (toobs[movefrom-1].checkEmpty() == true){
        System.out.println("Invalid! Tabung from gak boleh kosong");
    }
    else if (toobs[movefrom-1].checkSealed() == true || toobs[moveto-1].checkSealed() == true){
        System.out.println("Invalid! Tabung sealed tidak bisa diedit!");
    }  
    else if (movefrom == moveto){ // diri sendiri
        System.out.println("Invalid! Gak boleh pindah ke diri sendiri");
    }
    else if (toobs[moveto-1].getSize() == 4){
        System.out.println("Invalid! Full, pindahin dulu dong!");
    }
    else if (toobs[moveto-1].checkEmpty() == false && toobs[moveto-1].peekStack() != toobs[movefrom-1].peekStack() ){
        System.out.println("Invalid! Mismatch");
    }
    // else if (toobs[movefrom-1].checkEmpty() == true){
    //     System.out.println("Invalid! Tabung from gak boleh kosong");
    // }
    else{
        int add = toobs[movefrom-1].getPopStack();
        toobs[moveto-1].pushStack(add);
    }

    for (int a = 0; a < 5; a++){
        for (int b = 0; b < 2; b++){
            if (toobs[a].getSize() == 4 && toobs[a].getStackIndex(b) == toobs[a].getStackIndex(b+1)){
                toobs[a].sealedornot = true;
                // System.out.println("test");
            }
            else if (toobs[a].getSize() != 4){
                toobs[a].sealedornot = false;
                break;
            }
            else{
                toobs[a].sealedornot = false;
                break;
            }
        }
    }

    int howmanysealed = 0;
    for (int a = 0; a < 5; a++){
        if (toobs[a].checkSealed() == true){
            howmanysealed++;
        }
    }
    totalsealed = howmanysealed;

    // break; // to prevent looping
    } catch (Exception e){
        System.out.println("Error, shutting down!");
        break;
    }
    } // try catch ends here

    }
}
