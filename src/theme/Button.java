package theme;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {

    public Button(int width, int height, Color foreGround, Color backGround, String name, ImageIcon icon)
    {

        //this.setBorderPainted(false);
      //  this.setContentAreaFilled(true);

        this.setFont(new Font("Californian FB", Font.BOLD, 25));
        this.setText(name);
        this.setHorizontalTextPosition(SwingConstants.LEADING);
        this.setIcon(icon);
        this.setBackground(backGround);
        this.setForeground(foreGround);
        this.setSize(width, height);
    }
}
