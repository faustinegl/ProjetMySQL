import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectDAO {
    List<User> users = new ArrayList<>();
    List<Student> students = new ArrayList<>();
    List<Teacher> teachers = new ArrayList<>();
    List<Room> rooms = new ArrayList<>();
    List<Promotion> promotions = new ArrayList<>();
    List<Course> courses = new ArrayList<>();
    List<Site> sites = new ArrayList<>();
    List<Session> sessions = new ArrayList<>();
    List<Type> types = new ArrayList<>();
    List<RoomSession> roomSessions = new ArrayList<>();
    List<PromotionSession> promotionSessions = new ArrayList<>();

    public List<Promotion> getPromotions() {
        return promotions;
    }

    public void createConnection() {
        try {
            //Connect to Database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root", "");
            Statement query = ((Connection) connect).createStatement();


            DAO<Student> studentDao = new StudentDAO(connect);
            DAO<User> userDao = new UserDAO(connect);
            DAO<Teacher> teacherDAO = new TeacherDAO(connect);
            DAO<Room> roomDAO = new RoomDAO(connect);
            DAO<Promotion> promotionDAO = new PromotionDAO(connect);
            DAO<Course> courseDAO = new CourseDAO(connect);
            DAO<Site> siteDAO = new SiteDAO(connect);
            DAO<Session> sessionDAO = new SessionDAO(connect);
            DAO<Type> typeDAO = new TypeDAO(connect);
            DAO<RoomSession> roomSessionDAO = new RoomSessionDAO(connect);
            DAO<PromotionSession> promotionSessionDAO = new PromotionSessionDAO(connect);


            for (int i = 0; i < 10000; i++) {
                User user = new User();
                user = userDao.find(i, user, promotions, courses, sites, types, roomSessions, promotionSessions);


                if (user.getId() != 0) {
                    users.add(user);
                }

                Room room = roomDAO.find(i, user, promotions, courses, sites, types, roomSessions, promotionSessions);
                if (room.getId() != 0) {
                    rooms.add(room);
                }
                Promotion promotion = promotionDAO.find(i, user, promotions, courses, sites, types, roomSessions, promotionSessions);
                if (promotion.getId() != 0) {
                    promotions.add(promotion);
                }

                Course course = courseDAO.find(i, user, promotions, courses, sites, types, roomSessions, promotionSessions);
                if (course.getId() != 0) {
                    courses.add(course);
                }
                Site site = siteDAO.find(i, user, promotions, courses, sites, types, roomSessions, promotionSessions);
                if (site.getId() != 0) {
                    sites.add(site);
                }
                Type type = typeDAO.find(i, user, promotions, courses, sites, types, roomSessions, promotionSessions);
                if (type.getId() != 0) {
                    types.add(type);
                }
                RoomSession roomSession = roomSessionDAO.find(i, user, promotions, courses, sites, types, roomSessions, promotionSessions);
                if (roomSession.getId() != 0) {
                    roomSessions.add(roomSession);
                }
                PromotionSession promotionSession = promotionSessionDAO.find(i, user, promotions, courses, sites, types, roomSessions, promotionSessions);
                if (promotionSession.getId() != 0) {
                    promotionSessions.add(promotionSession);
                }
                Session session = sessionDAO.find(i, user, promotions, courses, sites, types, roomSessions, promotionSessions);

                if (session.getId() != 0) {
                    sessions.add(session);
                }


            }

            for (int i = 0; i < 10000; i++) {
                for (User user : users) {
                    if (i == user.getId()) {
                        Session session = new Session();
                        Student student = studentDao.find(i, user, promotions, courses, sites, types, roomSessions, promotionSessions);
                        if (student.getId() != 0) {
                            students.add(student);
                        }
                    }
                }
            }

            for (int i = 0; i < 10000; i++) {
                for (User user : users) {
                    if (i == user.getId()) {
                        Session session = new Session();
                        Teacher teacher = teacherDAO.find(i, user, promotions, courses, sites, types, roomSessions, promotionSessions);
                        if (teacher.getId() != 0) {

                            teachers.add(teacher);
                        }
                    }
                }
            }


/*



            for (User user : users) {
                System.out.println(user.getPermission() + " : " + user.getFirstName() + "  - ");

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
            System.out.println();
            */
/*for (Room room : rooms) {
                System.out.println("Capacite " + room.getCapacity() + "  - ");

            }*//*

            System.out.println("LISTE SALLES :");
            for (Room room : rooms) {

                System.out.println(room.getId()+ " -"+room.getName() + "  - "+ room.getCapacity()+" -"+
                        room.getSite().getId()+" -"+ room.getSite().getName());
            }
            System.out.println("LISTE SESSIONS :");
            for (Session session : sessions) {

                System.out.println(session.getId()+ " -"+session.getWeek() + "  - "+ session.getDate()+" -"+
                        session.getStartTime()+" -"+ session.getEndTime()+ " -"+ session.getCourse().getName()+" -"+
                        session.getState()+ " -"+ session.getType().getName()+ " -"+ session.getIdRoom()+ " -"+ session.getIdPromotion());
            }
*/



  /*          User user =new User();
            Student student=new Student();
            Promotion promotion=new Promotion();
            int choice=0,id=0,number=0,idPromo=0;
            String email;
            String password;
            String lastname;
            String firstname;
            String permission;
            String promo;
            System.out.println("Voulez-vous ajouter un eleve (1) ou un Professeur(2)? ");
            Scanner scanner=new Scanner(System.in);
            Scanner scanner2=new Scanner(System.in);
            choice=scanner.nextInt();

            if (choice ==1)
            {
                permission="STUDENT";
                System.out.println("Donnez les information de l'eleve ");
                id=scanner.nextInt();
                student.setId(id);

                email=scanner.next( "[\\w.-]+@[\\w.-]+\\.[a-z]{2,}" );
                student.setEmail(email);

                password=scanner2.nextLine();
                student.setPassword(password);

                firstname=scanner2.nextLine();
                student.setFirstName(firstname);

                lastname=scanner2.nextLine();
                student.setLastName(lastname);

                student.setPermission(permission);

                number=scanner.nextInt();
                student.setNumber(number);

                promo=scanner2.nextLine();
                for (Promotion promotion1 : promotions) {
                    if (promo.equals(promotion1.getName()))
                    {
                        student.setPromotion(promotion1);
                    }
                }




                userDao.create(student);
                studentDao.create(student);


            }
            else if(choice==2)
            {

            }*/

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
}

