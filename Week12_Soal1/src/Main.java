import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);        
    // Create a new Tree object
        TrinaryTree tree1 = new TrinaryTree();
        TrinaryTree tree = new TrinaryTree();
        ArrayList<Integer> temp = new ArrayList<>();
        // Add nodes to the tree

        for (int i = 0; i < 13; i++){
            System.out.print("Write a number: ");
            int a = s.nextInt();
            temp.add(a);
            System.out.print("Continue? (Y/N): ");
            String yesno = s.next() + s.nextLine();
            while (!yesno.equalsIgnoreCase("y") && !yesno.equalsIgnoreCase("n")){
                System.out.print("Invalid! Continue? (Y/N):  ");
                yesno = s.next() + s.nextLine();
            }
                if (yesno.equalsIgnoreCase("y")){System.out.println("");}
                else if (yesno.equalsIgnoreCase("n")){
                    System.out.println("Exiting!");
                    break;
                }
        }

        int left = 0;
        int middle = 0;
        int right = 0;
        for (int i = 0; i < temp.size(); i++){
            if (i == 0){
                tree.addNodetoRoot(temp.get(i));
            }
            else if (i == 1){ // first row
                if (temp.size() == 2){
                int firstrow1 = temp.get(i);
                    tree.addNode(temp.get(0), firstrow1);
                    break;
                }
                if (temp.size() == 3){
                int firstrow1 = temp.get(i);
                int firstrow2 = temp.get(i+1);
                    if (firstrow1 < firstrow2){
                        tree.addNode(temp.get(0), firstrow1);
                        tree.addNode(temp.get(0), firstrow2);
                    } else {
                        tree.addNode(temp.get(0), firstrow2);
                        tree.addNode(temp.get(0), firstrow1);
                    }
                    break;
                }
                if (temp.size() >= 4){
                int firstrow1 = temp.get(i);
                int firstrow2 = temp.get(i+1);
                int firstrow3 = temp.get(i+2);
                    int[] sorted = {firstrow1, firstrow2, firstrow3};
                    Arrays.sort(sorted);
                    tree.addNode(temp.get(0), sorted[0]);
                    tree.addNode(temp.get(0), sorted[1]);
                    tree.addNode(temp.get(0), sorted[2]);
                    left = sorted[0];
                    middle = sorted[1];
                    right = sorted[2];
                i += 2; // i becomes 3, add when loop becomes 4
                }
            }
            else if (i >= 4 && i < 7){
                if (temp.size() == 5){
                int secondrow1 = temp.get(i);
                tree.addNode(left, secondrow1);
                break;
                } 
                else if (temp.size() == 6){
                    System.out.println("test");
                    int secondrow1 = temp.get(i);
                    int secondrow2 = temp.get(i+1);
                    if (secondrow1 < secondrow2){
                        tree.addNode(left, secondrow1);
                        tree.addNode(left, secondrow2);
                    } else {
                        tree.addNode(left, secondrow2);
                        tree.addNode(left, secondrow1);
                    }
                break;
                } 
                else if (temp.size() >= 7){
                    int secondrow1 = temp.get(i);
                    int secondrow2 = temp.get(i+1);
                    int secondrow3 = temp.get(i+2);
                        int[] sorted = {secondrow1, secondrow2, secondrow3};
                        Arrays.sort(sorted);
                        tree.addNode(left, sorted[0]);
                        tree.addNode(left, sorted[1]);
                        tree.addNode(left, sorted[2]);
                    i += 2; // i becomes 6 (4 +6), add when loop becomes 7
                } 
            }
            else if (i >= 7 && i < 10){
                if (temp.size() == 8){
                    int secondrow1 = temp.get(i);
                    tree.addNode(middle, temp.get(i));
                    break;
                    } 
                    else if (temp.size() == 9){
                        int secondrow1 = temp.get(i);
                        int secondrow2 = temp.get(i+1);
                        if (secondrow1 < secondrow2){
                            tree.addNode(middle, secondrow1);
                            tree.addNode(middle, secondrow2);
                        } else {
                            tree.addNode(middle, secondrow2);
                            tree.addNode(middle, secondrow1);
                        }
                    break;
                    } 
                    else if (temp.size() >= 10){
                        int secondrow1 = temp.get(i);
                        int secondrow2 = temp.get(i+1);
                        int secondrow3 = temp.get(i+2);
                            int[] sorted = {secondrow1, secondrow2, secondrow3};
                            Arrays.sort(sorted);
                            tree.addNode(middle, sorted[0]);
                            tree.addNode(middle, sorted[1]);
                            tree.addNode(middle, sorted[2]);
                        i += 2; // i becomes 9 (7 + 2), add when loop becomes 10
                    } 
            }
            else if (i > 10 && i < 13){
                if (temp.size() == 11){
                    int secondrow1 = temp.get(i);
                    tree.addNode(right, temp.get(i));
                    break;
                    } 
                    else if (temp.size() == 12){
                        int secondrow1 = temp.get(i);
                        int secondrow2 = temp.get(i+1);
                        if (secondrow1 < secondrow2){
                            tree.addNode(right, secondrow1);
                            tree.addNode(right, secondrow2);
                        } else {
                            tree.addNode(right, secondrow2);
                            tree.addNode(right, secondrow1);
                        }
                        break;
                    } 
                    else if (temp.size() >= 13){
                        int secondrow1 = temp.get(i);
                        int secondrow2 = temp.get(i+1);
                        int secondrow3 = temp.get(i+2);
                            int[] sorted = {secondrow1, secondrow2, secondrow3};
                            Arrays.sort(sorted);
                            tree.addNode(right, sorted[0]);
                            tree.addNode(right, sorted[1]);
                            tree.addNode(right, sorted[2]);
                        i += 2; // i becomes 9 (7 + 2), add when loop becomes 10
                    } 
            }
        }
        
        System.out.println("");
        printTreeStraight(tree.getRoot());
        System.out.println("\n");
        // printTree(tree.getRoot(), "");

        String yesnode = "";
        while (!yesnode.equalsIgnoreCase("n")){
        System.out.print("Input to remove a node:");
        int removenode = s.nextInt();
        tree.removeNode(removenode);

        System.out.println("\nResult after removing node: ");
        printTreeStraight(tree.getRoot());
        System.out.println("\n");
        // printTree(tree.getRoot(), "");

        System.out.print("Remove again? (Y/N): ");
        yesnode = s.next()+s.nextLine();
        while (!yesnode.equalsIgnoreCase("y") && !yesnode.equalsIgnoreCase("n")){
            System.out.print("Invalid! Continue? (Y/N):  ");
            yesnode = s.next() + s.nextLine();
        }
            if (yesnode.equalsIgnoreCase("y")){System.out.println("");}
            else if (yesnode.equalsIgnoreCase("n")){
                System.out.println("Exiting!");
                break;
            }
        }

        System.out.println("Add again (Y/N): ");
        String yesnoagain = s.next() + s.nextLine();
        while (!yesnoagain.equalsIgnoreCase("y") && !yesnoagain.equalsIgnoreCase("n")){
            System.out.print("Invalid! Continue? (Y/N):  ");
            yesnoagain = s.next() + s.nextLine();
        }
            if (yesnoagain.equalsIgnoreCase("y")){
            System.out.print("Input: ");
            int inputagain = s.nextInt();
            tree.addNode(temp.get(0), inputagain);
            }
            else if (yesnoagain.equalsIgnoreCase("n")){
                System.out.println("Exiting!");
                System.exit(0);
            }

        System.out.println("");
        printTreeStraight(tree.getRoot());
        }

    private static void printTree(TrinaryTree.Node node, String indent) {
        System.out.println(indent + node.getData());
        TrinaryTree.Node[] children = node.getChildren();
        for (TrinaryTree.Node n : children) {
            printTree(n, indent + "  ");
        }
    }

    private static void printTreeStraight(TrinaryTree.Node node) {
        if (node == null) return;
    
        System.out.print(node.getData() + " ");
    
        TrinaryTree.Node[] children = node.getChildren();
        if (children.length > 0) {
            printTreeStraight(children[0]);
            if (children.length > 1) {
                printTreeStraight(children[1]);
                if (children.length > 2) {
                    printTreeStraight(children[2]);
                }
            }
        }
    }
}