import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAO extends DAO<User> {
    public UserDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean update(User user) {
        try (PreparedStatement preparedStatement = connect.prepareStatement("INSERT INTO User (ID,EMAIL,PASSWORD,FIRST_NAME,LAST_NAME,PERMISSION) VALUES (?, ?, ?,?, ?, ?)")) {
            // On ne set pas l'id, la base s'en occupe toute seule (autoincrement)
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getFirstName());
            preparedStatement.setString(5, user.getLastName());
            preparedStatement.setString(6, user.getPermission());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(User user) {

        try (PreparedStatement preparedStatement = connect.prepareStatement("DELETE FROM User WHERE ID=?");){
            preparedStatement.setInt(1,user.getId());
            preparedStatement.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean modify(User user) {
        try (PreparedStatement preparedStatement = connect.prepareStatement("UPDATE User SET EMAIL=?,PASSWORD=?,FIRST_NAME=?," +
                "LAST_NAME=?,PERMISSION=? WHERE ID=?");){
            preparedStatement.setString(1,user.getEmail());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getFirstName());
            preparedStatement.setString(4,user.getLastName());
            preparedStatement.setString(5,user.getPermission());
            preparedStatement.setInt(6,user.getId());



            preparedStatement.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public User find(int id, User users, List<Promotion>promotions,List<Course>courses, List <Site> sites,List<Type>types,List<RoomSession>roomSessions,List<PromotionSession>promotionSessions) {
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