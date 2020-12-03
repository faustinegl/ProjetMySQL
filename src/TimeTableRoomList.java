/*
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimeTableRoomList extends JPanel implements ActionListener {

    JScrollPane timePane;
    ConnectDAO connectDAO = new ConnectDAO();
    ResearchRoom researchRoom = new ResearchRoom();



    TimeTableRoomList()
    {

        connectDAO.createConnection();
        String[][]  lines= {

                { "","", "", "" ,"","","","","","","","","",""},
                { "","", "", "","","","","","","","","","","" },
        };

        // Column Names
        String[] columns = {"Matiere", "Date", "Heure de debut", "Heure de fin", "Promotion","Professeur", "Site", "Etat"};
        JTable timeTableRoom = new JTable(lines, columns);



        for (Room room : connectDAO.rooms) {
            if (researchRoom.room.getText().equals(room.getName())) {
                for (Session element : connectDAO.sessions) {
                    if (element.getIdRoom() == room.getId()) {
                        lines[0][1] = element.getCourse().getName();
                        lines[0][2] = String.valueOf(element.getDate());
                        lines[0][3] = String.valueOf(element.getStartTime());
                        lines[0][4] = String.valueOf(element.getEndTime());
                        lines[0][7] = room.getSite().getName();
                        lines[0][8] = element.getState();

                        for (Promotion promotion : connectDAO.promotions) {

                            if (promotion.getId() == element.getIdPromotion()) {
                                lines[0][5] = promotion.getName();
                            }
                        }


                    }
                }


            }
        }

        JScrollPane sp = new JScrollPane(timeTableRoom);
        sp.setBounds(30, 300, 1200, 315);
        this.timePane = sp;
    }

    public JScrollPane getTimePane() {
        return timePane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {



    }
}
*/
