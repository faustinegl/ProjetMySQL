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

public class AddRoom extends JPanel implements ActionListener {

    ConnectDAO connectDAO = new ConnectDAO();


    JTextField id5 = new JTextField();
    JTextField name5 = new JTextField();
    JTextField capacity = new JTextField();
    JTextField site = new JTextField();




    public AddRoom() {

        this.setSize(1250, 900);
        this.setLayout(null);


        Font police = new Font("Arial", Font.BOLD, 10);

        JLabel question = new JLabel("Renseignez les informations suivantes");
        JLabel idtitle = new JLabel("ID :");
        JLabel nametitle = new JLabel("NOM DE LA SALLE:");
        JLabel capacitytitle = new JLabel("CAPACITE :");
        JLabel sitetitle = new JLabel("NOM DU SITE");



        question.setFont(police);
        idtitle.setFont(police);
        nametitle.setFont(police);
        capacitytitle.setFont(police);
        sitetitle.setFont(police);


        id5.setFont(police);
        name5.setFont(police);
        capacity.setFont(police);
        site.setFont(police);


        question.setBounds(200, 100, 250, 50);
        idtitle.setBounds(200, 150, 150, 20);
        nametitle.setBounds(200, 200, 150, 20);
        capacitytitle.setBounds(200, 250, 150, 20);
        sitetitle.setBounds(200, 300, 150, 20);


        id5.setBounds(400, 150, 150, 20);
        name5.setBounds(400, 200, 150, 20);
        capacity.setBounds(200, 250, 150, 20);
        site.setBounds(200, 300, 150, 20);

        id5.addActionListener(this);
        name5.addActionListener(this);
        capacity.addActionListener(this);
        site.addActionListener(this);


        this.add(question);
        this.add(idtitle);
        this.add(nametitle);
        this.add(capacitytitle);
        this.add(sitetitle);


        this.add(id5);
        this.add(name5);
        this.add(capacity);
        this.add(site);
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

            Room room = new Room();
            DAO<Room> roomDAO = new RoomDAO(connect);

            room.setId(Integer.parseInt(id5.getText()));
            room.setName(name5.getText());
            room.setCapacity(Integer.parseInt(capacity.getText()));
            for (Site element : connectDAO.sites) {
                if (site.getText().equals(element.getName()))
                {
                    room.setSite(element);
                }
            }

            roomDAO.create(room);

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

