package Pieces;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import Main.Board;

public class Piece {

    public int col, row;
    public int xpos, ypos;

    public boolean isWhite;
    public String name;
    public int value;

    BufferedImage sheet;
    {
        try {
            sheet = ImageIO.read(ClassLoader.getSystemResourceAsStream("res/Pieces.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected int sheetScale = sheet.getWidth() / 6;

    Image sprite;

    Board board;

    public Piece(Board board) {
        this.board = board;
    }

    public boolean isValidMovement(int col, int row) {
        return true;
    }

    public boolean moveCollideWithPiece(int col, int row) {
        return false;
    }

    public void paint(Graphics2D g2d) {

        g2d.drawImage(sprite, xpos, ypos, null);
    }
}
