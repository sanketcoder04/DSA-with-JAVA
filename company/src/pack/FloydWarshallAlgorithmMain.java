package pack;

class FloydWarshallAlgorithm {
    public void floydWarshall(int[][] graph) {
        int size = graph.length;
        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                if(graph[i][j] == -1) {
                    graph[i][j] = Integer.MAX_VALUE;
                }
                if(i == j) {
                    graph[i][j] = 0;
                }
            }
        }
        for(int k=0;k<size;k++) {
            for(int i=0;i<size;i++) {
                for(int j=0;j<size;j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                if(graph[i][j] == Integer.MAX_VALUE) {
                    graph[i][j] = -1;
                }
            }
        }
    }

    public void display(int[][] graph) {
        int size = graph.length;
        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                System.out.print(graph[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

public class FloydWarshallAlgorithmMain {
    public static void main(String[] args) {
        int[][] graph = {{0, 2, -1, -1},
                         {1, 0, 3, -1},
                         {-1, -1, 0, -1},
                         {3, 5, 4, 0}};

        FloydWarshallAlgorithm algo = new FloydWarshallAlgorithm();
        algo.floydWarshall(graph);
        algo.display(graph);
    }
}
