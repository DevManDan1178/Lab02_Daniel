/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab02_daniel;


import java.util.HashSet;
import java.util.Set;
import javafx.animation.Animation;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *
 * @author 6323612
 */
public class Lab02_Daniel extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
    }
        

    @Override
    public void start(Stage primaryStage) {
        final double IMAGE_TRANSITION_DURATION = 2;
        Image[] IMAGES = new Image[20];
        
        for (int i = 0; i < 20; i++) {     
            int imgPathIndex = 101 + i;
            IMAGES[i] = new Image("file:images/" + imgPathIndex + ".jpg");
        }
        int[] index = {0}; //must be array to be modifiable in lambda
        
        // Set size and title
        primaryStage.setWidth(250);
        primaryStage.setHeight(300);
        primaryStage.setTitle("Java Games");
        
        // Create root and scene
        VBox rootVBox = new VBox();
        BorderPane borderPane = new BorderPane();
        
        Scene scene = new Scene(rootVBox);
        
        // Create other elements
        VBox middle = new VBox();
        Label topLabel = new Label("Random Game");
        Label botLabel = new Label("Waiting....");
        Label lblImage = new Label();
        ImageView imgView = new ImageView(IMAGES[0]);
        lblImage.setGraphic(imgView);
        // Setup structure elements
        borderPane.setTop(topLabel);
        borderPane.setBottom(botLabel);
        borderPane.setCenter(middle);
        middle.getChildren().addAll(lblImage, botLabel);
        
        // Align structure elements
        middle.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(topLabel, Pos.CENTER);
        BorderPane.setAlignment(botLabel, Pos.CENTER);
        
        //LAB07_B 
        
        //Create Button
        HBox buttonsHBox = new HBox();
        Button interactButton = new Button("PLAY");
        Button addSpeedButton = new Button("SPEED +10%");
        Button subSpeedButton = new Button("SPEED -10%");
        
        buttonsHBox.getChildren().addAll(interactButton, addSpeedButton, subSpeedButton);
        buttonsHBox.setAlignment(Pos.CENTER);
        buttonsHBox.setSpacing(20);
        //Transition
        FadeTransition transition = new FadeTransition();
        transition.setDuration(Duration.seconds(IMAGE_TRANSITION_DURATION));
        
        
        transition.setOnFinished(e -> {
            index[0] = (index[0] + 1) % 20;
            imgView.setImage(IMAGES[index[0]]);
            transition.playFromStart();
        });
        //Button functionality
        interactButton.setOnAction(e -> {
            if (!transition.getStatus().equals(Animation.Status.RUNNING)) {
                transition.play();
                interactButton.setText("PAUSE");
            } else {
                transition.pause();
                interactButton.setText("PLAY");
            }
        });
        
        addSpeedButton.setOnAction(e -> {
            transition.setRate(transition.getRate() * 1.1);
        });
        
        subSpeedButton.setOnAction(e -> {
           transition.setRate(transition.getRate() * .9);
        });
        
        transition.setNode(borderPane);
        
        
        rootVBox.getChildren().addAll(borderPane, buttonsHBox);
        // Set and display scene/stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    

} 
