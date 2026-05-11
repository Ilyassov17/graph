import java.util.*;
public class DijkstraSearch<V> {
    public Map<Vertex<V>, Double> dijkstra(Vertex<V> start) {
        Map<Vertex<V>, Double> distances=new HashMap<>();
        PriorityQueue<VertexDistance<V>> pq=
                new PriorityQueue<>(Comparator.comparingDouble(v -> v.distance));
        distances.put(start,0.0);
        pq.add(new VertexDistance<>(start, 0.0));
        while (!pq.isEmpty()) {
            VertexDistance<V> currentPair=pq.poll();
            Vertex<V> current=currentPair.vertex;
            double currentDistance=currentPair.distance;
            for (Map.Entry<Vertex<V>,Double> neighborEntry :
                    current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor=neighborEntry.getKey();
                double weight=neighborEntry.getValue();
                double newDistance=currentDistance+weight;
                if (!distances.containsKey(neighbor)
                        || newDistance < distances.get(neighbor)) {
                    distances.put(neighbor, newDistance);
                    pq.add(new VertexDistance<>(neighbor,newDistance));
                }
            }
        }
        return distances;
    }
    private static class VertexDistance<V> {
        Vertex<V> vertex;
        double distance;
        VertexDistance(Vertex<V> vertex,double distance) {
            this.vertex=vertex;
            this.distance=distance;
        }
    }
}