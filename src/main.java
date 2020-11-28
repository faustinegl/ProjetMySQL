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
                    "jdbc:mysql://localhost:8889/Projet","root","root");
            Statement query = connect.createStatement();

            List<User> users = new ArrayList();
            DAO<User> userDao = new UserDAO(connect);
            for(int i = 8110; i < 8120; i++){
                User user = userDao.find(i,users);
                System.out.println("Elève N°" + user.getPassword() + "  - " + user.getFirstName() + " " + user.getEmail());
            }

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
