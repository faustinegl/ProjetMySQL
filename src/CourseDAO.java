import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CourseDAO extends DAO<Course> {

    public CourseDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean update(Course course) {
        try (PreparedStatement preparedStatement = connect.prepareStatement("INSERT INTO Course (ID,NAME) VALUES (?, ?)")) {
            // On ne set pas l'id, la base s'en occupe toute seule (autoincrement)
            preparedStatement.setInt(1, course.getId());
            preparedStatement.setString(2, course.getName());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Course obj) {
        return false;
    }

    @Override
    public boolean modify(Course obj) {
        return false;
    }

    @Override
    public Course find(int id, User user, List<Promotion> promotions, List<Course> courses, List<Site> sites, List<Type> types, List<RoomSession> roomSessions, List<PromotionSession> promotionSessions) {

        Course course = new Course();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Course WHERE ID = " + id);
            if (result.first())
                course = new Course(id, result.getString("NAME"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }
}
