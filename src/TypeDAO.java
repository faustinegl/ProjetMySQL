import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TypeDAO extends DAO<Type>{

    public TypeDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean update(Type type) {
        try (PreparedStatement preparedStatement = connect.prepareStatement("INSERT INTO type_course (ID,NAME) VALUES (?, ?)")) {
            // On ne set pas l'id, la base s'en occupe toute seule (autoincrement)
            preparedStatement.setInt(1, type.getId());
            preparedStatement.setString(2, type.getName());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Type obj) {
        return false;
    }

    @Override
    public boolean modify(Type obj) {
        return false;
    }

    @Override
    public Type find(int id, User user, List<Promotion>promotions,List<Course>courses, List <Site> sites,List<Type>types) {

        Type type=new Type();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM type_course WHERE ID = " + id);
            if(result.first())
                type = new Type(id, result.getString("NAME"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return type;
    }
}
