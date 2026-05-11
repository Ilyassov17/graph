import java.util.Map;
public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>(false);
        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 2);
        graph.addEdge("B", "D", 1);
        graph.addEdge("C", "D", 7);
        graph.addEdge("C", "E", 3);
        graph.addEdge("D", "E", 1);
        System.out.println("BFS Traversal:");
        BreadthFirstSearch<String> bfs=new BreadthFirstSearch<>();
        bfs.bfs(graph.getVertex("A"));
        System.out.println("\n");
        System.out.println("Dijkstra Shortest Paths:");
        DijkstraSearch<String> dijkstra=new DijkstraSearch<>();
        Map<Vertex<String>, Double> distances=
                dijkstra.dijkstra(graph.getVertex("A"));
        for (Map.Entry<Vertex<String>,Double>entry:distances.entrySet()) {
            System.out.println(
                    "Distance from A to "
                            +entry.getKey()
                            +"="
                            +entry.getValue()
            );
        }
    }
}