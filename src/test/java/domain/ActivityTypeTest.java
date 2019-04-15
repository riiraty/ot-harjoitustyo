package domain;



import static javafx.scene.paint.Color.LIGHTGREEN;
import static javafx.scene.paint.Color.SALMON;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import timemanagementapp.domain.ActivityType;


public class ActivityTypeTest {
    
    ActivityType activityType;
    
    @Before
    public void setUp() {
        activityType = new ActivityType("Work", SALMON);
    }
    
    @Test
    public void constructorSetsTheTypeRight() {
        assertEquals("Work", activityType.getType());
    }
    
    @Test
    public void constructorSetsTheColorCodeRight() {
        assertEquals(SALMON, activityType.getColorCode());
    }
    
    @Test
    public void setterSetsTheTypeRight() {
        activityType.setType("Sport");
        assertEquals("Sport", activityType.getType());
    }
    
    @Test
    public void setterSetsTheColorCodeRight() {
        activityType.setColorCode(LIGHTGREEN);
        assertEquals(LIGHTGREEN, activityType.getColorCode());
    }
    
    
}
