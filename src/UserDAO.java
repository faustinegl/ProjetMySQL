import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAO extends DAO<User> {
    public UserDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(User obj) {
        return false;
    }

    @Override
    public boolean delete(User obj) {
        return false;
    }

    @Override
    public boolean update(User obj) {
        return false;
    }

    public User find(int id, User users, List<Promotion>promotions,List<Course>courses, List <Site> sites) {
        User user=new User();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM User WHERE ID = " + id);
            if(result.first())
                user = new User(id, result.getString("EMAIL"),
                        result.getString("PASSWORD"),
                        result.getString("LAST_NAME"),
                        result.getString("FIRST_NAME"),
                        result.getString("PERMISSION"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}