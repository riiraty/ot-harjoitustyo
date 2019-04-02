
package timemanagementapp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class TimeManagementAppUi extends Application {

    
    @Override
    public void init() throws Exception {
        
    }

    @Override
    public void start(Stage primaryStage) {
        Button newLogButton = new Button("NEW LOG");
        Button uselessButton = new Button("USELESS BUTTON");
        
        VBox layOutRight = new VBox();
        layOutRight.setPadding(new Insets(10, 10, 10, 10));
        layOutRight.setSpacing(20);
        layOutRight.setPrefSize(160, 700);
        layOutRight.getChildren().addAll(newLogButton, uselessButton);
        
        Canvas canvas = new Canvas(1100, 700);

        BorderPane layOut = new BorderPane();
        layOut.setRight(layOutRight);
        layOut.setLeft(canvas);
        
        Scene mainScene = new Scene(layOut);
        
        
        Label activityLabel = new Label("Activity type: ");
        TextField activityField = new TextField();
        Label StartLabel = new Label("Start time: ");
        TextField StartField = new TextField();
        Label EndLabel = new Label("End time: ");
        TextField EndField = new TextField();
        
        HBox logLayOut = new HBox();
        
        newLogButton.setOnAction((event) -> {
            Stage logStage = new Stage();
            logStage.setTitle("New Log");
            logStage.show();
        });
        
        primaryStage.setTitle("Time Management App");
        primaryStage.setScene(mainScene);
        primaryStage.show();
        
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }


    
}
