package interfaces;

public interface QueueIntf <T> {
    void enqueue(T element);
    T dequeue();
    T peek();
    boolean isEmpty();
    int size();
    void printQueue();
    void clear();

}
