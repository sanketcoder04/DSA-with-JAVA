package pack;

import java.util.ArrayList;

@SuppressWarnings("unused")
class DirectedGraph {
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
        this.graph = new ArrayList[10];
        for (int i = 0; i < 10; i++) {
            this.graph[i] = new ArrayList<>();
        }

        // Directed Graph contains cycle

        // For vertex 0
        graph[0].add(new Edge(0, 1, 0));

        // For vertex 1
        graph[1].add(new Edge(1, 2, 0));

        // For vertex 2
        graph[2].add(new Edge(2, 3, 0));
        graph[2].add(new Edge(2, 6, 0));

        // For vertex 3
        graph[3].add(new Edge(3, 4, 0));

        // For vertex 4
        graph[4].add(new Edge(4, 5, 0));

        // For vertex 6
        graph[6].add(new Edge(6, 4, 0));

        // For vertex 7
        graph[7].add(new Edge(7, 1, 0));
        graph[7].add(new Edge(7, 8, 0));

        // For vertex 8
        graph[8].add(new Edge(8, 9, 0));

        // For vertex 9
        graph[9].add(new Edge(9, 7, 0));
    }

    public ArrayList<Edge> neighbours(int vertex) {
        return graph[vertex];
    }

    public boolean hasCycle() {
        int vertices = graph.length;
        boolean[] visited = new boolean[vertices];
        boolean[] pathVisit = new boolean[vertices];

        // Check for all vertices because graph can be described as components
        for(int i=0;i<vertices;i++) {
            if(!visited[i]) {
                if(hasCycle(i, visited, pathVisit)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasCycle(int vertex, boolean[] visited, boolean[] pathVisit) {
        visited[vertex] = true;
        pathVisit[vertex] = true;

        for(Edge edge : neighbours(vertex)) {
            int neighbor = edge.destination;
            if(!visited[neighbor]) {
                if(hasCycle(neighbor, visited, pathVisit)) {
                    return true;
                }
            }
            else if(pathVisit[neighbor]) {
                return true;
            }
        }
        pathVisit[vertex] = false;
        return false;
    }
}

public class DirectedGraphMain {
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph();
        graph.create();
        System.out.println(graph.hasCycle());
    }
}
