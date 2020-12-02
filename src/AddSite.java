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

public class AddSite extends JPanel implements ActionListener {

    ConnectDAO connectDAO = new ConnectDAO();


    JTextField id5 = new JTextField();
    JTextField name5 = new JTextField();


    public AddSite() {

        this.setSize(1250, 900);
        this.setLayout(null);


        Font police = new Font("Arial", Font.BOLD, 10);

        JLabel question = new JLabel("Renseignez les informations suivantes");
        JLabel idtitle = new JLabel("ID :");
        JLabel nametitle = new JLabel("NOM DU SITE:");



        question.setFont(police);
        idtitle.setFont(police);
        nametitle.setFont(police);


        id5.setFont(police);
        name5.setFont(police);


        question.setBounds(200, 100, 250, 50);
        idtitle.setBounds(200, 150, 150, 20);
        nametitle.setBounds(200, 200, 150, 20);


        id5.setBounds(400, 150, 150, 20);
        name5.setBounds(400, 200, 150, 20);

        id5.addActionListener(this);
        name5.addActionListener(this);


        this.add(question);
        this.add(idtitle);
        this.add(nametitle);


        this.add(id5);
        this.add(name5);
        this.setBackground(Color.white);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            //Connect to Database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:8889/Projet",
                    "root","root");
            Statement query = ((Connection) connect).createStatement();


          Site site = new Site();
            DAO<Site> siteDAO = new SiteDAO(connect);

            site.setId(Integer.parseInt(id5.getText()));
            site.setName(name5.getText());

            siteDAO.create(site);

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


