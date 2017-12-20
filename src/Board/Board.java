package Board;

import java.awt.*;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Board Color Scheme:
 * 0: Blank
 * 1: Red
 * 2: Green
 * 3: Blue
 * 4: White
 * 5: Yellow
 * 6: Orange
 */

public class Board {
    private int[][] data;
    private Collection<Board> neighbors;

    public Board(int[][] state) {
        this.setData(state);
        this.neighbors = null;
    }

    public int[][] getData() {
        return this.data;
    }

    public void setData(int[][] newData) {
        this.data = newData;
    }

    public Collection<? extends Board> getNeighbors() {
        if (this.neighbors != null) {
            System.out.println("Yee haw");
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
                    if (this.getData()[i][j] == 0) {
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
                int[][] neighborData = this.data.clone();
                neighborData[rowIndex][columnIndex] = neighborData[rowIndex - 1][columnIndex];
                neighborData[rowIndex - 1][columnIndex] = 0;

                neighbors.add(new Board(neighborData));
            }
            if (switchDown) {
                int[][] neighborData = this.data.clone();
                neighborData[rowIndex][columnIndex] = neighborData[rowIndex + 1][columnIndex];
                neighborData[rowIndex + 1][columnIndex] = 0;

                neighbors.add(new Board(neighborData));
            }
            if (switchLeft) {
                int[][] neighborData = this.data.clone();
                neighborData[rowIndex][columnIndex] = neighborData[rowIndex][columnIndex - 1];
                neighborData[rowIndex][columnIndex - 1] = 0;

                neighbors.add(new Board(neighborData));
            }
            if (switchRight) {
                int[][] neighborData = this.data.clone();
                neighborData[rowIndex][columnIndex] = neighborData[rowIndex][columnIndex + 1];
                neighborData[rowIndex][columnIndex + 1] = 0;

                neighbors.add(new Board(neighborData));
            }

            this.setNeighbors(neighbors);
            return neighbors;
        }
    }

    public void setNeighbors(Collection<Board> newNeighbors) {
        this.neighbors = newNeighbors;
    }

    public boolean equivalentTo(Board otherBoard) {
        for (int i = 1; i < this.getData().length - 1; i++) {
            for (int j = 1; j < this.getData().length - 1; j++) {
                if (this.getData()[i][j] != otherBoard.getData()[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean containsSequence(int[][] middleSequence) {
        for(int i = 0; i < middleSequence.length; i++) {
            for(int j = 0; j < middleSequence[0].length; j++) {
                if (middleSequence[i][j] != this.getData()[i + 1][j + 1]) {
                    return false;
                }
            }
        }

        return true;
    }
}