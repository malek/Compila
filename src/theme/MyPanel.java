package theme;

import javax.swing.JPanel;
import java.awt.*;

public class MyPanel extends JPanel{

    MyPanel(){ this.setBackground(new Color(45, 52, 54)); }

    public MyPanel(Color color)
    {
        this.setBackground(color);
    }
    public MyPanel(int x, int y, Color color)
    {
        this.setBackground(color);
        this.setPreferredSize(new Dimension(x, y));
    }

}
