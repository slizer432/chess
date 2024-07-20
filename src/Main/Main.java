package Main;

import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.plaf.DimensionUIResource;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new GridBagLayout());
        frame.setMinimumSize(new DimensionUIResource(1000, 1000));
        frame.setLocationRelativeTo(null);

        Board board = new Board();
        frame.add(board);

        frame.setVisible(true);
    }
}
