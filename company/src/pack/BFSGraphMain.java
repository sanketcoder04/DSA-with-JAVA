package pack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class BFSGraph {
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

    // start with Node 0
    // if visited not true
    // remove from queue
    // print it
    // Make visited true
    // Get all the neighbours
    // Add all the neighbours at the queue

    public void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[graph.length];
        queue.offer(0);

        while(!queue.isEmpty()) {
            int vertex = queue.poll();  
            if(!visited[vertex]) {      
                System.out.print(vertex + "\t");   
                visited[vertex] = true;     
                ArrayList<Edge> neighbours = neighbours(vertex);    
                for (Edge edge : neighbours) {
                    queue.offer(edge.destination);      
                }
            }
        }
        System.out.println();
    }
}

public class BFSGraphMain {
    public static void main(String[] args) {
        BFSGraph graph = new BFSGraph();
        graph.create(7);
        graph.bfs();
    }
}
