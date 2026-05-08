import java.util.*;

public class BFS {
    private Graph graph;
    private Set<Character> marked;
    private List<Character> order;

    public BFS(Graph graph) {
        this.graph = graph;
    }

    public List<Character> bfs(char source) {
        marked = new HashSet<>();
        order = new ArrayList<>();
        Queue<Character> queue = new LinkedList<>();

        System.out.println("\n=== BFS TRACE ===");
        System.out.println("Queue: " + source);

        marked.add(source);
        queue.add(source);

        while (!queue.isEmpty()) {
            char v = queue.poll();
            order.add(v);
            System.out.println("\nRemoves " + v + " from the queue and puts its adjacent vertices");

            for (char w : graph.getNeighbors(v)) {
                if (!marked.contains(w)) {
                    marked.add(w);
                    queue.add(w);
                    System.out.println("  " + w);
                }
            }
            System.out.print("Queue: ");
            for (char q : queue) {
                System.out.print(q + " ");
            }
            System.out.println();
        }
        return order;
    }
}