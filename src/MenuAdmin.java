import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MenuAdmin extends JPanel implements ActionListener {

    JButton buttonAdd= new JButton("Ajout");
    JButton buttonDelete= new JButton("Suppression");
    JButton buttonModify= new JButton("Cours");
    JButton students= new JButton("Etudiants");
    JButton promotions= new JButton("Promotion");
    JButton teachers= new JButton("Professeurs");
    JButton rooms= new JButton("Salles");





    /*JButton[] buttons = new JButton[52];
    ConnectDAO connectDAO = new ConnectDAO();
    JScrollPane timePane;
    String[][]  lines= {

            { "Lundi","", "", "" ,"","","","","","","","","",""},
            { "Mardi","", "", "","","","","","","","","","","" },
            { "Mercredi","", "", "","","","","","","","","","","" },
            { "Jeudi","", "", "","","","","","","","","","","" },
            { "Vendredi","", "", "","","","","","","","","","","" },
            { "Samedi","", "", "","","","","","","","","","","" },
    };*/

    public MenuAdmin()
    {
        this.setSize(1500, 1000);
        this.setLayout(null);


        Font police = new Font("Arial",Font.BOLD,12);
        Font policeTitre = new Font("Arial",Font.BOLD,15);
        Font policeChiffre = new Font("Arial",Font.BOLD,10);

        JLabel labelFond = new JLabel(new ImageIcon("PHOTOS/homepage.png"));
        labelFond.setBounds(0,0,1250,900);
        labelFond.setSize(1460,677);
/*
        JLabel titre=new JLabel("Emploi du temps :");
        titre.setFont(policeTitre);
        titre.setBounds(10,95,150,30);

        int nb=0;*/

        /*for (int j = 0; j < 2 ; j++){
            for (int i=0;i<26;i++) {
                buttons[nb] = new JButton();
                buttons[nb].setBounds(50+(i * 45), 140+(j*23), 45, 23);
                buttons[nb].setFont(policeChiffre);
                //buttons[indice].addActionListener(this);
                this.add(buttons[nb]);
                buttons[nb].addActionListener(this);
                nb++;
            }
        }
        buttons[0].setText("32");
        buttons[1].setText("33");
        buttons[2].setText("34");
        buttons[3].setText("35");
        buttons[4].setText("36");
        buttons[5].setText("37");
        buttons[6].setText("38");
        buttons[7].setText("39");
        buttons[8].setText("40");
        buttons[9].setText("41");
        buttons[10].setText("42");
        buttons[11].setText("43");
        buttons[12].setText("44");
        buttons[13].setText("45");
        buttons[14].setText("46");
        buttons[15].setText("47");
        buttons[16].setText("48");
        buttons[17].setText("49");
        buttons[18].setText("50");
        buttons[19].setText("51");
        buttons[20].setText("52");
        buttons[21].setText("1");
        buttons[22].setText("2");
        buttons[23].setText("3");
        buttons[24].setText("4");
        buttons[25].setText("5");
        buttons[26].setText("6");
        buttons[27].setText("7");
        buttons[28].setText("8");
        buttons[29].setText("9");
        buttons[30].setText("10");
        buttons[31].setText("11");
        buttons[32].setText("12");
        buttons[33].setText("13");
        buttons[34].setText("14");
        buttons[35].setText("15");
        buttons[36].setText("16");
        buttons[37].setText("17");
        buttons[38].setText("18");
        buttons[39].setText("19");
        buttons[40].setText("20");
        buttons[41].setText("21");
        buttons[42].setText("22");
        buttons[43].setText("23");
        buttons[44].setText("24");
        buttons[45].setText("25");
        buttons[46].setText("26");
        buttons[47].setText("27");
        buttons[48].setText("28");
        buttons[49].setText("28");
        buttons[50].setText("30");
        buttons[51].setText("31");
*/



        students.setBounds(0,10,120,30);
        teachers.setBounds(120,10,120,30);
        promotions.setBounds(240,10,120,30);
        rooms.setBounds(360,10,120,30);
        buttonAdd.setBounds(480,10,120,30);
        buttonDelete.setBounds(600,10,120,30);
        buttonModify.setBounds(720,10,120,30);

        buttonDelete.setFont(police);
        buttonModify.setFont(police);
        students.setFont(police);
        promotions.setFont(police);
        teachers.setFont(police);
        rooms.setFont(police);
        buttonAdd.setFont(police);


        //this.add(timeTableRoom.getTimePane());
        //this.add(titre);
        this.add(buttonDelete);
        this.add(buttonModify);
        this.add(students);
        this.add(promotions);
        this.add(teachers);
        this.add(rooms);
        this.add(buttonAdd);
        this.setBackground(Color.white);
        this.add(labelFond);



       /* String[][]  lines= {

                { "Lundi","", "", "" ,"","","","","","","","","",""},
                { "Mardi","", "", "","","","","","","","","","","" },
                { "Mercredi","", "", "","","","","","","","","","","" },
                { "Jeudi","", "", "","","","","","","","","","","" },
                { "Vendredi","", "", "","","","","","","","","","","" },
                { "Samedi","", "", "","","","","","","","","","","" },*/
        };

        /*String[] columns = { "Jours","8h", "9h", "10h","11h","12h","13h","14h","15h","16h","17h","18h","19h","20h" };
        JTable timeTableStudent = new JTable(lines,columns);
        timeTableStudent.setRowHeight(65);

        for (Session session : connectDAO.sessions)
        {
            lines[2][(session.getStartTime()- 7)]=session.getCourse().getName();
        }



        JScrollPane sp = new JScrollPane(timeTableStudent);
        sp.setBounds(30, 200, 1200, 415);
        this.timePane= sp;
        this.add(timePane);
*/

/*
    public JScrollPane getTimePane ()
    {
        return timePane ;
    }*/

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}


