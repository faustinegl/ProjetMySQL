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
        try{
            //Connect to Database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(
                    "jdbc:mysql://localhost:8889/Projet",
                    "root","root");
            Statement query = connect.createStatement();

            List<User> users = new ArrayList<User>();
           List <Student> students = new ArrayList<>();
            List<Teacher> teachers= new ArrayList<>();
            List<Room> rooms= new ArrayList<>();
            List<Promotion>promotions =new ArrayList<>();

            DAO <Student> studentDao = new StudentDAO(connect);
            DAO<User> userDao = new UserDAO(connect);
            DAO <Teacher> teacherDAO = new TeacherDAO(connect);
            DAO <Room> roomDAO = new RoomDAO(connect);
            DAO<Promotion> promotionDAO = new PromotionDAO(connect);

            for(int i = 0; i < 10000; i++){
                User user = new User();
                user =userDao.find(i,user,promotions);
                //Student student = studentDao.find(i,users);
                Teacher teacher = teacherDAO.find(i,user,promotions);


                if (user.getId()!=0) {
                    users.add(user);
                }

                Room room = roomDAO.find(i,user,promotions);
                if (room.getId()!=0){
                    rooms.add(room);
                }
                Promotion promotion = promotionDAO.find(i,user,promotions);
                if (promotion.getId()!=0){
                    promotions.add(promotion);
                }
            }

            for(int i = 0; i < 10000; i++) {
                for(User user : users)
                {
                    if (i==user.getId()){
                        Student student = studentDao.find(i,user,promotions);
                        if (student.getId() != 0) {
                            students.add(student);
                        }
                    }
                }
            }
            for(int i = 0; i < 10000; i++) {
                for(User user : users)
                {
                    if (i==user.getId()){
                        Teacher teacher = teacherDAO.find(i,user,promotions);
                        if (teacher.getId() != 0) {
                            teachers.add(teacher);
                        }
                    }
                }
            }





            for (User user : users) {
                System.out.println(user.getId()+ " : "+ user.getFirstName() + "  - ");

            }
            System.out.println("LISTE ELEVES :");
            for (Student student : students) {

                System.out.println(student.getId()+ " -"+student.getFirstName() + "  - "+ student.getLastName()+" -"+
                        student.getEmail()+" -"+ student.getPassword()+" -"+student.getNumber()+ " -"+student.getPromotion().getName());
            }

            System.out.println("LISTE PROFESSEURS :");
            for (Teacher teacher : teachers) {
                System.out.println(teacher.getId()+ " -"+teacher.getFirstName() + "  - "+ teacher.getLastName()+" -"+
                        teacher.getEmail()+" -"+ teacher.getPassword()+" -"+teacher.getListCourse());
            }
            /*for (Room room : rooms) {
                System.out.println("Capacite " + room.getCapacity() + "  - ");

            }*/


/*            UserDAO userDAO=new UserDAO(connect);
            User user =new User();
            StudentDAO studentDAO=new StudentDAO(connect);
            Student student=new Student();
            PromotionDAO promotionDAO=new PromotionDAO(connect);
            Promotion promotion=new Promotion();
            List<Student> students = new ArrayList();
            List<User> users = new ArrayList();
            for (int i=8110;i<8113;i++)
            {
                users.add(userDAO.find(i,users));
                students.add(studentDAO.find(i,users));
                System.out.println(students.get(i).getFirstName());

            }*/




            //Insert/Uodate data to Database
            ///query.executeUpdate("INSERT INTO Table" + "(value)" + "VALUES('x'), ('y')," +
            //        "('z'), ('a')");

            //Execute a select all statement
            //ResultSet rs = query.executeQuery("SELECT * FROM Test1");
            //System.out.println("Projet");
//            while (rs.next()){
//                String table = rs.getString("nom");
//                System.out.println(table);
//            }

//            System.out.println("Connected to Database");
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
