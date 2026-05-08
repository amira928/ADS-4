import java.util.*;

public class Dijkstra {
    private WeightedGraph graph;

    public Dijkstra(WeightedGraph graph) {
        this.graph = graph;
    }

    public void findShortestPath(String source, String destination) {
        Map<String, Integer> dist = new HashMap<>();
        Map<String, String> prev = new HashMap<>();
        Set<String> visited = new HashSet<>();

        PriorityQueue<Map.Entry<Integer, String>> pq = new PriorityQueue<>(
                Map.Entry.comparingByKey()
        );

        for (String v : graph.getVertices()) {
            dist.put(v, Integer.MAX_VALUE);
            prev.put(v, null);
        }
        dist.put(source, 0);
        pq.add(new AbstractMap.SimpleEntry<>(0, source));

        System.out.println("\nDijkstra's Algorithm Trace:");
        int step = 1;

        while (!pq.isEmpty()) {
            Map.Entry<Integer, String> entry = pq.poll();
            int currDist = entry.getKey();
            String curr = entry.getValue();

            if (visited.contains(curr)) continue;
            visited.add(curr);

            System.out.println("Step " + step + ": Processing " + curr + " (dist=" + currDist + ")");
            step++;

            if (curr.equals(destination)) break;

            for (Edge e : graph.getNeighbors(curr)) {
                String neighbor = e.getDestination();
                int weight = e.getWeight();
                int newDist = currDist + weight;

                if (!visited.contains(neighbor) && newDist < dist.get(neighbor)) {
                    dist.put(neighbor, newDist);
                    prev.put(neighbor, curr);
                    pq.add(new AbstractMap.SimpleEntry<>(newDist, neighbor));
                    System.out.println("  Updated " + neighbor + " = " + newDist);
                }
            }
        }

        // Print result
        System.out.println("\n" + "=".repeat(60));
        System.out.println("RESULT - Shortest path from " + source + " to " + destination);
        System.out.println("=".repeat(60));

        List<String> path = new ArrayList<>();
        String current = destination;
        while (current != null) {
            path.add(0, current);
            current = prev.get(current);
        }
        System.out.println("Path: " + String.join(" → ", path));
        System.out.println("Distance: " + dist.get(destination) + " miles");
    }
}