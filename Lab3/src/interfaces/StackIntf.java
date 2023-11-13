package interfaces;

public interface StackIntf <T> {
    boolean isEmpty();
    void push(T element);
    T pop();
    T peek();
    int size();
    void printStack();
    void clear();

}
