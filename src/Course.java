public class Course {

    public enum TypeCourse {TD, TP, PROJECT, SUPPORT, LECTURE, INTERACTIVE_COURSE}

    private int id;
    private String name;
    private TypeCourse typeCourse;

    public Course(int id, String name, TypeCourse typeCourse) {
        this.id = id;
        this.name = name;
        this.typeCourse = typeCourse;
    }

    public int getId() {
        return id;
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

    public TypeCourse getTypeCourse() {
        return typeCourse;
    }

    public void setTypeCourse(TypeCourse typeCourse) {
        this.typeCourse = typeCourse;
    }
}

