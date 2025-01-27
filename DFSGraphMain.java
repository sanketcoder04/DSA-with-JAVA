import java.util.ArrayList;
import java.util.Stack;

class DFSGraph {
    private class Edge {
        @SuppressWarnings("unused")
        int source;
        int destination;

        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    private ArrayList<Edge>[] graph = null;

    @SuppressWarnings("unchecked")
    public void create(int vertices) {
        this.graph = new ArrayList[vertices];
        for(int i=0;i<vertices;i++) {
            graph[i] = new ArrayList<>();
        }

        // vertex 0
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        // vertex 1
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        // vertex 2
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        // vertex 3
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        // vertex 4
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        // vertex 5
        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        // vertex 6
        graph[6].add(new Edge(6, 5));
    }

    public ArrayList<Edge> neighbours(int vertex) {
        return graph[vertex]; 
    }

    // Traverse from start Node and go to all the neighbours of Graph 
    // If visited is false then print it and make visited = true
    // Then go to it's neighbour nodes and repeat it for all nodes


    // Recursive DFS Traversal
    public void dfs() {
        boolean[] visited = new boolean[graph.length];
        dfs(0, visited);
        System.out.println();
    }

    private void dfs(int vertex, boolean[] visited) {
        if(!visited[vertex]) {
            visited[vertex] = true;
            System.out.print(vertex + "\t");
            for(Edge edge : neighbours(vertex)) {
                dfs(edge.destination, visited);
            }
        }
    }

    // Iterative DFS using a stack
    public void dfsUsingStack() {
        boolean[] visited = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            if (!visited[vertex]) {
                visited[vertex] = true;
                System.out.print(vertex + "\t");

                for (Edge edge : neighbours(vertex)) {
                    stack.push(edge.destination);
                }
            }
        }
        System.out.println();
    }
}

public class DFSGraphMain {
    public static void main(String[] args) {
        DFSGraph graph = new DFSGraph();
        graph.create(7);
        graph.dfsUsingStack();
    }
}
