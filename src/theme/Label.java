package theme;

import javax.swing.*;
import java.awt.*;

public class Label extends JLabel{

    public Label()
    {}

    public Label(String FontName,int FontType, int Size, Color foreGround, String text)
    {
        this.setFont(new Font(FontName, FontType, Size));
        this.setForeground(foreGround);
        this.setText(text);
    }

    public Label(Color color, int x ,int y)
    {
        this.setBackground(color);
        this.setPreferredSize(new Dimension(x,y));
    }
}
