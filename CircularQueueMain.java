class CircularQueue{
    protected int[] queue;
    private static final int DEFAULT_SIZE = 10;
    protected int rear = -1;
    protected int front = -1;
    protected int length = 0;
    protected int size;

    CircularQueue() {
        this.size = DEFAULT_SIZE;
        this.queue = new int[this.size];
    }

    CircularQueue(int size) {
        this.size = size;
        this.queue = new int[this.size];
    }

    public void enque(int data){
        if(isFull()){
            System.out.println("Circular Queue is Full, insertion not possible");
            return;
        }
        if(front == -1){
            front++;
        }
        rear++;
        rear = rear % size;
        queue[rear] = data;
        length++;
    }

    public int deque(){
        if(isEmpty()){
            System.out.println("Circular Queue is Empty, deletion not possible");
            return -1;
        }
        int delete = queue[front];
        front++;
        front = front % size;
        length--;
        return delete;
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Circular Queue is Empty, Nothing to display");
            return;
        }
        int i = front;
        int j = rear;
        if(i<=j){
            while(i<=j){
                System.out.print(queue[i] + " ");
                i++;
            }
        }else{
            while(i<=size-1){
                System.out.print(queue[i] + " ");
                i++;
            }
            i=0;
            while(i<=j){
                System.out.print(queue[i] + " ");
                i++;
            }
        }
        System.out.println();
    }

    // public void enque(int data){
    //     if(isFull()){
    //         System.out.println("Circular Queue is Full, insertion not possible");
    //         return;
    //     }
    //     queue[rear++] = data;
    //     rear = rear % size; 
    //     length++;
    // }

    // public int deque(){
    //     if(isEmpty()){
    //         System.out.println("Circular Queue is Empty, deletion not possible");
    //         return -1;
    //     }
    //     int delete = queue[front++];
    //     front = front % size;
    //     length--;
    //     return delete;
    // }

    public int front(){
        if(isEmpty()){
            System.out.println("Empty Queue");
            return -1;
        }
        return queue[front];
    }

    public int rear(){
        if(isEmpty()){
            System.out.println("Empty Queue");
            return -1;
        }
        return queue[rear];
    }

    // public void display(){
    //     if(isEmpty()){
    //         System.out.println("Empty Queue, nothing to display");
    //         return;
    //     }
    //     System.out.print("[ ");
    //     int i = front;
    //     do{
    //         System.out.print(queue[i] + " ");
    //         i++;
    //         i = i % size;
    //     }while(i != rear);
    //     System.out.println("]");
    // }

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
        if (length == size) {
            return true;
        }
        return false;
    }
}

public class CircularQueueMain {
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(4);
        queue.enque(5);
        queue.enque(7);
        queue.enque(4);
        queue.enque(9);
        queue.display();
        
        // System.out.println(queue.front());
        // System.out.println(queue.rear());

        System.out.println(queue.deque());
        System.out.println(queue.deque());
        System.out.println(queue.deque());
        queue.display();

        queue.enque(2);
        queue.enque(6);
        queue.display();
        System.out.println(queue.front());
        System.out.println(queue.rear());
    }
}
