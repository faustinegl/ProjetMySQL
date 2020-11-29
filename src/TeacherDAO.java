import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


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

        Teacher teacher = new Teacher();
        List<Course>courseTeacher=new ArrayList<>();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM teacher WHERE ID_USER = " + id);

            if (result.first())

                    if (user.getPermission().equals("TEACHER")) {

                        for (Course course2 : courses) {
                            System.out.println(course2.getId()+" "+result.getInt("ID_COURSE"));
                            if(course2.getId()==result.getInt("ID_COURSE")){
                                courseTeacher.add(course2);
                            }
                        }


                        teacher = new Teacher(id, user.getEmail(),
                                user.getPassword(),
                                user.getLastName(),
                                user.getFirstName(),
                                user.getPermission(), courseTeacher);


                    }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacher;
    }
}