
package timemanagementapp.ui;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import timemanagementapp.domain.ActivityType;
import timemanagementapp.domain.TimeManagementService;


public class TimeManagementAppUi extends Application {
    private TimeManagementService timeManagementService;
    
    @Override
    public void init() throws Exception {
        timeManagementService = new TimeManagementService();      
    }

    @Override
    public void start(Stage primaryStage) {
        
        // the components of the main scene
        Button newLogButton = new Button("NEW LOG");
        
        VBox layOutRight = new VBox();
        layOutRight.setPadding(new Insets(10, 10, 10, 10));
        layOutRight.setSpacing(15);
        layOutRight.setPrefSize(180, 700);
        layOutRight.getChildren().addAll(newLogButton);
        
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.");
        
        Label label1 = new Label(LocalDate.now().minusDays(5).format(dateFormatter));
        Label label2 = new Label(LocalDate.now().minusDays(4).format(dateFormatter));
        Label label3 = new Label(LocalDate.now().minusDays(3).format(dateFormatter));
        Label label4 = new Label(LocalDate.now().minusDays(2).format(dateFormatter));
        Label labelY = new Label("Yestarday");
        Label labelT = new Label("Today");
        
        VBox box1 = new VBox();
        VBox box2 = new VBox();
        VBox box3 = new VBox();
        VBox box4 = new VBox();
        VBox boxY = new VBox();
        VBox boxT = new VBox();
        
        GridPane leftField = new GridPane();
        leftField.setPrefSize(1100, 700);
        leftField.setVgap(10);
        leftField.setHgap(100);
        //leftField.setGridLinesVisible(true); //!!
        
        
        leftField.add(label1, 0, 0);
        leftField.add(label2, 1, 0);
        leftField.add(label3, 2, 0);
        leftField.add(label4, 3, 0);
        leftField.add(labelY, 4, 0);
        leftField.add(labelT, 5, 0);
        
        leftField.add(box1, 0, 1);
        leftField.add(box2, 1, 1);
        leftField.add(box3, 2, 1);
        leftField.add(box4, 3, 1);
        leftField.add(boxY, 4, 1);
        leftField.add(boxT, 5, 1);
        
        BorderPane layOut = new BorderPane();
        layOut.setRight(layOutRight);
        layOut.setLeft(leftField);
        
        Scene mainScene = new Scene(layOut);
        
        primaryStage.setTitle("Time Management App");
        primaryStage.setScene(mainScene);
        primaryStage.show();

        //a new window for making new logs
        ObservableList<ActivityType> options = 
                FXCollections.observableArrayList(timeManagementService.getActivityTypes());
        ComboBox comboBox = new ComboBox(options);
        comboBox.setPromptText("Select --");
             
        LocalDateTime current = LocalDateTime.now();
        LocalDateTime anHourEarlier = LocalDateTime.now().minusHours(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        String formatCurrent = current.format(formatter);
        String formatEarlier = anHourEarlier.format(formatter);
        
        Label activityLabel = new Label("Activity type: ");
        
        Label startLabel = new Label("Start time: ");
        TextField startField = new TextField("" + formatEarlier);
        
        Label endLabel = new Label("End time: ");
        TextField endField = new TextField("" + formatCurrent);
        
        Button createLogButton = new Button("LOG");
        
        VBox logLayOut = new VBox();
        logLayOut.setPadding(new Insets(10, 10, 10, 10));
        logLayOut.setSpacing(15);
        logLayOut.setPrefSize(180, 300);
        logLayOut.getChildren().addAll(activityLabel, comboBox, startLabel,
                startField, endLabel, endField, createLogButton);
        
        Scene logScene = new Scene(logLayOut);
        
        Stage logStage = new Stage();
        logStage.setTitle("New Log");
        logStage.setScene(logScene);
        
        newLogButton.setOnAction((event) -> { 
            logStage.show();
        });
        
        
        createLogButton.setOnAction((event) -> {
            ActivityType activity = (ActivityType) comboBox.getValue();
            
            String startString = startField.getText();
            LocalDateTime startTime = LocalDateTime.parse(startString, formatter);
            
            String endString = endField.getText();
            LocalDateTime endTime = LocalDateTime.parse(endString, formatter);
            
            Duration duration = Duration.between(startTime, endTime);
            long diff = Math.abs(duration.toMinutes());
            System.out.println(diff);
            
            timeManagementService.createLog(activity, startTime, endTime);
            
            Rectangle rect = new Rectangle();
            rect.setHeight(diff);
            rect.setWidth(150);
            rect.setFill(activity.getColorCode());
            rect.setStroke(Color.LIGHTGRAY);
            rect.setStrokeWidth(1);
            rect.setArcHeight(10);
            rect.setArcWidth(10);
        
            boxT.getChildren().add(rect);
            
            logStage.close();
        });
        
  
    }
    
    @Override
    public void stop() {
        System.out.println("Closing...");
    }
    
    public static void main(String[] args) {
        launch(args);
    }


    
}
