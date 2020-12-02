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

public class AddPromotion extends JPanel implements ActionListener {

    ConnectDAO connectDAO = new ConnectDAO();


    JTextField id4 = new JTextField();
    JTextField name4 = new JTextField();



    public AddPromotion() {

        this.setSize(1250, 900);
        this.setLayout(null);


        Font police = new Font("Arial", Font.BOLD, 10);

        JLabel question = new JLabel("Renseignez les informations suivantes");
        JLabel idtitle = new JLabel("ID :");
        JLabel nametitle = new JLabel("NOM DE LA PROMOTION:");



        question.setFont(police);
        idtitle.setFont(police);
        nametitle.setFont(police);


        id4.setFont(police);
        name4.setFont(police);


        question.setBounds(200, 100, 250, 50);
        idtitle.setBounds(200, 150, 150, 20);
        nametitle.setBounds(200, 200, 150, 20);


        id4.setBounds(400, 150, 150, 20);
        name4.setBounds(400, 200, 150, 20);

        id4.addActionListener(this);
        name4.addActionListener(this);


        this.add(question);
        this.add(idtitle);
        this.add(nametitle);


        this.add(id4);
        this.add(name4);
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

            Promotion promotion = new Promotion();
            DAO<Promotion> promotionDAO = new PromotionDAO(connect);

            promotion.setId(Integer.parseInt(id4.getText()));
            promotion.setName(name4.getText());

            promotionDAO.update(promotion);

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


