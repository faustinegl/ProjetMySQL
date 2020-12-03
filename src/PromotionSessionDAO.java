import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PromotionSessionDAO extends DAO<PromotionSession>{

    public PromotionSessionDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean update(PromotionSession promotionSession) {
        try (PreparedStatement preparedStatement = connect.prepareStatement("INSERT INTO groups_session (ID_SESSION,ID_PROMOTION) VALUES (?, ?)")) {
            // On ne set pas l'id, la base s'en occupe toute seule (autoincrement)
            preparedStatement.setInt(1, promotionSession.getId());
            preparedStatement.setInt(2, promotionSession.getIdPromotion());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(PromotionSession obj) {
        return false;
    }

    @Override
    public boolean modify(PromotionSession obj) {
        return false;
    }

    @Override
    public PromotionSession find(int id, User user, List<Promotion>promotions,List<Course>courses, List <Site> sites,List<Type>types,List<RoomSession>roomSessions,List<PromotionSession>promotionSessions) {

        PromotionSession promotionSession=new PromotionSession();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM groups_session WHERE ID_SESSION = " + id);
            if(result.first())
                promotionSession = new PromotionSession(id, result.getInt("ID_PROMOTION"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return promotionSession ;
    }
}
