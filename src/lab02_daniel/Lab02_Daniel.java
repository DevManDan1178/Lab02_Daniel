/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab02_daniel;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import java.util.Random;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author 6323612
 */
public class Lab02_Daniel extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }
        

    @Override
    public void start(Stage primaryStage) {
        // Set size and title
        primaryStage.setWidth(250);
        primaryStage.setHeight(300);
        primaryStage.setTitle("Java Games");
        
        // Create root and scene
        BorderPane rootBorderPane = new BorderPane();
        Scene scene = new Scene(rootBorderPane);
        // Create other elements
        VBox middle = new VBox();
        Label topLabel = new Label("Random Game");
        Label botLabel = new Label("Waiting....");
        Label lblImage = new Label();
        
        // Setup structure elements
        rootBorderPane.setTop(topLabel);
        rootBorderPane.setBottom(botLabel);
        rootBorderPane.setCenter(middle);
        middle.getChildren().add(lblImage);
        
        // Align structure elements
        middle.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(topLabel, Pos.CENTER);
        BorderPane.setAlignment(botLabel, Pos.CENTER);

        // Set random image
        Random rng = new Random();
        int randomImageNumber =  rng.nextInt(101, 121);
        Image img = new Image("file:images/" + randomImageNumber + ".jpg");
        lblImage.setGraphic(new ImageView(img));
        
        // Set and display scene/stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    

} 
