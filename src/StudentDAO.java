import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentDAO extends DAO<Student> {

    public StudentDAO(Connection conn) {
        super(conn);
    }

    public boolean create(Student obj) {
        return false;
    }

    public boolean delete(Student obj) {
        return false;
    }

    public boolean update(Student obj) {
        return false;
    }

    public Student find(int id, List<User> users) {

       // DAO<User> userDAO = new UserDAO(connect);
        Student student=new Student();
        //User user= new User();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM student WHERE ID_USER = " + id);

            if(result.first())
                //System.out.println("l");
                for (User user : users) {

                    if (user.getPermission().equals("STUDENT")) {
                        Promotion promotion = new Promotion(result.getInt("ID_PROMOTION"),
                               "");
                        student = new Student(id, user.getEmail(),
                                user.getPassword(),
                                user.getLastName(),
                                user.getFirstName(),
                                user.getPermission(),
                                result.getInt("NUMBER"), promotion);





                    }

                    //System.out.println(student.getFirstName());
                }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
}