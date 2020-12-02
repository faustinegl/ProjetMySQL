public class Room {

    private int id ;
    private String name ;
    private int capacity ;
    private Site site;

    public Room(int id, String name, int capacity, Site site) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.site = site;
    }

    public Room(){}

    public int getId() {
        return id;
    }

    public int getIdSite(){
        return site.getId();
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }
}
