import implementations.*;
import interfaces.QueueIntf;
import interfaces.StackIntf;

public class StackQueueDemo {
    public static void main(String[] args) {
        StackIntf<String> stackArrayUp = new StackArrayUp<>(10);
        stackDemo(stackArrayUp);

        StackIntf<String> stackArrayDown = new StackArrayDown<>(10);
        stackDemo(stackArrayDown);

        StackIntf<String> linkedListStack = new LinkedListStack<>();
        stackDemo(linkedListStack);

        QueueIntf<String> queueArrayUp = new QueueArrayUp<>(10);
        queueDemo(queueArrayUp);

        QueueIntf<String> queueArrayDown = new QueueArrayDown<>(10);
        queueDemo(queueArrayUp);

        QueueIntf<String> linkedListQueue = new LinkedListQueue<>();
        queueDemo(queueArrayUp);

    }

    public static void stackDemo(StackIntf<String> stack) {
        System.out.println(stack.getClass());
        stack.push("Katea");
        stack.push("Marin");
        stack.push("Liuda");
        stack.push("Masha");
        stack.printStack();
        System.out.println("Popped element: " + stack.pop());
        stack.printStack();
        System.out.println("Peeked element: " + stack.peek());
        System.out.println("Size: " + stack.size());
        stack.printStack();
        System.out.println("Is the stack empty: " + stack.isEmpty());
        System.out.print("Cleared stack: ");
        stack.clear();
        stack.printStack();
        System.out.println("Is the stack empty: " + stack.isEmpty());

        System.out.println("");
    }

    public static void queueDemo(QueueIntf<String> queue) {
        System.out.println(queue.getClass());
        queue.enqueue("Katea");
        queue.enqueue("Marin");
        queue.enqueue("Liuda");
        queue.enqueue("Masha");
        queue.printQueue();
        System.out.println("Dequeued element: " + queue.dequeue());
        queue.printQueue();
        System.out.println("Peeked element: " + queue.peek());
        System.out.println("Size: " + queue.size());
        queue.printQueue();
        System.out.println("Is the queue empty: " + queue.isEmpty());
        System.out.print("Cleared queue: ");
        queue.clear();
        queue.printQueue();
        System.out.println("Is the queue empty: " + queue.isEmpty());

        System.out.println("");
    }

}
