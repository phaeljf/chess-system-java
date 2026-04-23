package application;

import boardgame.Board;
import boardgame.Position;

public class program {

    static void main() {

        Position pos = new Position(1,5);
        System.out.println(pos.toString());

        Board board = new Board(8,8);

    }


}
