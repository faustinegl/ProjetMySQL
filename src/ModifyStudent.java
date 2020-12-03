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

public class ModifyStudent extends JPanel implements ActionListener {

    ConnectDAO connectDAO = new ConnectDAO();

    JTextField prenom1 = new JTextField();
    JTextField prenom2 = new JTextField();

    public ModifyStudent(){
        connectDAO.createConnection();
        this.setSize(1250,900);
        this.setLayout(null);


        Font police = new Font("Arial", Font.BOLD, 10);

        JLabel question = new JLabel("Renseignez le prenom de l'eleve a modifier");
        JLabel prenomTitle = new JLabel("Prenom :");

        JLabel question2 = new JLabel("Renseignez le nouveau prenom de l'eleve a modifier");
        JLabel prenomTitle2 = new JLabel("Prenom :");

        question.setFont(police);
        prenomTitle.setFont(police);
        question2.setFont(police);
        prenomTitle2.setFont(police);

        prenom1.setFont(police);

        question.setBounds(200, 100, 250, 50);
        prenomTitle.setBounds(200, 150, 150, 20);

        question2.setBounds(200, 400, 250, 50);
        prenomTitle2.setBounds(200, 450, 150, 20);

        prenom1.setBounds(400, 150, 150, 20);
        prenom2.setBounds(400, 450, 150, 20);

        prenom1.addActionListener(this);
        prenom2.addActionListener(this);

        this.add(question);
        this.add(prenomTitle);
        this.add(question2);
        this.add(prenomTitle2);

        this.add(prenom1);
        this.add(prenom2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            //Connect to Database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:8889/Projet",
                    "root","root");
            Statement query = ((Connection) connect).createStatement();

            User user =new User();
            Student student=new Student();
            Student student1=new Student();
            DAO<Student> studentDao = new StudentDAO(connect);
            DAO<User> userDao = new UserDAO(connect);

            student.setFirstName(prenom1.getText());
            student1.setFirstName(prenom2.getText());

            userDao.modify(student,student1);
            //studentDao.modify(student);
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

