/*
import javax.swing.*;

public class TimeTableTeacher extends TimeTable {

    ConnectDAO connectDAO = new ConnectDAO();
    Menu menu = new Menu();




    TimeTableTeacher() {

        super();
        connectDAO.createConnection();

        String[][]  lines= {

                { "Lundi","", "", "" ,"","","","","","","","","",""},
                { "Mardi","", "", "","","","","","","","","","","" },
                { "Mercredi","", "", "","","","","","","","","","","" },
                { "Jeudi","", "", "","","","","","","","","","","" },
                { "Vendredi","", "", "","","","","","","","","","","" },
                { "Samedi","", "", "","","","","","","","","","","" },
        };

        // Column Names
        String[] columns = {"Jours", "8h", "9h", "10h", "11h", "12h", "13h", "14h", "15h", "16h", "17h", "18h", "19h", "20h"};
        JTable timeTableTeacher = new JTable(lines, columns);
        timeTableTeacher.setRowHeight(65);



        for (Teacher element : connectDAO.teachers )
        {
           if (element.getLastName().equals(homePage.textEmail.getText())
           {
               for (Course course : element.getListCourse())

               {
                   for (Session session : connectDAO.sessions)

                       if (session.getCourse().getId()==course.getId())
                       {

                           if (menu.weekChoice.getText().equals("1"))
                           {
                               if ((session.getDate()-20200104)<6)
                               {
                                   for (Promotion promotion : connectDAO.promotions)
                                   {

                                   if (promotion.getId()==session.getIdPromo()
                                   {

                                   lines[(session.getDate()-20200104)][(session.getStartTime()- 7)]= course.getName()
                                           + session.getState() + promotion.getName()  + session.getIdRoom();
                                           }
                                           }

                               }
                           }

                           if (menu.weekChoice.getText().equals("2"))
                           {
                               if ((session.getDate()-20200111)<6)
                               {
                                   lines[(session.getDate()-20200111)][(session.getStartTime()- 7)]= course.getName();
                               }
                           }

                       }

               }



           }
        }



        JScrollPane sp = new JScrollPane(timeTableTeacher);
        sp.setBounds(30, 300, 1200, 315);
        this.timePane = sp;
    }

    @Override
    public JScrollPane getTimePane() {
        return timePane;
    }

   */
/* @Override
    public void setValueAt(String value, int row, int col) {
        lines[row][col] = value;

    }*//*

}


*/
