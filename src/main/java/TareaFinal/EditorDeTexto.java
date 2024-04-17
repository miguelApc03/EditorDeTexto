package TareaFinal;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditorDeTexto extends JFrame {
    private JTextPane textPane1; //Panel de texto
    private JButton button1; //Negrita
    private JButton button2; //Coloe
    private JButton button3; // Cursiva

    private JPanel panel1;
    private JComboBox<String> tipografia; //Tipografia
    private JComboBox<Integer> tamaño; //Tamaño

    public EditorDeTexto() {
        setTitle("Editor de Texto"); // Con esto creamos el nombre de la pestaña
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Cerrar la pestaña
        setSize(600, 400); // Tamaño de la pestaña

        // Inicializamos el panel de texto
        textPane1 = new JTextPane();
        JScrollPane scrollPane = new JScrollPane(textPane1); // Añadimos un JScrollPane al panel de texto
        add(scrollPane, BorderLayout.CENTER); // Añadimos el panel de texto al centro

        // Inicializamos los botones y selectores de nuestro editor
        button1 = new JButton("Negrita"); // Botón para cambiar la letra a negrita
        button1.addActionListener(new BoldButtonListener()); // Agregamos un ActionListener al botón para darle funcionalidad mas tarde

        button2 = new JButton("Color"); // Botón para cambiar el color del texto
        button2.addActionListener(new ColorButtonListener());

        button3 = new JButton("Cursiva"); // Botón para cambiar a cursiva
        button3.addActionListener(new ItalicButtonListener());

        // Añadimos un menu desplegable para seleccionar la tipografía
        tipografia = new JComboBox<>(new String[]{"Arial", "Times New Roman", "Courier New"});
        tipografia.addActionListener(new FontFamilyListener());

        // Añadimos otro menu desplegable para seleccionar el tamaño de la fuente
        tamaño = new JComboBox<>(new Integer[]{8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 1000});
        tamaño.addActionListener(new FontSizeListener());


        // Añadimos al panel los botones y selectores
        JPanel panelBoton = new JPanel();
        panelBoton.add(button1);
        panelBoton.add(button2);
        panelBoton.add(button3);
        panelBoton.add(tipografia);
        panelBoton.add(tamaño);
        add(panelBoton, BorderLayout.NORTH); // Colocamos el panel de botones y selectores en la parte superior de la ventana
    }


    // ActionListener para el botón de Negrita
    private class BoldButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            StyledDocument doc = textPane1.getStyledDocument(); // Obtiene el documento del JTextPane
            int start = textPane1.getSelectionStart();
            int end = textPane1.getSelectionEnd();
            AttributeSet attribs = doc.getCharacterElement(start).getAttributes(); // Obtiene los atributos

            MutableAttributeSet attrs = new SimpleAttributeSet(attribs); // Crea un AttributeSet mutable
            StyleConstants.setBold(attrs, !StyleConstants.isBold(attribs)); // Hace que la letra  sea en negrita
            doc.setCharacterAttributes(start, end - start, attrs, false); // Establece los atributos en el texto seleccionado
        }
    }

    // ActionListener para el botón de Color
    private class ColorButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Color selectedColor = JColorChooser.showDialog(null, "Seleccione un color", Color.BLACK); // Abre un JColorChooser para seleccionar un color
            if (selectedColor != null) {
                textPane1.setForeground(selectedColor); // Establece el color del texto que hayamos elegido
            }
        }
    }


    // ActionListener para el botón de Cursiva
    private class ItalicButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            StyledDocument doc = textPane1.getStyledDocument();
            int start = textPane1.getSelectionStart();
            int end = textPane1.getSelectionEnd();
            AttributeSet attribs = doc.getCharacterElement(start).getAttributes();

            MutableAttributeSet attrs = new SimpleAttributeSet(attribs);
            StyleConstants.setItalic(attrs, !StyleConstants.isItalic(attribs)); // Hace que la letra sea cursiva
            doc.setCharacterAttributes(start, end - start, attrs, false);
        }
    }

    // ActionListener para el menú desplegable de Tipografía
    private class FontFamilyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String fontFamily = (String) tipografia.getSelectedItem(); // Obtiene la tipografía seleccionada
            StyledDocument doc = textPane1.getStyledDocument();
            int start = textPane1.getSelectionStart();
            int end = textPane1.getSelectionEnd();
            AttributeSet attrs = doc.getCharacterElement(start).getAttributes();
            MutableAttributeSet setAttrs = new SimpleAttributeSet(attrs);
            StyleConstants.setFontFamily(setAttrs, fontFamily); // Establece la tipografía que hayamos seleccionado
            doc.setCharacterAttributes(start, end - start, setAttrs, false);
        }
    }

    // ActionListener para el menú desplegable de Tamaño de fuente
    private class FontSizeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int fontSize = (Integer) tamaño.getSelectedItem();
            StyledDocument doc = textPane1.getStyledDocument();
        }

        public static void main(String[] args) {
            JPasswordField contraseña = new JPasswordField();

            EditorDeTexto editor = new EditorDeTexto();
            editor.setVisible(true);
            int clave = JOptionPane.showConfirmDialog(null, contraseña, "contraseña", JOptionPane.OK_CANCEL_OPTION);

            if (clave == JOptionPane.OK_OPTION && new String(contraseña.getPassword()).equals("1234")) {
                editor.getContentPane().setBackground(Color.black);
                editor.setBounds(820, 200, 350, 300);
                editor.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
                SwingUtilities.invokeLater(() -> {
                });
            }
        }
    }
}