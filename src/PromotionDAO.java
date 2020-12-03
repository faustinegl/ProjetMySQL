import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PromotionDAO extends DAO<Promotion>{

    public PromotionDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean update(Promotion promotion) {
        try (PreparedStatement preparedStatement = connect.prepareStatement("INSERT INTO Promotion (ID,NAME) VALUES (?, ?)")) {
            // On ne set pas l'id, la base s'en occupe toute seule (autoincrement)
            preparedStatement.setInt(1, promotion.getId());
            preparedStatement.setString(2, promotion.getName());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Promotion obj) {
        return false;
    }

    @Override
    public boolean modify(Promotion obj) {
        return false;
    }

    @Override
    public Promotion find(int id, User user, List<Promotion>promotions,List<Course>courses, List <Site> sites,List<Type>types,List<RoomSession>roomSessions,List<PromotionSession>promotionSessions) {

        Promotion promotion=new Promotion();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Promotion WHERE ID = " + id);
            if(result.first())
                promotion = new Promotion(id, result.getString("NAME"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return promotion;
    }
}
