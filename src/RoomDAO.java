import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class RoomDAO extends DAO<Room> {

    public RoomDAO(Connection conn) {
        super(conn);
    }

    public boolean create(Room obj) {
        return false;
    }

    public boolean delete(Room obj) {
        return false;
    }

    public boolean update(Room obj) {
        return false;
    }

    public Room find(int id, User user, List<Promotion>promotions,List<Course>courses, List<Site> sites) {


        Room room = new Room();
        Site site= new Site();


        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM room WHERE ID = " + id);


            if(result.first()) {
                for (Site elemSite : sites) {
                    if (elemSite.getId() == result.getInt("ID_SITE")) {
                        site = elemSite;
                    }
                }

                room = new Room(id, result.getString("NAME"),
                        result.getInt("CAPACITY"), site);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return room;
    }
}
