public class Course {

    public enum TypeCourse {AMPHITHEATRE, PRACTICAL, TD, PROJECT, SUPPORT}

    private int id;
    private String name;
    //private String typeCourse;

    public Course(int id, String name) {
        this.id = id;
        this.name = name;
        //this.typeCourse = typeCourse;
    }
    public Course(){}

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

  //  public String getTypeCourse() {
      //  return typeCourse;
    //}

   // public void setTypeCourse(String typeCourse) {
       // this.typeCourse = typeCourse;
    //}
}

