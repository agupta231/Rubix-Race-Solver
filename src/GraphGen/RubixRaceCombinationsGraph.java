package GraphGen;

import Board.Board;
import Board.BoardColor;

import java.util.Collection;
import java.util.HashMap;

public class RubixRaceCombinationsGraph implements Graph<Board, BoardColor[][]> {
    private HashMap<BoardColor[][], Board> nodesMap;

    RubixRaceCombinationsGraph() {
        nodesMap = new HashMap<>();
    }

    @Override
    public Collection<? extends Node> getNodes() {
        return nodesMap.values();
    }

    @Override
    public Board getNodeForData(BoardColor[][] data) {
        return nodesMap.getOrDefault(data, null);
    }
}
