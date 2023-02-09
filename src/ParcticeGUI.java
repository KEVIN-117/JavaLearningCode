import N_20_UsersData.Window;

import javax.swing.*;
import java.awt.*;

public class ParcticeGUI{
    public static void main(String[] args) {
        window window = new window(new Point(0,0), new Dimension(350,240));
        window.repaint();
        window.revalidate();
    }
}
class window extends JFrame{
    private JButton button;
    private JLabel lbelA, labelB, labelT, labelR;
    private JTextField JTA, JTB, JTR;
    private JPanel panel;
    public window(Point point, Dimension dimension){
        this.setSize(dimension);
        this.setLocation(point);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.panel =  new JPanel();
        this.panel.setLayout(null);

        this.add(this.panel);
        this.revalidate();
        this.repaint();
        loadComponet();
    }
    private void loadComponet(){

        this.labelT = new JLabel("the adition of two numbers".toUpperCase());
        this.lbelA = new JLabel("Number A");
        this.JTA =  new JTextField();
        this.labelB = new JLabel("Number B");

        this.JTB = new JTextField();
        this.labelR = new JLabel("result".toUpperCase());


        this.JTR =  new JTextField();
        this.revalidate();
        this.repaint();
        this.button = new JButton("suma".toUpperCase());
        this.button.addActionListener((key) ->{
            int A = Integer.parseInt(this.JTA.getText());
            int B = Integer.parseInt(this.JTB.getText());
            this.JTR.setText(String.valueOf(A+B));
        });
        this.panel.setSize(350,240);
        this.panel.setBackground(Color.BLACK);

        this.lbelA.setBounds(20, 60, 100, 30);
        this.JTA.setBounds(100, 58, 100,30);
        this.labelB.setBounds(20,100, 100, 30);
        this.JTB.setBounds(100,98, 100,30);
        this.labelT.setBounds(20, 10, 200,30);
        this.labelR.setBounds(20,140, 100,30);
        this.JTR.setBounds(100, 138, 100,30);
        this.button.setBounds(200, 138, 100,30);



        this.panel.add(this.labelT);
        this.panel.add(this.lbelA);
        this.panel.add(this.labelB);
        this.panel.add(this.labelR);
        this.panel.add(this.JTA);
        this.panel.add(this.JTB);
        this.panel.add(this.JTR);
        this.panel.add(this.button);

    }
}
