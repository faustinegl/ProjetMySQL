public class Student extends User {

//    private String idUser;
    private int number;
    private Promotion promotion;

    public Student(int id, String email, String password, String lastName, String firstName, Permission permission, int number, Promotion promotion) {
        super(id, email, password, lastName, firstName, permission);
        this.number = number;
        this.promotion = promotion;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }
}
