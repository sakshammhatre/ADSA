import java.util.*;

public class BFS {

    static int[] queue = new int[100];
    static int front = -1, rear = -1;
    static boolean[] visited = new boolean[100];

    static void enqueue(int vertex) {
        if (rear == 99)
            return;

        if (front == -1)
            front = 0;

        queue[++rear] = vertex;
    }

    static int dequeue() {
        if (front == -1)
            return -1;

        int vertex = queue[front];

        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front++;
        }

        return vertex;
    }

    static void BFS(int[][] graph, int vertices) {

        for (int i = 0; i < vertices; i++)
            visited[i] = false;

        enqueue(0);
        visited[0] = true;

        System.out.print("BFS Traversal: ");

        while (front != -1) {
            int current = dequeue();

            System.out.print(current + " ");

            for (int i = 0; i < vertices; i++) {
                if (graph[current][i] == 1 && !visited[i]) {
                    enqueue(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();

        int[][] graph = new int[vertices][vertices];

        System.out.println("Enter adjacency matrix:");

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        BFS(graph, vertices);

        sc.close();
    }
}
