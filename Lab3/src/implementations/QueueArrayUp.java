package implementations;

import interfaces.QueueIntf;

public class QueueArrayUp<T> implements QueueIntf<T> {
    private Object[] array;
    private int front;
    private int rear;
    private int size;

    public QueueArrayUp(int capacity) {
        array = new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    @Override
    public void enqueue(T element) {
        if (size < array.length) {
            rear = (rear + 1) % array.length;
            array[rear] = element;
            size++;
        } else {
            System.out.println("Queue is full");
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (!isEmpty()) {
            T data = (T) array[front];
            front = (front + 1) % array.length;
            size--;
            return data;
        } else {
            System.out.println("Queue is empty");
            return null; // Indicates empty queue
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public T peek() {
        if (!isEmpty()) {
            return (T) array[front];
        } else {
            System.out.println("Queue is empty");
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printQueue() {
        int i = front;
        for (int count = 0; count < size; count++) {
            System.out.print(array[i] + " ");
            i = (i + 1) % array.length;
        }
        System.out.println();
    }

    @Override
    public void clear() {
        front = 0;
        rear = -1;
        size = 0;
    }
}
