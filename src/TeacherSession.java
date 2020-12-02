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

    public TeacherSession(int id, int week, int date, int startTime, int endTime, Course course, String state, List<Teacher> teachers,Type type) {
        super(id, week, date, startTime, endTime, course, state, type);
        this.teachers = teachers;
    }
}
