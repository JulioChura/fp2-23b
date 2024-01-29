package gui;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import logica.Army;

public class InformationFrame extends JPanel {

    private JTextArea area;
    private Army army;

    public InformationFrame(Army army) {
        this.army = army;

        area = new JTextArea();
        area.setEditable(false);

        area.append(army.getName() + army.showArmy());
        add(area);

        setVisible(true);

    }
}
