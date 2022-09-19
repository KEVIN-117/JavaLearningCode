package N_20_UsersData.WindowComponets;

import java.awt.*;
import java.awt.event.ActionListener;

public class JButton extends javax.swing.JButton {
    public JButton(String text, ActionListener listener, Point point, Dimension dimension) {
        super(text);
        this.addActionListener(listener);
    }
}
