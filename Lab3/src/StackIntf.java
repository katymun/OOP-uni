public interface StackIntf <T> {
    void push(T t);
    boolean empty();
    T peek();
    T pop();
    int search(T t);
    void add(T t);
    void add(int index, T t);
    void clear();
    int capacity();
    boolean contains(T t);
    T get(int index);
    int indexOf(T t);
    T firstElement();
    void remove(int index);
    void remove(T t); //removes the first occurrence
    void set(int index, T t);

}
