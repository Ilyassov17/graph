import java.util.HashMap;
import java.util.Map;
public class WeightedGraph<V> {
    private Map<V,Vertex<V>> vertices;
    private boolean directed;
    public WeightedGraph(boolean directed) {
        this.directed=directed;
        vertices=new HashMap<>();
    }
    public void addVertex(V data) {
        vertices.putIfAbsent(data,new Vertex<>(data));
    }
    public void addEdge(V source,V destination,double weight) {
        addVertex(source);
        addVertex(destination);
        Vertex<V> sourceVertex=vertices.get(source);
        Vertex<V> destinationVertex=vertices.get(destination);
        sourceVertex.addAdjacentVertex(destinationVertex,weight);
        if (!directed) {
            destinationVertex.addAdjacentVertex(sourceVertex,weight);
        }
    }
    public Vertex<V> getVertex(V data) {
        return vertices.get(data);
    }
    public Map<V,Vertex<V>> getVertices() {
        return vertices;
    }
}