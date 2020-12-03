/*
import javax.sound.sampled.Line;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimeTableStudentList extends JPanel implements ActionListener {

    JScrollPane timePane;
    ConnectDAO connectDAO = new ConnectDAO();
    ResearchStudent researchStudent = new ResearchStudent();


    TimeTableStudentList() {

        connectDAO.createConnection();
        String[][] lines = {

                {"", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        };

        // Column Names
        String nameRoom;
        String nameTeacher;
        String nameSite;
        String[] columns = {"Matiere", "Date", "Heure de debut", "Heure de fin", "Salle", "Site", "Etat", "Professeur"};
        JTable timeTableStudent = new JTable(lines, columns);
        for (Student element : connectDAO.students) {
            for (Session session : connectDAO.sessions) {
                if (session.getIdPromotion() == element.getIdPromo()) {
                    for (Room room : connectDAO.rooms) {
                        if (room.getId() == session.getIdRoom()) {
                            nameRoom = room.getName();
                            for (Teacher teacher : connectDAO.teachers) {
                                if (teacher.getIdCourse() == session.getIdCourse()) {
                                    nameTeacher = teacher.getLastName();
                                    for (Site site : connectDAO.sites) {
                                        if (site.getId() == room.getIdSite()) {
                                            nameSite = site.getName();
                                            if (connectDAO.sessions.get(2).getIdCourse() == session.getIdCourse()) {
                                                lines[0][1] = String.valueOf(session.getCourse().getName());
                                                lines[0][1] = String.valueOf(session.getDate());
                                                lines[0][2] = String.valueOf(session.getStartTime());
                                                lines[0][3] = String.valueOf(session.getEndTime());
                                                lines[0][4] = String.valueOf(nameRoom);
                                                lines[0][5] = String.valueOf(nameSite);
                                                lines[0][6] = session.getState();
                                                lines[0][7] = String.valueOf(nameTeacher);

                                            } else if (connectDAO.sessions.get(3).getIdCourse() == session.getIdCourse()) {
                                                lines[1][1] = String.valueOf(session.getCourse().getName());
                                                lines[1][1] = String.valueOf(session.getDate());
                                                lines[1][2] = String.valueOf(session.getStartTime());
                                                lines[1][3] = String.valueOf(session.getEndTime());
                                                lines[1][4] = String.valueOf(nameRoom);
                                                lines[1][5] = String.valueOf(nameSite);
                                                lines[1][6] = session.getState();
                                                lines[1][7] = String.valueOf(nameTeacher);

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
        JScrollPane sp = new JScrollPane(timeTableStudent);
        sp.setBounds(30, 300, 1200, 315);
        this.timePane = sp;
    }

    public JScrollPane getTimePane() {
        return timePane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }
}*/
