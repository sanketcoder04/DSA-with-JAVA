package pack;

import java.util.Stack;

class DFS {
    private Node root;

    private class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public void populate(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            insert(nums[i]);
        }
    }

    private void insert(int value) {
        root = insert(value, root);
    }

    private Node insert(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }
        if (value < node.data) {
            node.left = insert(value, node.left);
        }
        if (value > node.data) {
            node.right = insert(value, node.right);
        }
        return node;
    }

    // Pre Order Traversal [Node -> Left Subtree -> Right Subtree]
    public void printDFS() {
        Node node = root;
        if(node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()) {
            Node removed = stack.pop();
            System.out.print(removed.data + "\t");
            if(removed.right != null) {
                stack.push(removed.right);
            }
            if(removed.left != null) {
                stack.push(removed.left);
            }
        }
    }
}

public class DFSMain {
    public static void main(String[] args) {
        DFS dfs = new DFS();
        int nums[] = { 5, 2, 7, 1, 4, 6, 9, 8, 3, 10 };
        dfs.populate(nums);
        dfs.printDFS();
    }
}
