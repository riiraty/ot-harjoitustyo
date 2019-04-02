
package timemanagementapp;

import java.time.LocalDateTime;
import java.util.ArrayList;


public class TimeManagementService {
    //private LogDao logDao;
    private ArrayList<Log> logs;

    public TimeManagementService() {
        logs = new ArrayList<>();
    }
    
    public boolean createLog(ActivityType activityType, LocalDateTime start, LocalDateTime end) {
        Log log = new Log(activityType, start, end);
        logs.add(log);
        
//        try {
//            logDao.create(log);
//        } catch (Exception ex) {
//            return false;
//        }
        
        return true;
    }
    
    
    
}
