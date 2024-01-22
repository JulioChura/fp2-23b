import javax.swing.JPanel;
import javax.swing.JTextArea;

public class InformationFrame extends JPanel {

    private JTextArea area;
    private Army army;
    
    public InformationFrame(Army army1, Army army2)  {
        this.arm1 = army1;
        this.army2 = army2;
        setTitle("Informacion del combate");
       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());


        area1 = new JTextArea();
        area1.setEditable(false);
        area2 = new JTextArea();
        area2.setEditable(false);

        area1.append(arm1.showArmy());
        area2.append(army2.showArmy());
        add(area1);
        add(area2);

        setVisible(true);
    }
}
