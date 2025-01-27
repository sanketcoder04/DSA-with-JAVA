package pack;

class CircularLinkedList{
    private Node head;
    private int size;

    CircularLinkedList(){
        this.size = 0;
    }

    private class Node{
        private int data;
        private Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(int value){
        Node newNode = new Node(value);
        Node temp1 = head;
        if(temp1 == null){
            head = newNode;
            newNode.next = head;
            size++;
            return;
        }
        newNode.next = temp1;
        Node temp2 = head;
        do{
            temp2 = temp2.next;
        }while(temp2.next != head);

        temp2.next = newNode;
        head = newNode;
        size++;
    }

    public void addLast(int value){
        Node newNode = new Node(value);
        Node temp = head;
        if(temp == null){
            head = newNode;
            newNode.next = head;
            size++;
            return;
        }
        do{
            temp = temp.next;
        }while(temp.next != head);

        temp.next = newNode;
        newNode.next = head;
        size++;
    }

    public void addAtIndex(int value, int index) {
        if (index == 0) {
            addFirst(value);
            return;
        }
        if (index == size) {
            addLast(value);
            return;
        }
        Node newNode = new Node(value);
        Node temp = head;
        int i = 0;
        while (i != index - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    public int removeFirst(){
        Node temp1,temp2;
        temp1 = temp2 = head;
        if(temp1 == null){
            System.out.println("Empty Linked List");
            return 0;
        }
        do{
            temp2 = temp2.next;
        }while(temp2.next != head);

        int value = temp1.data;
        temp2.next = temp1.next;
        head = temp1.next;
        size--;
        return value;
    }

    public int removeLast(){
        Node temp1 = head;
        Node temp2 = head;
        if(temp1 == null){
            System.out.println("Empty Linked List");
            return 0;
        }
        do{
            temp2 = temp2.next;
        }while(temp2.next.next != head);

        int value = temp2.next.data;
        temp2.next = temp1;
        size--;
        return value;
    }

    public int removeAtIndex(int index){
        Node temp1 = head;
        if (temp1 == null) {
            System.out.println("Empty Linked List");
            return 0;
        }
        if (index == 0) {
            int value = removeFirst();
            return value;
        }
        if (index == size-1) {
            int value = removeLast();
            return value;
        }
        int i = 0;
        while (i != index - 1) {
            temp1 = temp1.next;
            i++;
        }
        Node temp2 = temp1.next;
        int value = temp2.data;
        temp1.next = temp2.next;
        size--;
        return value;
    }

    public void display(){
        Node temp = head;
        if(temp == null){
            System.out.println("Empty Linked List");
            return;
        }
        do{
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }while(temp != head);
        System.out.println("HEAD");
    }

    public int getSize(){
        return this.size;
    }

    public int getHead(){
        return head.data;
    }
}

public class CircularLinkedListMain {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.addFirst(4);
        list.addFirst(7);
        list.addFirst(2);
        list.addLast(6);
        list.addLast(9);
        list.addLast(1);
        list.addAtIndex(13, 6);
        list.display();

        list.removeAtIndex(6);
        list.display();
        System.out.println(list.getSize());
    }
}
