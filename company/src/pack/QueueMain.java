package pack;

class Queue{
    protected int[] queue;
    public static final int DEFAULT_SIZE = 10;
    protected int end = -1;
    protected int length = 0;
    protected int size;

    Queue() {
        this.size = DEFAULT_SIZE;
        this.queue = new int[this.size];
    }

    Queue(int size) {
        this.size = size;
        this.queue = new int[this.size];
    }

    public void enque(int data){
        if(isFull()){
            System.out.println("Queue is Full, insertion not possible");
            return;
        }
        end++;
        queue[end] = data;
        length++;
    }

    public int deque(){
        if(isEmpty()){
            System.out.println("Queue is Empty, removal not possible");
            return -1;
        }
        int delete = queue[0];
        for(int i=1;i<length;i++){
            queue[i-1] = queue[i];
        }
        end--;
        length--;
        return delete;
    }

    public int front(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        return queue[0];
    }

    public int rear(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        return queue[end];
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Queue is Empty, nothing to display");
            return;
        }
        System.out.print("[ ");
        for(int i=0;i<length;i++){
            System.out.print(queue[i]+" ");
        }
        System.out.println("]");
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

public class QueueMain {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enque(34);
        queue.enque(89);
        queue.enque(65);
        queue.display();
        System.out.println(queue.deque());
        queue.display();
    }
}
