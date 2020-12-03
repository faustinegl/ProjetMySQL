import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TimeTableStudent extends TimeTable{

    ConnectDAO connectDAO = new ConnectDAO();



    String[][]  lines= {

            { "Lundi","", "", "" ,"","","","","","","","","",""},
            { "Mardi","", "", "","","","","","","","","","","" },
            { "Mercredi","", "", "","","","","","","","","","","" },
            { "Jeudi","", "", "","","","","","","","","","","" },
            { "Vendredi","", "", "","","","","","","","","","","" },
            { "Samedi","", "", "","","","","","","","","","","" },
    };

    TimeTableStudent(){
        super();

        connectDAO.createConnection();



                // Column Names
                String[] columns = { "Jours","8h", "9h", "10h","11h","12h","13h","14h","15h","16h","17h","18h","19h","20h" };
                JTable timeTableStudent = new JTable(lines,columns);
                timeTableStudent.setRowHeight(65);

                for (Session session : connectDAO.sessions)
                {
                   if ((session.getDate()-20200104)<6)
                   {
                       lines[(session.getDate()-20200104)][(session.getStartTime()- 7)]=session.getCourse().getName();
                   }
                }


                JScrollPane sp = new JScrollPane(timeTableStudent);
                sp.setBounds(30, 200, 1200, 415);
                this.timePane= sp;

            }






    @Override
    public JScrollPane getTimePane ()
    {
        return timePane ;
    }

   /* @Override
    public void setValueAt(String value, int row, int col) {
        lines[row][col] = value;

    }*/


}
