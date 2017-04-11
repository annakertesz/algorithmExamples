package balancedTree;

/**
 * Created by annakertesz on 4/7/17.
 */
public class RedBlackTree<T> {
    Node root;

    public RedBlackTree(Node root) {
        this.root = root;
        this.root.black = true;
        root.leftChild = new Node();
        root.rightChild = new Node();
    }

    public RedBlackTree(int value, T object) {
        this.root = new Node<T>(value, object);
        this.root.black = true;
        root.leftChild = new Node();
        root.rightChild = new Node();
    }

    public static RedBlackTree fillWithList(int[] list){ // static fuggvenyeket vagy az elejere vagy a vegere szok irni
        RedBlackTree tree = new RedBlackTree(new Node(list[0]));
        for (int i=1; i<list.length; i++){
            tree.insert(list[i]);
        }
        return  tree;
    }

    public void insert(int value){
        insertionStep(root, value);
    }

    public void insert(int value, T object){
        insertionStep(root, value, object);
    }

    private void insertionStep(Node node, int value) {
//        System.out.println("... placing node " + value + " ...");
        if (node.value>value && node.value!=0) {
            if (node.leftChild.value == 0) placeNodeToLeft(node, value);
            else insertionStep(node.leftChild, value);
        }
        else if (node.value<=value && node.value!=0){
            if (node.rightChild.value==0) placeNodeToRight(node, value);
            else insertionStep(node.rightChild, value);
        }
    }

    private void insertionStep(Node node, int value, T object) {
//        System.out.println("... placing node " + value + " ...");
        if (node.value>value && node.value!=0) {
            if (node.leftChild.value == 0) placeNodeToLeft(node, value, object);
            else insertionStep(node.leftChild, value, object);
        }
        else if (node.value<=value && node.value!=0){
            if (node.rightChild.value==0) placeNodeToRight(node, value, object);
            else insertionStep(node.rightChild, value, object);
        }
    }

    private void placeNodeToLeft(Node node, int value) {
        node.leftChild = new Node(value);
        node.leftChild.parent = node;
        node.leftChild.leftChild =new Node();
        node.leftChild.rightChild = new Node();
        printNodeRelations(node.leftChild);
        fixViolation(node.leftChild);
    }

    private void placeNodeToLeft(Node node, int value, T object) {
        node.leftChild = new Node(value, object);
        node.leftChild.parent = node;
        node.leftChild.leftChild =new Node();
        node.leftChild.rightChild = new Node();
        printNodeRelations(node.leftChild);
        fixViolation(node.leftChild);
    }

    private void placeNodeToRight(Node node, int value) {
        node.rightChild = new Node(value);
        node.rightChild.parent = node;
        node.rightChild.leftChild =new Node();
        node.rightChild.rightChild = new Node();
        printNodeRelations(node.rightChild);
        fixViolation(node.rightChild);
    }

    private void placeNodeToRight(Node node, int value, T object) {
        node.rightChild = new Node(value, object);
        node.rightChild.parent = node;
        node.rightChild.leftChild =new Node();
        node.rightChild.rightChild = new Node();
        printNodeRelations(node.rightChild);
        fixViolation(node.rightChild);
    }

    private void fixViolation(Node node) {

        System.out.println("\n I'm in violation fixing branch");

        if (node.parent == null) {
            System.out.println("it's the root");
            node.black=true;
            return;
        }

        Node parent = node.parent;

        //        There is no violation
        if(parent.black==true) {
            System.out.println("there is no violation, the parent is black - " + parent.black);
            return;
        }

//        if node is the root, color it black
        if (parent==null) {
            node.black=true;
            System.out.println("my node is the root, so i colored it to black");
            return;
        }

        Node grandParent = node.parent.parent;
        Node uncle = grandParent.leftChild==parent ? grandParent.rightChild : grandParent.leftChild;
        System.out.println("my nodes grandparent is " + grandParent.value + ", and the uncle is " + uncle.value);



//        if uncle is red
        if (!uncle.black) {
            uncle.black = true;
            parent.black = true;
            grandParent.black = false;
            System.out.println("as the uncle was red, i recolored the branch");
            fixViolation(grandParent);
        }

//        if uncle is black
        else if (uncle.black) {

            System.out.print("the uncle is black. ");

//            right triangle case
            if ( parent.leftChild==node && grandParent.rightChild==parent) {
                System.out.println("It's a right triangle case'");
                rightRotate(parent);
                fixViolation(node.rightChild);
            }

//            left triange case
            if (parent.rightChild==node && grandParent.leftChild==parent) {
                System.out.println("It's a left triangle case'");
                leftRotate(parent);
                fixViolation(node.leftChild);
            }

//            right line case
            if (parent.leftChild==node && grandParent.leftChild==parent) {
                System.out.println("It's a right line case'");
                rightRotate(grandParent);
                node.parent.black=true;
                node.parent.rightChild.black=false;
            }

//            left line case
            if (parent.rightChild==node && grandParent.rightChild==parent) {
                System.out.println("It's a left line case'");
                leftRotate(grandParent);
                node.parent.black=true;
                node.parent.leftChild.black=false;
            }
        }
    }

    private void leftRotate(Node node){
//        System.out.println("i rotate my node " + node.value);
        Node orphan = node.rightChild.leftChild;

        if (node.parent==null) {
            node.parent = node.rightChild;
            node.parent.leftChild = node;
            node.parent.parent=null;
            root = node.parent;
        }
        else {
            Node parent = node.parent;
            if (parent.leftChild == node) parent.leftChild = node.rightChild;
            if (parent.rightChild == node) parent.rightChild = node.rightChild;
            node.parent = node.rightChild;
            node.parent.leftChild = node;
            node.parent.parent = parent;
        }
        node.rightChild = orphan;
        node.rightChild.parent = node;
        printRotationResult(node, orphan);

    }

    private void rightRotate(Node node){
        Node orphan = node.leftChild.rightChild;
        if (node.parent==null) {
            node.parent = node.leftChild;
            node.parent.rightChild = node;
            node.parent.parent =null;
            root = node.parent;
        }
        else {
            Node parent = node.parent;
            if (parent.leftChild == node) parent.leftChild = node.leftChild;
            if (parent.rightChild == node) parent.rightChild = node.leftChild;

            node.parent = node.leftChild;
            node.parent.rightChild = node;
            node.parent.parent = parent;
        }
        node.leftChild = orphan;
        node.leftChild.parent = node;

//        Node orphanBranch = node.rightChild;
//        Node futureParent = node.parent.parent;
//        node.rightChild = node.parent;
//        node.parent = futureParent;
//        node.rightChild.parent = node;
//        node.leftChild.rightChild = orphanBranch;
//        orphanBranch.parent = node.leftChild;

        printRotationResult(node, orphan);

    }

    private void printRotationResult(Node node, Node orphanBranch){
        System.out.println("\n after rotation my new relations: ");
        System.out.println("   my node is " + node.value);
        if (node.parent == null) System.out.println("he is the root.");
        else {
            System.out.println("   his parent is " + node.parent.value);

            if (node.parent.parent == null) System.out.println("    his parent is the root.");
            else System.out.println("     his grandparent is " + node.parent.parent.value);
        }

        System.out.println("   his new kids are: " + node.leftChild.value + " from the left, and " + node.rightChild.value + " from the right");
        System.out.println("   my orphan node is the kid of " + orphanBranch.parent.value);
    }

    private void printNodeRelations(Node node) {
        if (node.parent==null) System.out.println("my node, the " + node.value + ", is the root");
        else {
            System.out.println("\n  My node is the " + node.value);
            System.out.print("  his parent id " + node.parent.value);
            if (node.parent.leftChild==node) System.out.println(", it is his left child");
            if (node.parent.rightChild==node) System.out.println(", it is his right child");
            System.out.println("  his left child is  " + node.leftChild.value);
            System.out.println("  his right child is  " + node.rightChild.value);
        }
    }

    public void print(){
        printTree(root, 1);
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
