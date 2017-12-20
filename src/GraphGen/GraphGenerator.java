package GraphGen;

public interface GraphGenerator<T, K> {
    T generateGraph(K startingNode);
}
