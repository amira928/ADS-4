import java.util.*;

public class Graph {
    private Map<Character, List<Character>> adj;

    public Graph() {
        adj = new HashMap<>();
    }

    public void addEdge(char u, char v) {
        adj.putIfAbsent(u, new ArrayList<>());
        adj.putIfAbsent(v, new ArrayList<>());
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public List<Character> getNeighbors(char v) {
        return adj.getOrDefault(v, new ArrayList<>());
    }

    public Set<Character> getVertices() {
        return adj.keySet();
    }

    public void buildGraph() {
        addEdge('A', 'C');
        addEdge('A', 'B');
        addEdge('A', 'D');
        addEdge('B', 'C');
        addEdge('B', 'E');
        addEdge('B', 'G');
        addEdge('C', 'D');
        addEdge('E', 'G');
        addEdge('E', 'F');
        addEdge('F', 'G');
    }

    public void printGraph() {
        System.out.println("Graph Adjacency List:");
        for (char v : adj.keySet()) {
            System.out.println(v + ": " + adj.get(v));
        }
    }
}