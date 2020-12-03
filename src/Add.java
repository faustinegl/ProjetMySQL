import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add extends JPanel implements ActionListener {

    JCheckBox astudent = new JCheckBox("ELEVE");
    JCheckBox acourse = new JCheckBox("COURS");
    JCheckBox apromotion = new JCheckBox("PROMOTION");
    JCheckBox aroom = new JCheckBox("SALLE");
    JCheckBox asession = new JCheckBox("SESSION");
    JCheckBox asite = new JCheckBox("SITE");
    JCheckBox ateacher= new JCheckBox("PROFESSEUR");

    Add(){
        this.setSize(1250,900);
        this.setLayout(null);

        Font police = new Font("Arial",Font.BOLD,10);
        JLabel message = new JLabel("Ajout :");

        JLabel labelFond = new JLabel(new ImageIcon("PHOTOS/homepage.png"));
        labelFond.setBounds(0,0,1250,900);
        labelFond.setSize(1460,677);

        message.setFont(police);
        astudent.setFont(police);
        acourse.setFont(police);
        apromotion.setFont(police);
        aroom.setFont(police);
        asession.setFont(police);
        asite.setFont(police);
        ateacher.setFont(police);


        message.setBounds(50,100,100,20);
        astudent.setBounds(100,100,100,20);
        acourse.setBounds(100,150,100,20);
        apromotion.setBounds(100,200,100,20);
        aroom.setBounds(100,250,100,20);
        asession.setBounds(100,300,100,20);
        asite.setBounds(100,350,100,20);
        ateacher.setBounds(100,400,100,20);


        this.add(message);
        this.add(astudent);
        this.add(acourse);
        this.add(apromotion);
        this.add(aroom);
        this.add(asession);
        this.add(asite);
        this.add(ateacher);
        this.add(labelFond);
    }

    @Override
    public void actionPerformed(ActionEvent e) {



    }
}
