import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Delete extends JPanel implements ActionListener {

    JCheckBox sstudent = new JCheckBox("ELEVE");
    JCheckBox ssession = new JCheckBox("SESSION");
    JCheckBox steacher = new JCheckBox("PROFESSEUR");

    JButton buttonAdd = new JButton("Ajout");
    JButton buttonDelete = new JButton("Suppression");
    JButton buttonModify = new JButton("Cours");
    JButton students = new JButton("Etudiants");
    JButton promotions = new JButton("Promotion");
    JButton teachers = new JButton("Professeurs");
    JButton rooms = new JButton("Salles");
    JButton graphique = new JButton("CapaciteSalle");
    JButton graphique2 = new JButton("StatistiquesCours ");

    Delete() {
        this.setSize(1250, 900);
        this.setLayout(null);

        Font police = new Font("Arial", Font.BOLD, 10);

        JLabel labelFond = new JLabel(new ImageIcon("PHOTOS/homepage.png"));
        labelFond.setBounds(0, 0, 1250, 900);
        labelFond.setSize(1460, 677);

        JLabel message = new JLabel("Suppression :");

        message.setFont(police);
        sstudent.setFont(police);
        ssession.setFont(police);
        steacher.setFont(police);


        message.setBounds(50, 100, 100, 20);
        sstudent.setBounds(150, 100, 100, 20);
        ssession.setBounds(150, 150, 100, 20);
        steacher.setBounds(150, 200, 100, 20);

        students.setBounds(0, 10, 120, 30);
        teachers.setBounds(120, 10, 120, 30);
        promotions.setBounds(240, 10, 120, 30);
        rooms.setBounds(360, 10, 120, 30);
        buttonAdd.setBounds(480, 10, 120, 30);
        buttonDelete.setBounds(600, 10, 120, 30);
        buttonModify.setBounds(720, 10, 120, 30);
        graphique.setBounds(840, 10, 120, 30);
        graphique2.setBounds(960, 10, 120, 30);

        buttonDelete.setFont(police);
        buttonModify.setFont(police);
        students.setFont(police);
        promotions.setFont(police);
        teachers.setFont(police);
        rooms.setFont(police);
        buttonAdd.setFont(police);
        graphique2.setFont(police);
        graphique.setFont(police);


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
        this.add(labelFond);


        this.add(message);
        this.add(graphique);
        this.add(graphique2);
        this.add(sstudent);
        this.add(ssession);
        this.add(steacher);

        this.add(labelFond);
    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }
}
