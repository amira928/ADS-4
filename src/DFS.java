import java.util.*;

public class DFS {
    private Graph graph;
    private Set<Character> marked;
    private List<Character> order;

    public DFS(Graph graph) {
        this.graph = graph;
    }

    public List<Character> dfs(char source) {
        marked = new HashSet<>();
        order = new ArrayList<>();
        System.out.println("\n=== DFS TRACE ===");
        dfsRecursive(source);
        return order;
    }

    private void dfsRecursive(char v) {
        marked.add(v);
        order.add(v);
        System.out.println("dfs(" + v + ")");

        for (char w : graph.getNeighbors(v)) {
            System.out.println("  check " + w);
            if (!marked.contains(w)) {
                System.out.println("  " + w + " not visited, calling dfs(" + w + ")");
                dfsRecursive(w);
                System.out.println("  back to " + v);
            } else {
                System.out.println("  " + w + " already visited");
            }
        }
        System.out.println(v + " done");
    }
}
