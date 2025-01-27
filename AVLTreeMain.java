class AVLTree {
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

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty() {
        return root == null;
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
        return rotate(node);
    }

    // We need to return the tree which is self balancing

    private Node rotate(Node node) {
        if(height(node.left) - height(node.right) > 1) {
            // Left heavy Case
            if(height(node.left.left) - height(node.left.right) > 0) {
                // Left Left Case -> Left rotate the tree
                return rightRotate(node);
            }
            if(height(node.left.left) - height(node.left.right) < 0) {
                // Left Right Case -> Left rotate and then Right rotate the tree
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if(height(node.right) - height(node.left) > 1) {
            // Right heavy Case
            if(height(node.right.right) - height(node.right.left) > 0) {
                // Right Right Case -> Right rotate the tree
                return leftRotate(node);
            }
            if(height(node.right.right) - height(node.right.left) < 0) {
                // Right Left Case -> Right rotate and then Left rotate the tree
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    // From the diagram of Right rotate we have to change p, c and subtree accordingly

    private Node rightRotate(Node p) {
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);
        return c;
    }

    // From the diagram of Left rotate we have to change p, c and subtree accordingly

    private Node leftRotate(Node c) {
        Node p = c.right;
        Node t = p.left;

        p.left = c;
        c.right = t;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);
        return c;
    }
}

public class AVLTreeMain {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        for(int i=1;i<=10;i++) {
            tree.insert(i);
        }
        System.out.println(tree.height());
    }
}
