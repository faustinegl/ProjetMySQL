import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Menu extends JPanel implements ActionListener {



    TimeTableStudent timeTableStudent = new TimeTableStudent();
    //TimeTableTeacher timeTableTeacher = new TimeTableTeacher();
    ConnectDAO connectDAO = new ConnectDAO();
    JScrollPane timePane;

    JButton deconnexion = new JButton("DECONNEXION");

    JTextField weekChoice= new JTextField();
    JButton choiceValidated = new JButton("Valider");



    public Menu()
    {
        this.setSize(1500, 1000);
        this.setLayout(null);

        Font police = new Font("Arial",Font.BOLD,12);
        Font policeTitre = new Font("Arial",Font.BOLD,15);
        Font policeChiffre = new Font("Arial",Font.BOLD,10);

        JLabel title=new JLabel("Emploi du temps :");
        title.setFont(policeTitre);
        title.setBounds(10,10,150,30);

        JLabel message =new JLabel("Inscrivez la semaine pour laquelle vous souhaitez voir votre emploi du temps");
        JLabel week = new JLabel ("WEEK :");

        weekChoice.setFont(police);
        choiceValidated.setFont(police);
        message.setFont(police);
        week.setFont(police);

        deconnexion.setFont(police);

        message.setBounds((350),50,700,20);
        week.setBounds(400,100,50,20);
        weekChoice.setBounds(450,100,100,20);
        choiceValidated.setBounds(600,100,100,20);

        deconnexion.setBounds(900,20,200,20);

        this.add(title);
        this.add(week);
        this.add(weekChoice);
        this.add(message);
        this.add(choiceValidated);
        this.add(deconnexion);
        this.setBackground(Color.white);




    }




    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

