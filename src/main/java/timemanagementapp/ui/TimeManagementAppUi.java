
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
import javafx.scene.layout.HBox;
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
        
        LocalDate date1 = LocalDate.now().minusDays(6);
        LocalDate date2 = LocalDate.now().minusDays(5);
        LocalDate date3 = LocalDate.now().minusDays(4);
        LocalDate date4 = LocalDate.now().minusDays(3);
        LocalDate date5 = LocalDate.now().minusDays(2);
        LocalDate dateY = LocalDate.now().minusDays(1);
        LocalDate dateT = LocalDate.now();
        
        Label label1 = new Label(date1.format(dateFormatter));
        Label label2 = new Label(date2.format(dateFormatter));
        Label label3 = new Label(date3.format(dateFormatter));
        Label label4 = new Label(date4.format(dateFormatter));
        Label label5 = new Label(date5.format(dateFormatter));
        Label labelY = new Label("Yestarday");
        Label labelT = new Label("Today");
  
        VBox box1 = new VBox();
        box1.getChildren().add(label1);
        VBox box2 = new VBox();
        box2.getChildren().add(label2);
        VBox box3 = new VBox();
        box3.getChildren().add(label3);
        VBox box4 = new VBox();
        box4.getChildren().add(label4);
        VBox box5 = new VBox();
        box5.getChildren().add(label5);
        VBox boxY = new VBox();
        boxY.getChildren().add(labelY);
        VBox boxT = new VBox();
        boxT.getChildren().add(labelT);
        
        HBox vboxes = new HBox();
        vboxes.setPadding(new Insets(10, 10, 10, 10));
        vboxes.setSpacing(20);
        vboxes.getChildren().addAll(box1, box2, box3, box4, box5, boxY, boxT);
 
        VBox leftField = new VBox();
        leftField.setPrefSize(1100, 700);
        leftField.getChildren().add(vboxes);
    
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
            
            LocalDate date = startTime.toLocalDate();
            
            Duration duration = Duration.between(startTime, endTime);
            long diff = Math.abs(duration.toMinutes());
            
            timeManagementService.createLog(activity, startTime, endTime);
            
            Rectangle rect = new Rectangle();
            rect.setHeight(diff);
            rect.setWidth(150);
            rect.setFill(activity.getColorCode());
            rect.setStroke(Color.LIGHTGRAY);
            rect.setStrokeWidth(1);
            rect.setArcHeight(10);
            rect.setArcWidth(10);
        
            if(date.equals(dateT)) {
                boxT.getChildren().add(rect);
            } else if (date.equals(dateY)) {
                boxY.getChildren().add(rect);
            } else if(date.equals(date5)) {
                box5.getChildren().add(rect);
            } else if (date.equals(date4)) {
                box4.getChildren().add(rect);
            } else if (date.equals(date3)) {
                box3.getChildren().add(rect);
            } else if (date.equals(date2)) {
                box2.getChildren().add(rect);
            } else if (date.equals(date1)) {
                box1.getChildren().add(rect);
            }
                      
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
