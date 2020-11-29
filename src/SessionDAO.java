

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

    public Session find(int id, User user, List<Promotion>promotions,List<Course>courses, List <Site> sites) {

        Session session=new Session();
        Course course = new Course();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM session WHERE ID = " + id);

            if(result.first())
            {
                for(Course course1: courses) {
                    if (course1.getId() == result.getInt("ID_COURSE")) {
                        course = course1;
                    }
                }

                session = new Session(id, result.getInt("WEEK"),
                        result.getString("DATE"),
                        result.getInt("START_TIME"),
                        result.getInt("END_TIME"),
                        course, result.getString("STATE"));
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return session;
    }
}

