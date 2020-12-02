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

public class DeleteTeacher extends JPanel implements ActionListener {

    ConnectDAO connectDAO = new ConnectDAO();

    JTextField id1 = new JTextField();

    public DeleteTeacher(){
        connectDAO.createConnection();
        this.setSize(1250,900);
        this.setLayout(null);


        Font police = new Font("Arial", Font.BOLD, 10);

        JLabel question = new JLabel("Renseignez l'ID du professeur a supprimer");
        JLabel idtitle = new JLabel("ID :");

        question.setFont(police);
        idtitle.setFont(police);

        id1.setFont(police);

        question.setBounds(200, 100, 250, 50);
        idtitle.setBounds(200, 150, 150, 20);

        id1.setBounds(400, 150, 150, 20);

        id1.addActionListener(this);

        this.add(question);
        this.add(idtitle);

        this.add(id1);
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
            Teacher teacher=new Teacher();
            DAO<Teacher> teacherDAO = new TeacherDAO(connect);
            DAO<User> userDao = new UserDAO(connect);

            teacher.setPermission("STUDENT");
            teacher.setId(Integer.parseInt(id1.getText()));

            teacherDAO.delete(teacher);
            userDao.delete(teacher);

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

