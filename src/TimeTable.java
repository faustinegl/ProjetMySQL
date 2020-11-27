import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimeTable extends JPanel implements ActionListener {

    JScrollPane timePane;

    // Constructor
    TimeTable()
    {

        String[][]  lines= {
                { "Cours 1", "", "Cours 2" ,"","","","","","","","","",""},
                { "Cours 1", "Cours 2", "","","","","","","","","","","" }
        };

        // Column Names
        String[] columns = { "8h", "9h", "10h","11h","12h","13h","14h","15h","16h","17h","18h","19h","20h" };

         JTable timeTable = new JTable(lines, columns);


        JScrollPane sp = new JScrollPane(timeTable);
        sp.setBounds(30, 300, 200, 300);
       this.timePane= sp;

    }

    public JScrollPane getTimePane ()
    {
        return timePane ;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
