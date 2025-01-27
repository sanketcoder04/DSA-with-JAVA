package pack;

import java.util.Scanner;

class BinaryTree {
    Node root;

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public void populate(Scanner scanner) {
        System.out.println("Enter the data of the root node : ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }

    private void populate(Scanner scanner, Node node) {
        System.out.println("Do you want to Enter Left of " + node.data);
        boolean left = scanner.nextBoolean();

        if (left) {
            System.out.println("Enter the data of the left node " + node.data);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }

        System.out.println("Do you want to Enter Right of " + node.data);
        boolean right = scanner.nextBoolean();

        if (right) {
            System.out.println("Enter the data of the right node " + node.data);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }
    }

    public void display() {
        display(root, "");
    }

    private void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + node.data);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }
}

public class BinaryTreeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.populate(scanner);
        binaryTree.display();
    }
}
