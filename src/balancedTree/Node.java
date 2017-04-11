package balancedTree;

/**
 * Created by annakertesz on 4/7/17.
 */
public class Node<T> {

    int value;
    Node parent;
    Node leftChild;
    Node rightChild;
    T object;
    boolean visited;
    boolean black;

    public Node() {
        this.black=true;
    }

    public Node(int value) {
        this.value = value;
        this.parent = null;
        this.leftChild = null;
        this.rightChild = null;
        this.visited = false;
        this.black = false;
    }

    public Node(int value, T object) {
        this.value = value;
        this.parent = null;
        this.leftChild = null;
        this.rightChild = null;
        this.visited = false;
        this.black = false;
        this.object = object;
    }
}


