package GraphGen;

import Board.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class RRGraphGenerator {
    public RubixRaceCombinationsGraph generateGraph(Board startingNode) {
        RubixRaceCombinationsGraph graph = new RubixRaceCombinationsGraph();

        HashMap<BoardColor[][], Board> vistedNodes = new HashMap<>();
        HashMap<Board, Integer> distances = new HashMap<>();
        Queue<Board> boardsToVisit = new LinkedList<>();

        graph.addNode(startingNode);

        vistedNodes.put(startingNode.getData(), startingNode);
        distances.put(startingNode, 0);

        boardsToVisit.addAll(startingNode.getNeighbors());

        for (Board b : startingNode.getNeighbors()) {
            b.addNeighbor(startingNode);
            boardsToVisit.add(b);
            distances.put(b, 1);
        }

        while (!boardsToVisit.isEmpty()) {
            Board currentBoard = boardsToVisit.poll();

            for (Board b : currentBoard.getNeighbors()) {
                if(!vistedNodes.containsKey(b.getData())) {
                    b.addNeighbor(currentBoard);
                    distances.put(b, distances.get(currentBoard) + 1);

                    boardsToVisit.add(b);
                }
                else {
                    Board bOld = (Board) graph.getNodeForData(b.getData());

                    bOld.addNeighbor(currentBoard);

                    Integer oldDistance = distances.get(bOld);
                    Integer newDistance = distances.get(currentBoard) + 1;

                    distances.remove(bOld);
                    distances.put(bOld, Math.min(oldDistance, newDistance));
                }
            }

            vistedNodes.put(currentBoard.getData(), currentBoard);
        }

        return graph;
    }
}
