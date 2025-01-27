import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BFS {
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
        return node;
    }

    public void printBFS() {
        Node node = root;
        if(node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            for(int i=1;i<=levelSize;i++) {
                node = queue.poll();
                System.out.print(node.data + "\t");
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
    }

    // Average of Every values at each levels

    public List<Double> averageOfLevels() {
        if(root == null) {
            return new ArrayList<>();
        }
        Node node = root;
        List<Double> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            double sum = 0;
            for(int i=1;i<=levelSize;i++) {
                node = queue.poll();
                sum += (double)node.data;

                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            Double average = Double.valueOf(sum/levelSize);
            result.add(average);
        }
        return result;
    }

    // Immediate Successor of any Element -> Element that right next to it

    public int immediateSuccessor(int element) {
        if(root == null) {
            return -1;
        }
        Node node = root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()) {
            node = queue.poll();

            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
            if(node.data == element) {
                break;
            }
        }
        if(queue.peek() != null) {
            Node result = queue.peek();
            return result.data;
        }
        return -1;
    }

    // Zigzag Level Order Traversal

    public void zigzagPrintBFS() {
        Node node = root;
        if(node == null) {
            return;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.offer(node);

        boolean reverse = false;

        while(!queue.isEmpty()) {
            int levelSize = queue.size();

            for(int i=1;i<=levelSize;i++) {
                if(!reverse) {
                    node = queue.pollFirst();
                    System.out.print(node.data + "\t");

                    if(node.left != null) {
                        queue.addLast(node.left);
                    }
                    if(node.right != null) {
                        queue.addLast(node.right);
                    }
                }
                else {
                    node = queue.pollLast();
                    System.out.print(node.data + "\t");

                    if(node.right != null) {
                        queue.addFirst(node.right);
                    }
                    if(node.left != null) {
                        queue.addFirst(node.left);
                    }
                }
            }
            reverse = !reverse;
        }
    }
}

public class BFSMain {
    public static void main(String[] args) {
        BFS bfs = new BFS();
        int nums[] = { 5, 2, 7, 1, 4, 6, 9, 8, 3, 10 };
        bfs.populate(nums);
        bfs.printBFS();
        System.out.println("Immediate Successor : " + bfs.immediateSuccessor(10));
        bfs.zigzagPrintBFS();
    }
}
