
package timemanagementapp.domain;

import timemanagementapp.domain.ActivityType;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


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

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        String startTime = start.format(formatter);
        String endTime = end.format(formatter);
        return ("Activity type: " + activityType + ", Start time: " + startTime 
                + ", End time: " + endTime);
    }
    
    
    
    
    
}
