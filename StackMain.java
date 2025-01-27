class Stack {
    protected int[] stack;
    private static final int DEFAULT_SIZE = 10;
    private int top = -1;
    protected int length = 0;
    protected int size;

    Stack() {
        this.size = DEFAULT_SIZE;
        this.stack = new int[this.size];
    }

    Stack(int size) {
        this.size = size;
        this.stack = new int[this.size];
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack is Full ,push operation not possible");
            return;
        }
        top++;
        stack[top] = data;
        length++;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Empty Stack ,pop operation not possible");
            return -1;
        }
        int delete = stack[top];
        top--;
        length--;
        return delete;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Empty Stack ,peek operation not possible");
            return -1;
        }
        return stack[top];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Empty Stack ,nothing to display");
            return;
        }
        System.out.println();
        for (int i = top; i >= 0; i--) {
            System.out.println("|  " + stack[i] + "  |");
            System.out.println("--------");
        }
        System.out.println();
    }

    public int getLength() {
        return this.length;
    }

    public boolean isEmpty() {
        if (length == 0) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (length == this.size) {
            return true;
        }
        return false;
    }
}

public class StackMain {
    public static void main(String[] args) {
        Stack st = new Stack();
        // st.push(34);
        // st.push(87);
        // st.push(67);
        // st.push(17);
        // st.push(39);
        // st.push(45);
        // st.push(67);
        // st.push(17);
        // st.push(39);
        // st.push(45);
        // st.push(100);
        System.out.println(st.isEmpty());
    }
}
