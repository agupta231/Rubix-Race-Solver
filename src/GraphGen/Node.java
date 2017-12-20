package GraphGen;

import java.util.Collection;

public interface Node<T> {
    T getData();
    void setData(T newData);
    Collection<? extends Node> getNeighbors();
    void setNeighbors(Collection<Node> newNeighbors);
    void addNeighbor(Node newNeighbor);
    abstract boolean equivalentTo(Node otherNode);
}