import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CourseDAO extends DAO<Course>{

    public CourseDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Course obj) {
        return false;
    }

    @Override
    public boolean delete(Course obj) {
        return false;
    }

    @Override
    public boolean update(Course obj) {
        return false;
    }

    @Override
    public Course find(int id, User user, List<Promotion>promotions,List<Course>courses, List <Site> sites) {

        Course course =new Course();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Course WHERE ID = " + id);
            if(result.first())
                course = new Course(id, result.getString("NAME"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }
}
