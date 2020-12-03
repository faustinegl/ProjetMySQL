import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentDAO extends DAO<Student> {

    public StudentDAO(Connection conn) {
        super(conn);
    }

    public boolean update(Student student) {
        try (PreparedStatement preparedStatement = connect.prepareStatement("INSERT INTO Student (ID_USER,NUMBER,ID_PROMOTION) VALUES (?, ?,?)")) {
            // On ne set pas l'id, la base s'en occupe toute seule (autoincrement)
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setInt(2, student.getNumber());
            preparedStatement.setInt(3, student.getIdPromo());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }


    public boolean delete(Student student) {

        try (PreparedStatement preparedStatement = connect.prepareStatement("DELETE FROM student WHERE ID_USER=?");){
            preparedStatement.setInt(1,student.getId());
            preparedStatement.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean modify(Student student) {
        try (PreparedStatement preparedStatement = connect.prepareStatement("UPDATE student SET NUMBER=?,ID_PROMOTION=? WHERE ID_USER=?");){
            preparedStatement.setInt(1,student.getNumber());
            preparedStatement.setInt(2,student.getIdPromo());
            preparedStatement.setInt(3,student.getId());


            preparedStatement.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public Student find(int id, User user, List<Promotion>promotions,List<Course>courses, List <Site> sites,List<Type>types,List<RoomSession>roomSessions,List<PromotionSession>promotionSessions) {

        Student student=new Student();
        Promotion promotion=new Promotion();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Projet.student WHERE ID_USER = " + id);

            if(result.first())
            for(Promotion promos: promotions){
                if(promos.getId()==result.getInt("ID_PROMOTION")){
                    promotion=promos;
                }
            }
                if (user.getPermission().equals("STUDENT")) {
                    student = new Student(user.getId(), user.getEmail(),
                            user.getPassword(),
                            user.getLastName(),
                            user.getFirstName(),
                            user.getPermission(),
                            result.getInt("NUMBER"), promotion);


                }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
}