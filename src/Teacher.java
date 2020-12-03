import java.util.List;

public class Teacher extends User {

    private List<Course> ListCourse;


    public Teacher(int id, String email, String password, String lastName, String firstName, String permission, List<Course> listCourse) {
        super(id, email, password, lastName, firstName, permission);
        ListCourse = listCourse;
    }

    public Teacher() {
    }

    ;

    public int getIdCourse() {
        int cours = 0;
        for (Course course : ListCourse) {
            cours = course.getId();
        }
        return cours;
    }

    public List<Course> getListCourse() {
        return ListCourse;
    }

    public void setListCourse(List<Course> listCourse) {
        ListCourse = listCourse;
    }
}
