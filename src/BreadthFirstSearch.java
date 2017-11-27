import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch implements GraphSearchEngine {
    @Override
    public LinkedList<Node> shortestPath(Node node1, Node node2) {
        HashSet<Node> visistedNodes = new HashSet<>();
        HashMap<Node, Integer> distanceFromNode1 = new HashMap<>();
        Queue<Node> nodesToSearch = new LinkedList<>();

        if (node1.equivalentTo(node2)) {
            LinkedList<Node> resultantList = new LinkedList<>();
            resultantList.add(node1);

            return resultantList;
        }

        visistedNodes.add(node1);
        distanceFromNode1.put(node1, 0);

        for(Object o : node1.getNeighbors()) {
            Node n = (Node) o;
        }
    }
}
