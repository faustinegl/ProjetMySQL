public class PromotionSession {
     private int id ;
     private int idPromotion;

     public PromotionSession(int id, int idPromotion) {
          this.id = id;
          this.idPromotion = idPromotion;
     }
     public PromotionSession() {}

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public int getIdPromotion() {
          return idPromotion;
     }

     public void setIdPromotion(int idPromotion) {
          this.idPromotion = idPromotion;
     }
}
