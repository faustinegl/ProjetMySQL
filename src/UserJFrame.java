import javax.swing.*;
import java.awt.*;

public class UserJFrame extends JFrame {

    /*ConnectDAO connectDAO = new ConnectDAO();


    public UserJFrame() {
        super();
        connectDAO.createConnection();
        setTitle("Tableau d'utilisateurs");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Object[][] donnees;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; i < connectDAO.users.size(); j++) {
                switch (i) {
                    case 0:
                        // ID
                        donnees[i][j] = connectDAO.users.get(i).getId();

                    case 1:
                        // Prenom
                        donnees[i][j] = connectDAO.users.get(i).getFirstName();

                    case 2:
                        // NOM
                        donnees[i][j] = connectDAO.users.get(i).getLastName();

                    case 3:
                        // Email
                        donnees[i][j] = connectDAO.users.get(i).getEmail();

                    case 4:
                        // Password
                        donnees[i][j] = connectDAO.users.get(i).getPassword();

                    case 5:
                        // Utilisateur
                        donnees[i][j] = connectDAO.users.get(i).getPermission();

                    default:
                        throw new IllegalArgumentException();
                }

            }
        }

            String[] entetes = {"Prénom", "Nom", "Couleur favorite", "Homme", "Sport"};

            JTable tableau = new JTable(donnees, entetes);

            getContentPane().add(tableau.getTableHeader(), BorderLayout.NORTH);
            getContentPane().add(tableau, BorderLayout.CENTER);

            pack();
    }*/
}
