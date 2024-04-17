package INTERFACES1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Jbutton1 extends JFrame implements ActionListener {
    //Creamos las variables, en este caso botones
    private JButton button1, button2, button3, button4;
//Ahora le damos valor a nuestras variables creando un constructor
    public Jbutton1() {
        setLayout(null);
        button1 = new JButton("Azul"); //Instanciamos la variable
        button1.setBounds(10, 10, 90, 30); //Le damos las priopedadesdç de tamaño,etc...
        add(button1);
        button1.addActionListener(this);

        button2 = new JButton("Rojo");
        button2.setBounds(100, 10, 90, 30);
        add(button2);
        button2.addActionListener(this);

        button3 = new JButton("Rosa");
        button3.setBounds(180, 10, 90, 30);
        add(button3);
        button3.addActionListener(this);

        button4 = new JButton("Salir");
        button4.setBounds(100, 80, 90, 30);
        add(button4);
        button4.addActionListener(this);
    }
//Usamos este codigo para que el boton sea accionable
    public void actionPerformed(ActionEvent e) {
        //Le damos acciones a los botones
        if (e.getSource() == button1) {
            getContentPane().setBackground(Color.blue);
            setTitle("Has seleccionado el color Azul");
        }
        if (e.getSource() == button2) {
            getContentPane().setBackground(Color.red);
            setTitle("Has seleccionado el color Rojo");
        }
        if (e.getSource() == button3) {
            getContentPane().setBackground(Color.pink);
            setTitle("Has seleccionado el color Rosa");
        }
        if (e.getSource() == button4) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        JPasswordField contraseña = new JPasswordField();
        int clave = JOptionPane.showConfirmDialog(null, contraseña, "contraseña", JOptionPane.OK_CANCEL_OPTION);

        //con esta funcion verificamos que la contraseña sea correcta o incorrecta
        //si es correcta el programa se ejecuta y si es incorrecta se cierra
        if (clave == JOptionPane.OK_OPTION && new String(contraseña.getPassword()).equals("1234")) {
            Jbutton1 ejemplo = new Jbutton1();
            ejemplo.setTitle("Selecciona un color de fondo");
            ejemplo.getContentPane().setBackground(Color.black);
            ejemplo.setBounds(820, 200, 350, 300);
            ejemplo.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
}
