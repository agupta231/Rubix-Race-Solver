package Board;

import java.util.Collection;
import java.util.LinkedList;

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
        this.neighbors = null;
    }

    public BoardColor[][] getData() {
        return this.data;
    }

    public void setData(BoardColor[][] newData) {
        this.data = newData;
    }

    public Collection<? extends Board> getNeighbors() {
        if (this.neighbors != null) {
            return this.neighbors;
        }
        else {
            LinkedList<Board> neighbors = new LinkedList<>();

            final int rowLength = this.getData().length;
            final int columnLength = this.getData()[0].length;

            int rowIndex = -1;
            int columnIndex = -1;

            for(int i = 0; i < rowLength; i++) {
                for(int j = 0; j < columnLength; j++) {
                    if (this.getData()[i][j] == BoardColor.BLANK) {
                        rowIndex = i;
                        columnIndex = j;
                    }
                }
            }

            // TODO: abstract this in some manner... Don't like this hardcoding
            boolean switchUp = true;
            boolean switchDown = true;
            boolean switchRight = true;
            boolean switchLeft = true;

            if (rowIndex == 0) {
                switchUp = false;
            }
            if (columnIndex == 0) {
                switchLeft = false;
            }
            if (rowIndex == rowLength - 1) {
                switchDown = false;
            }
            if (columnIndex == columnLength - 1) {
                switchRight = false;
            }

            if (switchUp) {
                BoardColor[][] neighborData = this.data.clone();
                neighborData[rowIndex][columnIndex] = neighborData[rowIndex - 1][columnIndex];
                neighborData[rowIndex - 1][columnIndex] = BoardColor.BLANK;

                neighbors.add(new Board(neighborData));
            }
            if (switchDown) {
                BoardColor[][] neighborData = this.data.clone();
                neighborData[rowIndex][columnIndex] = neighborData[rowIndex + 1][columnIndex];
                neighborData[rowIndex + 1][columnIndex] = BoardColor.BLANK;

                neighbors.add(new Board(neighborData));
            }
            if (switchLeft) {
                BoardColor[][] neighborData = this.data.clone();
                neighborData[rowIndex][columnIndex] = neighborData[rowIndex][columnIndex - 1];
                neighborData[rowIndex][columnIndex - 1] = BoardColor.BLANK;

                neighbors.add(new Board(neighborData));
            }
            if (switchRight) {
                BoardColor[][] neighborData = this.data.clone();
                neighborData[rowIndex][columnIndex] = neighborData[rowIndex][columnIndex + 1];
                neighborData[rowIndex][columnIndex + 1] = BoardColor.BLANK;

                neighbors.add(new Board(neighborData));
            }

            this.setNeighbors(neighbors);
            return neighbors;
        }
    }

    public void setNeighbors(Collection<Board> newNeighbors) {
        this.neighbors = newNeighbors;
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