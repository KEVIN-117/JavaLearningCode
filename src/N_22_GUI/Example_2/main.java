package N_22_GUI.Example_2;

import javax.swing.*;
import java.awt.*;

public class main {
    public static void main(String[] args) {
        Frame frame = new Frame(new Point(0,0), new Dimension(400, 400));

    }
}

class Frame extends JFrame{
    private JButton btn;
    private JDialog jDialog;
    private JTextField jTextField;
    public Frame(Point point, Dimension dimension) throws HeadlessException {
        this.setSize(dimension);
        this.setLocation(point);
        this.setLocationRelativeTo(null);
        this.setName("Frame Father");
        this.setVisible(true);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        loadComponets();
    }
    private void loadComponets(){
        this.btn = new JButton();
        this.btn.setSize(100,30);

        this.btn.setText("click");
        this.btn.setName("button");

        this.jDialog = new JDialog();
        this.jDialog.setSize(100, 30);

        this.jTextField = new JTextField();
        this.jTextField.setSize(100, 30);
        this.jTextField.setToolTipText("cursor sobre este componente");
        System.out.println(this.btn.getName());
        System.out.println(btn.getParent());
        Button button = new Button(new Point(100,100), new Dimension(100, 30), "CLICK!");


        this.repaint();
        this.revalidate();
        this.add(this.btn);
        this.add(button);
        this.add(this.jTextField);
        this.btn.addActionListener((item) ->{
            System.out.println(item);
        });
    }

}
class Button extends JButton{
    public Button(Point p, Dimension d, String t){
        super(t);
        this.setSize(d);
        this.setLocation(p);
    }
    public Button(String text) {
        super(text);
    }

    public Button(Action a) {
        super(a);
    }

    public Button(String text, Icon icon) {
        super(text, icon);
    }

    public Button() {
    }

    public Button(Icon icon) {
        super(icon);
    }
}