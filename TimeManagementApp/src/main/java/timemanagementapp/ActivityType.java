
package timemanagementapp;

import javafx.scene.paint.Color;


public class ActivityType {
    private String type;
    private Color colorCode;
    
    public ActivityType(String type, Color color){
        this.type = type;
        this.colorCode = color;
    }

    public String getType() {
        return type;
    }

    public Color getColorCode() {
        return colorCode;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setColorCode(Color colorCode) {
        this.colorCode = colorCode;
    }

    @Override
    public String toString() {
        return type;
    }
    
    
}
