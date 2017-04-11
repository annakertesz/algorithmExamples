package stack;

/**
 * Created by annakertesz on 4/3/17.
 */
public class Stack {

    StackNode top;

    public Stack() {
        this.top = null;
    }

    public void push(int value) {
        StackNode lastNode = top;
        top = new StackNode(value);
        top.nodeBefore = lastNode;
    }

    public int pop() {
        StackNode lastNode = top;
        top = top.nodeBefore;
        return lastNode.value;
    }

    public void print() {
        System.out.println("");
        if (top==null) System.out.println("list is empty");
        else printNode(top);
    }

    public void printNode(StackNode node) {
        System.out.print(node.value + ", ");
        if (node.nodeBefore==null) return;
        else printNode(node.nodeBefore);
    }




}
