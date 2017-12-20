package Board;

import GraphGen.Node;

public class Board extends Node<BoardColor[][]> {
    public static BoardColor[][] startingBoard = new BoardColor[][]
                   {{BoardColor.RED, BoardColor.GREEN, BoardColor.GREEN, BoardColor.WHITE, BoardColor.YELLOW},
                    {BoardColor.RED, BoardColor.ORANGE, BoardColor.YELLOW, BoardColor.RED, BoardColor.BLANK},
                    {BoardColor.GREEN, BoardColor.ORANGE, BoardColor.YELLOW, BoardColor.RED, BoardColor.ORANGE},
                    {BoardColor.ORANGE, BoardColor.BLUE, BoardColor.BLUE, BoardColor.WHITE, BoardColor.BLUE},
                    {BoardColor.YELLOW, BoardColor.GREEN, BoardColor.WHITE, BoardColor.BLUE, BoardColor.YELLOW}};

    public static BoardColor[][] endingBoard = new BoardColor[][]
                    {{BoardColor.ORANGE, BoardColor.YELLOW, BoardColor.WHITE},
                    {BoardColor.ORANGE, BoardColor.YELLOW, BoardColor.RED},
                    {BoardColor.BLUE, BoardColor.BLUE, BoardColor.WHITE}};

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