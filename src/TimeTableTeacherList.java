import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimeTableTeacherList extends JPanel implements ActionListener {

    JScrollPane timePane;
    ConnectDAO connectDAO = new ConnectDAO();
    ResearchTeacher researchTeacher = new ResearchTeacher();

    TimeTableTeacherList()
    {

        connectDAO.createConnection();
        String[][]  lines= {

                { "","", "", "" ,"","","","","","","","","",""},
                { "","", "", "","","","","","","","","","","" },
        };

        // Column Names
        String[] columns = {"Matiere", "Date", "Heure de debut", "Heure de fin", "Salle", "Site", "Etat","Promotion"};
        JTable timeTableTeacher = new JTable(lines, columns);
        String nameRoom;
        String namePromotion;
        String nameSite;
        for (Teacher element : connectDAO.teachers)
        {
            if (researchTeacher.teacher.getText().equals(element.getLastName()));
            {
                lines[0][0]= element.getListCourse().get(0).getName();
                lines[1][0]= element.getListCourse().get(2).getName();

                for (Session sessionElement : connectDAO.sessions)
                {
                    for (Room room : connectDAO.rooms) {
                        if(room.getId()==sessionElement.getIdRoom()){
                            nameRoom=room.getName();
                            for (Promotion promotion : connectDAO.promotions) {
                                if(promotion.getId()==sessionElement.getIdPromotion()){
                                    namePromotion=promotion.getName();
                                    for (Site site : connectDAO.sites) {
                                        if(site.getId()==room.getIdSite()){
                                            nameSite=site.getName();
                                            if (element.getListCourse().get(0).getId()==sessionElement.getCourse().getId())
                                            {
                                                lines[0][1]=String.valueOf(sessionElement.getDate());
                                                lines[0][2]=String.valueOf(sessionElement.getStartTime());
                                                lines[0][3]=String.valueOf(sessionElement.getEndTime());
                                                lines[0][4]=String.valueOf(nameRoom);
                                                lines[0][5]=String.valueOf(nameSite);
                                                lines[0][6]=sessionElement.getState();
                                                lines[0][7]=String.valueOf(namePromotion);

                                            }
                                            else if (element.getListCourse().get(2).getId()==sessionElement.getCourse().getId())
                                            {
                                                lines[1][1]=String.valueOf(sessionElement.getDate());
                                                lines[1][2]=String.valueOf(sessionElement.getStartTime());
                                                lines[1][3]=String.valueOf(sessionElement.getEndTime());
                                                lines[1][4]=String.valueOf(nameRoom);
                                                lines[1][5]=String.valueOf(nameSite);
                                                lines[1][6]=sessionElement.getState();
                                                lines[1][7]=String.valueOf(namePromotion);
                                            }
                                        }
                                    }

                                }
                            }

                        }
                }

                }


            }
        }
        JScrollPane sp = new JScrollPane(timeTableTeacher);
        sp.setBounds(30, 200, 1200, 415);
        this.timePane = sp;
    }

    public JScrollPane getTimePane() {
        return timePane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {



    }
}
