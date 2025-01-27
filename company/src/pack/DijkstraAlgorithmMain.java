package pack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class DijkstraAlgorithm {
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
        
        graph[0].add(new Edge(0,1,4));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1, 0, 4));
        graph[1].add(new Edge(1, 2, 2));

        graph[2].add(new Edge(2, 0, 4));
        graph[2].add(new Edge(2, 1, 2));
        graph[2].add(new Edge(2, 3, 3));
        graph[2].add(new Edge(2, 4, 1));
        graph[2].add(new Edge(2, 5, 6));
        
        graph[3].add(new Edge(3, 2, 3));
        graph[3].add(new Edge(3, 5, 2));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 5, 3));

        graph[5].add(new Edge(5, 3, 2));
        graph[5].add(new Edge(5, 4, 3));
    }

    public void neighbours(int vertex) {
        System.out.println("Neighbours of the vertex : " + vertex);
        for (Edge edge : graph[vertex]) {
            System.out.println(edge.source + " -> " + edge.destination + " weight : " + edge.weight);
        }
    }

    // Dijkstra Algo for the path to Every node from start node with min weight

    public int[] dijkstra(int source) {
        int[] distance = new int[graph.length];
        for(int i=0;i<graph.length;i++) {
            distance[i] = Integer.MAX_VALUE;  // put max value at every dis position as infinity
        }
        distance[source] = 0; // distance to source is 0

        PriorityQueue<Edge> queue = new PriorityQueue<>((x,y) -> x.weight - y.weight);  // create a priority queue
        queue.add(new Edge(-1, source, 0));                                  // add source to the queue with distance as we don't need source so that will be -1

        while(!queue.isEmpty()) {
            int dist = queue.peek().weight;         // get the weight from the queue
            int vertex = queue.peek().destination;  // get the current node from the queue
            queue.remove();                         // remove from the queue

            for (Edge edge : graph[vertex]) {
                int newDis = dist + edge.weight;    // get the new distance 
                if (newDis < distance[edge.destination]) {  // check if the new distance is less that the old one
                    distance[edge.destination] = newDis;    // if true update it
                    queue.add(new Edge(-1, edge.destination, newDis));    // add to the queue
                }
            }
        }
        return distance;
    }

    // Shortest path between source and destination using dijkstra algo start -> 0 end -> 5

    public List<Integer> shortestPath() {
        PriorityQueue<Edge> queue = new PriorityQueue<>((x,y) -> x.weight - y.weight);
        int[] distance = new int[graph.length];
        int[] previous = new int[graph.length];

        for(int i=0;i<graph.length;i++) {
            distance[i] = Integer.MAX_VALUE;  // put max value at every dis position as infinity
            previous[i] = i;                  // initialize with index value at every index
        }
        distance[0] = 0;                                        // distance to source is 0
        queue.add(new Edge(-1, 0, 0));       // add the source node

        // Apply Dijkstra Algo
        while(!queue.isEmpty()) {
            Edge item = queue.remove();
            int dist = item.weight;
            int vertex = item.destination;

            for(Edge edge : graph[vertex]) {
                int newDis = dist + edge.weight;    // get the new distance
                if (newDis < distance[edge.destination]) {  // check if the new distance is less
                    distance[edge.destination] = newDis;    // if true update it
                    previous[edge.destination] = vertex;  // update the previous node
                    queue.add(new Edge(-1, edge.destination, newDis));    // add to the queue
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        if(distance[5] == Integer.MAX_VALUE) {      // If there is no path to the last node return empty list
            return list;
        }

        int elem = 5;
        while(previous[elem] != elem) {
            list.add(elem);
            elem = previous[elem];      // using the previous array store the path 
        }
        
        list.add(0);    // Enter the first element
        Collections.reverse(list);      // reverse the list 
        return list;
   }
}

public class DijkstraAlgorithmMain {
    public static void main(String[] args) {
        DijkstraAlgorithm graph = new DijkstraAlgorithm();
        graph.create();
        int result[] = graph.dijkstra(4);
        
        for(int item : result) {
            System.out.print(item + "\t");
        }

        System.out.println(graph.shortestPath());
    }
}
