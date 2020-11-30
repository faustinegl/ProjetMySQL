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

    public boolean create(Student obj) {
       /* try (PreparedStatement preparedStatement = connect.prepareStatement("INSERT INTO album (title, artist_name, release_year) VALUES (?, ?, ?)")) {
            // On ne set pas l'id, la base s'en occupe toute seule (autoincrement)
            preparedStatement.setString(1, album.getTitle());
            preparedStatement.setString(2, album.getArtistName());
            preparedStatement.setInt(3, album.getReleaseYear());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/
        return false;
    }


    public boolean delete(Student obj) {
        return false;
    }

    public boolean update(Student obj) {
        return false;
    }

    public Student find(int id, User user, List<Promotion>promotions,List<Course>courses, List <Site> sites) {

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