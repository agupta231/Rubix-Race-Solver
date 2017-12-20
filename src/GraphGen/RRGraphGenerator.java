package GraphGen;

import Board.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class RRGraphGenerator {
    public RubixRaceCombinationsGraph generateGraph(Board startingNode) {
        RubixRaceCombinationsGraph graph = new RubixRaceCombinationsGraph();

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

            graph.addNode(currentBoard);
            vistedNodes.put(currentBoard.getData(), currentBoard);
        }

        return graph;
    }
}
