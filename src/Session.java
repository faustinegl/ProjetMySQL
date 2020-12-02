import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Session {

    public enum State {IN_PROCESS,VALIDATES, CANCELLED}
    private int id;
    private int week ;
    private int date;
    private int startTime;
    private int endTime;
    private Course course ;
    private String state ;
    private Type type;

    public Session(int id, int week, int date, int startTime, int endTime, Course course, String state, Type type) {
        this.id = id;
        this.week = week;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.course = course;
        this.state = state;
        this.type=type;
    }
    Session(){}

    public int getId() {
        return id;
    }

    public int getIdCourse(){
        return course.getId();
    }
    public int getIdType(){
        return type.getId();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Type getType(){ return type; }

    public void setType(Type type){this.type=type;}
}
