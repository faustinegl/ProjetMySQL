import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Page extends JFrame implements ActionListener {

    HomePage homePage = new HomePage();
    Menu menu = new Menu();
/*    AddStudent addStudent= new AddStudent();
    AddTeacher addTeacher=new AddTeacher();
    AddCourse addCourse=new AddCourse();
    AddPromotion addPromotion=new AddPromotion();
    AddRoom addRoom=new AddRoom();
    AddSession addSession=new AddSession();
    AddSite addSite=new AddSite();
    UserJFrame userJFrame=new UserJFrame();

    DeleteStudent deleteStudent=new DeleteStudent();
    DeleteTeacher deleteTeacher=new DeleteTeacher();
    DeleteSession deleteSession=new DeleteSession();*/

    ModifyStudent modifyStudent=new ModifyStudent();


    ConnectDAO connectDAO = new ConnectDAO();
    Add add= new Add();
    Delete delete=new Delete();



    public Page() {

        super("Page d'accueil");
        connectDAO.createConnection();
        this.setSize(1250, 900);
//        this.setDefaultLookAndFeelDecorated(true);
        this.setLayout(null);
        this.add(modifyStudent);
        this.setVisible(true);
        homePage.validated.addActionListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {


        String email = homePage.textEmail.getText();
        String password = new String(homePage.textPassWord.getPassword());
        JDialog errorMessage = new JDialog(this,"Email ou mot de passe incorrect",true );
        errorMessage.setLayout(null);


        for (User user : connectDAO.users)
            if ((email.equals(user.getEmail()) && (password.equals(user.getPassword())))) {
                switch (user.getPermission()) {
                    case ("TEACHER") -> {
                        menu.add(menu.timeTableTeacher.getTimePane());
                        this.setContentPane(menu);
                        this.revalidate();
                    }
                    case ("STUDENT") -> {
                        menu.add(menu.timeTableStudent.getTimePane());
                        this.setContentPane(menu);
                        this.revalidate();
                    }
                    case ("ADMIN") -> {
                        menu.add(menu.timeTablePromotion.getTimePane());
                        this.setContentPane(menu);
                        this.revalidate();
                    }
                    case ("PEDA") -> {
                        menu.add(menu.timeTableRoom.getTimePane());
                        this.setContentPane(menu);
                        this.revalidate();
                    }
                }

            }



    }


}