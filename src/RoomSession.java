import java.time.LocalDateTime;
import java.util.List;

public class RoomSession extends Session{

    private List<Room> rooms ;

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public RoomSession(int id, int week, int date, int startTime, int endTime, Course course, String state, List<Room> rooms) {
        super(id, week, date, startTime, endTime, course, state);
        this.rooms = rooms;
    }
}
