import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SiteDAO extends DAO<Site>{

    public SiteDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Site obj) {
        return false;
    }

    @Override
    public boolean delete(Site obj) {
        return false;
    }

    @Override
    public boolean update(Site obj) {
        return false;
    }

    @Override
    public Site find(int id, User user, List<Promotion> promotions,List<Course>courses, List <Site> sites) {
        Site site=new Site();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM site WHERE ID = " + id);
            if(result.first())
                site = new Site(id, result.getString("SITE"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return site;
    }

}