package GraphGen;

import Board.Board;

import java.lang.reflect.Array;
import java.util.*;

public class RubixRaceCombinationsGraph {
    private HashMap<Integer, Board> nodesMap;
    public RubixRaceCombinationsGraph() {
        nodesMap = new HashMap<>();
    }

    public Collection<Board> getNodes() {
        return nodesMap.values();
    }

    public Board getNodeForData(BoardColor[][] data) {
        return nodesMap.getOrDefault(Arrays.deepHashCode(data), null);
    }

    public void addNode(Board newNode) {
        nodesMap.put(Arrays.deepHashCode(newNode.getData()), newNode);
    }

    public void generateGraph(Board startingNode) {
        HashMap<Integer, Board> vistedNodes = new HashMap<>();
        Queue<Board> boardsToVisit = new LinkedList<>();

        boardsToVisit.add(startingNode);

        while (!boardsToVisit.isEmpty()) {
            Board currentBoard = boardsToVisit.poll();
            vistedNodes.put(Arrays.deepHashCode(currentBoard.getData()), currentBoard);

            System.out.println(vistedNodes.size());

            for (Board b : currentBoard.getNeighbors()) {
                if (!vistedNodes.containsKey(Arrays.deepHashCode(b.getData()))) {
                    boardsToVisit.add(b);
                } else if (vistedNodes.containsKey(Arrays.deepHashCode(b.getData()))) {
                    System.out.println("Here bb");
                }

                System.out.println(vistedNodes.containsKey(Arrays.deepHashCode(b.getData())));
            }

            this.addNode(currentBoard);

            System.out.println(boardsToVisit.size());
        }
    }
}
