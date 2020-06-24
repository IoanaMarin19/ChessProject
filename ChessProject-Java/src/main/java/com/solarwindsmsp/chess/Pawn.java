package com.solarwindsmsp.chess;

public class Pawn {

    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private PieceColor pieceColor;

    public Pawn(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public ChessBoard getChesssBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int value) {
        this.xCoordinate = value;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int value) {
        this.yCoordinate = value;
    }

    public PieceColor getPieceColor() {
        return this.pieceColor;
    }

    public void setPieceColor(PieceColor value) {
        pieceColor = value;
    }

    public void Move(MovementType movementType, int newX, int newY) {
        if (isBlackPawnMove(movementType, newX, newY) || isWhitePawnMove(movementType, newX, newY)) {
            setYCoordinate(newY);
        }
    }

    private boolean isWhitePawnMove(MovementType movementType, int newX, int newY) {
        return MovementType.MOVE.equals(movementType) && PieceColor.WHITE.equals(getPieceColor()) && ((getYCoordinate() + 1) == newY)
                && (getXCoordinate() == newX);
    }


    private boolean isBlackPawnMove(MovementType movementType, int newX, int newY) {
        return MovementType.MOVE.equals(movementType) && PieceColor.BLACK.equals(getPieceColor())
                && ((getYCoordinate() - 1) == newY) && (getXCoordinate() == newX);
    }


    @Override
    public String toString() {
        return CurrentPositionAsString();
    }

    protected String CurrentPositionAsString() {
        String eol = System.lineSeparator();
        return String.format("Current X: {1}{0}Current Y: {2}{0}Piece Color: {3}", eol, xCoordinate, yCoordinate, pieceColor);
    }
}
