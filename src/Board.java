import java.util.LinkedList;

public class Board extends Node<int[][]> {
    public static int[][] startingBoard = {{2}, {3}};

    public Board(int[][] state) {
        this.setData(state);
    }

    @Override
    boolean equivalentTo(Node otherNode) {
        if(otherNode instanceof Board) {
            Board otherBoard = (Board) otherNode;

            for (int i = 1; i < this.getData().length - 1; i++) {
                for (int j = 1; j < this.getData().length - 1; j++) {
                    if (this.getData()[i][j] != otherBoard.getData()[i][j]) {
                        return false;
                    }
                }
            }

            return true;
        }
        else {
            return false;
        }
    }
}