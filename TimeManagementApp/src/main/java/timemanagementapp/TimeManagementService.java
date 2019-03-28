
package timemanagementapp;

import java.time.LocalDateTime;


public class TimeManagementService {
    //private LogDao logDao;

    public TimeManagementService() {
    }
    
    public boolean createLog(ActivityType activityType, LocalDateTime start, LocalDateTime end) {
        Log log = new Log(activityType, start, end);
        
//        try {
//            logDao.create(log);
//        } catch (Exception ex) {
//            return false;
//        }
        
        return true;
    }
    
    
    
}
