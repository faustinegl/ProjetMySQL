import java.util.List;

public class Teacher extends User{

    private List<Course> ListCourse ;


    public Teacher(int id, String email, String password, String lastName, String firstName, Permission permission, List<Course> listCourse) {
        super(id, email, password, lastName, firstName, permission);
        ListCourse = listCourse;
    }

    public List<Course> getListCourse() {
        return ListCourse;
    }

    public void setListCourse(List<Course> listCourse) {
        ListCourse = listCourse;
    }
}
