import java.time.LocalDateTime;
import java.util.List;

public class TeacherSession extends Session{

    private List<Teacher> teachers ;

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public TeacherSession(int id, int week, String date, LocalDateTime startTime, LocalDateTime endTime, Course course, String state, List<Teacher> teachers) {
        super(id, week, date, startTime, endTime, course, state);
        this.teachers = teachers;
    }
}
