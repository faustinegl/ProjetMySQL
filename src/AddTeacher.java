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

public class AddTeacher extends JPanel implements ActionListener {

    JTextField id2 = new JTextField();
    JTextField email2 = new JTextField();
    JTextField password2 = new JTextField();
    JTextField lastName2 = new JTextField();
    JTextField firstName2 = new JTextField();
    JTextField courses = new JTextField();


    public AddTeacher()
    {

        this.setSize(1250,900);
        this.setLayout(null);


        Font police = new Font("Arial", Font.BOLD, 10);

        JLabel question = new JLabel("Renseignez les informations suivantes");
        JLabel idtitle = new JLabel("ID :");
        JLabel emailtitle = new JLabel("EMAIL :");
        JLabel passwordtitle = new JLabel("PASSWORD :");
        JLabel lastNametitle = new JLabel("NOM :");
        JLabel firstNametitle = new JLabel("PRENOM :");
        JLabel coursetitle = new JLabel("COURS :");




        question.setFont(police);
        idtitle.setFont(police);
        emailtitle.setFont(police);
        passwordtitle.setFont(police);
        lastNametitle.setFont(police);
        firstNametitle.setFont(police);
        coursetitle.setFont(police);


        id2.setFont(police);
        email2.setFont(police);
        password2.setFont(police);
        lastName2.setFont(police);
        firstName2.setFont(police);
        courses.setFont(police);


        question.setBounds(200, 100, 250, 50);
        idtitle.setBounds(200, 150, 150, 20);
        emailtitle.setBounds(200, 200, 150, 20);
        passwordtitle.setBounds(200, 250, 150, 20);
        lastNametitle.setBounds(200, 300, 150, 20);
        firstNametitle.setBounds(200, 350, 150, 20);
        coursetitle.setBounds(200, 400, 150, 20);


        id2.setBounds(400, 150, 150, 20);
        email2.setBounds(400, 200, 150, 20);
        password2.setBounds(400, 250, 150, 20);
        lastName2.setBounds(400, 300, 150, 20);
        firstName2.setBounds(400, 350, 150, 20);
        courses.setBounds(400, 400, 150, 20);


        id2.addActionListener(this);
        email2.addActionListener(this);
        password2.addActionListener(this);
        lastName2.addActionListener(this);
        firstName2.addActionListener(this);
        courses.addActionListener(this);


        this.add(question);
        this.add(idtitle);
        this.add(emailtitle);
        this.add(passwordtitle);
        this.add(lastNametitle);
        this.add(firstNametitle);
        this.add(coursetitle);

        this.add(id2);
        this.add(email2);
        this.add(password2);
        this.add(lastName2);
        this.add(firstName2);
        this.add(courses);
        this.setBackground(Color.white);


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
            Course course = new Course();
            DAO<Teacher> teacherDAO = new TeacherDAO(connect);
            DAO<User> userDao = new UserDAO(connect);

            teacher.setPermission("TEACHER");
            teacher.setId(Integer.parseInt(id2.getText()));
            teacher.setEmail(email2.getText());
            teacher.setPassword(password2.getText());
            teacher.setLastName(lastName2.getText());
            teacher.setFirstName(firstName2.getText());
            course.setName(courses.getText());

            teacher.getListCourse().add(course);
            userDao.create(teacher);
            teacherDAO.create(teacher);

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
