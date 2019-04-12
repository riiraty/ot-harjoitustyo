
package domain;

import java.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import timemanagementapp.domain.ActivityType;
import timemanagementapp.domain.TimeManagementService;


public class TimeManagementServiceTest {
    
    TimeManagementService service;
    ActivityType activityType;
    LocalDateTime start;
    LocalDateTime end;
    
    @Before
    public void setUp() {
        service = new TimeManagementService();
        activityType = service.getActivityTypes().get(0);
        start = LocalDateTime.now();
        end = LocalDateTime.now().plusMinutes(15);
        
    }
    
    @Test
    public void constructorCreatesAnArrayListForLogs() {
        assertTrue(service.getLogs().isEmpty());
    }
    
    @Test
    public void constructorCreatesAnArrayListOfActivityTypes() {
        assertFalse(service.getActivityTypes().isEmpty());
    }
    
    @Test
    public void createLogCreatesALog() {
        assertTrue(service.createLog(activityType, start, end));
    }
    
    @Test
    public void createLogAddsTheLogToTheList() {
        service.createLog(activityType, start, end);
        assertFalse(service.getLogs().isEmpty());
    }
    

    
    

}
