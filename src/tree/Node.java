package tree;

/**
 * Created by annakertesz on 4/6/17.
 */
public class Node {

    int value;
    Node parent;
    Node leftChild;
    Node rightChild;
    boolean visited;

    public Node(int value) {
        this.value = value;
        this.parent = null;
        this.leftChild = null;
        this.rightChild = null;
        this.visited = false;

    }
}
