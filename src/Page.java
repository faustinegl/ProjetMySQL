import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Page extends JFrame implements ActionListener {

    HomePage homePage = new HomePage();
    Menu menu = new Menu();


    public Page() {

        super("Page d'accueil");

        this.setSize(1250, 900);
//        this.setDefaultLookAndFeelDecorated(true);
        this.setLayout(null);
        this.add(homePage);
        this.setVisible(true);
        homePage.validated.addActionListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String email = homePage.textEmail.getText();
        String password = new String(homePage.textPassWord.getPassword());
        JDialog errorMessage = new JDialog(this,"Email ou mot de passe incorrect",true );
       errorMessage.setLayout(null);
        try {

            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet?use" +
                            "Unicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false" +
                            "&serverTimezone=UTC", "root", "");

            Statement instruction = connect.createStatement();
            ResultSet resultat = instruction.executeQuery("SELECT * FROM User");

            while(resultat.next()) {
                if ((email.equals(resultat.getString("email")) && (password.equals(resultat.getString("password"))))) {
                    errorMessage.setVisible(false);
                    switch (resultat.getString("PERMISSION")) {
                        case ("TEACHER") -> {
                            menu.add(menu.timeTableTeacher.getTimePane());
                            this.setContentPane(menu);
                            this.revalidate();
                        }
                        case ("STUDENT") -> {
                            menu.add(menu.timeTableStudent.getTimePane());
                            this.setContentPane(menu);
                            this.revalidate();
                        }
                    }

                }

               /* else {
                    errorMessage.setBounds(350, 125, 500, 20);
                    errorMessage.setBackground(Color.RED);
                    errorMessage.setVisible(true);
                    errorMessage.dispose();
                }*/

            }


        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

}

















