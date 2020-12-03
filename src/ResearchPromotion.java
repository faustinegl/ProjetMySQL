import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResearchPromotion extends JPanel implements ActionListener {

    // Initialisation des attributs

    JTextField promotion = new JTextField();
    JTextField week2 = new JTextField();
    JButton researchValidate2 = new JButton("Valider");

    JButton buttonAdd= new JButton("Ajout");
    JButton buttonDelete= new JButton("Suppression");
    JButton buttonModify= new JButton("Cours");
    JButton students= new JButton("Etudiants");
    JButton promotions= new JButton("Promotion");
    JButton teachers= new JButton("Professeurs");
    JButton rooms= new JButton("Salles");
    JButton graphique = new JButton("CapaciteSalle");
    JButton graphique2 = new JButton("StatistiquesCours ");


    ResearchPromotion()
    {

        this.setSize(1500, 1000);
        this.setLayout(null);
        Font police = new Font("Arial",Font.BOLD,12);



        JLabel title = new JLabel("Veuillez renseignez les termes ci dessous pour afficher l'emploi du temps");
        JLabel promotionTitle = new JLabel("PROMOTION");
        JLabel weektitle = new JLabel("SEMAINE");

        JLabel labelFond = new JLabel(new ImageIcon("PHOTOS/homepage.png"));
        labelFond.setBounds(0,0,1250,900);
        labelFond.setSize(1460,677);

        promotion.setFont(police);
        week2.setFont(police);
        title.setFont(police);
        promotionTitle.setFont(police);
        weektitle.setFont(police);
        researchValidate2.setFont(police);

        title.setBounds(130,70,600,20);
        promotion.setBounds(290,120,200,20);
        promotionTitle.setBounds(190,120,100,20);
        week2.setBounds(290,140,200,20);
        weektitle.setBounds(190,140,100,20);
        researchValidate2.setBounds(345,200,100,20);

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


        this.add(title);
        this.add(promotion);
        this.add(promotionTitle);
        this.add(week2);
        this.add(weektitle);
        this.add(researchValidate2);
//        this.add(labelFond);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
