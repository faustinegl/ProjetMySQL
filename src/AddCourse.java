import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddCourse extends JPanel implements ActionListener {

    ConnectDAO connectDAO = new ConnectDAO();


    JTextField id3 = new JTextField();
    JTextField name3 = new JTextField();

    JButton buttonAdd = new JButton("Ajout");
    JButton buttonDelete = new JButton("Suppression");
    JButton buttonModify = new JButton("Modification");
    JButton students = new JButton("Etudiants");
    JButton promotions = new JButton("Promotion");
    JButton teachers = new JButton("Professeurs");
    JButton rooms = new JButton("Salles");
    JButton graphique = new JButton("CapaciteSalle");
    JButton graphique2 = new JButton("StatistiquesCours ");


    public AddCourse() {

        this.setSize(1250, 900);
        this.setLayout(null);


        Font police = new Font("Arial", Font.BOLD, 10);

        JLabel labelFond = new JLabel(new ImageIcon("PHOTOS/homepage.png"));
        labelFond.setBounds(0, 0, 1250, 900);
        labelFond.setSize(1460, 677);

        JLabel question = new JLabel("Renseignez les informations suivantes");
        JLabel idtitle = new JLabel("ID :");
        JLabel nametitle = new JLabel("NOM DU COURS:");


        question.setFont(police);
        idtitle.setFont(police);
        nametitle.setFont(police);


        id3.setFont(police);
        name3.setFont(police);


        question.setBounds(200, 100, 250, 50);
        idtitle.setBounds(200, 150, 150, 20);
        nametitle.setBounds(200, 200, 150, 20);


        id3.setBounds(400, 150, 150, 20);
        name3.setBounds(400, 200, 150, 20);

        id3.addActionListener(this);
        name3.addActionListener(this);

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


        this.add(question);
        this.add(idtitle);
        this.add(nametitle);


        this.add(id3);
        this.add(name3);
        this.setBackground(Color.white);

        this.add(labelFond);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            //Connect to Database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root", "");
            Statement query = ((Connection) connect).createStatement();

            Course course = new Course();
            DAO<Course> courseDAO = new CourseDAO(connect);

            course.setId(Integer.parseInt(id3.getText()));
            course.setName(name3.getText());

            courseDAO.update(course);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

    }

}

