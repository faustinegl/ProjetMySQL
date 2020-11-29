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

    public Teacher find(int id, User user, List<Promotion>promotions) {

        // DAO<User> userDAO = new UserDAO(connect);
        Teacher teacher = new Teacher();
        //User user= new User();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM teacher WHERE ID_USER = " + id);

            if (result.first())
                //System.out.println("l");
                //for (User user : users) {

                    if (user.getPermission().equals("TEACHER")) {

                        List<Course> courses = new ArrayList<>();
                        for (Course element : courses) {
                            Course course = new Course(result.getInt("ID_COURSE"),
                                    result.getString("NAME_COURSE"));
                            courses.add(course);
                        }


                        teacher = new Teacher(id, user.getEmail(),
                                user.getPassword(),
                                user.getLastName(),
                                user.getFirstName(),
                                user.getPermission(), courses);


                    }
                    //System.out.println(student.getFirstName());
               // }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacher;
    }
}