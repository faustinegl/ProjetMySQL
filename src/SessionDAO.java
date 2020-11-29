/*
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SessionDAO extends DAO<Session> {

    public SessionDAO(Connection conn) {
        super(conn);
    }

    public boolean create(Session obj) {
        return false;
    }

    public boolean delete(Session obj) {
        return false;
    }

    public boolean update(Session obj) {
        return false;
    }

    public Session find(int id, List<User> users) {

        // DAO<User> userDAO = new UserDAO(connect);
        Session session=new Session();
        //User user= new User();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM session WHERE ID_USER = " + id);

            if(result.first())
            {
                Course course = new Course(result.getInt("ID_COURSE"),
                                    result.getString("NAME_COURSE"));
                session = new Student(id, result.getString("WEEK"),
                        result.getString("DATE"),
                        result.getInt("START_TIME),
                        user.getINT("END_TIME"),
                        course, result.getString("STATE");
            }
                //System.out.println("l");








                    //System.out.println(student.getFirstName());



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return session;
    }
}*/
