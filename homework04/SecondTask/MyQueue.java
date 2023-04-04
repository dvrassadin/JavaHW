package homework04.SecondTask;

import java.util.LinkedList;

public class MyQueue {
    static LinkedList<Integer> queue = new LinkedList<>();

    public void print() {
        System.out.println(queue);
    }

    public void enqueue(int element) {
        queue.add(element);
    }

    public int dequeue() {
        return queue.removeFirst();
    }

    public Integer first() {
        return queue.getFirst();
    }
}
