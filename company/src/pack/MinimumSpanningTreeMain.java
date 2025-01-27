package pack;

import java.util.ArrayList;
import java.util.PriorityQueue;

class MinimumSpanningTree {
    @SuppressWarnings("unused")
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
        this.graph = new ArrayList[5];
        for (int i = 0; i < 5; i++) {
            this.graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 2));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 2));
        graph[2].add(new Edge(2, 4, 2));

        graph[3].add(new Edge(3, 2, 2));
        graph[3].add(new Edge(3, 4, 1));

        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 2, 2));
    }

    public ArrayList<Edge> neighbours(int vertex) {
        return graph[vertex];
    }

    public int primsAlgo() {
        PriorityQueue<Edge> queue = new PriorityQueue<Edge>((x, y) -> x.weight - y.weight);
        boolean[] visited = new boolean[graph.length];

        // Add all the neighbours in the queue for the vertex 0
        for(Edge edge : neighbours(0)) {
            queue.offer(edge);
        }  
        visited[0] = true;   
        int sum = 0;
        while(!queue.isEmpty()) {
            Edge current = queue.poll();
            int weight = current.weight;
            int destination = current.destination;

            if(visited[destination]) {
                continue;
            }
            visited[destination] = true;
            sum += weight;

            for(Edge edge : neighbours(destination)) {
                int neighbor = edge.destination;
                if(!visited[neighbor]) {
                    queue.offer(edge);
                }
            }
        }
        return sum;
    }
}

public class MinimumSpanningTreeMain {
    public static void main(String[] args) {
        MinimumSpanningTree graph = new MinimumSpanningTree();
        graph.create();
        System.out.println("Minimum Spanning Tree Sum of Weight : " + graph.primsAlgo());
    }
}