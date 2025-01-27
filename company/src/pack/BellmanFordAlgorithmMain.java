package pack;

import java.util.ArrayList;

class BellmanFordAlgorithm {
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

    public int[] bellmanFord(int start) {
        int vertices = graph.length;
        int[] distance = new int[vertices];

        for(int i=0;i<vertices;i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[start] = 0;

        // Iterate for N-1 iterations
        for(int i=0;i<vertices;i++) {
            for(Edge edge : neighbours(i)) {
                int source = edge.source;
                int destination = edge.destination;
                int weight = edge.weight;

                if(distance[source] != Integer.MAX_VALUE && distance[source] + weight < distance[destination]) {
                    distance[destination] = distance[source] + weight;
                }
            }
        }
        
        // Checking for the Nth iteration
        for(Edge edge : neighbours(vertices)) {
            int source = edge.source;
            int destination = edge.destination;
            int weight = edge.weight;

            if(distance[source] != Integer.MAX_VALUE && distance[source] + weight < distance[destination]) {
                return new int[]{};
            }
        }
        return distance;
    }

    public void display(int[] arr) {
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}

public class BellmanFordAlgorithmMain {
    public static void main(String[] args) {
        BellmanFordAlgorithm graph = new BellmanFordAlgorithm();
        graph.create();
        int[] result = graph.bellmanFord(0);
        graph.display(result);
    }
}
