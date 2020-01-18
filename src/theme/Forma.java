package theme;

import javax.swing.JFrame;

public class Forma extends JFrame{

    public Forma(int x, int y, String title)
    {

        this.setTitle(title);
        this.setSize(x, y);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}