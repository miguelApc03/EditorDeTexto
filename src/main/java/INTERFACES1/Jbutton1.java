package INTERFACES1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class jbutton1 extends JFrame implements ActionListener{
    private JButton button1,button2,button3;

    public jbutton1() {
        setLayout(null);
        button1 = new JButton("no");
        button1.setBounds(100, 100, 90, 30);
        add(button1);
        button1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        System.out.println(e);
    }

    public static void main(String[] args) {
        jbutton1 ejemplo = new jbutton1();
        ejemplo.setBounds(100, 100, 350, 30);
        ejemplo.setVisible(true);
    }
}