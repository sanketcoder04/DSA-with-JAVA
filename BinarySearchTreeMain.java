package pack;

class BinarySearchTree {
    Node root;

    class Node {
        int data;
        Node left;
        Node right;
        int height;

        public Node(int data) {
            this.data = data;
        }

        public int getValue() {
            return data;
        }
    }

    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    // Every Node is going to be traversed from the root node with it's given
    // details till the leaf node

    public void display() {
        display(root, "Root Node : ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.getValue());
        display(node.left, "Left Child of " + node.getValue() + " : ");
        display(node.right, "Right Child of " + node.getValue() + " : ");
    }

    // To insert chunks of elements in the BST

    public void populate(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            insert(nums[i]);
        }
    }

    public void populateSorted(int nums[]) {
        populateSorted(nums, 0, nums.length - 1);
    }

    private void populateSorted(int nums[], int start, int end) {
        if (start > end) {
            return;
        }
        int mid = (start + end) / 2;
        insert(mid); // insert mid element
        populateSorted(nums, start, mid); // call for left part
        populateSorted(nums, mid + 1, end);
    }

    // Whenever an element user wants to insert the function recursively check for
    // the value is less or greater than the current node value and after successful
    // checking that node will return from the function call
    // When a null node present a new Node will created and attached to its parent
    // node

    public void insert(int value) {
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
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    // Check for a tree is balanced or not from root node to all sub trees. Tree is
    // balanced if abs value is <= 1 and it makes recursive function calls to left
    // and right subtree till the leaf node
    // When no sub tree is present it will return true as balanced

    public boolean isBalanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    // Traversal Order is Node -> Left -> Right

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + "  ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // Traversal Route is Left -> Right -> Node

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + "  ");
    }

    // Traversal Route is Left -> Node -> Right

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + "  ");
        inOrder(node.right);
    }
}

public class BinarySearchTreeMain {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int nums[] = { 5, 2, 7, 1, 4, 6, 9, 8, 3, 10 };
        tree.populate(nums);
        // tree.display();
        tree.inOrder();
    }
}
