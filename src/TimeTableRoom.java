import javax.swing.*;

public class TimeTableRoom extends TimeTable{
    String[][]  lines ;

    TimeTableRoom(){
            super();

            String[][]  lines= {
                    { "Lundi","Cours classe", "", "Cours 2" ,"","","","","","","","","",""},
                    { "Mardi","Cours 1", "Cours 2", "","","","","","","","","","","" },
                    { "Mercredi","Cours 1", "Cours 2", "","","","","","","","","","","" },
                    { "Jeudi","Cours 1", "Cours 2", "","","","","","","","","","","" },
                    { "Vendredi","Cours 1", "Cours 2", "","","","","","","","","","","" },
                    { "Samedi","Cours 1", "Cours 2", "","","","","","","","","","","" },
            };

            // Column Names
            String[] columns = { "Jours","8h", "9h", "10h","11h","12h","13h","14h","15h","16h","17h","18h","19h","20h" };
            JTable timeTableSalle = new JTable(lines,columns);
            timeTableSalle.setRowHeight(65);

            JScrollPane sp = new JScrollPane(timeTableSalle);
            sp.setBounds(30, 200, 1200, 415);
            this.timePane= sp;
        }


        @Override
        public JScrollPane getTimePane ()
        {
            return timePane ;
        }
    /*@Override
    public void setValueAt(String value, int row, int col) {
        lines[row][col] = value;

    }*/


}
