import java.util.*;

public class GraphAlgorithms {
    
    // Graph class using adjacency list representation
    static class Graph {
        private Map<Integer, List<Integer>> adjList;

        // Constructor
        public Graph() {
            adjList = new HashMap<>();
        }

        // Add a vertex to the graph
        public void addVertex(int vertex) {
            adjList.putIfAbsent(vertex, new ArrayList<>());
        }

        // Add an edge between two vertices
        public void addEdge(int from, int to) {
            adjList.putIfAbsent(from, new ArrayList<>());
            adjList.putIfAbsent(to, new ArrayList<>());
            adjList.get(from).add(to);
        }

        // Get the adjacency list of a vertex
        public List<Integer> getAdjVertices(int vertex) {
            return adjList.get(vertex);
        }

        // Get all vertices in the graph
        public Set<Integer> getVertices() {
            return adjList.keySet();
        }

        // Depth-First Search (DFS)
        public void dfs(int start) {
            Set<Integer> visited = new HashSet<>();
            dfsUtil(start, visited);
        }

        // Utility method for DFS
        private void dfsUtil(int vertex, Set<Integer> visited) {
            visited.add(vertex);
            System.out.print(vertex + " ");

            for (int neighbor : adjList.get(vertex)) {
                if (!visited.contains(neighbor)) {
                    dfsUtil(neighbor, visited);
                }
            }
        }

        // Breadth-First Search (BFS)
        public void bfs(int start) {
            Set<Integer> visited = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();
            
            visited.add(start);
            queue.offer(start);

            while (!queue.isEmpty()) {
                int vertex = queue.poll();
                System.out.print(vertex + " ");

                for (int neighbor : adjList.get(vertex)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        // Add vertices
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        // Add edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        graph.addEdge(4, 0);

        System.out.println("Depth-First Search (DFS) starting from vertex 0:");
        graph.dfs(0);  // Expected Output: 0 1 2 3 4
        System.out.println();

        System.out.println("Breadth-First Search (BFS) starting from vertex 0:");
        graph.bfs(0);  // Expected Output: 0 1 2 3 4
        System.out.println();
    }
}
