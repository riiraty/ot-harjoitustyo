package domain;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static javafx.scene.paint.Color.RED;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import timemanagementapp.domain.ActivityType;
import timemanagementapp.domain.Log;


public class LogTest {
    
    ActivityType activityType;
    LocalDateTime start;
    LocalDateTime end;
    Log log;
    
    @Before
    public void setUp() {
        activityType = new ActivityType("Work", RED);
        start = LocalDateTime.now();
        end = LocalDateTime.now().plusMinutes(15);
        log = new Log(activityType, start, end);
    }
    
    @Test
    public void constructorSetsTheActivityTypeRight() {
        assertEquals("Work", activityType.getType());
    }
    
    @Test
    public void toStringPrintsWhatItIsSupposeTo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        String startTime = start.format(formatter);
        String endTime = end.format(formatter);
        assertEquals(("Activity type: " + activityType + ", Start time: " + 
                startTime + ", End time: " + endTime), log.toString());
    }
    


}
