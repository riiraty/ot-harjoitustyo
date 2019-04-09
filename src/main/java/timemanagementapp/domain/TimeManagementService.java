
package timemanagementapp.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import static javafx.scene.paint.Color.*;
//import timemanagementapp.dao.LogDao;


public class TimeManagementService {
    //private LogDao logDao;
    private ArrayList<Log> logs;
    private ArrayList<ActivityType> activityTypes;

    public TimeManagementService() {
        logs = new ArrayList<>();
        activityTypes = new ArrayList<>();
        activityTypes.add(new ActivityType("Work", RED));
        activityTypes.add(new ActivityType("Errands", BLUE));
        activityTypes.add(new ActivityType("Sport", GREEN));
    }
    
//    public TimeManagementService(LogDao logDao) {
//        this.logDao = logDao;
//    }

    public ArrayList<Log> getLogs() {
        return logs;
    }
    
    public ArrayList<ActivityType> getActivityTypes() {
        return activityTypes;
    }
    

    /**
     * Creates a new log and ads it to the list that stores the logs
     * @param activityType type of the new log
     * @param start
     * @param end
     * @return true 
     */
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
    
    /**
     * Prints all the logs the user has logged
     */
    public void printLogs() {
        for (Log log: logs) {
            System.out.println(log);
        }

    }
    
    public void printActivityTypes() {
        for (ActivityType type: activityTypes) {
            System.out.println(type);
        }
    }
       
    
}
