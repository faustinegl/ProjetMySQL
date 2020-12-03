import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Delete extends JPanel implements ActionListener {

    JCheckBox sstudent = new JCheckBox("ELEVE");
    JCheckBox ssession = new JCheckBox("SESSION");
    JCheckBox steacher = new JCheckBox("PROFESSEUR");

    Delete(){
        this.setSize(1250,900);
        this.setLayout(null);

        Font police = new Font("Arial",Font.BOLD,10);

        JLabel labelFond = new JLabel(new ImageIcon("PHOTOS/homepage.png"));
        labelFond.setBounds(0,0,1250,900);
        labelFond.setSize(1460,677);

        JLabel message = new JLabel("Suppression :");

        message.setFont(police);
        sstudent.setFont(police);
        ssession.setFont(police);
        steacher.setFont(police);


        message.setBounds(50,100,100,20);
        sstudent.setBounds(150,100,100,20);
        ssession.setBounds(150,150,100,20);
        steacher.setBounds(150,200,100,20);


        this.add(message);
        this.add(sstudent);
        this.add(ssession);
        this.add(steacher);

        this.add(labelFond);
    }

    @Override
    public void actionPerformed(ActionEvent e) {



    }
}
