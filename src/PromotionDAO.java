import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PromotionDAO extends DAO<Promotion>{

    public PromotionDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Promotion obj) {
        return false;
    }

    @Override
    public boolean delete(Promotion obj) {
        return false;
    }

    @Override
    public boolean update(Promotion obj) {
        return false;
    }

    @Override
    public Promotion find(int id, User user, List<Promotion>promotions,List<Course>courses, List <Site> sites) {

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
