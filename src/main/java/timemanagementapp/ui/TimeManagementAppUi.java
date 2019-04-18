
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
    private LocalDate date1;
    private LocalDate date2;
    private LocalDate date3;
    private LocalDate date4;
    private LocalDate date5;
    private LocalDate dateY;
    private LocalDate dateT;
    private VBox box1;
    private VBox box2;
    private VBox box3;
    private VBox box4;
    private VBox box5;
    private VBox boxY;
    private VBox boxT;
    
    @Override
    public void init() throws Exception {
        timeManagementService = new TimeManagementService(); 
        dateT = LocalDate.now();
        dateY = dateT.minusDays(1);
        date5 = dateY.minusDays(1);
        date4 = date5.minusDays(1);
        date3 = date4.minusDays(1);
        date2 = date3.minusDays(1);
        date1 = date2.minusDays(1);
        box1 = new VBox();
        box2 = new VBox();
        box3 = new VBox();
        box4 = new VBox();
        box5 = new VBox();
        boxY = new VBox();
        boxT = new VBox();

    }

    @Override
    public void start(Stage primaryStage) {
        
        // the components of the main scene
        Button newLogButton = new Button("NEW LOG");
        
        VBox layOutRight = new VBox();
        layOutRight.setPadding(new Insets(10, 10, 10, 10));
        layOutRight.setSpacing(15);
        layOutRight.setPrefSize(150, 700);
        layOutRight.getChildren().addAll(newLogButton);
        
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.");
  
        Label label1 = new Label(date1.format(dateFormatter));
        label1.setMinWidth(150);
        Label label2 = new Label(date2.format(dateFormatter));
        label2.setMinWidth(150);
        Label label3 = new Label(date3.format(dateFormatter));
        label3.setMinWidth(150);
        Label label4 = new Label(date4.format(dateFormatter));
        label4.setMinWidth(150);
        Label label5 = new Label(date5.format(dateFormatter));
        label5.setMinWidth(150);
        Label labelY = new Label("Yesterday");
        labelY.setMinWidth(150);
        Label labelT = new Label("Today");
        labelT.setMinWidth(150);

        box1.getChildren().add(label1);
        box2.getChildren().add(label2);
        box3.getChildren().add(label3);
        box4.getChildren().add(label4);
        box5.getChildren().add(label5);
        boxY.getChildren().add(labelY);
        boxT.getChildren().add(labelT);
        
        HBox vboxes = new HBox();
        vboxes.setPadding(new Insets(10, 20, 10, 20));
        vboxes.setSpacing(10);
        vboxes.getChildren().addAll(box1, box2, box3, box4, box5, boxY, boxT);
 
        VBox layOutLeft = new VBox();
        layOutLeft.setPrefSize(1100, 700);
        layOutLeft.getChildren().add(vboxes);
        
        newLogButton.setOnAction((event) -> { 
            Stage logStage = drawNewLogWindow();
            logStage.show();
        });
    
        BorderPane layOut = new BorderPane();
        layOut.setRight(layOutRight);
        layOut.setLeft(layOutLeft);
        
        Scene mainScene = new Scene(layOut);
        
        primaryStage.setTitle("Time Management App");
        primaryStage.setScene(mainScene);
        primaryStage.show();

    }
    
    public Stage drawNewLogWindow() {
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
            
            drawARectangle(date, diff, activity);
                      
            logStage.close();
        });
        
        return logStage;
    } 
    
    public void drawARectangle(LocalDate date, long diff, ActivityType activity) {
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
    }
    
    @Override
    public void stop() {
        System.out.println("Closing...");
    }
    
    public static void main(String[] args) {
        launch(args);
    }


    
}
