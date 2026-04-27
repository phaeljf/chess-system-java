package boardgame;

import boardgame.exceptions.BoadrException;

public class Board {

    private Integer rows;
    private Integer columns;
    private Piece[][] pieces;

    public Board(Integer rows, Integer columns) {
        if (rows < 1 || columns < 1) {
            throw new BoadrException("Error crating Board: there must be at laeast 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        this.pieces = new Piece[rows][columns];
    }

    public Integer getRows() {return rows; }
    public Integer getColumns() {return columns; }

    public Piece piece(Integer row, Integer column) {
        if (!positionExists(row, column)) {
            throw new BoadrException("Position not on the board");
        }
        return pieces[row][column];
    }

    public Piece piece(Position position){
        if (!positionExists(position)) {
            throw new BoadrException("Position not on the board");
        }
        return pieces[position.getRow()][position.getCol()];
    }

    public void placePiece(Piece piece, Position position){
        if(thereIsPiece(position)){
            throw new BoadrException("There is already a piece on the board " + position);
        }
        pieces[position.getRow()][position.getCol()] = piece;
        piece.position = position;
    }

    private boolean positionExists(int row, int col){
        return row >= 0 && row < rows && col >= 0 && col < columns;
    }

    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getCol());
    }

    public boolean thereIsPiece(Position position){
        if (!positionExists(position)) {
            throw new BoadrException("Position not on the board");
        }
        return piece(position) != null;
    }

    public Piece removePiece(Position position){
        if (!positionExists(position)) {
            throw new BoadrException("Position not on the board");
        }
        if (piece(position) == null) {
            return null;
        }
        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getCol()] = null;
        return aux;
    }

}
