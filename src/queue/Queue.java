package queue;

/**
 * Created by annakertesz on 4/3/17.
 */
public class Queue {

    QueueNode head;
    QueueNode tail;

    public Queue() {
        this.head = null;
        this.tail = null;
    }

    public void push(int value) {
        if (head==null) {
            head = new QueueNode(value);
            tail = head;
        }
        else {
            tail.before = new QueueNode(value);
            tail = tail.before;
        }
    }

    public void pop() {
        System.out.println(head);
        head = head.before;
    }
}
