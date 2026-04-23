package application;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;

public class program {

    static void main() {


        ChessMatch chessMatch = new ChessMatch();
        UI.printBoard(chessMatch.getPieces());


    }


}
