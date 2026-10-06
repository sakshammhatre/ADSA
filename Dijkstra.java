import java.util.*;

public class Dijkstra {

    static int[] dijkstra(int[][] graph, int source, int n) {
        int[] distance = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        for (int count = 0; count < n - 1; count++) {
            int u = -1;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (!visited[i] && distance[i] < min) {
                    min = distance[i];
                    u = i;
                }
            }

            if (u == -1)
                break;

            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != 0 &&
                    distance[u] != Integer.MAX_VALUE &&
                    distance[u] + graph[u][v] < distance[v]) {
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 4, 0, 0, 8},
            {4, 0, 8, 0, 0},
            {0, 8, 0, 7, 0},
            {0, 0, 7, 0, 9},
            {8, 0, 0, 9, 0}
        };

        int n = graph.length;
        int source = 0;

        int[] distance = dijkstra(graph, source, n);

        for (int i = 0; i < n; i++) {
            System.out.println("Distance from " + source + " to " + i + " = " + distance[i]);
        }
    }
}