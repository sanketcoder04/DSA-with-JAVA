class DynamicQueue extends Queue{
    DynamicQueue(){
        super();
    }

    DynamicQueue(int size){
        super(size);
    }

    public void enque(int data){
        if (isFull()) {
            int temp[] = new int[queue.length + 1];
            this.size = temp.length;
            for (int i = 0; i < queue.length; i++) {
                temp[i] = queue[i];
            }
            queue = temp;
        }
        end++;
        queue[end] = data;
        length++;
    }
}

public class DynamicQueueMain{
    public static void main(String[] args) {
        DynamicQueue queue = new DynamicQueue(4);
        queue.enque(56);
        queue.enque(68);
        queue.enque(16);
        queue.enque(23);
        queue.enque(94);
        queue.display();
    }
}
