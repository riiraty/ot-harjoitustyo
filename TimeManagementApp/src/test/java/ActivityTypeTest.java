

import static javafx.scene.paint.Color.RED;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import timemanagementapp.ActivityType;


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
    
    public void constructorSetsTheColorCodeRight() {
        assertEquals(RED, activityType.getColorCode());
    }
    
}
