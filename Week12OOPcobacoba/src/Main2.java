import java.util.Queue;

public class Main2 {
    public static void main(String[] args) {
        // Create a new Tree object
        Tree tree = new Tree();

        // Add nodes to the tree
        tree.addNodetoRoot("A");
        tree.addNode("A", "B");
        tree.addNode("B", "asu");
        tree.addNode("B", "tai");
        tree.addNode("A", "C");
        tree.addNode("A", "D");

        // Print the tree before removing a node
        System.out.println("Tree before removing a node:");
        printTree(tree.getRoot(), "");

        // Remove a node
        tree.removeNode("B");

        // Print the tree after removing a node
        System.out.println("\n\nTree after removing node with value 'B':");
        printTree(tree.getRoot(), "");
    }

    // Helper method to print the tree
    private static void printTree(Tree.Node node, String indent) {
        System.out.println(indent + node.getData());
        Tree.Node[] children = node.getChildren();
        for (Tree.Node n : children) {
            printTree(n, indent + "  ");
        }
    }
}