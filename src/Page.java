import org.jfree.chart.demo.BarChart;
import org.jfree.chart.ui.UIUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Page extends JFrame implements ActionListener {

    HomePage homePage = new HomePage();

    Menu menu = new Menu();
    MenuAdmin menuAdmin = new MenuAdmin();


    ResearchTeacher researchTeacher = new ResearchTeacher();
   // TimeTableTeacherList timeTableTeacherList = new TimeTableTeacherList();

    AddStudent addStudent = new AddStudent();
    AddTeacher addTeacher = new AddTeacher();
    AddCourse addCourse = new AddCourse();
    AddPromotion addPromotion = new AddPromotion();
    AddRoom addRoom = new AddRoom();
    AddSession addSession = new AddSession();
    AddSite addSite = new AddSite();


    DeleteStudent deleteStudent = new DeleteStudent();
    DeleteTeacher deleteTeacher = new DeleteTeacher();
    DeleteSession deleteSession = new DeleteSession();

    Modify modify = new Modify();
    ModifyStudent modifyStudent = new ModifyStudent();
    ModifySession modifySession = new ModifySession();


    ResearchStudent researchStudent = new ResearchStudent();
   // TimeTableStudentList timeTableStudentList = new TimeTableStudentList();

    ResearchRoom researchRoom = new ResearchRoom();
    //TimeTableRoomList timeTableRoomList = new TimeTableRoomList();

    ResearchPromotion researchPromotion = new ResearchPromotion();
    //TimeTablePromotionList timeTablePromotionList = new TimeTablePromotionList();




    ConnectDAO connectDAO = new ConnectDAO();
    Add add = new Add();
    Delete delete = new Delete();

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
        menuAdmin.graphique2.addActionListener(this);
        menuAdmin.graphique.addActionListener(this);

        add.buttonAdd.addActionListener(this);
        add.teachers.addActionListener(this);
        add.students.addActionListener(this);
        add.rooms.addActionListener(this);
        add.promotions.addActionListener(this);
        add.buttonDelete.addActionListener(this);
        add.buttonModify.addActionListener(this);
        add.graphique2.addActionListener(this);
        add.graphique.addActionListener(this);

        addCourse.buttonAdd.addActionListener(this);
        addCourse.teachers.addActionListener(this);
        addCourse.students.addActionListener(this);
        addCourse.rooms.addActionListener(this);
        addCourse.promotions.addActionListener(this);
        addCourse.buttonDelete.addActionListener(this);
        addCourse.buttonModify.addActionListener(this);
        addCourse.graphique2.addActionListener(this);
        addCourse.graphique.addActionListener(this);

        addPromotion.buttonAdd.addActionListener(this);
        addPromotion.teachers.addActionListener(this);
        addPromotion.students.addActionListener(this);
        addPromotion.rooms.addActionListener(this);
        addPromotion.promotions.addActionListener(this);
        addPromotion.buttonDelete.addActionListener(this);
        addPromotion.buttonModify.addActionListener(this);
        addPromotion.graphique2.addActionListener(this);
        addPromotion.graphique.addActionListener(this);

        addRoom.buttonAdd.addActionListener(this);
        addRoom.teachers.addActionListener(this);
        addRoom.students.addActionListener(this);
        addRoom.rooms.addActionListener(this);
        addRoom.promotions.addActionListener(this);
        addRoom.buttonDelete.addActionListener(this);
        addRoom.buttonModify.addActionListener(this);
        addRoom.graphique2.addActionListener(this);
        addRoom.graphique.addActionListener(this);

        addSession.buttonAdd.addActionListener(this);
        addSession.teachers.addActionListener(this);
        addSession.students.addActionListener(this);
        addSession.rooms.addActionListener(this);
        addSession.promotions.addActionListener(this);
        addSession.buttonDelete.addActionListener(this);
        addSession.buttonModify.addActionListener(this);
        addSession.graphique2.addActionListener(this);
        addSession.graphique.addActionListener(this);

        addSite.buttonAdd.addActionListener(this);
        addSite.teachers.addActionListener(this);
        addSite.students.addActionListener(this);
        addSite.rooms.addActionListener(this);
        addSite.promotions.addActionListener(this);
        addSite.buttonDelete.addActionListener(this);
        addSite.buttonModify.addActionListener(this);
        addSite.graphique2.addActionListener(this);
        addSite.graphique.addActionListener(this);

        addStudent.buttonAdd.addActionListener(this);
        addStudent.teachers.addActionListener(this);
        addStudent.students.addActionListener(this);
        addStudent.rooms.addActionListener(this);
        addStudent.promotions.addActionListener(this);
        addStudent.buttonDelete.addActionListener(this);
        addStudent.buttonModify.addActionListener(this);
        addStudent.graphique2.addActionListener(this);
        addStudent.graphique.addActionListener(this);

        addTeacher.buttonAdd.addActionListener(this);
        addTeacher.teachers.addActionListener(this);
        addTeacher.students.addActionListener(this);
        addTeacher.rooms.addActionListener(this);
        addTeacher.promotions.addActionListener(this);
        addTeacher.buttonDelete.addActionListener(this);
        addTeacher.buttonModify.addActionListener(this);
        addTeacher.graphique2.addActionListener(this);
        addTeacher.graphique.addActionListener(this);

        delete.buttonAdd.addActionListener(this);
        delete.teachers.addActionListener(this);
        delete.students.addActionListener(this);
        delete.rooms.addActionListener(this);
        delete.promotions.addActionListener(this);
        delete.buttonDelete.addActionListener(this);
        delete.buttonModify.addActionListener(this);
        delete.graphique2.addActionListener(this);
        delete.graphique.addActionListener(this);

        deleteSession.buttonAdd.addActionListener(this);
        deleteSession.teachers.addActionListener(this);
        deleteSession.students.addActionListener(this);
        deleteSession.rooms.addActionListener(this);
        deleteSession.promotions.addActionListener(this);
        deleteSession.buttonDelete.addActionListener(this);
        deleteSession.buttonModify.addActionListener(this);
        deleteSession.graphique2.addActionListener(this);
        deleteSession.graphique.addActionListener(this);



        deleteStudent.buttonAdd.addActionListener(this);
        deleteStudent.teachers.addActionListener(this);
        deleteStudent.students.addActionListener(this);
        deleteStudent.rooms.addActionListener(this);
        deleteStudent.promotions.addActionListener(this);
        deleteStudent.buttonDelete.addActionListener(this);
        deleteStudent.buttonModify.addActionListener(this);
        deleteStudent.graphique2.addActionListener(this);
        deleteStudent.graphique.addActionListener(this);


        deleteTeacher.buttonAdd.addActionListener(this);
        deleteTeacher.teachers.addActionListener(this);
        deleteTeacher.students.addActionListener(this);
        deleteTeacher.rooms.addActionListener(this);
        deleteTeacher.promotions.addActionListener(this);
        deleteTeacher.buttonDelete.addActionListener(this);
        deleteTeacher.buttonModify.addActionListener(this);
        deleteTeacher.graphique2.addActionListener(this);
        deleteTeacher.graphique.addActionListener(this);


        researchPromotion.buttonAdd.addActionListener(this);
        researchPromotion.teachers.addActionListener(this);
        researchPromotion.students.addActionListener(this);
        researchPromotion.rooms.addActionListener(this);
        researchPromotion.promotions.addActionListener(this);
        researchPromotion.buttonDelete.addActionListener(this);
        researchPromotion.buttonModify.addActionListener(this);
        researchPromotion.graphique2.addActionListener(this);
        researchPromotion.graphique.addActionListener(this);


        researchRoom.buttonAdd.addActionListener(this);
        researchRoom.teachers.addActionListener(this);
        researchRoom.students.addActionListener(this);
        researchRoom.rooms.addActionListener(this);
        researchRoom.promotions.addActionListener(this);
        researchRoom.buttonDelete.addActionListener(this);
        researchRoom.buttonModify.addActionListener(this);
        researchRoom.graphique2.addActionListener(this);
        researchRoom.graphique.addActionListener(this);

        researchStudent.buttonAdd.addActionListener(this);
        researchStudent.teachers.addActionListener(this);
        researchStudent.students.addActionListener(this);
        researchStudent.rooms.addActionListener(this);
        researchStudent.promotions.addActionListener(this);
        researchStudent.buttonDelete.addActionListener(this);
        researchStudent.buttonModify.addActionListener(this);
        researchStudent.graphique2.addActionListener(this);
        researchStudent.graphique.addActionListener(this);

        researchTeacher.buttonAdd.addActionListener(this);
        researchTeacher.teachers.addActionListener(this);
        researchTeacher.students.addActionListener(this);
        researchTeacher.rooms.addActionListener(this);
        researchTeacher.promotions.addActionListener(this);
        researchTeacher.buttonDelete.addActionListener(this);
        researchTeacher.buttonModify.addActionListener(this);
        researchTeacher.graphique2.addActionListener(this);
        researchTeacher.graphique.addActionListener(this);

        modify.buttonAdd.addActionListener(this);
        modify.teachers.addActionListener(this);
        modify.students.addActionListener(this);
        modify.rooms.addActionListener(this);
        modify.promotions.addActionListener(this);
        modify.buttonDelete.addActionListener(this);
        modify.buttonModify.addActionListener(this);
        modify.graphique2.addActionListener(this);
        modify.graphique.addActionListener(this);


        researchTeacher.researchValidate.addActionListener(this);
        researchStudent.researchValidate1.addActionListener(this);
        researchRoom.researchValidate3.addActionListener(this);
        researchPromotion.researchValidate2.addActionListener(this);


        homePage.validated.addActionListener(this);
        menu.choiceValidated.addActionListener(this);
        menu.deconnexion.addActionListener(this);
        menuAdmin.deconnexion.addActionListener(this);

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
        JDialog errorMessage = new JDialog(this, "Email ou mot de passe incorrect", true);
        errorMessage.setLayout(null);


        for (User user : connectDAO.users)
            if ((email.equals(user.getEmail()) && (password.equals(user.getPassword())))) {
                switch (user.getPermission()) {
                    case ("TEACHER") -> {
                       // menu.add(menu.timeTableTeacher.getTimePane());
                        this.setContentPane(menu);
                        this.revalidate();
                    }
                    case ("STUDENT") -> {
                        menu.add(menu.timeTableStudent.getTimePane());
                        this.setContentPane(menu);
                        this.revalidate();
                    }
                    case ("ADMIN"), ("PEDA") -> {
                        menuAdmin.add(menuAdmin.listUser.getTimePane());
                        this.setContentPane(menuAdmin);
                        this.revalidate();
                    }
                }
            }
        if (e.getSource()==menu.deconnexion)
        {
            this.setContentPane(homePage);
            this.revalidate();
        }

        if (e.getSource()==menuAdmin.deconnexion)
        {
            this.setContentPane(homePage);
            this.revalidate();
        }

       /* if (e.getSource()== menu.choiceValidated)
        {

            menu.add(menu.timeTableTeacher.getTimePane());
            this.setContentPane(menu);
            this.revalidate();
        }*/

        if (e.getSource() == menuAdmin.teachers) {
            this.setContentPane(researchTeacher);
            this.revalidate();
        }
       /* if (e.getSource() == researchTeacher.researchValidate) {
            researchTeacher.add(timeTableTeacherList.getTimePane());
            this.setContentPane(researchTeacher);
            this.revalidate();
        }*/

        if (e.getSource() == menuAdmin.students) {
            this.setContentPane(researchStudent);
            this.revalidate();
        }
       /* if (e.getSource() == researchStudent.researchValidate1) {
            researchStudent.add(timeTableStudentList.getTimePane());
            this.setContentPane(researchStudent);
            this.revalidate();
        }
*/

        if (e.getSource() == menuAdmin.rooms) {
            this.setContentPane(researchRoom);
            this.revalidate();
        }
        /*if (e.getSource() == researchRoom.researchValidate3) {
            researchRoom.add(timeTableRoomList.getTimePane());
            this.setContentPane(researchRoom);
            this.revalidate();
        }*/


        if (e.getSource() == menuAdmin.promotions) {
            this.setContentPane(researchPromotion);
            this.revalidate();
        }
       /* if (e.getSource() == researchPromotion.researchValidate2) {
            researchPromotion.add(timeTablePromotionList.getTimePane());
            this.setContentPane(researchPromotion);
            this.revalidate();
        }*/


        if (e.getSource() == menuAdmin.buttonAdd) {
            this.setContentPane(add);
            this.revalidate();

        }
        if (e.getSource() == add.astudent) {
            this.setContentPane(addStudent);
            this.revalidate();
        }

        if (e.getSource() == add.acourse) {
            this.setContentPane(addCourse);
            this.revalidate();
        }

        if (e.getSource() == add.ateacher) {
            this.setContentPane(addTeacher);
            this.revalidate();
        }

        if (e.getSource() == add.apromotion) {
            this.setContentPane(addPromotion);
            this.revalidate();
        }

        if (e.getSource() == add.aroom) {
            this.setContentPane(addRoom);
            this.revalidate();
        }

        if (e.getSource() == add.asession) {
            this.setContentPane(addSession);
            this.revalidate();
        }

        if (e.getSource() == add.asite) {
            this.setContentPane(addSite);
            this.revalidate();
        }


        if (e.getSource() == menuAdmin.buttonDelete) {
            this.setContentPane(delete);
            this.revalidate();


        }
        if (e.getSource() == delete.sstudent) {
            this.setContentPane(deleteStudent);
            this.revalidate();
        }

        if (e.getSource() == delete.ssession) {
            this.setContentPane(deleteSession);
            this.revalidate();
        }

        if (e.getSource() == deleteTeacher) {
            delete.add(menuAdmin);
            this.setContentPane(deleteTeacher);
            this.revalidate();
        }


        if (e.getSource() == menuAdmin.buttonModify) {
            this.setContentPane(modify);
            this.revalidate();


        }
        if (e.getSource() == modify.sstudent) {
            this.setContentPane(modifyStudent);
            this.revalidate();
        }

        if (e.getSource() == modify.ssession) {
            this.setContentPane(modifySession);
            this.revalidate();
        }






        if (e.getSource()== menuAdmin.graphique)
        {
            final BarChart capacite_salles = new BarChart("Capacité salles");
            capacite_salles.pack();
            UIUtils.centerFrameOnScreen(capacite_salles);
            capacite_salles.setVisible(true);
        }

        if (e.getSource()== menuAdmin.graphique2)
        {
            org.jfree.chart.demo.PieChart demo = new org.jfree.chart.demo.PieChart("Répartition des Cours");
            demo.pack();
            UIUtils.centerFrameOnScreen(demo);
            demo.setVisible(true);
        }

    }
}

