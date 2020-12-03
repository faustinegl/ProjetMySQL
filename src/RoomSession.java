public class RoomSession {
    private int id ;
    private int idRoom;

    public RoomSession(int id, int idRoom) {
        this.id = id;
        this.idRoom = idRoom;
    }
    public RoomSession() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }
}
