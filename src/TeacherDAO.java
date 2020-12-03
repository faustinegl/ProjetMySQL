import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class TeacherDAO extends DAO<Teacher> {

    public TeacherDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean update(Teacher teacher) {
        try (PreparedStatement preparedStatement = connect.prepareStatement("INSERT INTO Teacher (ID_USER,ID_COURSE) VALUES (?, ?)")) {
            // On ne set pas l'id, la base s'en occupe toute seule (autoincrement)
            preparedStatement.setInt(1, teacher.getId());
            preparedStatement.setInt(2, teacher.getIdCourse());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Teacher teacher) {
        try (PreparedStatement preparedStatement = connect.prepareStatement("DELETE FROM teacher WHERE ID_USER=?");){
            preparedStatement.setInt(1,teacher.getId());
            preparedStatement.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean modify(Teacher obj) {
        return false;
    }

    public Teacher find(int id, User user, List<Promotion>promotions,List<Course>courses, List <Site> sites,List<Type>types,List<RoomSession>roomSessions,List<PromotionSession>promotionSessions) {
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
                    /*Set<Course> mySet = new HashSet<Course>(courseTeacher);
                    List<Course> courseTeacherF = new ArrayList<Course>(mySet);*/
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