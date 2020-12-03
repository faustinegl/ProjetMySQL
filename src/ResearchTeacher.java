import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResearchTeacher extends JPanel implements ActionListener {

    JTextField teacher = new JTextField();
    JTextField week = new JTextField();
    JButton researchValidate = new JButton("Valider");

    JButton buttonAdd= new JButton("Ajout");
    JButton buttonDelete= new JButton("Suppression");
    JButton buttonModify= new JButton("Modifier");
    JButton students= new JButton("Etudiants");
    JButton promotions= new JButton("Promotion");
    JButton teachers= new JButton("Professeurs");
    JButton rooms= new JButton("Salles");
    JButton graphique = new JButton("CapaciteSalle");
    JButton graphique2 = new JButton("StatistiquesCours ");


    ResearchTeacher()
    {

        this.setSize(1500, 1000);
        this.setLayout(null);
        Font police = new Font("Arial",Font.BOLD,12);



        JLabel title = new JLabel("Veuillez renseignez les termes ci dessous pour afficher l'emploi du temps");
        JLabel teachertitle = new JLabel("PROFESSEUR");
        JLabel weektitle = new JLabel("SEMAINE");

        JLabel labelFond = new JLabel(new ImageIcon("PHOTOS/homepage.png"));
        labelFond.setBounds(0,0,1250,900);
        labelFond.setSize(1460,677);

        teacher.setFont(police);
        week.setFont(police);
        title.setFont(police);
        teachertitle.setFont(police);
        weektitle.setFont(police);
        researchValidate.setFont(police);

        title.setBounds(130,70,600,20);
        teacher.setBounds(290,120,200,20);
        teachertitle.setBounds(190,120,100,20);
        week.setBounds(290,140,200,20);
        weektitle.setBounds(190,140,100,20);
        researchValidate.setBounds(345,200,100,20);

        students.setBounds(0,10,120,30);
        teachers.setBounds(120,10,120,30);
        promotions.setBounds(240,10,120,30);
        rooms.setBounds(360,10,120,30);
        buttonAdd.setBounds(480,10,120,30);
        buttonDelete.setBounds(600,10,120,30);
        buttonModify.setBounds(720,10,120,30);
        graphique.setBounds(840,10,120,30);
        graphique2.setBounds(960,10,120,30);

        buttonDelete.setFont(police);
        buttonModify.setFont(police);
        students.setFont(police);
        promotions.setFont(police);
        teachers.setFont(police);
        rooms.setFont(police);
        buttonAdd.setFont(police);
        graphique2.setFont(police);
        graphique.setFont(police);



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

        this.add(title);
        this.add(teacher);
        this.add(teachertitle);
        this.add(week);
        this.add(weektitle);
        this.add(researchValidate);
       // this.add(labelFond);


    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
