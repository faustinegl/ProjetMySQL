import javax.swing.*;
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

        try {

            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3308/projet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root", "");

            Statement instruction = connect.createStatement();
            ResultSet resultat = instruction.executeQuery("SELECT * FROM User");

            while(resultat.next())
            {
                if ((email.equals(resultat.getString("email")) && (password.equals(resultat.getString("password")))) )
                {

                    homePage.erreur = false;
                    this.setContentPane(menu);
                    this.revalidate();}

                }
        }
        catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

            /*Statement query = connect.createStatement();

            // Vérifier si l'email existe dans la table "USER"
            ResultSet rs = query.executeQuery("Select email from USER where email like '" + homePage.textEmail.getText() + "'");

            if (rs.next()){
                homePage.erreur = false;
                this.setContentPane(menu);
                this.revalidate();}

        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }*/
    }


        /*List<String> emails = new ArrayList<String>();
        // valid email addresses

        for(User user : users){
            emails.add(user.getEmail());
        }*/


       /* if (homePage.textEmail.getText().equals("aaaa")) {
                homePage.erreur = false;
                this.setContentPane(menu);
                this.revalidate();
            }*/

               /* for (User user : users) {
                    if (homePage.textEmail.getText().equals(user.getEmail())) {
                        homePage.erreur = false;
                        this.setContentPane(menu);
                        this.revalidate();
                    }
                } */












