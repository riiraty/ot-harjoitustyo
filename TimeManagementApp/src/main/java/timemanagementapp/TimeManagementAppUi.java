
package timemanagementapp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import static javafx.scene.paint.Color.BLUE;
import static javafx.scene.paint.Color.GREEN;
import static javafx.scene.paint.Color.RED;
import javafx.stage.Stage;


public class TimeManagementAppUi extends Application {
    private TimeManagementService timeManagementService;
    
    @Override
    public void init() throws Exception {
        timeManagementService = new TimeManagementService();
    }

    @Override
    public void start(Stage primaryStage) {
        
        Button newLogButton = new Button("NEW LOG");
        Button uselessButton = new Button("USELESS BUTTON");
        
        VBox layOutRight = new VBox();
        layOutRight.setPadding(new Insets(10, 10, 10, 10));
        layOutRight.setSpacing(15);
        layOutRight.setPrefSize(180, 700);
        layOutRight.getChildren().addAll(newLogButton, uselessButton);
        
        Canvas canvas = new Canvas(1100, 700);

        BorderPane layOut = new BorderPane();
        layOut.setRight(layOutRight);
        layOut.setLeft(canvas);
        
        Scene mainScene = new Scene(layOut);
        
        primaryStage.setTitle("Time Management App");
        primaryStage.setScene(mainScene);
        primaryStage.show();
        
        ObservableList<ActivityType> options = 
            FXCollections.observableArrayList(
                new ActivityType("Work", RED),
                new ActivityType("Errands", BLUE),
                new ActivityType("Sport", GREEN)
            );
        final ComboBox comboBox = new ComboBox(options);
        
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        String formatDateTime = current.format(formatter);
        Label activityLabel = new Label("Activity type: ");
        
        Label startLabel = new Label("Start time: ");
        TextField startField = new TextField("" + formatDateTime);
        Label endLabel = new Label("End time: ");
        TextField endField = new TextField("" + formatDateTime);
        Button createLogButton = new Button("LOG");
        
        VBox logLayOut = new VBox();
        logLayOut.setPadding(new Insets(10, 10, 10, 10));
        logLayOut.setSpacing(15);
        logLayOut.setPrefSize(180, 300);
        logLayOut.getChildren().addAll(activityLabel, comboBox, startLabel,
                startField, endLabel, endField, createLogButton);
        
        Scene logScene = new Scene(logLayOut);
        
        newLogButton.setOnAction((event) -> {
            Stage logStage = new Stage();
            logStage.setTitle("New Log");
            logStage.setScene(logScene);
            logStage.show();
        });
        
        createLogButton.setOnAction((event) -> {
            //ActivityType activity = comboBox.getValue();
            //timeManagementService.createLog();
        });
        
        
        
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }


    
}
