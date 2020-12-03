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

    JButton buttonAdd= new JButton("Ajout");
    JButton buttonDelete= new JButton("Suppression");
    JButton buttonModify= new JButton("Cours");
    JButton students= new JButton("Etudiants");
    JButton promotions= new JButton("Promotion");
    JButton teachers= new JButton("Professeurs");
    JButton rooms= new JButton("Salles");
    JButton graphique = new JButton("CapaciteSalle");
    JButton graphique2 = new JButton("StatistiquesCours ");

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

        students.setBounds(0,10,120,30);
        teachers.setBounds(120,10,120,30);
        promotions.setBounds(240,10,120,30);
        rooms.setBounds(360,10,120,30);
        buttonAdd.setBounds(480,10,120,30);
        buttonDelete.setBounds(600,10,120,30);
        buttonModify.setBounds(720,10,120,30);
        graphique.setBounds(840, 10, 120, 30);
        graphique2.setBounds(960,10,120,30);

        buttonDelete.setFont(police);
        buttonModify.setFont(police);
        students.setFont(police);
        promotions.setFont(police);
        teachers.setFont(police);
        rooms.setFont(police);
        buttonAdd.setFont(police);
        graphique.setFont(police);
        graphique2.setFont(police);


        //this.add(timeTableRoom.getTimePane());
        //this.add(titre);
        this.add(buttonDelete);
        this.add(buttonModify);
        this.add(students);
        this.add(promotions);
        this.add(teachers);
        this.add(rooms);
        this.add(buttonAdd);
        this.add(graphique);
        this.add(graphique2);
        this.setBackground(Color.white);
        this.add(labelFond);




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
