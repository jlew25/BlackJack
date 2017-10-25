package practice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/*
 * To set up the project, right click on the project and choose Properties.
 * Under build path, select the Libraries Tab and click on Add External Jars
 * In you system, find the Java folder and look for the jre folder (either 7 or 8)
 * Navigate to the lib file and find either jfxrt.jar( java 7) or jfxswt.jar(java 8)
 * 
 * On the school computers, we need an extra step.  First, there must be a main method.
 * Most setups will not require a main to run a FX program, but it will not hurt
 * Also, we need to make sure that the main method is called.
 * To do this, right click on the .java file and choose Run As -> run configurations
 * Make sure that the main class is the same name as your program name
 */


public class practice1 extends Application{

	//remember that an FX application has a stage
	//the stage can hold one scene at a time
	//the scene holds the content

	@Override
	public void start(Stage stage) throws Exception {
		
		//create our application elements and add text to them
		Button btn = new Button();
		btn.setText("Easy");
		btn.getStyleClass().add("red");
		
		btn.setOnAction(event -> System.out.println("That was easy."));
		
		Label lbl=new Label();
		lbl.setText("hi");
		
		
		//need to create the content pane which holds all elements
		//and add the application elements to the content pane
		FlowPane root=new FlowPane();
		root.getChildren().add(btn);
		root.getChildren().add(lbl);
		
		
		//we then need to create a scene to hold the content
		Scene scene1 = new Scene(root, 300, 250);
		
		//to style your elements, create a seperate css file
		//click on File -> New -> Untitled Text file
		//Save in the source folder as abcdef.css
		//we also have to link the scene to the style file
		scene1.getStylesheets().add("style.css");
		
		//standard commands to make the stage visible to the user
		stage.setTitle("Hello World!!");
		stage.setScene(scene1);
		stage.show();
	}
	
	/**
	 * The main method is included for any systems that do not 
	 * recognize that the FX program runs with start.  The launch
	 * command will trigger the start method.
	 */
	public static void main(String[] args) {
		launch(args);
	}


}