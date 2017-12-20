package Board;

import java.util.Collection;

public class Board {
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

    private BoardColor[][] data;
    private Collection<Board> neighbors;

    public Board(BoardColor[][] state) {
        this.setData(state);
    }

    public BoardColor[][] getData() {
        return this.data;
    }

    public void setData(BoardColor[][] newData) {
        this.data = newData;
    }

    public Collection<? extends  Board> getNeighbors() {
        return this.neighbors;
    }

    public void setNeighbors(Collection<Board> newNeighbors) {
        this.neighbors = newNeighbors;
    }

    public void addNeighbor(Board newNeighbor) {

    }

    public boolean equivalentTo(Board otherNode) {
        Board otherBoard = otherNode;

        for (int i = 1; i < this.getData().length - 1; i++) {
            for (int j = 1; j < this.getData().length - 1; j++) {
                if (this.getData()[i][j].equals(otherBoard.getData()[i][j])) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean containsSequence(BoardColor[][] middleSequence) {
        for(int i = 0; i < middleSequence.length; i++) {
            for(int j = 0; j < middleSequence[0].length; j++) {
                if (!middleSequence[i][j].equals(this.getData()[i + 1][j + 1])) {
                    return false;
                }
            }
        }

        return true;
    }
}