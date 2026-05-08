import java.util.*;

public class WeightedGraph {
    private Map<String, List<Edge>> adj;

    public WeightedGraph() {
        adj = new HashMap<>();
    }

    public void addEdge(String from, String to, int weight) {
        adj.putIfAbsent(from, new ArrayList<>());
        adj.putIfAbsent(to, new ArrayList<>());
        adj.get(from).add(new Edge(to, weight));
        adj.get(to).add(new Edge(from, weight));
    }

    public List<Edge> getNeighbors(String v) {
        return adj.getOrDefault(v, new ArrayList<>());
    }

    public Set<String> getVertices() {
        return adj.keySet();
    }

    public void buildScottishNetwork() {
        addEdge("Edinburgh", "Stirling", 50);
        addEdge("Edinburgh", "Glasgow", 70);
        addEdge("Edinburgh", "Perth", 100);
        addEdge("Glasgow", "Stirling", 50);
        addEdge("Stirling", "Perth", 40);
        addEdge("Perth", "Dundee", 60);
    }

    public void printGraph() {
        System.out.println("\nScottish Road Network:");
        for (String v : adj.keySet()) {
            System.out.print(v + " → ");
            for (Edge e : adj.get(v)) {
                System.out.print(e.getDestination() + "(" + e.getWeight() + ") ");
            }
            System.out.println();
        }
    }
}