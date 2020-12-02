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



    public AddCourse() {

        this.setSize(1250, 900);
        this.setLayout(null);


        Font police = new Font("Arial", Font.BOLD, 10);

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


        this.add(question);
        this.add(idtitle);
        this.add(nametitle);


        this.add(id3);
        this.add(name3);
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

            Course course = new Course();
            DAO<Course> courseDAO = new CourseDAO(connect);

            course.setId(Integer.parseInt(id3.getText()));
            course.setName(name3.getText());

            courseDAO.create(course);

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

