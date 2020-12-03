

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SessionDAO extends DAO<Session> {

    public SessionDAO(Connection conn) {
        super(conn);
    }

    public boolean update(Session session) {
        try (PreparedStatement preparedStatement = connect.prepareStatement("INSERT INTO Session (ID,WEEK,DATE,START_TIME,END_TIME,STATE,ID_COURSE,ID_TYPE) VALUES (?, ?,?,?,?, ?,?,?)")) {
            // On ne set pas l'id, la base s'en occupe toute seule (autoincrement)
            preparedStatement.setInt(1, session.getId());
            preparedStatement.setInt(2, session.getWeek());
            preparedStatement.setInt(3, session.getDate());
            preparedStatement.setInt(4, session.getStartTime());
            preparedStatement.setInt(5, session.getEndTime());
            preparedStatement.setString(6, session.getState());
            preparedStatement.setInt(7, session.getIdCourse());
            preparedStatement.setInt(8, session.getIdType());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean delete(Session session) {

        try (PreparedStatement preparedStatement = connect.prepareStatement("DELETE FROM session WHERE ID=?");){
            preparedStatement.setInt(1,session.getId());
            preparedStatement.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean modify(Session obj) {
        return false;
    }

    public Session find(int id, User user, List<Promotion>promotions,List<Course>courses, List <Site> sites,List<Type>types) {

        Session session=new Session();
        Course course = new Course();
        Type type=new Type();

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
                for(Type type1: types) {
                    if (type1.getId() == result.getInt("ID_TYPE")) {
                        type = type1;
                    }
                }

                session = new Session(id, result.getInt("WEEK"),
                        result.getInt("DATE"),
                        result.getInt("START_TIME"),
                        result.getInt("END_TIME"),
                        course, result.getString("STATE"), type);
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return session;
    }
}

