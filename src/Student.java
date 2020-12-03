public class Student extends User {

    //    private String idUser;
    private int number;
    private Promotion promotion;

    public Student(int id, String email, String password, String lastName, String firstName, String permission, int number, Promotion promotion) {
        super(id, email, password, lastName, firstName, permission);
        this.number = number;
        this.promotion = promotion;
    }

    public Student() {
    }

    ;

    public int getId() {
        return super.getId();
    }

    public int getIdPromo() {
        return promotion.getId();
    }

    public int setIdPromo(int promo) {
        return promotion.getId();
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
