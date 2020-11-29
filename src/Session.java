import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Session {

    public enum State {IN_PROCESS,VALIDATES, CANCELLED}
    private int id;
    private int week ;
    private String date;
    private int startTime;
    private int endTime;
    private Course course ;
    private String state ;

    public Session(int id, int week, String date, int startTime, int endTime, Course course, String state) {
        this.id = id;
        this.week = week;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.course = course;
        this.state = state;
    }
    Session(){}

    public int getId() {
        return id;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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
}
