package GraphGen;

import Board.Node;

import java.util.Collection;

public interface Graph<T> {
    Collection<? extends Node> getNodes();

    Node<T> getNodeForData(T data);
}
