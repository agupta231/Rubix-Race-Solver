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
    private Integer[][] data;
    private Collection<Board> neighbors;

    public Board(Integer[][] state) {
        this.setData(state);
        this.neighbors = null;
    }

    public Integer[][] getData() {
        return this.data;
    }

    public void setData(Integer[][] newData) {
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
                Integer[][] neighborData = this.data.clone();
                neighborData[rowIndex][columnIndex] = neighborData[rowIndex - 1][columnIndex];
                neighborData[rowIndex - 1][columnIndex] = 0;

                neighbors.add(new Board(neighborData));
            }
            if (switchDown) {
                Integer[][] neighborData = this.data.clone();
                neighborData[rowIndex][columnIndex] = neighborData[rowIndex + 1][columnIndex];
                neighborData[rowIndex + 1][columnIndex] = 0;

                neighbors.add(new Board(neighborData));
            }
            if (switchLeft) {
                Integer[][] neighborData = this.data.clone();
                neighborData[rowIndex][columnIndex] = neighborData[rowIndex][columnIndex - 1];
                neighborData[rowIndex][columnIndex - 1] = 0;

                neighbors.add(new Board(neighborData));
            }
            if (switchRight) {
                Integer[][] neighborData = this.data.clone();
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
                if (!this.getData()[i][j].equals(otherBoard.getData()[i][j])) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean containsSequence(Integer[][] middleSequence) {
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