class DoublyLinkedList {
    private Node head;
    private int size;

    DoublyLinkedList() {
        this.size = 0;
    }

    public class Node {
        private int data;
        private Node next;
        private Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public void addFirst(int value) {
        Node newNode = new Node(value);
        Node temp = head;
        if (temp == null) {
            head = newNode;
            size++;
            return;
        }
        newNode.next = temp;
        temp.prev = newNode;
        head = newNode;
        size++;
    }

    public void addLast(int value){
        Node newNode = new Node(value);
        Node temp = head;
        if(temp == null){
            head = newNode;
            size++;
            return;
        }
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
        size++;
    }

    public void addAtIndex(int value,int index){
        if(index == 0){
            addFirst(value);
            return;
        }
        if(index == size-1){
            addLast(value);
            return;
        }
        Node newNode = new Node(value);
        Node temp = head;
        int i = 0;
        while(temp.next == null){
            if(i == index-1){
                temp.next.prev = newNode;
                newNode.next = temp.next;
                temp.next = newNode;
                newNode.prev = temp;
                size++;
                return;
            }
            temp = temp.next;
            i++;
        }
    }

    public void addAfter(int value,int index){
        if(index == size-1){
            addLast(value);
            return;
        }
        Node newNode = new Node(value);
        Node temp = head;
        int i = 0;
        while(temp.next != null){
            if(i == index){
                newNode.next = temp.next;
                temp.next.prev = newNode;
                temp.next = newNode;
                newNode.prev = temp;
                size++;
                return;
            }
            temp = temp.next;
            i++;
        }
    }

    public void addBefore(int value,int index){
        if(index == 0){
            addFirst(value);
            return;
        }
        Node newNode = new Node(value);
        Node temp = head;
        int i = 0;
        while(temp.next != null){
            if(i == index){
                newNode.prev = temp.prev;
                temp.prev.next = newNode;
                newNode.next = temp;
                temp.prev = newNode;
                size++;
                return;
            }
            temp = temp.next;
            i++;
        }
    }

    public int removeFirst(){
        Node temp = head;
        if(temp == null){
            System.out.println("Empty Linked List");
            return 0;
        }
        if(temp.next == null){
            head = null;
        }
        head = temp.next;
        int value = temp.data;
        temp.next.prev = null;
        temp = null;
        size--;
        return value;
    }

    public int removeLast(){
        Node temp = head;
        if(temp == null){
            System.out.println("Empty Linked List");
            return 0;
        }
        if(temp.next == null){
            head = null;
        }
        while(temp.next != null){
            temp = temp.next;
        }
        int value = temp.data;
        temp.prev.next = null;
        temp.prev = null;
        size--;
        return value;
    }

    public int removeAtIndex(int index){
        if(index == 1){
            int value = removeFirst();
            return value;
        }
        if(index == size-1){
            int value = removeLast();
            return value;
        }
        Node temp = head;
        if(temp == null){
            System.out.println("Empty Linked List");
            return 0;
        }
        int i = 0;
        while(i != index){
            temp = temp.next;
            i++;
        }
        int value  = temp.data;
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        size--;
        return value;
    }

    public int removeBefore(int index){
        if(index == 0){
            System.out.println("Removal Not Possible");
            return 0;
        }
        if(index == 1){
            int value = removeFirst();
            return value;
        }
        Node temp = head;
        if(temp == null){
            System.out.println("Empty Linked List");
            return 0;
        }
        int i = 0;
        while(i != index){
            temp = temp.next;
            i++;
        }
        int value = temp.prev.data;
        temp.prev = temp.prev.prev;
        temp.prev.next = temp;
        size--;
        return value;
    }

    public int removeAfter(int index){
        if(index == size-1){
            System.out.println("Removal Not Possible");
            return 0;
        }
        if(index == size-2){
            int value = removeLast();
            return value;
        }
        Node temp = head;
        if(temp == null){
            System.out.println("Empty Linked List");
            return 0;
        }
        int i = 0;
        while(i != index){
            temp = temp.next;
            i++;
        }
        int value = temp.next.data;
        temp.next = temp.next.next;
        temp.next.prev = temp;
        size--;
        return value;
    }

    public void display() {
        Node temp = head;
        if (temp == null) {
            System.out.println("Empty Linked List");
            return;
        }
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public void reverse(){
        Node temp = head;
        if (temp == null) {
            System.out.println("Empty Linked List");
            return;
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        head = temp;
        while(temp != null){
            temp.next = temp.prev;
            temp = temp.prev;
        }
    }

    public int getSize(){
        return this.size;
    }

    public int getHead(){
        return head.data;
    }
}

public class DoublyLinkedListMain {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addFirst(6);
        list.addFirst(7);
        list.addFirst(8);
        list.addFirst(9);
        list.addAfter(2, 2);
        list.display();
        System.out.println(list.getSize());

        list.removeAfter(3);
        list.display();
    }
}
