package XO;

import javax.swing.*;
import java.awt.*;

public class Main  {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setSize(600, 600);
        window.setLayout(new BorderLayout());
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        Game game = new Game();
        window.add(game);
    }
}