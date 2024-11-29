import java.util.*;

class Graph {
    private int vertices;
    private List<List<Integer>> adjList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Add edges between two vertices
    public void addEdge(int source, int dest) {
        adjList.get(source).add(dest);
        adjList.get(dest).add(source);
    }

    // Perform BFS to find the shortest path
    public int findShortestPath(int source, int dest) {
        if (source == dest) return 0;

        int[] distance = new int[vertices];
        Arrays.fill(distance, -1); // Initialize distances as -1
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        distance[source] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : adjList.get(current)) {
                if (distance[neighbor] == -1) { // If not visited
                    distance[neighbor] = distance[current] + 1;
                    queue.add(neighbor);

                    if (neighbor == dest) { // Early exit if destination is reached
                        return distance[neighbor];
                    }
                }
            }
        }

        return -1; // Destination not reachable
    }
}

public class MinimumPath {
    static int gridSize = 4;

    // Check if the cell is valid (inside the grid and not blocked)
    static boolean isValid(int i, int j, int[][] grid) {
        return (i >= 0 && i < gridSize && j >= 0 && j < gridSize && grid[i][j] != 0);
    }

    public static int findMinimumPath(int[][] grid) {
        int source = 0, dest = 0;
        int vertices = gridSize * gridSize + 1;
        Graph graph = new Graph(vertices);

        int nodeNumber = 1; // Each cell is a node
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (grid[i][j] != 0) {
                    // Add edges for all valid neighbors
                    if (isValid(i, j + 1, grid)) graph.addEdge(nodeNumber, nodeNumber + 1);
                    if (isValid(i, j - 1, grid)) graph.addEdge(nodeNumber, nodeNumber - 1);
                    if (isValid(i + 1, j, grid)) graph.addEdge(nodeNumber, nodeNumber + gridSize);
                    if (isValid(i - 1, j, grid)) graph.addEdge(nodeNumber, nodeNumber - gridSize);

                    if (grid[i][j] == 1) source = nodeNumber; // Mark source node
                    if (grid[i][j] == 2) dest = nodeNumber;   // Mark destination node
                }
                nodeNumber++;
            }
        }

        return graph.findShortestPath(source, dest);
    }

    public static void main(String[] args) {
        int[][] grid = {
            {3, 3, 1, 0},
            {3, 0, 3, 3},
            {2, 3, 0, 3},
            {0, 3, 3, 3}
        };

        int result = findMinimumPath(grid);
        System.out.println("Minimum moves: " + result);
    }
}
