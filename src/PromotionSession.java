import java.time.LocalDateTime;
import java.util.List;

public class PromotionSession extends Session{
     private List<Promotion> groupsSession;

     public List<Promotion> getGroupsSession() {
          return groupsSession;
     }

     public void setGroupsSession(List<Promotion> groupsSession) {
          this.groupsSession = groupsSession;
     }

     public PromotionSession(int id, int week, String date, LocalDateTime startTime, LocalDateTime endTime, Course course, State state, List<Promotion> groupsSession) {
          super(id, week, date, startTime, endTime, course, state);
          this.groupsSession = groupsSession;
     }
}
