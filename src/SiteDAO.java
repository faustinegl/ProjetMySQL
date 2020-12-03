import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SiteDAO extends DAO<Site> {

    public SiteDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean update(Site site) {
        try (PreparedStatement preparedStatement = connect.prepareStatement("INSERT INTO Site (ID,SITE) VALUES (?, ?)")) {
            // On ne set pas l'id, la base s'en occupe toute seule (autoincrement)
            preparedStatement.setInt(1, site.getId());
            preparedStatement.setString(2, site.getName());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Site site) {
        try (PreparedStatement preparedStatement = connect.prepareStatement("DELETE FROM site WHERE ID=?");) {
            preparedStatement.setInt(1, site.getId());
            preparedStatement.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean modify(Site obj) {
        return false;
    }

    @Override
    public Site find(int id, User user, List<Promotion> promotions, List<Course> courses, List<Site> sites, List<Type> types, List<RoomSession> roomSessions, List<PromotionSession> promotionSessions) {
        Site site = new Site();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM site WHERE ID = " + id);
            if (result.first())
                site = new Site(id, result.getString("SITE"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return site;
    }

}

