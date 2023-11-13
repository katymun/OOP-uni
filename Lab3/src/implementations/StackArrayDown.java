package implementations;

import interfaces.StackIntf;

public class StackArrayDown<T> implements StackIntf<T> {
    private Object[] array;
    private int top;

    public StackArrayDown(int capacity) {
        array = new Object[capacity];
        top = -1;
    }

    @Override
    public void push(T element) {
        if (top < array.length - 1) {
            array[top + 1] = element;
            top++;
        } else {
            System.out.println("Stack overflow");
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public T pop() {
        if (!isEmpty()) {
            return (T) array[top--];
        } else {
            System.out.println("Stack underflow");
            return null; // Indicates underflow
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public T peek() {
        if (!isEmpty()) {
            return (T) array[top];
        } else {
            System.out.println("Stack is empty");
            return null; // Indicates empty stack
        }
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public void printStack() {
        for (int i = top; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    @Override
    public void clear() {
        top = -1;
    }
}
