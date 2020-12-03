import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListUser extends JPanel implements ActionListener {

    JScrollPane timePane;
    ConnectDAO connectDAO = new ConnectDAO();

    ListUser() {

        connectDAO.createConnection();
        String[][] lines = {

                {"", ""},
                {"", ""},
                {"", ""},
                {"", ""},
                {"", ""},
                {"", ""},
                {"", ""},
                {"", ""},
                {"", ""},
                {"", ""},
                {"", ""},
                {"", ""},
                {"", ""},
                {"", ""},
                {"", ""},
                {"", ""},
                {"", ""},
                {"", ""},
        };

        // Column Names
        String[] columns = {"ID", "TYPE"};
        JTable listUser = new JTable(lines, columns);

        int i=0;
        for (User element : connectDAO.users) {
            i++;
            lines[i][0] = String.valueOf(element.getId());
            lines[i][1] = String.valueOf(element.getPermission());

        }

        JScrollPane sp = new JScrollPane(listUser);
        sp.setBounds(30,200,1200,415);
        this.timePane =sp;
    }


    public JScrollPane getTimePane() {
        return timePane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {



    }
}