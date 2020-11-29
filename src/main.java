import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class main {
    public static void main(String[] args) {
        main connection = new main();
        connection.createConnection();
        //Page page = new Page();
    }

    //Create a method to connect to database
    void createConnection(){
        try {
            //Connect to Database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(
                    "jdbc:mysql://localhost:8889/Projet",
                    "root", "root");
            Statement query = connect.createStatement();

            List<User> users = new ArrayList<>();
            List<Student> students = new ArrayList<>();
            List<Teacher> teachers = new ArrayList<>();
            List<Room> rooms = new ArrayList<>();
            List<Promotion> promotions = new ArrayList<>();
            List<Course>courses=new ArrayList<>();
            List<Site> sites=new ArrayList<>();
            List<Session> sessions=new ArrayList<>();


            DAO<Student> studentDao = new StudentDAO(connect);
            DAO<User> userDao = new UserDAO(connect);
            DAO<Teacher> teacherDAO = new TeacherDAO(connect);
            DAO<Room> roomDAO = new RoomDAO(connect);
            DAO<Promotion> promotionDAO = new PromotionDAO(connect);
            DAO<Course> courseDAO=new CourseDAO(connect);
            DAO<Site> siteDAO=new SiteDAO(connect);
            DAO<Session> sessionDAO=new SessionDAO(connect);



            for (int i = 0; i < 10000; i++) {
                User user = new User();
                user = userDao.find(i, user, promotions,courses,sites);


                if (user.getId() != 0) {
                    users.add(user);
                }

                Room room = roomDAO.find(i, user, promotions,courses,sites);
                if (room.getId() != 0) {
                    rooms.add(room);
                }
                Promotion promotion = promotionDAO.find(i, user, promotions,courses,sites);
                    if (promotion.getId() != 0) {
                        promotions.add(promotion);
                    }
               Course course= courseDAO.find(i, user, promotions,courses,sites);
                    if (course.getId() != 0) {
                        courses.add(course);
                    }
                Site site= siteDAO.find(i, user, promotions,courses,sites);
                    if (site.getId() != 0) {
                        sites.add(site);
                    }
                Session session = sessionDAO.find(i, user, promotions,courses,sites);

                if(session.getId()!=0)
                {
                    sessions.add(session);
                }

            }

            for (int i = 0; i < 10000; i++) {
                for (User user : users) {
                    if (i == user.getId()) {
                        Student student = studentDao.find(i, user, promotions,courses,sites);
                        if (student.getId() != 0) {
                            students.add(student);
                        }
                    }
                }
            }
            for (int i = 0; i < 10000; i++) {
                for (User user : users) {
                    if (i == user.getId()) {
                        Teacher teacher = teacherDAO.find(i, user, promotions,courses,sites);
                        if (teacher.getId() != 0) {
                            teachers.add(teacher);
                        }
                    }
                }
            }


            for (User user : users) {
                System.out.println(user.getId() + " : " + user.getFirstName() + "  - ");

            }
            System.out.println("LISTE ELEVES :");
            for (Student student : students) {

                System.out.println(student.getId() + " -" + student.getFirstName() + "  - " + student.getLastName() + " -" +
                        student.getEmail() + " -" + student.getPassword() + " -" + student.getNumber() + " -" + student.getPromotion().getName());
            }

            System.out.println("LISTE PROFESSEURS :");
            for (Teacher teacher : teachers) {
                for(Course course : teacher.getListCourse()){
                    System.out.println(teacher.getId() + " -" + teacher.getFirstName() + "  - " + teacher.getLastName() + " -" +
                            teacher.getEmail() + " -" + teacher.getPassword() + " -" + course.getName());
                }

            }
            /*for (Room room : rooms) {
                System.out.println("Capacite " + room.getCapacity() + "  - ");

            }*/
            System.out.println("LISTE SALLES :");
            for (Room room : rooms) {

                System.out.println(room.getId()+ " -"+room.getName() + "  - "+ room.getCapacity()+" -"+
                        room.getSite().getId()+" -"+ room.getSite().getName());
            }
            System.out.println("LISTE SESSIONS :");
            for (Session session : sessions) {

                System.out.println(session.getId()+ " -"+session.getWeek() + "  - "+ session.getDate()+" -"+
                        session.getStartTime()+" -"+ session.getEndTime()+ " -"+ session.getCourse().getName()+" -"+
                        session.getState());
            }


        }
        catch (ClassNotFoundException ex){
            Logger.getLogger(main.class.getName()).log(Level.SEVERE,null,ex);
        }

        catch(SQLException ex){
            Logger.getLogger(main.class.getName()).log(Level.SEVERE,null,ex);
            ex.printStackTrace();
        }
    }

}
