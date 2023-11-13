import implementations.LinkedListStack;
import implementations.StackArrayDown;
import implementations.StackArrayUp;
import interfaces.StackIntf;

public class StackDemo {
    public static void main(String[] args) {
        StackIntf<String> stackArrayUp = new StackArrayUp<>(10);
        stackDemo(stackArrayUp);

        StackIntf<String> stackArrayDown = new StackArrayDown<>(10);
        stackDemo(stackArrayDown);

        StackIntf<String> linkedListStack = new LinkedListStack<>();
        stackDemo(linkedListStack);

    }

    public static void stackDemo(StackIntf<String> stack) {
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
        System.out.print("Cleared stack: ");
        stack.clear();
        stack.printStack();
        System.out.println("Is the stack empty: " + stack.isEmpty());

        System.out.println("");
    }

    public static void queueDemo() {

    }

}
