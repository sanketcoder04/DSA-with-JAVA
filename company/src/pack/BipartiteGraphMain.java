package pack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings({"unchecked","unused"})
class BipartiteGraph {
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

    public void create(int vertices) {
        this.graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            this.graph[i] = new ArrayList<>();
        }

        // Undirected Graph does contains cycle 

        // For vertex 0
        graph[0].add(new Edge(0,1,0));

        // For vertex 1
        graph[1].add(new Edge(1, 0, 0));
        graph[1].add(new Edge(1, 2, 0));
        graph[1].add(new Edge(1, 4, 0));

        // For vertex 2
        graph[2].add(new Edge(2, 1, 0));
        graph[2].add(new Edge(2, 3, 0));

        // For vertex 3
        graph[3].add(new Edge(3, 2, 0));
        graph[3].add(new Edge(3, 4, 0));
        graph[3].add(new Edge(3, 5, 0));

        // For vertex 4
        graph[4].add(new Edge(4, 1, 0));
        graph[4].add(new Edge(4, 3, 0));

        // For vertex 5
        graph[5].add(new Edge(5, 3, 0));
    }

    public ArrayList<Edge> neighbours(int vertex) {
        return graph[vertex];
    }

    public boolean isBipartiteBFS() {
        Queue<Integer> queue = new LinkedList<>();
        int[] colored = new int[graph.length];          // Color -> '1' & '-1'
        queue.offer(0);   // Add first vertex 
        colored[0] = 1;     // color it

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            for (Edge edge : neighbours(vertex)) {
                if (colored[edge.destination] == 0) {  // If not colored
                    colored[edge.destination] = (-1) * colored[vertex];  // Color with opposite color
                    queue.offer(edge.destination);
                } 
                else if (colored[edge.destination] == colored[vertex]) {
                    return false;  // If adjacent vertex has the same color, it's not bipartite
                }
            }
        }
        return true;
    }

    public boolean isBipartiteDFS() {
        int[] colored = new int[graph.length];          // Color -> '1' & '-1'
        return isBipartiteDFS(0, colored, 1);
    }

    private boolean isBipartiteDFS(int vertex, int[] colored, int color) {
        colored[vertex] = color; // Color the vertex with the current color
        for (Edge edge : neighbours(vertex)) {
            int neighbor = edge.destination;
            if (colored[neighbor] == 0) { // If neighbor is uncolored
                if (!isBipartiteDFS(neighbor, colored, -color)) { // Alternate color
                    return false;
                }
            } else if (colored[neighbor] == color) { // Conflict found
                return false;
            }
        }
        return true;
    }
}

public class BipartiteGraphMain {
    public static void main(String[] args) {
        BipartiteGraph graph = new BipartiteGraph();
        graph.create(6);
        System.out.println(graph.isBipartiteBFS());
        System.out.println(graph.isBipartiteDFS());
    }
}
