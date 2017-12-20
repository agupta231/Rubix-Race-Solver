package BFS;

import Board.*;
import GraphGen.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    public LinkedList<Board> shortestPath(Board startingNode, BoardColor[][] endingPosition, RubixRaceCombinationsGraph graph) {
        HashMap<Integer, Board> vistedNodes = new HashMap<>();
        HashMap<Board, Integer> distances = new HashMap<>();
        Queue<Board> boardsToVisit = new LinkedList<>();

        distances.put(startingNode, 0);
        boardsToVisit.add(startingNode);

        while (!boardsToVisit.isEmpty()) {
            Board currentBoard = boardsToVisit.poll();

            if (currentBoard.containsSequence(endingPosition)) {
                return reconstructPath(currentBoard, distances);
            }

            for (Board b : currentBoard.getNeighbors()) {
                if (!vistedNodes.containsKey(Arrays.deepHashCode(b.getData()))) {
                    distances.put(b, distances.get(currentBoard) + 1);

                    boardsToVisit.add(b);
                } else {
                    Board bOld = graph.getNodeForData(b.getData());

                    Integer oldDistance = distances.get(bOld);
                    Integer newDistance = distances.get(currentBoard) + 1;

                    distances.remove(bOld);
                    distances.put(bOld, Math.min(oldDistance, newDistance));
                }
            }

            vistedNodes.put(Arrays.deepHashCode(currentBoard.getData()), currentBoard);
        }

        return null;
    }

    private LinkedList<Board> reconstructPath(Board endingNode, HashMap<Board, Integer> distances) {
        Board shortestPath = null;
        Integer shortestDistance = Integer.MAX_VALUE;

        for (Board child : endingNode.getNeighbors()) {
            if (distances.containsKey(child)) {
                final Integer distance = distances.get(child);

                if (distance == 0) {
                    LinkedList<Board> path = new LinkedList<>();
                    path.add(child);
                    path.add(endingNode);

                    return path;
                }

                if (distance <= shortestDistance) {
                    shortestPath = child;
                    shortestDistance = distance;
                }
            }
        }

        LinkedList<Board> path = reconstructPath(shortestPath, distances);
        path.add(endingNode);

        return path;
    }
}
