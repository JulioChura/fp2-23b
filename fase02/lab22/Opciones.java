import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;

public class Opciones extends JFrame {
    private static final int ANCHO = 400;
    private static final int LARGO = 300;


    private JPanel norte;
    private JButton regresar;
    private JButton iniciar;

    private JComboBox oponente1;

    private JComboBox oponente2;

    private static JLabel instrucciones;

    private static JLabel titulo;
    private JPanel arena;
    private JCheckBox playa;
    private JCheckBox bosque;
    private JCheckBox montaña;
    private JCheckBox campo;
    private JCheckBox desierto;

    public Opciones() {
        setSize(ANCHO, LARGO);
        setTitle("Opciones para jugar");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        norte = new JPanel();
        norte.setLayout(new GridLayout(2,0));
        regresar = new JButton("Regresar");
        iniciar = new JButton("Iniciar");
        norte.setLayout(new GridLayout(1,2));
        norte.add(regresar);
        norte.add(iniciar);
        norte.setVisible(true);

        
        instrucciones = new JLabel("1.- En esta sección se escogen los reinos\n 2.- Ambos jugadores deben seleccionar una arena para poder jugar, la arena definitiva sera seleccionada al azar");

        oponente1 = new JComboBox<>(new String[] {"1: Inglaterra", "2: Moros", "3: Roma", "4: Castilla", "5: Francia" });
        oponente2 = new JComboBox<>(new String[] {"1: Inglaterra", "2: Moros", "3: Roma", "4: Castilla", "5: Francia" });

        
        arena = new JPanel();
        arena.setVisible(true);
        titulo = new JLabel("Elija una arena");
        arena.setLayout(new GridLayout(5,1));
        playa = new JCheckBox("Playa");
        bosque = new JCheckBox("Bosque");
        montaña = new JCheckBox("Montaña");
        campo = new JCheckBox("Campo");
        desierto = new JCheckBox("Desierto");
        arena.add(titulo);
        arena.add(playa);
        arena.add(montaña);
        arena.add(campo);
        arena.add(desierto);

        //Esto agregará los componentes a la ventana de opciones

        add(norte, BorderLayout.NORTH);
        add(oponente1, BorderLayout.WEST);
        add(oponente2, BorderLayout.EAST);
        add(arena, BorderLayout.CENTER);
        add(instrucciones, BorderLayout.SOUTH);
        setVisible(true);
    }
    
    public static void main (String[] args ) {
        Opciones op = new Opciones();
    }
}
