package pack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

@SuppressWarnings("unused")
class TopologicalSort {
    private class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    ArrayList<Edge>[] graph = null;

    @SuppressWarnings("unchecked")
    public void create() {
        this.graph = new ArrayList[6];
        for (int i = 0; i < 6; i++) {
            this.graph[i] = new ArrayList<>();
        }

        // Directed Graph does contains cycle

        // For vertex 2
        graph[2].add(new Edge(2, 3, 0));

        // For vertex 3
        graph[3].add(new Edge(3, 1, 0));

        // For vertex 4
        graph[4].add(new Edge(4, 0, 0));
        graph[4].add(new Edge(4, 1, 0));

        // For vertex 5
        graph[5].add(new Edge(5, 0, 0));
        graph[5].add(new Edge(5, 2, 0));
    }

    public ArrayList<Edge> neighbours(int vertex) {
        return graph[vertex];
    }

    public void topologicalSortDFS() {
        int vertices = graph.length;
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<vertices;i++) {
            if (!visited[i]) {
                topologicalSortDFS(i, visited, stack);
            }
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + "\t");
        }
        System.out.println();
    }

    private void topologicalSortDFS(int vertex, boolean[] visited, Stack<Integer> stack) {
        visited[vertex] = true;
        for (Edge edge : graph[vertex]) {
            int neighbor = edge.destination;
            if (!visited[neighbor]) {
                topologicalSortDFS(neighbor, visited, stack);
            }
        }
        stack.push(vertex);
    }

    public void topologicalSortBFS() {
        int vertices = graph.length;
        int[] inDegree = new int[vertices];

        for(int i=0;i<vertices;i++) {
            for(Edge edge : neighbours(i)) {
                int neighbor = edge.destination;
                inDegree[neighbor]++;               // Incoming edge detected and updating the inDegree value
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<vertices;i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);         // Add node with inDegree 0
            }
        }
        while(!queue.isEmpty()) {
            int vertex = queue.peek();
            queue.remove();
            System.out.print(vertex + "\t");

            for(Edge edge : neighbours(vertex)) {
                int neighbor = edge.destination;
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
    }
}

public class TopologicalSortMain {
    public static void main(String[] args) {
        TopologicalSort graph = new TopologicalSort();
        graph.create();
        graph.topologicalSortDFS();
        graph.topologicalSortBFS();
    }
}
