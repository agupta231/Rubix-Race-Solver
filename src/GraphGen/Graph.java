package GraphGen;

import java.util.Collection;

public interface Graph<T, K> {
    Collection<? extends Node> getNodes();

    T getNodeForData(K data);
}
