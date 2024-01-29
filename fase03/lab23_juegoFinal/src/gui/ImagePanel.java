package gui;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {

    public ImagePanel(String field) {
        ImageIcon imageIcon = new ImageIcon("img/campos/" + field.toLowerCase() + ".jpg");
        System.out.println("Arena: "+ imageIcon.getDescription());
        // Obtener la imagen del ImageIcon
        Image imagenOriginal = imageIcon.getImage();

        // Redimensiona la imagen
        Image imagenRedimensionada = imagenOriginal.getScaledInstance(700, 400, Image.SCALE_SMOOTH);

        // Crea un nuevo ImageIcon con la imagen redimensionada
        ImageIcon iconRedimensionado = new ImageIcon(imagenRedimensionada);

        // Crea el JLabel con el nuevo ImageIcon
        JLabel label = new JLabel(iconRedimensionado);
        setLayout(new GridLayout(1, 0));
        // Agrega el JLabel al panel
        add(label);
    }
}
