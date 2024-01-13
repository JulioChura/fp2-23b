import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.GridLayout;

public class Opciones extends JFrame {
    private static final int ANCHO = 400;
    private static final int LARGO = 300;


    private JFrame norte;
    private JButton regresar;
    private JButton iniciar;

    private JComboBox oponente1;
    private JComboBox oponente2;

    private JCheckBox arena;

    private static JLabel titulo;
    private static JLabel instrucciones;

    public Opciones() {
        setSize(ANCHO, LARGO);
        setTitle("Opciones para jugar");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        norte = new JFrame();
        norte.setLayout(new GridLayout(2,0));
    }

}
