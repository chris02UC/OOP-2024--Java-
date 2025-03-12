import java.util.ArrayList;
import java.util.LinkedList;

public class TrinaryTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void addNodetoRoot(int a) {
        Node newNode = new Node(a);
        if (root == null) {
            root = newNode;
        } else {
            root.addChild(newNode);
        }
    }

    public void addNode(int parent, int value) {
        Node newNode = new Node(value);
        Node nodeParent = searchNode(parent, root, new Queue());
        if (nodeParent == null) {
            System.out.println("Node parent not found");
            root.addChild(newNode);
        } else {
                nodeParent.addChild(newNode);
        }
    }
    

    public Node searchNode(int data, Node root, Queue q) {
        if (root.getData() == data) {
            return root;
        } else {
            Node[] children = root.getChildren();
            for (Node n : children) {
                q.enqueue(n);
            }
            while (!q.isEmpty()) {
                root = (Node) q.dequeue();
                Node result = searchNode(data, root, q);
                if (result!= null) {
                    return result;
                }
            }
            return null;
        }
    }

    public boolean removeNode(int data) {
        Node nodeParent = searchParent(data, root, new Queue());
        Node node;
    
        if (nodeParent == null) {
            if (root.getData() == data) {
                root = null;
                return true;
            } else {
                return false;
            }
        }
    
        node = searchNode(data, root, new Queue());
        if (node == null) {
            return false;
        }
    
        Node[] siblings = nodeParent.getChildren();
        int siblingCount = siblings.length - 1; // exclude the node to be removed
    
        Node[] children = node.getChildren();
        if (siblingCount == 0) { // by itself
            // no siblings, make children of the node to be removed children of the parent
            for (Node child : children) {
                nodeParent.addChild(child);
            }
        }
        else if (siblingCount == 1) {
            Node sibling = siblings[0];
            if (sibling.getData() == data) {
                // the node to be removed is the sibling, so we need to handle the case when the node has children
                sibling = siblings[1];
                for (Node child : children) {
                    sibling.addChild(child);
                }
            } else {
                // the node to be removed is not the sibling, so we just add the children of the node to be removed to the sibling
                for (Node child : children) {
                    sibling.addChild(child);
                }
            }
        }
        else if (siblingCount == 2){
            // give children to the siblings based on the rules
            Node smallestSibling = getSmallestSibling(siblings);
            if (smallestSibling == node) {
                // the node to be removed is the smallest sibling, so we need to handle the case when the node has children
                Node secondSmallestSibling = getSecondSmallestSibling(siblings);
                smallestSibling = secondSmallestSibling;
                // for (Node child : children) {
                //     secondSmallestSibling.addChild(child);
                // }
            } //else {
            int childcounter = 0;
                for (int i = 0; i < children.length; i++){
                    if (children.length < 3 || i < 2) {
                        smallestSibling.addChild(children[i]);
                    } else {
                        Node nextSibling = getNextSibling(smallestSibling, siblings);
                        nextSibling.addChild(children[i]);
                    }
                }
                // for (Node child : children) {
                //     if (smallestSibling.getData() <= child.getData()) {
                //         smallestSibling.addChild(child);
                //     } else {
                //         Node nextSibling = getNextSibling(smallestSibling, siblings);
                //         nextSibling.addChild(child);
                //     }
                // }
           // }
        }
        nodeParent.deleteChild(node);
        return true;
    }
    
    private Node getSmallestSibling(Node[] siblings) {
        Node smallest = siblings[0];
        for (Node sibling : siblings) {
            if (sibling.getData() < smallest.getData()) {
                smallest = sibling;
            }
        }
        return smallest;
    }

    private Node getSecondSmallestSibling(Node[] siblings) {
        Node secondSmallest = siblings[0];
        Node sibling0 = siblings[0];
        Node sibling1 = siblings[1];
        Node sibling2 = siblings[2];

        if (sibling0.getData() < sibling1.getData() && sibling1.getData() < sibling2.getData()){
            secondSmallest = siblings[1];
        }
        else if (sibling1.getData() < sibling0.getData() && sibling0.getData() < sibling2.getData()){

        }
        // if (secondSmallest.getData() < smallest.getData()) {
        //     Node temp = smallest;
        //     smallest = secondSmallest;
        //     secondSmallest = temp;
        // }
        // for (int i = 2; i < siblings.length; i++) {
        //     Node sibling = siblings[i];
        //     if (sibling.getData() < smallest.getData()) {
        //         secondSmallest = smallest;
        //         smallest = sibling;
        //     } else if (sibling.getData() < secondSmallest.getData()) {
        //         secondSmallest = sibling;
        //     }
        // }
        return secondSmallest;
    }
    
    private Node getNextSibling(Node sibling, Node[] siblings) {
        int index = 0;
        for (Node s : siblings) {
            if (s == sibling) {
                break;
            }
            index++;
        }
        return siblings[(index + 1) % siblings.length];
    }

    public Node searchParent(int data, Node root, Queue q) {
        Node[] children = root.getChildren();
        for (Node n : children) {
            if (n.getData() == data) {
                return root;
            }
        }
        for (Node n : children) {
            q.enqueue(n);
        }
        while (!q.isEmpty()) {
            root = (Node) q.dequeue();
            Node result = searchParent(data, root, q);
            if (result!= null) {
                return result;
            }
        }
        return null;
    }

    class Node {
        private int data;
        private ArrayList<Node> children;

        public Node(int newData) {
            data = newData;
            children = new ArrayList<Node>();
        }

        public void addChild(Node newNode) {
            if (children.size() < 3) {
                children.add(newNode);
            } else {
                System.out.println("Node already has 3 children");
            }
        }

        public void deleteChild(Node delNode) {
            children.remove(delNode);
        }

        public Node[] getChildren() {
            Node[] nodes = new Node[children.size()];
            for (int a = 0; a < children.size(); a++) {
                nodes[a] = children.get(a);
            }
            return nodes;
        }
        public int getNumChildren() {
            return children.size();
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }

    class Queue {
        private LinkedList<Node> list = new LinkedList<Node>();

        public void enqueue(Node item) {
            list.addLast(item);
        }

        public Node dequeue() {
            return list.pollFirst();
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }
    }
}