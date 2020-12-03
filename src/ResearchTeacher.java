import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResearchTeacher extends JPanel implements ActionListener {

    JTextField teacher = new JTextField();
    JTextField week = new JTextField();
    JButton researchValidate = new JButton("Valider");


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

        title.setBounds(40,100,600,20);
        teacher.setBounds(250,120,200,20);
        teachertitle.setBounds(80,120,100,20);
        week.setBounds(250,140,200,20);
        weektitle.setBounds(80,140,100,20);
        researchValidate.setBounds(60,160,100,20);

        this.add(title);
        this.add(teacher);
        this.add(teachertitle);
        this.add(week);
        this.add(weektitle);
        this.add(researchValidate);
        //this.add(labelFond);


    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
