package Main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Pieces.Piece;

public class Input extends MouseAdapter {

    Board board;

    public Input(Board board) {
        this.board = board;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int col = e.getX() / board.tileSize;
        int row = e.getY() / board.tileSize;

        Piece pieceXY = board.getPiece(col, row);
        if (pieceXY != null) {
            board.selsectedPiece = pieceXY;
        }
        throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (board.selsectedPiece != null) {
            board.selsectedPiece.xpos = e.getX() - board.tileSize / 2;
            board.selsectedPiece.ypos = e.getY() - board.tileSize / 2;

            board.repaint();
        }
        throw new UnsupportedOperationException("Unimplemented method 'mouseDragged'");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int col = e.getX() / board.tileSize;
        int row = e.getY() / board.tileSize;

        if (board.selsectedPiece != null) {
            Move move = new Move(board, board.selsectedPiece, col, row);

            if (board.isValidMove(move)) {
                board.makeMove(move);
            } else {
                board.selsectedPiece.xpos = board.selsectedPiece.col * board.tileSize;
                board.selsectedPiece.ypos = board.selsectedPiece.row * board.tileSize;
            }
        }

        board.selsectedPiece = null;
        board.repaint();

        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }
}
