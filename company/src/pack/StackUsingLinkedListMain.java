package pack;

class StackUsingLinkedList{
    private Node top;
    private int size;

    StackUsingLinkedList(){
        this.top = null;
        this.size = 0;
    }

    public class Node{
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void push(int data){
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public int pop(){
        if(top == null){
            System.out.println("Empty Stack, Nothing to Delete");
            return -1;
        }
        int delete = top.data;
        top = top.next;
        size--;
        return delete;
    }

    public int peek(){
        if(top == null){
            System.out.println("Empty Stack, No top element present");
            return -1;
        }
        return top.data;
    }

    public void display(){
        if(top == null){
            System.out.println("Empty Stack, Nothing to Display");
            return;
        }
        Node temp = top;
        while (temp != null){
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }

    public int getSize(){
        return this.size;
    }

    public boolean isEmpty(){
        if(top == null){
            return true;
        }
        return false;
    } 
}

public class StackUsingLinkedListMain{
    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(4);
        stack.push(2);
        stack.push(8);
        stack.push(6);
        stack.display();
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.display();
        System.out.println(stack.isEmpty());
    }
}