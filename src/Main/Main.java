package Main;

import BFS.BreadthFirstSearch;
import Board.*;
import GraphGen.RubixRaceCombinationsGraph;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        final Integer[][] startingBoard = new Integer[][]
               {{1, 1, 2, 4, 5},
                {1, 6, 5, 1, 0},
                {2, 6, 5, 1, 6},
                {6, 3, 3, 4, 3},
                {5, 2, 4, 3, 5}};

        final Integer[][] endingBoard = new Integer[][]
               {{6, 5, 4},
                {6, 5, 1},
                {3, 3, 4}};

        Board startingNode = new Board(startingBoard);

        System.out.println("Here");

        RubixRaceCombinationsGraph graph = new RubixRaceCombinationsGraph();
        graph.generateGraph(startingNode);

        System.out.println("Here2");

        BreadthFirstSearch searchEngine = new BreadthFirstSearch();

        LinkedList<Board> optimalSolution = searchEngine.shortestPath(startingNode, endingBoard, graph);

        System.out.println(optimalSolution);

        System.out.println(Arrays.deepHashCode(startingBoard) == Arrays.deepHashCode(startingBoard.clone()));
        System.out.println(BoardColor.WHITE.equals(BoardColor.WHITE));
    }
}
