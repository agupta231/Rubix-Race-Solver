package GraphGen;

import Board.Board;
import Board.BoardColor;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class RubixRaceCombinationsGraph {
    private HashMap<BoardColor[][], Board> nodesMap;

    public RubixRaceCombinationsGraph() {
        nodesMap = new HashMap<>();
    }

    public Collection<Board> getNodes() {
        return nodesMap.values();
    }

    public Board getNodeForData(BoardColor[][] data) {
        return nodesMap.getOrDefault(data, null);
    }

    public void addNode(Board newNode) {
        nodesMap.put(newNode.getData(), newNode);
    }

    public void generateGraph(Board startingNode) {
        HashMap<BoardColor[][], Board> vistedNodes = new HashMap<>();
        Queue<Board> boardsToVisit = new LinkedList<>();

        boardsToVisit.add(startingNode);

        while (!boardsToVisit.isEmpty()) {
            Board currentBoard = boardsToVisit.poll();

            for (Board b : currentBoard.getNeighbors()) {
                if(!vistedNodes.containsKey(b.getData())) {
                    boardsToVisit.add(b);
                }
            }

            this.addNode(currentBoard);
            vistedNodes.put(currentBoard.getData(), currentBoard);
        }
    }
}
