package BFS;

import Board.Node;

import java.util.LinkedList;

interface GraphSearchEngine {
    LinkedList<Node> shortestPath(Node node1, Node node2);
}
