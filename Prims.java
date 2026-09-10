import java.util.*;

public class PrimsAlgorithm {
    static int prim(int[][] graph, int n) {
        int[] key = new int[n];
        boolean[] mst = new boolean[n];
        int[] parent = new int[n];

        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        parent[0] = -1;

        int cost = 0;

        for (int count = 0; count < n - 1; count++) {
            int u = -1;

            for (int i = 0; i < n; i++)
                if (!mst[i] && (u == -1 || key[i] < key[u]))
                    u = i;

            mst[u] = true;

            for (int v = 0; v < n; v++)
                if (graph[u][v] != 0 && !mst[v] && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                    parent[v] = u;
                }
        }

        for (int i = 1; i < n; i++) {
            System.out.println(parent[i] + " - " + i + " : " + graph[i][parent[i]]);
            cost += graph[i][parent[i]];
        }

        return cost;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };

        System.out.println("Minimum Spanning Tree:");
        int cost = prim(graph, graph.length);
        System.out.println("Total Cost: " + cost);
    }
}
