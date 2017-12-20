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

        graph.addNode(startingNode);

        vistedNodes.put(startingNode.getData(), startingNode);

        for (Board b : startingNode.getNeighbors()) {
            b.addNeighbor(startingNode);
            boardsToVisit.add(b);
        }

        while (!boardsToVisit.isEmpty()) {
            Board currentBoard = boardsToVisit.poll();

            for (Board b : currentBoard.getNeighbors()) {
                if(!vistedNodes.containsKey(b.getData())) {
                    b.addNeighbor(currentBoard);

                    boardsToVisit.add(b);
                }
                else {
                    Board bOld = graph.getNodeForData(b.getData());

                    bOld.addNeighbor(currentBoard);
                }
            }

            vistedNodes.put(currentBoard.getData(), currentBoard);
        }

        return graph;
    }
}
