import java.util.Collection;

public abstract class Node<T> {
    private T _data;
    private Collection<Node> _neighbors;

    public T getData() {
        return this._data;
    }

    public void setData(T newData) {
        this._data = newData;
    }

    public Collection<? extends Node> getNeighbors() {
        return this._neighbors;
    }

    public void setNeighbors(Collection<Node> newNeighbors) {
        this._neighbors = newNeighbors;
    }

    public void addNeighbor(Node newNeighbor) {
        this._neighbors.add(newNeighbor);
    }

    abstract boolean equivalentTo(Node otherNode);
}