package com.solarwindsmsp.chess;

public class ChessBoard {

    public static int MAX_BOARD_WIDTH = 7;
    public static int MAX_BOARD_HEIGHT = 7;

    private Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];

    }

    public void Add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        if (IsLegalBoardPosition(xCoordinate, yCoordinate) && isLegalPawnPosition(xCoordinate, yCoordinate, pieceColor)) {
            pawn.setChessBoard(this);
            pawn.setXCoordinate(xCoordinate);
            pawn.setYCoordinate(yCoordinate);
            pawn.setPieceColor(pieceColor);
        }
        else {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
        }
    }
    private boolean isLegalPawnPosition(int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        return (isLegalPositionForBlackPawn(xCoordinate, yCoordinate, pieceColor)
                || isLegalPositionforWhitePawn(xCoordinate, yCoordinate, pieceColor));
    }

    private boolean isLegalPositionforWhitePawn(int xCoordinate,  int yCoordinate, PieceColor pieceColor) {
        return (pieceColor.equals(PieceColor.WHITE)) && (xCoordinate == 1) && ((yCoordinate >= 0) && (yCoordinate < 8));
    }

    private boolean isLegalPositionForBlackPawn(int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        return pieceColor.equals(PieceColor.BLACK) && (xCoordinate == 6) && ((yCoordinate >= 0) && (yCoordinate < 8));
    }
    public boolean IsLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return ((xCoordinate >= 0) && (xCoordinate <= 7) && (yCoordinate >= 0) && (yCoordinate <= 7)) ;
    }
}
