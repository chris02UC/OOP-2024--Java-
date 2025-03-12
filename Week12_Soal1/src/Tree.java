import java.util.ArrayList;
import java.util.LinkedList;

public class Tree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void addNodetoRoot (int a){
        Node newNode = new Node(a);
        if(root == null){
            root = newNode;
        } else {
            root.addChild(newNode);
        }
    }
    
    public void addNode(Object parent, Object value){
        //1. make new node
        //2. find node that isinya parent
        //3. Tambahkan node baru sbg anak node parent
        Node newNode = new Node(value);
        Node nodeParent = searchNode(parent, root, new Queue());
        if (nodeParent == null){
            System.out.println("Node parent not found");
            root.addChild(newNode);
        } else {
            nodeParent.addChild(newNode);
        }
    }

    public Node searchNode(Object data, Node root, Queue q){
        if(root.getData().equals(data)){
            return root;
        }else{
            Node[] children = root.getChildren();
            for (Node n : children){
                q.enqueue(n);
            }
            while(!q.isEmpty()){
                root = (Node) q.dequeue();
                return searchNode(data, root, q);
            }
            return null;
        }
    }

    public boolean removeNode(Object data){
        //1. Cari parent dari node yg mau dihapus
        Node nodeParent = searchParent(data, root, new Queue());
        Node node;

        if(nodeParent == null){
            if(root.getData().equals(data)){
                root = null;
                return true;
            }else{
                return false;
            }
        }
        //2. Cari node yg mau dihapus
        node = searchNode(data, nodeParent, new Queue());
        //3. Hapus node
        nodeParent.deleteChild(node);
        //4. Tambahkan children dari node yg dihapus
        Node[] children = node.getChildren();
        for(Node n : children){
            nodeParent.addChild(n);
        }
        return true;
    }

    public boolean removeNode1(Object data) {
        Queue q = new Queue();
    
        // Find the parent of the node to be removed
        Node nodeParent = searchParent(data, root, q);
        if (nodeParent == null) {
            // If the parent is null, it means we're removing the root node
            if (root.getData().equals(data)) {
                root = null;
                return true;
            } else {
                return false; // Node to delete not found
            }
        }
    
        // Find the node to be removed
        Node nodeToRemove = searchNode(data, root, q);
        if (nodeToRemove == null) {
            return false; // Node to delete not found
        }
    
        // Delete the node from its parent's children list
        nodeParent.deleteChild(nodeToRemove);
    
        // Add children of the deleted node to its parent
        Node[] children = nodeToRemove.getChildren();
        for (Node child : children) {
            nodeParent.addChild(child);
        }
        return true;
    }
    
    
    public Node searchParent(Object data, Node root, Queue q){
        Node[] children = root.getChildren();
        for (Node n : children){
            if(n.getData().equals(data)){
                return n;
            }
        }
        for (Node n : children){
            q.enqueue(n);
        }
        while(!q.isEmpty()){
            root = (Node) q.dequeue();
            return searchNode(data, root, q);
        }
        return null;
    }

    class Node{
        private Object data;
        //anak bisa sebanyak mungkin
        private ArrayList<Node> children;

        public Node(Object newData){
            data = newData;
            children = new ArrayList<Node>();
        }

        public void addChild(Node newNode){
            children.add(newNode);
        }
        
        public void deleteChild(Node delNode){
            children.remove(delNode);
        }
        
        public Node[] getChildren(){
            Node[] nodes = new Node[children.size()];
            for (int a = 0; a < children.size(); a++){
                nodes[a] = children.get(a);
            }
            return nodes;
        }

        public Object getData(){
            return data;
        }

        public void setData(Object data){
            this.data = data;
        }
    }
}
