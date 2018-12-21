package engineer.paul.util;

public class Stack {

    private String[] stack;
    private int currentPosition;

    /**
     * Initializes a Stack with an initial currentPosition of 10
     */
    public Stack() {
        this.stack = new String[10];
        this.currentPosition = 0;
    }

    /**
     * Pushes a single String element to the top of the stack.
     * @param element a string to be pushed onto the stack
     */
    public void push(String element) {
        if (this.currentPosition == stack.length-1)
            this.grow();

        this.stack[currentPosition] = element;
        this.currentPosition++;
    }

    /**
     * @return String element from the top of the stack
     */
    public String pop() {
        String elem = stack[this.currentPosition-1];
        stack[this.currentPosition-1] = null;
        this.currentPosition--;

        return elem;
    }

    /**
     * @return returns the element at the top of the stack or NULL if the stack is empty
     */
    public String peek() {
        if (!isEmpty())
            return this.stack[currentPosition-1];

        return null;
    }

    /**
     * @return returns the size of the stack
     */
    public int size() {
        return this.stack.length;
    }

    /**
     * @return return true is the stack is empty or false is the stack is not empty
     */
    public boolean isEmpty() {
        if (this.currentPosition == 0 && this.stack[currentPosition] == null)
            return true;
        else
            return false;
    }

    /**
     * Creates a new Stack twice the currentPosition of the previous Stack. Copies all data from the previous Stack to the new
     * Stack and replaces the old one.
     */
    private void grow() {
        int newSize = this.stack.length * 2;
        String[] newStack = new String[newSize];

        for (int i = 0, stackLen = this.stack.length; i < stackLen; i++) {
            newStack[i] = this.stack[i];
        }

        this.stack = newStack;
    }

}
