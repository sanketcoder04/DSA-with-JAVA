package pack;

import java.util.Scanner;

class SinglyLinkedList {
    private Node head;
    private int size;

    SinglyLinkedList() {
        this.size = 0;
    }

    private class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(int value) {
        Node temp = head;
        if (temp == null) {
            addFirst(value);
            return;
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        Node newnNode = new Node(value);
        temp.next = newnNode;
        size++;
    }

    public void addAtIndex(int value, int index) {
        if (index == 0) {
            addFirst(value);
            return;
        }
        if (index == size - 1) {
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

    public int removeFirst() {
        Node temp = head;
        if (temp == null) {
            System.out.println("Empty Linked List");
            return 0;
        }
        int value = head.data;
        head = temp.next;
        temp.next = null;
        size--;
        return value;
    }

    public int removeLast() {
        Node temp = head;
        if (temp == null) {
            System.out.println("Empty Linked List");
            return 0;
        }
        if (temp.next == null) {
            int value = removeFirst();
            return value;
        }
        while (temp.next.next != null) {
            temp = temp.next;
        }
        int value = temp.next.data;
        temp.next = null;
        size--;
        return value;
    }

    public int removeAtIndex(int index) {
        Node temp = head;
        if (temp == null) {
            System.out.println("Empty Linked List");
            return 0;
        }
        if (index == 0) {
            int value = removeFirst();
            return value;
        }
        if (index == size - 1) {
            int value = removeLast();
            return value;
        }
        int i = 0;
        while (i != index - 1) {
            temp = temp.next;
            i++;
        }
        Node temp2 = temp.next;
        int value = temp2.data;
        temp.next = temp2.next;
        return value;
    }

    public void addBeforeNode(int value, int index) {
        Node temp1 = head;
        if (temp1 == null) {
            addFirst(value);
            return;
        }
        int i = 0;
        while (i != index - 1) {
            temp1 = temp1.next;
            i++;
        }
        Node temp2 = temp1.next;
        Node newNode = new Node(value);
        newNode.next = temp2;
        temp1.next = newNode;
        size++;
    }

    public void addAfterNode(int value, int index) {
        Node temp1 = head;
        if (temp1 == null) {
            addFirst(value);
            return;
        }
        int i = 0;
        while (i != index) {
            temp1 = temp1.next;
            i++;
        }
        Node temp2 = temp1.next;
        Node newNode = new Node(value);
        newNode.next = temp2;
        temp1.next = newNode;
        size++;
    }

    public int removeBeforeNode(int index) {
        Node temp1 = head;
        if (temp1 == null) {
            System.out.println("Empty Linked List");
            return 0;
        }
        if (index == 0) {
            System.out.println("Operation Not Possible");
            return 0;
        }
        if (index == 1) {
            int value = removeFirst();
            return value;
        }
        int i = 0;
        while (i != index) {
            temp1 = temp1.next;
            i++;
        }
        Node temp2 = head;
        while (temp2.next.next != temp1) {
            temp2 = temp2.next;
        }
        int value = temp2.next.data;
        temp2.next = temp1;
        size--;
        return value;
    }

    public int removeAfterNode(int index) {
        Node temp = head;
        if (temp == null) {
            System.out.println("Empty Linked List");
            return 0;
        }
        if (index == size - 1) {
            System.out.println("Operation Not Possible");
            return 0;
        }
        if (index == size - 2) {
            int value = removeLast();
            return value;
        }
        int i = 0;
        while (i != index) {
            temp = temp.next;
            i++;
        }
        int value = temp.next.data;
        temp.next = temp.next.next;
        size--;
        return value;
    }

    public void update(int value, int index) {
        Node temp = head;
        if (temp == null) {
            System.out.println("Empty Linked List");
            return;
        }
        int i = 0;
        while (i != index) {
            if (i > size - 1) {
                System.out.println("Index Not Found - Updation Not Possible");
                return;
            }
            temp = temp.next;
            i++;
        }
        temp.data = value;
    }

    public void sortList() {
        Node temp1 = head;
        if (temp1 == null) {
            System.out.println("Empty Linked List");
            return;
        }
        if (temp1.next == null) {
            System.out.println("Sorting Not Possible - Only One Element Present");
            return;
        }
        Node temp2;
        while (temp1.next != null) {
            temp2 = temp1.next;
            while (temp2 != null) {
                if (temp1.data > temp2.data) {
                    int temp = temp1.data;
                    temp1.data = temp2.data;
                    temp2.data = temp;
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
    }

    public void insertAtSortList(int value) {
        Node newNode = new Node(value);
        Node temp = head;
        if (temp == null) {
            head = newNode;
        }
        while (temp != null) {
            if (temp.data <= newNode.data && newNode.data <= temp.next.data) {
                newNode.next = temp.next;
                temp.next = newNode;
                return;
            }
            temp = temp.next;
        }
    }

    public int getElement(int index) {
        Node temp = head;
        if (temp == null) {
            System.out.println("Empty Linked List");
            return 0;
        }
        for (int i = 0; i < size; i++) {
            if (i == index) {
                return temp.data;
            }
            temp = temp.next;
        }
        System.out.println("Element not Found of the given index");
        return 0;
    }

    public int getIndex(int value) {
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.data == value) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        System.out.println("Index not Found of the given value");
        return 0;
    }

    public void reverse() {
        // Node temp1 = head;
        // Node temp2 = head;
        // Node temp3 = head;
        // Node temp4 = head;
        // if (temp1 == null) {
        //     System.out.println("Empty Linked List");
        //     return;
        // }
        // if (temp1.next == null) {
        //     System.out.println("Reversing Not Possible");
        //     return;
        // }
        // while (temp2.next != null) {
        //     temp2 = temp2.next;
        // }
        // temp4 = temp2;
        // while (temp2 != temp1) {
        //     while (temp3.next != temp2) {
        //         temp3 = temp3.next;
        //     }
        //     temp2.next = temp3;
        //     temp2 = temp3;
        //     temp3 = head;
        // }
        // head = temp4;
        // temp3.next = null;
        
        if(head == null) {
            System.out.println("Empty Linked List");
            return;
        }
        if(head.next == null) {
            System.out.println("Reversing Not Possible");
            return;
        }
        Node presentNode = head;
        Node prevNode = null;
        Node nextNode = presentNode.next;

        while(presentNode != null) {
            presentNode.next = prevNode;
            prevNode = presentNode;
            presentNode = nextNode;
            if(nextNode != null) {
                nextNode = nextNode.next;
            }
        }
        head = prevNode;
    }

    public void display() {
        Node temp = head;
        if (temp == null) {
            System.out.println("Empty Linked list");
            return;
        }
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public int getHead() {
        return head.data;
    }

    public int getSize() {
        return this.size;
    }

    public void addRecursive(int value, int index) {
        head = addRecursive(value, index, head);
    }

    private Node addRecursive(int value, int index, Node node) {
        if (index == 0) {
            Node newNode = new Node(value, node);
            size++;
            return newNode;
        }
        node.next = addRecursive(value, index - 1, node.next);
        return node;
    }
}

public class SinglyLinkedListMain {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        boolean count = true;
        Scanner sc = new Scanner(System.in);
        while (count == true) {
            System.out.println("LINKED LIST OPERATIONS");
            System.out.println("_________________________________________________");
            System.out.println();
            System.out.println("Enter 1 for Creation");
            System.out.println("Enter 2 for Addition at Start Position");
            System.out.println("Enter 3 for Addition at End Position");
            System.out.println("Enter 4 for Addition at Specific Index");
            System.out.println("Enter 5 for Addition after a Specific Node");
            System.out.println("Enter 6 for Addition before a Specific Node");
            System.out.println("Enter 7 for Deletion from Start Position");
            System.out.println("Enter 8 for Deletion from End position");
            System.out.println("Enter 9 for Deletion from Specific Index");
            System.out.println("Enter 10 for Deletion after a Specific Node");
            System.out.println("Enter 11 for Deletion before a Specific Node");
            System.out.println("Enter 12 for Updation");
            System.out.println("Enter 13 to get Element at a Specific Index");
            System.out.println("Enter 14 to get Index of an Element");
            System.out.println("Enter 15 to Sort a List");
            System.out.println("Enter 16 to Insert Element at Sorted List");
            System.out.println("Enter 17 to get Head Element");
            System.out.println("Enter 18 to get Size of List");
            System.out.println("Enter 19 to Display List");
            System.out.println("Enter 20 to Reverse List");
            System.out.println("Enter 21 to Exit");
            System.out.println();
            System.out.println("_________________________________________________");

            int choice = sc.nextInt();
            int value, index, removeval;

            switch (choice) {

                case 1:
                    System.out.println("Enter Value");
                    value = sc.nextInt();
                    list.addFirst(value);
                    System.out.println("Do you want to Continue??Enter true or false");
                    boolean c = sc.nextBoolean();
                    while (c) {
                        System.out.println("Enter Value");
                        value = sc.nextInt();
                        list.addLast(value);
                        System.out.println("Do you want to Continue??Enter true or false");
                        c = sc.nextBoolean();
                    }
                    break;
                case 2:
                    System.out.println("Enter Value");
                    value = sc.nextInt();
                    list.addFirst(value);
                    break;
                case 3:
                    System.out.println("Enter Value");
                    value = sc.nextInt();
                    list.addLast(value);
                    break;
                case 4:
                    System.out.println("Enter Value");
                    value = sc.nextInt();
                    System.out.println("Enter Index");
                    index = sc.nextInt();
                    list.addAtIndex(value, index);
                    break;
                case 5:
                    System.out.println("Enter Value");
                    value = sc.nextInt();
                    System.out.println("Enter Index");
                    index = sc.nextInt();
                    list.addAfterNode(value, index);
                    break;
                case 6:
                    System.out.println("Enter Value");
                    value = sc.nextInt();
                    System.out.println("Enter Index");
                    index = sc.nextInt();
                    list.addBeforeNode(value, index);
                    break;
                case 7:
                    removeval = list.removeFirst();
                    if (removeval != 0) {
                        System.out.println("Deleted Item is : " + removeval);
                    }
                    break;
                case 8:
                    removeval = list.removeLast();
                    if (removeval != 0) {
                        System.out.println("Deleted Item is : " + removeval);
                    }
                    break;
                case 9:
                    System.out.println("Enter Index");
                    index = sc.nextInt();
                    removeval = list.removeAtIndex(index);
                    if (removeval != 0) {
                        System.out.println("Deleted Item is : " + removeval);
                    }
                    break;
                case 10:
                    System.out.println("Enter Index");
                    index = sc.nextInt();
                    removeval = list.removeAfterNode(index);
                    if (removeval != 0) {
                        System.out.println("Deleted Item is : " + removeval);
                    }
                    break;
                case 11:
                    System.out.println("Enter Index");
                    index = sc.nextInt();
                    removeval = list.removeBeforeNode(index);
                    if (removeval != 0) {
                        System.out.println("Deleted Item is : " + removeval);
                    }
                    break;
                case 12:
                    System.out.println("Enter Value");
                    value = sc.nextInt();
                    System.out.println("Enter Index");
                    index = sc.nextInt();
                    list.update(value, index);
                    break;
                case 13:
                    System.out.println("Enter Index");
                    index = sc.nextInt();
                    value = list.getElement(index);
                    if (value != 0) {
                        System.out.println("Value at Given Index: " + value);
                    }
                    break;
                case 14:
                    System.out.println("Enter Value");
                    value = sc.nextInt();
                    index = list.getIndex(value);
                    if (index != 0) {
                        System.out.println("Index of Given Value: " + index);
                    }
                    break;
                case 15:
                    list.sortList();
                    break;
                case 16:
                    System.out.println("Enter Value");
                    value = sc.nextInt();
                    list.insertAtSortList(value);
                    break;
                case 17:
                    value = list.getHead();
                    System.out.println("Head Element is : " + value);
                    break;
                case 18:
                    int size = list.getSize();
                    System.out.println("Size of the Given List :" + size);
                    break;
                case 19:
                    list.display();
                    break;
                case 20:
                    list.reverse();
                    break;
                case 21:
                    count = false;
                    break;
                default:
                    System.out.println("Not a Correct Option Chosen");
                    break;
            }
            System.out.println();
        }
        sc.close();
    }
}