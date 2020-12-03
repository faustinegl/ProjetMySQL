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

public class AddStudent extends JPanel implements ActionListener {

    ConnectDAO connectDAO = new ConnectDAO();


    JTextField id1 = new JTextField();
    JTextField email1 = new JTextField();
    JTextField password1 = new JTextField();
    JTextField lastName1 = new JTextField();
    JTextField firstName1 = new JTextField();
    JTextField number1 = new JTextField();
    JTextField promotion1 = new JTextField();


    public AddStudent()
    {
        connectDAO.createConnection();
        this.setSize(1250,900);
        this.setLayout(null);





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
        JLabel numbertitle = new JLabel("NUMERO :");
        JLabel promotiontitle = new JLabel("PROMOTION :");



        question.setFont(police);
        idtitle.setFont(police);
        emailtitle.setFont(police);
        passwordtitle.setFont(police);
        lastNametitle.setFont(police);
        firstNametitle.setFont(police);
        numbertitle.setFont(police);
        promotiontitle.setFont(police);

        id1.setFont(police);
        email1.setFont(police);
        password1.setFont(police);
        lastName1.setFont(police);
        firstName1.setFont(police);
        number1.setFont(police);
        promotion1.setFont(police);

        question.setBounds(200, 100, 250, 50);
        idtitle.setBounds(200, 150, 150, 20);
        emailtitle.setBounds(200, 200, 150, 20);
        passwordtitle.setBounds(200, 250, 150, 20);
        lastNametitle.setBounds(200, 300, 150, 20);
        firstNametitle.setBounds(200, 350, 150, 20);
        numbertitle.setBounds(200, 400, 150, 20);
        promotiontitle.setBounds(200, 450, 150, 20);

        id1.setBounds(400, 150, 150, 20);
        email1.setBounds(400, 200, 150, 20);
        password1.setBounds(400, 250, 150, 20);
        lastName1.setBounds(400, 300, 150, 20);
        firstName1.setBounds(400, 350, 150, 20);
        number1.setBounds(400, 400, 150, 20);
        promotion1.setBounds(400, 450, 150, 20);

        id1.addActionListener(this);
        email1.addActionListener(this);
        password1.addActionListener(this);
        lastName1.addActionListener(this);
        firstName1.addActionListener(this);
        number1.addActionListener(this);
        promotion1.addActionListener(this);


        this.add(question);
        this.add(idtitle);
        this.add(emailtitle);
        this.add(passwordtitle);
        this.add(lastNametitle);
        this.add(firstNametitle);
        this.add(numbertitle);
        this.add(promotiontitle);

        this.add(id1);
        this.add(email1);
        this.add(password1);
        this.add(lastName1);
        this.add(firstName1);
        this.add(number1);
        this.add(promotion1);
        this.setBackground(Color.white);
        this.add(labelFond);


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
        DAO<Student> studentDao = new StudentDAO(connect);
        DAO<User> userDao = new UserDAO(connect);

        student.setPermission("STUDENT");
        student.setId(Integer.parseInt(id1.getText()));
        student.setEmail(email1.getText());
        student.setPassword(password1.getText());
        student.setLastName(lastName1.getText());
        student.setFirstName(firstName1.getText());
        student.setNumber(Integer.parseInt(number1.getText()));

        //System.out.println(connectDAO.getPromotions().get(1).getName());
        for (Promotion promo : connectDAO.getPromotions()) {
            if (promotion1.getText().equals(promo.getName()))
            {
                student.setPromotion(promo);
            }
        }

        userDao.update(student);
        studentDao.update(student);

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
