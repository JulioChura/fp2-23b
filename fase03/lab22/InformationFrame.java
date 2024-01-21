import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import java.awt.*;

public class InformationFrame extends JFrame {
    private static final  int HEIGHT = 400;
    private static final int WIDTH = 400;

    private JTextArea area;
    private JScrollPane scoll;
    private Army arm1;
    private Army army2;
    private JTextArea area1;
    private JTextArea area2;
    
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
    public static void main(String[] args) {
            Army a = new Army("sd");
            Army b = new Army("sa");
            a.generateArmy(b);
            b.generateArmy(a);

            InformationFrame info = new InformationFrame(a, b);
            String str = a.showArmy();
            System.out.println(str);
      
    }
}
