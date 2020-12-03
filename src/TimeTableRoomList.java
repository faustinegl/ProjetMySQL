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
        String[] columns = {"Matiere", "Date", "Heure de debut", "Heure de fin", "Salle", "Site", "Etat"};
        JTable timeTableRoom = new JTable(lines, columns);
       /* for (Teacher element : connectDAO.teachers)
        {
            if (researchStudent.teacher.getText().equals(element.getLastName()));
            {
                lines[0][0]= element.getListCourse().get(0).getName();
                lines[1][0]= element.getListCourse().get(2).getName();

                for (Session sessionElement : connectDAO.sessions)
                {
                    if (element.getListCourse().get(0).getId()==sessionElement.getCourse().getId())
                    {
                        lines[0][1]=String.valueOf(sessionElement.getDate());
                        lines[0][2]=String.valueOf(sessionElement.getStartTime());
                        lines[0][3]=String.valueOf(sessionElement.getEndTime());
                        lines[0][6]=sessionElement.getState();

                    }
                    else if (element.getListCourse().get(2).getId()==sessionElement.getCourse().getId())
                    {
                        lines[1][1]=String.valueOf(sessionElement.getDate());
                        lines[1][2]=String.valueOf(sessionElement.getStartTime());
                        lines[1][3]=String.valueOf(sessionElement.getEndTime());
                        lines[1][6]=sessionElement.getState();
                    }
                }


            }
        }*/
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
