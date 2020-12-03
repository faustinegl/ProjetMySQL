import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddTeacher extends JPanel implements ActionListener {

    ConnectDAO connectDAO = new ConnectDAO();

    JTextField id2 = new JTextField();
    JTextField email2 = new JTextField();
    JTextField password2 = new JTextField();
    JTextField lastName2 = new JTextField();
    JTextField firstName2 = new JTextField();
    JTextField courses = new JTextField();
    JTextField coursesID = new JTextField();


    public AddTeacher()
    {

        this.setSize(1250,900);
        this.setLayout(null);
        connectDAO.createConnection();

        Font police = new Font("Arial", Font.BOLD, 10);

        JLabel labelFond = new JLabel(new ImageIcon("PHOTOS/homepage.png"));
        labelFond.setBounds(0,0,1250,900);
        labelFond.setSize(1460,677);

        JLabel question = new JLabel("Renseignez les informations suivantes");
        JLabel idtitle = new JLabel("ID :");
        JLabel emailtitle = new JLabel("EMAIL :");
        JLabel passwordtitle = new JLabel("PASSWORD :");
        JLabel lastNametitle = new JLabel("NOM :");
        JLabel firstNametitle = new JLabel("PRENOM :");
        JLabel coursetitle = new JLabel("COURS :");
        JLabel courseIDtitle = new JLabel("ID DU COURS :");




        question.setFont(police);
        idtitle.setFont(police);
        emailtitle.setFont(police);
        passwordtitle.setFont(police);
        lastNametitle.setFont(police);
        firstNametitle.setFont(police);
        coursetitle.setFont(police);
        courseIDtitle.setFont(police);


        id2.setFont(police);
        email2.setFont(police);
        password2.setFont(police);
        lastName2.setFont(police);
        firstName2.setFont(police);
        courses.setFont(police);
        coursesID.setFont(police);


        question.setBounds(200, 100, 250, 50);
        idtitle.setBounds(200, 150, 150, 20);
        emailtitle.setBounds(200, 200, 150, 20);
        passwordtitle.setBounds(200, 250, 150, 20);
        lastNametitle.setBounds(200, 300, 150, 20);
        firstNametitle.setBounds(200, 350, 150, 20);
        coursetitle.setBounds(200, 400, 150, 20);
        courseIDtitle.setBounds(200, 450, 150, 20);


        id2.setBounds(400, 150, 150, 20);
        email2.setBounds(400, 200, 150, 20);
        password2.setBounds(400, 250, 150, 20);
        lastName2.setBounds(400, 300, 150, 20);
        firstName2.setBounds(400, 350, 150, 20);
        courses.setBounds(400, 400, 150, 20);
        coursesID.setBounds(400, 450, 150, 20);

        id2.addActionListener(this);
        email2.addActionListener(this);
        password2.addActionListener(this);
        lastName2.addActionListener(this);
        firstName2.addActionListener(this);
        courses.addActionListener(this);
        coursesID.addActionListener(this);


        this.add(question);
        this.add(idtitle);
        this.add(emailtitle);
        this.add(passwordtitle);
        this.add(lastNametitle);
        this.add(firstNametitle);
        this.add(coursetitle);
        this.add(courseIDtitle);

        this.add(id2);
        this.add(email2);
        this.add(password2);
        this.add(lastName2);
        this.add(firstName2);
        this.add(courses);
        this.add(coursesID);
        this.setBackground(Color.white);

        this.add(labelFond);


    }
    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            //Connect to Database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root","");
            Statement query = ((Connection) connect).createStatement();

            User user =new User();
            Teacher teacher=new Teacher();
            Course course = new Course(Integer.parseInt(coursesID.getText()),courses.getText());
            DAO<Teacher> teacherDAO = new TeacherDAO(connect);
            DAO<User> userDao = new UserDAO(connect);
            List<Course> listCourse=new ArrayList<>();

            DAO<Course> courseDAO = new CourseDAO(connect);

            course.setId(Integer.parseInt(coursesID.getText()));
            course.setName(courses.getText());

            courseDAO.update(course);


            teacher.setPermission("TEACHER");
            teacher.setId(Integer.parseInt(id2.getText()));
            teacher.setEmail(email2.getText());
            teacher.setPassword(password2.getText());
            teacher.setLastName(lastName2.getText());
            teacher.setFirstName(firstName2.getText());
            listCourse.add(course);
            teacher.setListCourse(listCourse);

            userDao.update(teacher);
            teacherDAO.update(teacher);

        }

        catch (ClassNotFoundException ex){
            Logger.getLogger(main.class.getName()).log(Level.SEVERE,null,ex);
        }

        catch(SQLException ex){
            Logger.getLogger(main.class.getName()).log(Level.SEVERE,null,ex);
            ex.printStackTrace();
        }

    }
}
