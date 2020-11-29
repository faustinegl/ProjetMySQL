import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public abstract class TimeTable extends JPanel implements ActionListener {

    JScrollPane timePane;

    TimeTable()
    {

        JTable timeTable = new JTable();


        JScrollPane sp = new JScrollPane(timeTable);
        sp.setBounds(30, 200, 1200, 415);
       this.timePane= sp;

    }


    public abstract JScrollPane getTimePane ();
     public abstract void setValueAt(String value, int row, int col);

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
