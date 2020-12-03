import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Page extends JFrame implements ActionListener {

    HomePage homePage = new HomePage();

    Menu menu = new Menu();
    MenuAdmin menuAdmin = new MenuAdmin();

    AddStudent addStudent= new AddStudent();
    AddTeacher addTeacher=new AddTeacher();
    AddCourse addCourse=new AddCourse();
    AddPromotion addPromotion=new AddPromotion();
    AddRoom addRoom=new AddRoom();
    AddSession addSession=new AddSession();
    AddSite addSite=new AddSite();

    UserJFrame userJFrame=new UserJFrame();

    DeleteStudent deleteStudent=new DeleteStudent();
    DeleteTeacher deleteTeacher=new DeleteTeacher();
    DeleteSession deleteSession=new DeleteSession();

    ModifyStudent modifyStudent=new ModifyStudent();

    ResearchTeacher researchTeacher = new ResearchTeacher();
    TimeTableTeacherList timeTableTeacherList = new TimeTableTeacherList();

    ResearchStudent researchStudent = new ResearchStudent();
    TimeTableStudentList timeTableStudentList = new TimeTableStudentList();

    ResearchRoom researchRoom = new ResearchRoom();
    TimeTableRoomList timeTableRoomList = new TimeTableRoomList();

    ResearchPromotion researchPromotion = new ResearchPromotion();
    TimeTablePromotionList timeTablePromotionList = new TimeTablePromotionList();


    ConnectDAO connectDAO = new ConnectDAO();
    Add add= new Add();
    Delete delete=new Delete();



    public Page() {

        super("Page d'accueil");
        connectDAO.createConnection();
        this.setSize(1250, 900);
//        this.setDefaultLookAndFeelDecorated(true);
        this.setLayout(null);
        this.add(homePage);
        this.setVisible(true);

        menuAdmin.buttonAdd.addActionListener(this);
        menuAdmin.teachers.addActionListener(this);
        menuAdmin.students.addActionListener(this);
        menuAdmin.rooms.addActionListener(this);
        menuAdmin.promotions.addActionListener(this);
        menuAdmin.buttonDelete.addActionListener(this);
        menuAdmin.buttonModify.addActionListener(this);

        researchTeacher.researchValidate.addActionListener(this);
        researchStudent.researchValidate1.addActionListener(this);
        researchRoom.researchValidate3.addActionListener(this);
        researchPromotion.researchValidate2.addActionListener(this);


        homePage.validated.addActionListener(this);

        add.astudent.addActionListener(this);
        add.acourse.addActionListener(this);
        add.apromotion.addActionListener(this);
        add.aroom.addActionListener(this);
        add.asession.addActionListener(this);
        add.asite.addActionListener(this);
        add.ateacher.addActionListener(this);

        delete.ssession.addActionListener(this);
        delete.sstudent.addActionListener(this);
        delete.steacher.addActionListener(this);

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
                    case ("ADMIN"), ("PEDA") -> {
                        this.setContentPane(menuAdmin);
                        this.revalidate();
                    }
                }
            }

        if (e.getSource()==menuAdmin.teachers)
        {
            this.setContentPane(researchTeacher);
            this.revalidate();
        }
        if (e.getSource()==researchTeacher.researchValidate)
        {
            researchTeacher.add(timeTableTeacherList.getTimePane());
            this.setContentPane(researchTeacher);
            this.revalidate();
        }



        if (e.getSource()==menuAdmin.students)
        {
            this.setContentPane(researchStudent);
            this.revalidate();
        }
        if (e.getSource()==researchStudent.researchValidate1)
        {
            researchStudent.add(timeTableStudentList.getTimePane());
            this.setContentPane(researchStudent);
            this.revalidate();
        }



        if (e.getSource()==menuAdmin.rooms)
        {
            this.setContentPane(researchRoom);
            this.revalidate();
        }
        if (e.getSource()==researchRoom.researchValidate3)
        {
            researchRoom.add(timeTableRoomList.getTimePane());
            this.setContentPane(researchRoom);
            this.revalidate();
        }



        if (e.getSource()==menuAdmin.promotions)
        {
            this.setContentPane(researchPromotion);
            this.revalidate();
        }
        if (e.getSource()==researchPromotion.researchValidate2)
        {
            researchPromotion.add(timeTablePromotionList.getTimePane());
            this.setContentPane(researchPromotion);
            this.revalidate();
        }




        if (e.getSource()==menuAdmin.buttonAdd)
        {
            this.setContentPane(add);
            this.revalidate();


        }
        if (e.getSource()==add.astudent)
        {
            this.setContentPane(addStudent);
            this.revalidate();
        }

        if (e.getSource()==add.acourse)
        {
            this.setContentPane(addCourse);
            this.revalidate();
        }

        if (e.getSource()==add.ateacher)
        {
            this.setContentPane(addTeacher);
            this.revalidate();
        }

        if (e.getSource()==add.apromotion)
        {
            this.setContentPane(addPromotion);
            this.revalidate();
        }

        if (e.getSource()==add.aroom)
        {
            this.setContentPane(addRoom);
            this.revalidate();
        }

        if (e.getSource()==add.asession)
        {
            this.setContentPane(addSession);
            this.revalidate();
        }

        if (e.getSource()==add.asite)
        {
            this.setContentPane(addSite);
            this.revalidate();
        }




        if (e.getSource()==menuAdmin.buttonDelete)
        {
            this.setContentPane(delete);
            this.revalidate();


        }
        if (e.getSource()==delete.sstudent)
        {
            this.setContentPane(deleteStudent);
            this.revalidate();
        }

        if (e.getSource()==delete.ssession)
        {
            this.setContentPane(deleteSession);
            this.revalidate();
        }

        if (e.getSource()==deleteTeacher)
        {
            this.setContentPane(deleteTeacher);
            this.revalidate();
        }









    }


}