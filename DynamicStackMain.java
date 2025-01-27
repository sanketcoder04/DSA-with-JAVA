class DynamicStack extends Stack {
    DynamicStack() {
        super();
    }

    DynamicStack(int size) {
        super(size);
    }

    public void push(int data) {
        if (isFull()) {
            int temp[] = new int[stack.length + 1];
            this.size = temp.length;
            for (int i = 0; i < stack.length; i++) {
                temp[i] = stack[i];
            }
            stack = temp;
        }
        super.push(data);
    }
}

public class DynamicStackMain {
    public static void main(String[] args) {
        DynamicStack list = new DynamicStack(3);
        list.push(34);
        list.push(90);
        list.push(23);
        list.push(19);
        list.display();
        // System.out.println(list.getLength());
        // System.out.println(list.isEmpty());
        // System.out.println(list.isFull());
        // System.out.println(list.pop());
        // System.out.println(list.pop());
        // list.display();
        // System.out.println(list.getLength());
        // System.out.println(list.pop());
        // System.out.println(list.pop());
        // list.display();
        // System.out.println(list.isEmpty());
        // System.out.println(list.isFull());
    }
}
