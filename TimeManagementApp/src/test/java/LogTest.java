

import java.time.LocalDateTime;
import static javafx.scene.paint.Color.RED;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import timemanagementapp.ActivityType;
import timemanagementapp.Log;


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
    


}
