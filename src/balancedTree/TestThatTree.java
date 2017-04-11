package balancedTree;

import java.util.ArrayList;

/**
 * Created by annakertesz on 4/7/17.
 */
public class TestThatTree {

    public static void test(int[] list){

        RedBlackTree tree = RedBlackTree.fillWithList(list);

        if (testRoot(tree)) System.out.println("the root is black");
        else System.out.println("FAIL: the root is red!");

        if (testLeafs(tree)) System.out.println("all leafs are black");
        else System.out.println("FAIL: there is at least one red leaf");

        if (testRedNodeChild(tree)) System.out.println("every child of a red node is black");
        else System.out.println("FAIL: there is at least one red child of a red node");

        if (testBlackNodeNum(tree)) System.out.println("Black nodes num is equal on every root");
        else System.out.println("FAIL: there is some problem with the number of black nodes");
    }

    private static boolean testRoot(RedBlackTree tree){
        return tree.root.black;
    }

    private static boolean testLeafs(RedBlackTree tree){
        ArrayList<Node> leafes= new ArrayList<Node>();
        findLeaf(tree.root, leafes);
        for (Node leaf : leafes) {
            if (!leaf.black) return false;
        }
        return true;
    }

    private static boolean testRedNodeChild(RedBlackTree tree){
        ArrayList<Boolean> redNodesChild = new ArrayList<Boolean>();
        findRedNodes(tree.root, redNodesChild);
        for (Boolean nodeIsBlack : redNodesChild) {
            if (!nodeIsBlack) return false;
        }
        return true;

    }

    private static boolean testBlackNodeNum(RedBlackTree tree){
        ArrayList<Integer> blackNums = new ArrayList<Integer>();
        getBlackNodeNum(tree.root, blackNums, 0);
        for (Integer num : blackNums) {
            if (num != blackNums.get(0)) return false;
        }
        return true;
    }

    private static void findLeaf(Node node, ArrayList leafes){
        if (node.leftChild == null && node.rightChild == null) leafes.add(node);
        if (node.leftChild != null) findLeaf(node.leftChild, leafes);
        if (node.rightChild != null) findLeaf(node.rightChild, leafes);
    }

    private static void findRedNodes(Node node, ArrayList redNodesChild){
        if (node.leftChild == null && node.rightChild == null) return;
        if (!node.black) {
            redNodesChild.add(node.leftChild.black && node.rightChild.black);
        }
        if (node.leftChild != null) findRedNodes(node.leftChild, redNodesChild);
        if (node.rightChild != null) findRedNodes(node.rightChild, redNodesChild);
    }

    private static void getBlackNodeNum(Node node, ArrayList<Integer> blackNums, int counter) {
        if (node.leftChild == null && node.rightChild == null) {
            blackNums.add(counter);
        }
        if (node.leftChild != null) {
            if (node.leftChild.black) getBlackNodeNum(node.leftChild, blackNums, counter+1);
            else getBlackNodeNum(node.leftChild, blackNums, counter);
        }
        if (node.rightChild != null) {
            if (node.rightChild.black) getBlackNodeNum(node.rightChild, blackNums, counter+1);
            else getBlackNodeNum(node.rightChild, blackNums, counter);
        }
    }
}
