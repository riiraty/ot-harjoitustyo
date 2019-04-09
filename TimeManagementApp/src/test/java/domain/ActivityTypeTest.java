package domain;



import static javafx.scene.paint.Color.GREEN;
import static javafx.scene.paint.Color.RED;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import timemanagementapp.domain.ActivityType;


public class ActivityTypeTest {
    
    ActivityType activityType;
    
    @Before
    public void setUp() {
        activityType = new ActivityType("Work", RED);
    }
    
    @Test
    public void constructorSetsTheTypeRight() {
        assertEquals("Work", activityType.getType());
    }
    
    @Test
    public void constructorSetsTheColorCodeRight() {
        assertEquals(RED, activityType.getColorCode());
    }
    
    @Test
    public void setterSetsTheTypeRight() {
        activityType.setType("Sport");
        assertEquals("Sport", activityType.getType());
    }
    
    @Test
    public void setterSetsTheColorCodeRight() {
        activityType.setColorCode(GREEN);
        assertEquals(GREEN, activityType.getColorCode());
    }
    
    
}
