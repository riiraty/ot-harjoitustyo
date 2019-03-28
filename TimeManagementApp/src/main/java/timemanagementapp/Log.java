
package timemanagementapp;

import java.time.LocalDateTime;


public class Log {
    // private int id;
    private ActivityType activityType;
    private LocalDateTime start;
    private LocalDateTime end;
    //private int duration; //calculated,in minutes
    //private String description;

    public Log(ActivityType activityType, LocalDateTime start, LocalDateTime end) {
        this.activityType = activityType;
        this.start = start;
        this.end = end;
    }
    
    
    
}
