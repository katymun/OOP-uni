package implementations;

import interfaces.StackIntf;

import java.util.LinkedList;

public class LinkedListStack<T> implements StackIntf<T> {
    private LinkedList<T> stack;

    public LinkedListStack() {
        stack = new LinkedList<>();
    }

    @Override
    public void push(T element) {
        stack.addFirst(element);
    }

    @Override
    public T pop() {
        if (!isEmpty()) {
            return stack.removeFirst();
        } else {
            System.out.println("Stack underflow");
            return null;
        }
    }

    @Override
    public T peek() {
        if (!isEmpty()) {
            return stack.getFirst();
        } else {
            System.out.println("Stack is empty");
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public void printStack() {
        for (T element : stack) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    @Override
    public void clear() {
        stack.clear();
    }
}