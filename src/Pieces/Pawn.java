package Pieces;

import java.awt.image.BufferedImage;

import Main.Board;

public class Pawn extends Piece {
    public Pawn(Board board, int col, int row, boolean isWhite) {
        super(board);
        this.col = col;
        this.row = row;
        this.xpos = col * board.tileSize;
        this.ypos = row * board.tileSize;

        this.isWhite = isWhite;
        this.name = "Pawn";

        this.sprite = sheet.getSubimage(5 * sheetScale, isWhite ? 0 : sheetScale, sheetScale, sheetScale)
                .getScaledInstance(board.tileSize, board.tileSize, BufferedImage.SCALE_SMOOTH);
    }

    public boolean isValidMovement(int col, int row) {

        int colorIndex = isWhite ? 1 : -1;

        if (this.col == col && row == this.row - colorIndex && board.getPiece(col, row) == null) {
            return true;
        }

        if (isFirstMove && this.col == col && row == this.row - colorIndex * 2 && board.getPiece(col, row) == null
                && board.getPiece(col, row + colorIndex) == null) {
            return true;
        }

        if (col == this.col - 1 && row == this.row - colorIndex && board.getPiece(col, row) != null) {
            return true;
        }

        if (col == this.col + 1 && row == this.row - colorIndex && board.getPiece(col, row) != null) {
            return true;
        }

        return false;

    }
}
