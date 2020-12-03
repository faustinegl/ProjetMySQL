import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class RoomDAO extends DAO<Room> {

    public RoomDAO(Connection conn) {
        super(conn);
    }

    public boolean update(Room room) {
        try (PreparedStatement preparedStatement = connect.prepareStatement("INSERT INTO Room (ID,NAME,CAPACITY,ID_SITE) VALUES (?, ?,?,?)")) {
            // On ne set pas l'id, la base s'en occupe toute seule (autoincrement)
            preparedStatement.setInt(1, room.getId());
            preparedStatement.setString(2, room.getName());
            preparedStatement.setInt(3, room.getCapacity());
            preparedStatement.setInt(4, room.getIdSite());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean delete(Room room) {
        try (PreparedStatement preparedStatement = connect.prepareStatement("DELETE FROM room WHERE ID=?");){
            preparedStatement.setInt(1,room.getId());
            preparedStatement.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean modify(Room obj,Room obj2) {
        return false;
    }

    public Room find(int id, User user, List<Promotion>promotions,List<Course>courses, List<Site> sites,List<Type>types) {


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
