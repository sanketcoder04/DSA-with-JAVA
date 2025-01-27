class QueueUsingLinkedList{
    private Node front;
    private Node rear;
    private int size;
    
    QueueUsingLinkedList(){
        this.size = 0;
        this.front = null;
        this.rear = null;
    }

    class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void enque(int data){
        Node newNode = new Node(data);
        if(front == null){
            front = newNode;
        }
        if(rear != null){
            rear.next = newNode;
        }
        rear = newNode;
        size++;
    }

    public int deque(){
        if(front == null){
            System.out.println("Queue is Empty, Nothing to delete");
            return -1;
        }
        int delete = front.data;
        front = front.next;
        size--;
        return delete;
    }

    public int front(){
        if(front == null){
            System.out.println("Queue is Empty, No front Element Present");
            return -1;
        }
        return front.data;
    }

    public int rear(){
        if(rear == null){
            System.out.println("Queue is Empty, No rear Element present");
            return -1;
        }
        return rear.data;
    }

    public void display(){
        if(front == null || rear == null){
            System.out.println("Empty Queue, Nothing to display");
            return;
        }
        Node temp = front;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public boolean isEmpty(){
        if(front == null || rear == null){
            return true;
        }
        return false;
    }

    public int getSize(){
        return this.size;
    }
}

public class QueueUsingLinkedListMain {
    public static void main(String[] args) {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();
        queue.enque(65);
        queue.enque(12);
        queue.enque(87);
        queue.enque(23);
        queue.enque(11);
        queue.display();
    }
}
