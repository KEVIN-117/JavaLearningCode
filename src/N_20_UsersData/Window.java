package N_20_UsersData;

import N_20_UsersData.WindowComponets.JButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    private JButton button;
    private Integer number;
    public Window(Point point, Dimension dimension) {
        this.setLayout(null);
        this.setLocation(point);
        this.setSize(dimension);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        loadComponents();
    }

    private void loadComponents() {
        this.number = 0;
        this.button = new JButton("Click me", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(number++);
            }
        }, new Point(50,50), new Dimension(100,50));
        this.add(this.button);
    }

}
