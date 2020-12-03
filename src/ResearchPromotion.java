import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResearchPromotion extends JPanel implements ActionListener {

    JTextField promotion = new JTextField();
    JTextField week2 = new JTextField();
    JButton researchValidate2 = new JButton("Valider");


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

        title.setBounds(40,100,600,20);
        promotion.setBounds(250,120,200,20);
        promotionTitle.setBounds(80,120,100,20);
        week2.setBounds(250,140,200,20);
        weektitle.setBounds(80,140,100,20);
        researchValidate2.setBounds(60,160,100,20);

        this.add(title);
        this.add(promotion);
        this.add(promotionTitle);
        this.add(week2);
        this.add(weektitle);
        this.add(researchValidate2);
        //this.add(labelFond);


    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
