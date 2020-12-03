import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResearchRoom extends JPanel implements ActionListener {

    JTextField room = new JTextField();
    JTextField week3 = new JTextField();
    JButton researchValidate3 = new JButton("Valider");


    ResearchRoom()
    {

        this.setSize(1500, 1000);
        this.setLayout(null);
        Font police = new Font("Arial",Font.BOLD,12);



        JLabel title = new JLabel("Veuillez renseignez les termes ci dessous pour afficher l'emploi du temps");
        JLabel roomTitle = new JLabel("SALLE");
        JLabel weektitle = new JLabel("SEMAINE");

        JLabel labelFond = new JLabel(new ImageIcon("PHOTOS/homepage.png"));
        labelFond.setBounds(0,0,1250,900);
        labelFond.setSize(1460,677);

        room.setFont(police);
        week3.setFont(police);
        title.setFont(police);
        roomTitle.setFont(police);
        weektitle.setFont(police);
        researchValidate3.setFont(police);

        title.setBounds(40,100,600,20);
        room.setBounds(250,120,200,20);
        roomTitle.setBounds(80,120,100,20);
        week3.setBounds(250,140,200,20);
        weektitle.setBounds(80,140,100,20);
        researchValidate3.setBounds(60,160,100,20);

        this.add(title);
        this.add(room);
        this.add(roomTitle);
        this.add(week3);
        this.add(weektitle);
        this.add(researchValidate3);
        //this.add(labelFond);


    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
