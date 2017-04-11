package tree;

/**
 * Created by annakertesz on 4/6/17.
 */
public class BinaryTree {

    Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public void print(){
        printTree(root, 1);
    }

    public void insert(int value){
        insertionStep(root, value);
    }

    public Node search(int value) {
        System.out.println("\n\nMy binary search:");
        Node result = searchStep(root, value);
        System.out.println(result.value);
        return result;

    }

    public static BinaryTree fillWithList(int[] list){ // static fuggvenyeket vagy az elejere vagy a vegere szok irni
        BinaryTree tree = new BinaryTree(new Node(list[0]));
        for (int i=1; i<list.length; i++){
            tree.insert(list[i]);
        }
        return  tree;
    }

    private Node searchStep(Node node, int value) {
        System.out.print("i check the node " + node.value + ". ");
        if (node.value == value) {
            System.out.println("yeah, i found it!");
            return node;
        }
        if (node.value > value) {
            System.out.println("My value is smaller than that");
            if (node.leftChild==null) return null;
            return searchStep(node.leftChild, value);
        }
        if (node.value < value ) {
            if (node.rightChild == null) return null;
            System.out.println("My value is greater than that");
            return searchStep(node.rightChild, value);
        }
        return null;
    }

    private void insertionStep(Node node, int value) {
        if (node.value>value) {
            if (node.leftChild == null) node.leftChild = new Node(value);
            else insertionStep(node.leftChild, value);
        }
        else {
            if (node.rightChild==null) node.rightChild=new Node(value);
            else insertionStep(node.rightChild, value);
        }

    }

    private void printTree(Node node, int a){
        System.out.println(node.value);
        if (node.leftChild!=null) {
            printTree(node.leftChild, a+1);
        }
        if (node.rightChild!=null) {
            printTree(node.rightChild, a+1);
        }
    }

}

