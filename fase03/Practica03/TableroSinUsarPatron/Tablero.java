import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tablero extends JFrame {

    public Tablero() {

        Runtime runtime = Runtime.getRuntime();
        long memoriaTotal = runtime.totalMemory();
        long memoriaLibre = runtime.freeMemory();
        setTitle("Tablero 10x10");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new GridLayout(11, 11));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        mainPanel.setBackground(Color.DARK_GRAY);

        setLayout(new GridLayout(1, 1));

        mainPanel.add(new JLabel());
        for (char i = 'A'; i <= 'J'; i++) {
            JLabel label = new JLabel(String.valueOf(i), JLabel.CENTER);
            label.setForeground(Color.WHITE);
            mainPanel.add(label);
        }

        for (int i = 1; i <= 10; i++) {
            JLabel rowLabel = new JLabel(String.valueOf(i), JLabel.CENTER);
            rowLabel.setForeground(Color.WHITE);
            mainPanel.add(rowLabel);

            for (int j = 1; j <= 10; j++) {
                JButton button = new JButton();
                button.addActionListener(new BotonListener());
                button.setBackground(Color.WHITE);
                button.setFocusPainted(false);
                button.setFont(new Font("Arial", Font.BOLD, 14));
                
                button.setBorder(new LineBorder(Color.BLACK));

                button.addMouseListener(new BotonMouseListener(button));

                mainPanel.add(button);
            }
        }

        add(mainPanel);
        setVisible(true);


        long memoriaUtilizada = memoriaTotal - memoriaLibre;

        System.out.println("Memoria Total: " + memoriaTotal + " bytes");
        System.out.println("Memoria Libre: " + memoriaLibre + " bytes");
        System.out.println("Memoria Utilizada: " + memoriaUtilizada + " bytes");
    }

    private class BotonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            System.out.println("Botón clickeado: " + source);
        }
    }

    private class BotonMouseListener extends MouseAdapter {
        private final JButton button;

        public BotonMouseListener(JButton button) {
            this.button = button;
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            button.setBackground(Color.GRAY);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            button.setBackground(Color.WHITE);
        }
    }

    public static void main(String[] args) {
        new Tablero();
    }
}