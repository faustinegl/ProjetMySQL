import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResearchStudent extends JPanel implements ActionListener {

    JTextField student = new JTextField();
    JTextField week1 = new JTextField();
    JButton researchValidate1 = new JButton("Valider");


    ResearchStudent()
    {

        this.setSize(1500, 1000);
        this.setLayout(null);
        Font police = new Font("Arial",Font.BOLD,12);



        JLabel title = new JLabel("Veuillez renseignez les termes ci dessous pour afficher l'emploi du temps");
        JLabel studentTitle = new JLabel("ELEVE");
        JLabel weektitle = new JLabel("SEMAINE");

        JLabel labelFond = new JLabel(new ImageIcon("PHOTOS/homepage.png"));
        labelFond.setBounds(0,0,1250,900);
        labelFond.setSize(1460,677);

        student.setFont(police);
        week1.setFont(police);
        title.setFont(police);
        studentTitle.setFont(police);
        weektitle.setFont(police);
        researchValidate1.setFont(police);

        title.setBounds(40,100,600,20);
        student.setBounds(250,120,200,20);
        studentTitle.setBounds(80,120,100,20);
        week1.setBounds(250,140,200,20);
        weektitle.setBounds(80,140,100,20);
        researchValidate1.setBounds(60,160,100,20);

        this.add(title);
        this.add(student);
        this.add(studentTitle);
        this.add(week1);
        this.add(weektitle);
        this.add(researchValidate1);
        //this.add(labelFond);


    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
