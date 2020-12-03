import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RoomSessionDAO extends DAO<RoomSession> {

    public RoomSessionDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean update(RoomSession roomSession) {
        try (PreparedStatement preparedStatement = connect.prepareStatement("INSERT INTO room_session (ID_SESSION,ID_ROOM) VALUES (?, ?)")) {
            // On ne set pas l'id, la base s'en occupe toute seule (autoincrement)
            preparedStatement.setInt(1, roomSession.getId());
            preparedStatement.setInt(2, roomSession.getIdRoom());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(RoomSession obj) {
        return false;
    }

    @Override
    public boolean modify(RoomSession obj) {
        return false;
    }

    @Override
    public RoomSession find(int id, User user, List<Promotion> promotions, List<Course> courses, List<Site> sites, List<Type> types, List<RoomSession> roomSessions, List<PromotionSession> promotionSessions) {

        RoomSession roomSession = new RoomSession();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM room_session WHERE ID_SESSION = " + id);
            if (result.first())
                roomSession = new RoomSession(id, result.getInt("ID_ROOM"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roomSession;
    }
}
