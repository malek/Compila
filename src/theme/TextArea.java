package theme;

import javax.swing.*;
import java.awt.*;

public class TextArea extends JTextArea
{
    public TextArea(int x, int y, Color backGround, Color foreGround)
    {
        Dimension defaultDim;
        defaultDim = new Dimension(x, y);
        this.setBackground(backGround);
        this.setForeground(foreGround);
        Font defaultFont = new Font("Consolas", Font.BOLD, 20);
        this.setFont(defaultFont);
        this.setLineWrap(true);
        this.setWrapStyleWord(true);
        this.setPreferredSize(defaultDim);
        this.setBorder(null);
    }
}
