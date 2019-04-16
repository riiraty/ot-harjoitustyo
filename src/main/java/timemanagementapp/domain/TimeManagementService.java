
package timemanagementapp.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.*;
//import timemanagementapp.dao.LogDao;


public class TimeManagementService {
    //private LogDao logDao;
    private ArrayList<Log> logs;
    private ArrayList<ActivityType> activityTypes;

    public TimeManagementService() {
        logs = new ArrayList<>();
        activityTypes = new ArrayList<>();
        activityTypes.add(new ActivityType("Work", SALMON));
        activityTypes.add(new ActivityType("Errands", LIGHTBLUE));
        activityTypes.add(new ActivityType("Sport", LIGHTGREEN));
    }
    
//    public TimeManagementService(LogDao logDao) {
//        this.logDao = logDao;
//    }

    /**
     * Returns an ArrayList where the users logs are stored
     * @return ArrayList<>
     */

    public ArrayList<Log> getLogs() {
        return logs;
    }
    
    /**
     * Returns an ArrayList with all the ActivityTypes created
     * @return ArrayList<>
     */
    public ArrayList<ActivityType> getActivityTypes() {
        return activityTypes;
    }
    

    /**
     * Creates a new log and ads it to the list that stores the logs
     * @param activityType type of the new log
     * @param start moment the activity started at
     * @param end moment the activity was finished
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
     * Creates a new ActivityType and ads it to the ArrayList that stores the types
     * @param type descriptive word for the new type
     * @param color chosen colour for the type
     * @return true
     */
    public boolean createNewActivityType(String type, Color color) {
        activityTypes.add(new ActivityType(type, color));
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
