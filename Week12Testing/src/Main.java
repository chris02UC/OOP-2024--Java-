public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();

        // Adding nodes to the tree
        tree.addNodetoRoot("Root");
        tree.addNode("Root", "Child 1");
        tree.addNode("Root", "testing");
        tree.addNode("Child 1", "Grandchild 1");
        tree.addNode("Child 1", "Grandchild 2");
        tree.addNode("testing", "anjing");

        // Removing a node from the tree
        tree.removeNode("testing");

        // Printing the tree structure
        System.out.println("Tree Structure:");
        printTreeStructure(tree.getRoot(), "");
    }

    // Method to print the tree structure recursively
    public static void printTreeStructure(Tree.Node node, String indent) {
        if (node != null) {
            System.out.println(indent + node.getData());
            for (Tree.Node child : node.getChildren()) {
                printTreeStructure(child, indent + "  ");
            }
        }
    }
}
