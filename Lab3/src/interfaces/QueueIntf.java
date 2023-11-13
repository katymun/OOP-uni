package interfaces;

public interface QueueIntf {
    void enqueue(int element);
    int dequeue();
    int peek();
    boolean isEmpty();
    int size();
    void printQueue();

}
