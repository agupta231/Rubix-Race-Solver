package GraphGen;

import Board.Board;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class RubixRaceCombinationsGraph {
    private HashMap<Integer[][], Board> nodesMap;

    public RubixRaceCombinationsGraph() {
        nodesMap = new HashMap<>();
    }

    public Collection<Board> getNodes() {
        return nodesMap.values();
    }

    public Board getNodeForData(int[][] data) {
        return nodesMap.getOrDefault(data, null);
    }

    public void addNode(Board newNode) {
        nodesMap.put(newNode.getData(), newNode);
    }

    public void generateGraph(Board startingNode) {
        HashMap<Integer[][], Board> vistedNodes = new HashMap<>();
        Queue<Board> boardsToVisit = new LinkedList<>();

        boardsToVisit.add(startingNode);

        while (!boardsToVisit.isEmpty()) {
            Board currentBoard = boardsToVisit.poll();
            vistedNodes.put(currentBoard.getData(), currentBoard);

            System.out.println(vistedNodes.size());

            for (Board b : currentBoard.getNeighbors()) {
                if(!vistedNodes.containsKey(b.getData())) {
                    boardsToVisit.add(b);
                }
                else if(vistedNodes.containsKey(b.getData())){
                    System.out.println("Here bb");
                }

                System.out.println(vistedNodes.containsKey(b.getData()));
            }

            this.addNode(currentBoard);

            System.out.println(boardsToVisit.size());
        }
    }
}
