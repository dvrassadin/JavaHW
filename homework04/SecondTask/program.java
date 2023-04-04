package homework04.SecondTask;

// Реализуйте очередь с помощью LinkedList со следующими методами:
// enqueue() - помещает элемент в конец очереди,
// dequeue() - возвращает первый элемент из очереди и удаляет его,
// first() - возвращает первый элемент из очереди, не удаляя.

public class program {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        for (int i = 0; i < 10; i++)
            queue.enqueue(i);
        queue.print();

        System.out.println(queue.dequeue());
        queue.print();

        System.out.println(queue.first());
    }
}
