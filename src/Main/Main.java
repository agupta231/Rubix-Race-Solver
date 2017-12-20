package Main;

import Board.*;

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


    }
}
