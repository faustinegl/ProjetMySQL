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

public class AddSession extends JPanel implements ActionListener {

    ConnectDAO connectDAO = new ConnectDAO();


    JTextField id6 = new JTextField();
    JTextField week = new JTextField();
    JTextField date = new JTextField();
    JTextField startTime = new JTextField();
    JTextField endTime = new JTextField();
    JTextField course = new JTextField();
    JTextField state = new JTextField();
    JTextField type = new JTextField();

    JButton buttonAdd = new JButton("Ajout");
    JButton buttonDelete = new JButton("Suppression");
    JButton buttonModify = new JButton("Cours");
    JButton students = new JButton("Etudiants");
    JButton promotions = new JButton("Promotion");
    JButton teachers = new JButton("Professeurs");
    JButton rooms = new JButton("Salles");
    JButton graphique = new JButton("CapaciteSalle");
    JButton graphique2 = new JButton("StatistiquesCours ");


    public AddSession() {

        this.setSize(1250, 900);
        this.setLayout(null);
        connectDAO.createConnection();


        Font police = new Font("Arial", Font.BOLD, 10);

        JLabel labelFond = new JLabel(new ImageIcon("PHOTOS/homepage.png"));
        labelFond.setBounds(0, 0, 1250, 900);
        labelFond.setSize(1460, 677);

        JLabel question = new JLabel("Renseignez les informations suivantes");
        JLabel idtitle = new JLabel("ID :");
        JLabel weektitle = new JLabel("SEMAINE :");
        JLabel datetitle = new JLabel("DATE :");
        JLabel starttimetitle = new JLabel("DEBUT DE SEANCE :");
        JLabel endtimetitle = new JLabel("FIN DE SEANCE :");
        JLabel coursetitle = new JLabel("NOM DU COURS :");
        JLabel statetitle = new JLabel("ETAT :");
        JLabel typetitle = new JLabel("TYPE DU COURS :");


        question.setFont(police);
        idtitle.setFont(police);
        weektitle.setFont(police);
        datetitle.setFont(police);
        starttimetitle.setFont(police);
        endtimetitle.setFont(police);
        coursetitle.setFont(police);
        statetitle.setFont(police);
        typetitle.setFont(police);

        id6.setFont(police);
        week.setFont(police);
        date.setFont(police);
        startTime.setFont(police);
        endTime.setFont(police);
        course.setFont(police);
        state.setFont(police);
        type.setFont(police);

        question.setBounds(200, 100, 250, 50);
        idtitle.setBounds(200, 150, 150, 20);
        weektitle.setBounds(200, 200, 150, 20);
        datetitle.setBounds(200, 250, 150, 20);
        starttimetitle.setBounds(200, 300, 150, 20);
        endtimetitle.setBounds(200, 350, 150, 20);
        coursetitle.setBounds(200, 400, 150, 20);
        statetitle.setBounds(200, 450, 150, 20);
        typetitle.setBounds(200, 500, 150, 20);

        id6.setBounds(400, 150, 150, 20);
        week.setBounds(400, 200, 150, 20);
        date.setBounds(400, 250, 150, 20);
        startTime.setBounds(400, 300, 150, 20);
        endTime.setBounds(400, 350, 150, 20);
        course.setBounds(400, 400, 150, 20);
        state.setBounds(400, 450, 150, 20);
        type.setBounds(400, 500, 150, 20);

        id6.addActionListener(this);
        week.addActionListener(this);
        date.addActionListener(this);
        startTime.addActionListener(this);
        endTime.addActionListener(this);
        course.addActionListener(this);
        state.addActionListener(this);
        type.addActionListener(this);

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
        this.setBackground(Color.white);


        this.add(question);
        this.add(idtitle);
        this.add(weektitle);
        this.add(datetitle);
        this.add(starttimetitle);
        this.add(endtimetitle);
        this.add(coursetitle);
        this.add(statetitle);
        this.add(typetitle);

        this.add(id6);
        this.add(week);
        this.add(date);
        this.add(startTime);
        this.add(endTime);
        this.add(course);
        this.add(state);
        this.add(type);
        this.add(graphique);
        this.add(graphique2);
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

            Session session = new Session();
            Course courseSession = new Course();
            DAO<Session> sessionDAO = new SessionDAO(connect);

            session.setId(Integer.parseInt(id6.getText()));
            session.setWeek(Integer.parseInt(week.getText()));
            session.setDate(Integer.parseInt(date.getText()));
            session.setStartTime(Integer.parseInt(startTime.getText()));
            session.setEndTime(Integer.parseInt(endTime.getText()));
            session.setState(state.getText());

            for (Course course1 : connectDAO.courses) {
                if (course.getText().equals(course1.getName())) {
                    session.setCourse(course1);
                }
            }
            for (Type type1 : connectDAO.types) {
                if (type.getText().equals(type1.getName())) {
                    session.setType(type1);
                }
            }


            sessionDAO.update(session);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }


    }
}
