package linkedList;

/**
 * Created by annakertesz on 4/3/17.
 */
public class MyLinkedList {

    LinkedLIstNode head;

    public MyLinkedList() {
        this.head = null;
    }

    public void add(int value) {
        addElement(head, value);
    }

    public void print() {
        System.out.println("");
        if (head==null) System.out.println("list is empty");
        else printNode(head);
    }

    public void remove(int index) {
        if (index==0) head = head.nextNode;
        else removeElement(head, index);
    }


    private boolean printNode(LinkedLIstNode node){
        System.out.print(node.value + ", ");
        if (node.nextNode==null) return false;
        else printNode(node.nextNode);
        return true;
    }

    private void addElement(LinkedLIstNode node, int value){
        if (node == null) head=new LinkedLIstNode(value);
        else if (node.nextNode==null) node.nextNode = new LinkedLIstNode(value);
        else addElement(node.nextNode, value);
    }

    private boolean removeElement(LinkedLIstNode node, int index){
        if (node.nextNode==null) {
            System.out.println("index out of bounds");
            return false;
        }
        else if (index==1) node.nextNode=node.nextNode.nextNode;
        else removeElement(node.nextNode, index-1);
        return true;
    }

}