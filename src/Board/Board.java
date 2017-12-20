package Board;

public class Board extends Node<BoardColor[][]> {
    public static BoardColor[][] startingBoard;

    public Board(BoardColor[][] state) {
        this.setData(state);
    }

    @Override
    public boolean equivalentTo(Node otherNode) {
        if(otherNode instanceof Board) {
            Board otherBoard = (Board) otherNode;

            for (int i = 1; i < this.getData().length - 1; i++) {
                for (int j = 1; j < this.getData().length - 1; j++) {
                    if (this.getData()[i][j].equals(otherBoard.getData()[i][j])) {
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