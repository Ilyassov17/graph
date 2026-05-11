import java.util.*;
public class BreadthFirstSearch<V> {
    public void bfs(Vertex<V> start) {
        Set<Vertex<V>> visited=new HashSet<>();
        Queue<Vertex<V>> queue=new LinkedList<>();
        visited.add(start);
        queue.add(start);
        while (!queue.isEmpty()) {
            Vertex<V> current=queue.poll();
            System.out.print(current+" ");
            for (Vertex<V> neighbor:current.getAdjacentVertices().keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }
}