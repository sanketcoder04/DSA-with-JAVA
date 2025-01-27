import java.util.ArrayList;

class Graph {
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
    public void create(int vertices) {
        this.graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            this.graph[i] = new ArrayList<>();
        }

        // Undirected Graph contains cycle

        // For vertex 0
        graph[0].add(new Edge(0, 1, 5));

        // For vertex 1
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // For vertex 2
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        // For vertex 3
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        // For vertex 4
        graph[4].add(new Edge(4, 2, 2));

        // Undirected Graph doesn't contains cycle

        // For vertex 0
        graph[0].add(new Edge(0,1,0));

        // For vertex 1
        graph[1].add(new Edge(1, 0, 0));
        graph[1].add(new Edge(1, 2, 0));
        graph[1].add(new Edge(1, 3, 0));

        // For vertex 2
        graph[2].add(new Edge(2, 1, 0));

        // For vertex 3
        graph[3].add(new Edge(3, 1, 0));
        graph[3].add(new Edge(3, 4, 0));
        graph[3].add(new Edge(3, 5, 0));

        // For vertex 4
        graph[4].add(new Edge(4, 3, 0));

        // For vertex 5
        graph[5].add(new Edge(5, 3, 0));
    }

    public void neighbours(int vertex) {
        System.out.println("Neighbours of the vertex : " + vertex);
        for (Edge edge : graph[vertex]) {
            System.out.println(edge.source + " -> " + edge.destination + " weight : " + edge.weight);
        }
    }

    // Recursively check if the source's neighbours has path to the destination to
    // the destination then there was a path from source to destination

    public boolean hasPath(int src, int dest) {
        boolean[] visited = new boolean[graph.length];
        return hasPath(src, dest, visited);
    }

    private boolean hasPath(int src, int dest, boolean[] visited) {
        if (src == dest) {
            return true;
        }
        visited[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge edge = graph[src].get(i);
            if (!visited[edge.destination] && hasPath(edge.destination, dest, visited)) {
                return true;
            }
        }
        return false;
    }

    // Checking for a cycle in an undirected Graph

    public boolean hasCycle() {
        int vertices = graph.length;
        boolean[] visited = new boolean[vertices];

        // As the Graph is undirected and there is no component, so we can do this by starting a node which traverse all nodes, using this loop is optional
        for (int i = 0; i < vertices; i++) {
            if (!visited[i] && hasCycle(i, visited, -1)) {      // for starting node there is no parent so -1
                return true;
            }
        }
        return false;
    }

    private boolean hasCycle(int vertex, boolean[] visited, int parent) { // parent variable to check whether a node has different parent 
        visited[vertex] = true;
        for (Edge edge : graph[vertex]) {
            int neighbor = edge.destination;

            // If the neighbor has not been visited, recurse
            if (!visited[neighbor]) {
                if (hasCycle(neighbor, visited, vertex)) {
                    return true;
                }
            }
            // If the neighbor is visited and is not the parent, a cycle exists
            else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }
}

public class GraphMain {
    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph();
        graph.create(vertices);
        graph.neighbours(2);
        System.out.println(graph.hasPath(0, 4));
        System.out.println(graph.hasCycle());
    }
}
