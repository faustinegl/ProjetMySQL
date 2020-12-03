import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuAdmin extends JPanel implements ActionListener {

    JButton buttonAdd= new JButton("Ajout");
    JButton buttonDelete= new JButton("Suppression");
    JButton buttonModify= new JButton("Modification");
    JButton students= new JButton("Etudiants");
    JButton promotions= new JButton("Promotion");
    JButton teachers= new JButton("Professeurs");
    JButton rooms= new JButton("Salles");
    JButton graphique = new JButton("CapaciteSalle");
    JButton graphique2 = new JButton("StatistiquesCours ");


    JButton deconnexion = new JButton("DECONNEXION");


    public MenuAdmin() {
        this.setSize(1500, 1000);
        this.setLayout(null);


        Font police = new Font("Arial", Font.BOLD, 12);

        JLabel labelFond = new JLabel(new ImageIcon("PHOTOS/homepage.png"));
        labelFond.setBounds(0, 0, 1250, 900);
        labelFond.setSize(1460, 677);


        students.setBounds(0, 10, 120, 30);
        teachers.setBounds(120, 10, 120, 30);
        promotions.setBounds(240, 10, 120, 30);
        rooms.setBounds(360, 10, 120, 30);
        buttonAdd.setBounds(480, 10, 120, 30);
        buttonDelete.setBounds(600, 10, 120, 30);
        buttonModify.setBounds(720, 10, 120, 30);
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

        deconnexion.setFont(police);
        deconnexion.setBounds(900, 100, 200, 20);


        this.add(buttonDelete);
        this.add(buttonModify);
        this.add(students);
        this.add(promotions);
        this.add(teachers);
        this.add(rooms);
        this.add(buttonAdd);
        this.add(deconnexion);
        this.add(graphique);
        this.add(graphique2);
        this.setBackground(Color.white);
        this.add(labelFond);


    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}


