package BlackJackPack;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.stage.Stage;

public class Driver extends Application{

	Scene introScene;
	Button startB, helpB; 
	TextField nametf;
	Label startlb;
	Stage global;
	
	//OOP Components
	Player p;
	Game game;
	
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		
		global=stage;
		 
		
		VBox centBox = new VBox(10);
		//First scene set-up 
		 startlb= new Label("Welcome to Black Jack! linkedlist");
		

		 startB = new Button("TEST");
		 startB.getStyleClass().add("round-red"); 
		 
		 helpB = new Button("Help");
		 helpB.getStyleClass().add("round-red");

		 		 
		 nametf = new TextField();
		 nametf.setPromptText("Name");
		 p=new Player(nametf.getText());
		 
		 
		 startB.setOnAction(e -> {
			 
			 //Bringing up separate screen to run actual application
			 
			 TableDriver.display(nametf.getText());
			 
			 });
		 
		 //Because I couldn't figure out how to get the file writing to work, here's a help page.
		 
		 helpB.setOnAction(e -> {
			 try {
	             Desktop.getDesktop().browse(new URI("http://www.bicyclecards.com/how-to-play/blackjack/"));
	         } catch (IOException e1) {
	             e1.printStackTrace();
	         } catch (URISyntaxException e1) {
	             e1.printStackTrace();
	         }
	         
		 });
		
		
		 
		 centBox.getChildren().addAll(startlb,nametf,startB,helpB);
		 
		 //layout for introscene
		 BorderPane startPane = new BorderPane();
		 startPane.setCenter(centBox);
		 introScene = new Scene(startPane,400,200);
		 introScene.getStylesheets().addAll(this.getClass().getResource("intro.css").toExternalForm());
		 
		 //*********************************************************************************************
		 
		global.setScene(introScene);
		global.setTitle("Justin's Black Jack Program TEST");
		global.setResizable(false);
		global.show();
	}
	
	
}
