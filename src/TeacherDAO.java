import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class TeacherDAO extends DAO<Teacher> {

    public TeacherDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Teacher obj) {
        return false;
    }

    @Override
    public boolean delete(Teacher obj) {
        return false;
    }

    @Override
    public boolean update(Teacher obj) {
        return false;
    }

    public Teacher find(int id, User user, List<Promotion>promotions,List<Course>courses, List <Site> sites) {
        Set<Integer>idCourses = new HashSet<>();

        Teacher teacher = new Teacher();
        List<Course>courseTeacher=new ArrayList<>();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM teacher WHERE ID_USER = " + id);

            while (result.next()) {
                idCourses.add(result.getInt("ID_COURSE"));


                if (user.getPermission().equals("TEACHER")) {
                    for(Integer idCours : idCourses) {
                        for (Course course2 : courses) {

                            if (idCours.equals(course2.getId())) {
                                courseTeacher.add(course2);


                            }
                        }
                    }

                    teacher = new Teacher(id, user.getEmail(),
                            user.getPassword(),
                            user.getLastName(),
                            user.getFirstName(),
                            user.getPermission(), courseTeacher);


                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacher;
    }
}