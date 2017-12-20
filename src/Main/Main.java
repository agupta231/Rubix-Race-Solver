package Main;

import BFS.BreadthFirstSearch;
import Board.*;
import GraphGen.RubixRaceCombinationsGraph;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        final BoardColor[][] startingBoard = new BoardColor[][]
               {{BoardColor.RED, BoardColor.GREEN, BoardColor.GREEN, BoardColor.WHITE, BoardColor.YELLOW},
                {BoardColor.RED, BoardColor.ORANGE, BoardColor.YELLOW, BoardColor.RED, BoardColor.BLANK},
                {BoardColor.GREEN, BoardColor.ORANGE, BoardColor.YELLOW, BoardColor.RED, BoardColor.ORANGE},
                {BoardColor.ORANGE, BoardColor.BLUE, BoardColor.BLUE, BoardColor.WHITE, BoardColor.BLUE},
                {BoardColor.YELLOW, BoardColor.GREEN, BoardColor.WHITE, BoardColor.BLUE, BoardColor.YELLOW}};

        final BoardColor[][] endingBoard = new BoardColor[][]
               {{BoardColor.ORANGE, BoardColor.YELLOW, BoardColor.WHITE},
                {BoardColor.ORANGE, BoardColor.YELLOW, BoardColor.RED},
                {BoardColor.BLUE, BoardColor.BLUE, BoardColor.WHITE}};


//        Board startingNode = new Board(startingBoard);
//
//        System.out.println("Here");
//
//        RubixRaceCombinationsGraph graph = new RubixRaceCombinationsGraph();
//        graph.generateGraph(startingNode);
//
//        System.out.println("Here2");
//
//        BreadthFirstSearch searchEngine = new BreadthFirstSearch();
//
//        LinkedList<Board> optimalSolution = searchEngine.shortestPath(startingNode, endingBoard, graph);
//
//        System.out.println(optimalSolution);

        System.out.println(startingBoard.equals(startingBoard.clone()));
    }
}
