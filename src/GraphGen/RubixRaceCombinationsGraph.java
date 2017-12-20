package GraphGen;

import Board.Board;
import Board.BoardColor;

import java.util.Collection;
import java.util.HashMap;

public class RubixRaceCombinationsGraph {
    private HashMap<BoardColor[][], Board> nodesMap;

    RubixRaceCombinationsGraph() {
        nodesMap = new HashMap<>();
    }

    public Collection<Board> getNodes() {
        return nodesMap.values();
    }

    public Board getNodeForData(BoardColor[][] data) {
        return nodesMap.getOrDefault(data, null);
    }

    public void addNode(Board newNode) {

    }
}
