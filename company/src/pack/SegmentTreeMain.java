package pack;

class SegmentTree {
    class Node {
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int start, int end) {
            this.startInterval = start;
            this.endInterval = end;
        }
    }

    Node root;

    public SegmentTree(int arr[]) {
        // create a tree using array
        this.root = constructTree(arr, 0, arr.length-1);
    }

    private Node constructTree(int arr[], int start, int end) {
        if(start == end) {
            // leaf Node
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }
        // create a Node where you currently at
        Node node = new Node(start,end);
        int mid = (start + end) / 2;

        // constructing left and right tree
        node.left = constructTree(arr, start, mid);
        node.right = constructTree(arr, mid+1, end);

        // sum up and storing data at that node
        node.data = node.left.data + node.right.data;
        return node;
    }

    // To get the sum for a particular range

    public int query(int start, int end) {
        return querySum(root, start, end);
    }

    private int querySum(Node node, int start, int end) {
        if(node.startInterval >= start && node.endInterval <= end) {
            // Node range lying inside query range completely
            return node.data;
        } 
        else if(node.startInterval > end || node.endInterval < start) {
            // Node range lying outside query range completely
            return 0;
        }
        else {
            // Node range partially lying inside query range
            return querySum(node.left, start, end) + querySum(node.right, start, end);
        }
    }

    // To update any value at particular index

    public void update(int index, int value) {
        root.data = update(root, index, value);
    }

    private int update(Node node, int index, int value) {
        if(index >= node.startInterval && index <= node.endInterval) {
            if(index == node.startInterval && index == node.endInterval) {
                // at required leaf node
                node.data = value;
                return node.data;
            }
            else {
                int leftAnswer = update(node.left, index, value);
                int rightAnswer = update(node.right, index, value);

                node.data = leftAnswer + rightAnswer;
                return node.data;
            }
        }
        return node.data;
    }
}

public class SegmentTreeMain {
    public static void main(String[] args) {
        int arr[] = {3, 8, 6, -2, -8, 4, 9};
        SegmentTree tree = new SegmentTree(arr);
        int sum = tree.query(2, 6);
        System.out.println(sum);

        // update value at index 6 with 7
        tree.update(6, 7);
        int newSum = tree.query(2, 6);
        System.out.println(newSum);
    }
}
