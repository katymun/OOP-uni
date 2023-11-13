package implementations;

import interfaces.QueueIntf;

import java.util.LinkedList;

public class LinkedListQueue<T> implements QueueIntf<T> {
    private LinkedList<T> queue;

    public LinkedListQueue() {
        queue = new LinkedList<>();
    }

    @Override
    public void enqueue(T element) {
        queue.addLast(element);
    }

    @Override
    public T dequeue() {
        if (!isEmpty()) {
            return queue.removeFirst();
        } else {
            System.out.println("Queue is empty");
            return null; // Indicates empty queue
        }
    }

    @Override
    public T peek() {
        if (!isEmpty()) {
            return queue.getFirst();
        } else {
            System.out.println("Queue is empty");
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public void printQueue() {
        for (T element : queue) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    @Override
    public void clear() {
        queue.clear();
    }
}
